/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.model;

/**
 *
 * @author manoeltelesps
 */
public class Passageiro extends Pessoa {
    private String nacionalidade;
    
    public Passageiro(int idPessoa, String nome, String documento, String endereco, String telefone, String nacionalidade) {
        super(idPessoa, nome, documento, endereco, telefone);
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

}
