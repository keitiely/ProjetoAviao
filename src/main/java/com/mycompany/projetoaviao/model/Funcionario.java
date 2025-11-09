/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.model;

/**
 *
 * @author manoeltelesps
 */
public class Funcionario extends Pessoa {
    private String matricula;
    private String cargo;
    private int idAeroporto;
    
    public Funcionario(int idPessoa, String nome, String documento, String endereco, String telefone, String matricula, String cargo, int idAeroporto) {
        super(idPessoa, nome, documento, endereco, telefone);
        this.matricula = matricula;
        this.cargo = cargo;
        this.idAeroporto = idAeroporto;
    }
    
     public Funcionario(){
         super();
        // Construtor vazio, necessário para o Controller
        // e para o DAO poderem criar o objeto.
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the aeroporto
     */
    public int getIdAeroporto() {
        return idAeroporto;
    }

    /**
     * @param aeroporto the aeroporto to set
     */
    public void setIdAeroporto(int idAeroporto) {
        this.idAeroporto = idAeroporto;
    }
    
    @Override
    public String toString() {
        // Pega o nome/doc da classe Pessoa
        return "Funcionario [ID=" + getIdPessoa() + ", Nome=" + getNome() + 
               ", Matricula=" + matricula + ", Cargo=" + cargo + "]";
    }
}
