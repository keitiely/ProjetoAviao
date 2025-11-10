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
import com.mycompany.projetoaviao.dao.BilheteDAO;

//jimportando os models
import com.mycompany.projetoaviao.model.Funcionario;
import com.mycompany.projetoaviao.model.Passageiro;
import com.mycompany.projetoaviao.model.Pessoa;
import com.mycompany.projetoaviao.model.Voo;
import com.mycompany.projetoaviao.model.Bilhete;
import com.mycompany.projetoaviao.model.StatusBilhete;

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
    private BilheteDAO BilheteDAO;
    
    public Controller(){
        this.funcionarioDao = new FuncionarioDAO();
        this.passageiroDao = new PassageiroDAO();
        this.pessoaDao = new PessoaDAO();
        this.vooDao = new VooDAO(); 
        this.BilheteDAO = new BilheteDAO();
    }

    //Bilhete
    public String criarBilhete(String idPassageiroStr, String idVooStr, String lugar, String statusStr) {
    try {
        // Validação
        if (idPassageiroStr.isEmpty() || idVooStr.isEmpty() || lugar.isEmpty() || statusStr.isEmpty()) {
            return "Erro: Todos os campos são obrigatórios!";
        }

        // Conversão
        int idPassageiro = Integer.parseInt(idPassageiroStr);
        int idVoo = Integer.parseInt(idVooStr);
        
        // Validação do status
        StatusBilhete status;
        try {
            status = StatusBilhete.valueOf(statusStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return "Erro: Status inválido. Use: RESERVADO, PAGO, CANCELADO ou EMBARCADO";
        }

        // Buscar passageiro e voo
        Passageiro passageiro = buscarPassageiroPorId(idPassageiro);
        if (passageiro == null) {
            return "Erro: Passageiro não encontrado!";
        }

        Voo voo = buscarVooPorId(idVoo);
        if (voo == null) {
            return "Erro: Voo não encontrado!";
        }

        // Criar bilhete (idBilhete = 0 será gerado pelo banco)
        Bilhete bilhete = new Bilhete(0, status, lugar, passageiro, voo);
        
        // Inserir no banco
        int idBilhete = this.BilheteDAO.inserir(bilhete);
        
        if (idBilhete > 0) {
            return "Bilhete criado com sucesso! ID: " + idBilhete;
        } else {
            return "Erro ao criar bilhete.";
        }

    } catch (NumberFormatException e) {
        return "Erro: IDs devem ser números.";
    } catch (Exception e) {
        e.printStackTrace();
        return "Erro ao criar bilhete: " + e.getMessage();
    }
}

// Métodos auxiliares para buscar por ID
private Passageiro buscarPassageiroPorId(int id) throws Exception {
    List<Passageiro> passageiros = this.passageiroDao.listar();
    return passageiros.stream()
        .filter(p -> p.getIdPessoa() == id)
        .findFirst()
        .orElse(null);
}

private Voo buscarVooPorId(int id) throws Exception {
    List<Voo> voos = this.vooDao.listar();
    return voos.stream()
        .filter(v -> v.getIdVoo() == id)
        .findFirst()
        .orElse(null);
}

public List<Bilhete> listarBilhetes() {
    try {
        return this.BilheteDAO.listar();
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
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
                                      String nacionalidade) {
        try {
            // Validação
            if (nome.isEmpty() || documento.isEmpty()) {
                return "Erro: Nome, documento e data de nascimento são obrigatórios.";
            }

             // Criando o model Passageiro conforme construtor existente (idPessoa = 0)
            Passageiro passageiro = new Passageiro(
                0, nome, documento, endereco, telefone,
                nacionalidade
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
