/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.controller;
//importando os daos
import com.mycompany.projetoaviao.dao.FuncionarioDAO;
import com.mycompany.projetoaviao.dao.PassageiroDAO;
import com.mycompany.projetoaviao.dao.PessoaDAO;
import com.mycompany.projetoaviao.dao.VooDAO;

//jimportando os models
import com.mycompany.projetoaviao.model.Funcionario;
import com.mycompany.projetoaviao.model.Passageiro;
import com.mycompany.projetoaviao.model.Pessoa;
import com.mycompany.projetoaviao.model.Voo;

//importando os utilitarios 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author keity
 */
public class Controller {
    
    private FuncionarioDAO funcionarioDao;
    private PassageiroDAO passageiroDao;
    private PessoaDAO pessoaDao;
    private VooDAO vooDao;
    
    
    public Controller(){
        this.funcionarioDao = new FuncionarioDAO();
        this.passageiroDao = new PassageiroDAO();
        this.pessoaDao = new PessoaDAO();
        this.vooDao = new VooDAO(); 
    }

 //Métodos de Listar
    
    public List<Voo> listarVoos(){
        try {
            return this.vooDao.listar();
        }
        catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>(); // Retorna lista vazia em caso de erro
        }
    }
     
    public List<Pessoa> listarPessoas(){
        try {
            return this.pessoaDao.listar();
        }
        catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>(); 
        }
    }
    
    public List<Funcionario> listarFuncionarios(){
        try {
            return this.funcionarioDao.listar();
        }
        catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>(); 
        }
    }
    
    public List<Passageiro> listarPassageiros(){
        try {
            return this.passageiroDao.listar();
        }
        catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>(); 
        }
    }
    
    
    //Métodos Cadastrar
    public String cadastrarVoo(String idVooStr, String duracaoPrevistaStr, String idAeronaveStr, String idRotaStr) {
        
        try {
            // Validação
            if (idVooStr.isEmpty() || duracaoPrevistaStr.isEmpty() || idAeronaveStr.isEmpty() || idRotaStr.isEmpty()) {
                return "Erro: Todos os campos do Voo são obrigatórios!";
            }
            
            // O formato deve ser "HH:MM:SS" para o Time.valueOf() funcionar
            if (!duracaoPrevistaStr.matches("\\d{2}:\\d{2}:\\d{2}")) {
                return "Erro: Formato da duração inválido. Use HH:MM:SS (ex: 02:30:00).";
            }
  
            //Conversao
            int idVoo = Integer.parseInt(idVooStr);
            int idAeronave = Integer.parseInt(idAeronaveStr);
            int idRota = Integer.parseInt(idRotaStr);

            // Criando a model conforme construtor existente
            Voo novoVoo = new Voo(idVoo, duracaoPrevistaStr, idAeronave, idRota);
            
            // chamada ao Dao
            this.vooDao.inserir(novoVoo);

            // resposta para a view
            return "Voo salvo com sucesso!";

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "Erro: Os campos de ID devem ser apenas números.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao salvar Voo: " + e.getMessage();
        }    
    }
    
    public String cadastrarFuncionario(String nome, String documento, String endereco, String telefone, String matricula, String cargo, String idAeroportoStr) {
        try {
            // Validação
            if (nome.isEmpty() || documento.isEmpty() || matricula.isEmpty() || cargo.isEmpty()) {
                return "Erro: Nome, documento, matrícula e cargo são obrigatórios.";
            }
            int idAeroporto = Integer.parseInt(idAeroportoStr);

            // Criando o model Funcionario conforme construtor existente (idPessoa = 0 para novo registro)
            Funcionario funcionario = new Funcionario(
                0, nome, documento, endereco, telefone,
                matricula, cargo, idAeroporto
            );
            
            // Chamada ao DAO (que insere Funcionario)
            this.funcionarioDao.inserir(funcionario, funcionario);

            //  Resposta
            return "Funcionário cadastrado com sucesso!";
            
        } catch (NumberFormatException e) {
            return "Erro: ID do Aeroporto deve ser um número.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao cadastrar Funcionário: " + e.getMessage();
        }
    }
    
    
    public String cadastrarPassageiro(String nome, String documento, String endereco, String telefone,
                                      String nacionalidade, String dataNascimentoStr) {
        try {
            // Validação
            if (nome.isEmpty() || documento.isEmpty() || dataNascimentoStr.isEmpty()) {
                return "Erro: Nome, documento e data de nascimento são obrigatórios.";
            }
            // Crie o "tradutor" para o formato DD/MM/YYYY
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Usa o "tradutor" para converter a String (validação)
             LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatador);

             // Criando o model Passageiro conforme construtor existente (idPessoa = 0)
            Passageiro passageiro = new Passageiro(
                0, nome, documento, endereco, telefone,
                nacionalidade, dataNascimento
            );

            // Chamada ao DAO (que insere Passageiro)
            this.passageiroDao.inserir(passageiro, passageiro);

            // 4. Resposta
            return "Passageiro cadastrado com sucesso!";
            
        } catch (DateTimeParseException e) { 
            e.printStackTrace();
        return "Erro: Formato da data inválido. Use DD/MM/YYYY (ex: 20/05/1990).";
       } catch (Exception e) {
           e.printStackTrace();
        return "Erro ao cadastrar Passageiro: " + e.getMessage();
    }
    }
    
    //
}
