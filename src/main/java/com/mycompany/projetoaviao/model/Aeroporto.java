/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.model;

/**
 *
 * @author manoeltelesps
 */
public class Aeroporto {
    public int idAeroporto;
    public String fusoHorario;
    public String nome;
    public String cidade;
    public String pais;

    public Aeroporto(int idAeroporto, String fusoHorario, String nome, String cidade, String pais) {
        this.idAeroporto = idAeroporto;
        this.fusoHorario = fusoHorario;
        this.nome = nome;
        this.cidade = cidade;
        this.pais = pais;
    }

    /**
     * @return the idAeroporto
     */
    public int getIdAeroporto() {
        return idAeroporto;
    }

    /**
     * @param idAeroporto the idAeroporto to set
     */
    public void setIdAeroporto(int idAeroporto) {
        this.idAeroporto = idAeroporto;
    }

    /**
     * @return the fusoHorario
     */
    public String getFusoHorario() {
        return fusoHorario;
    }

    /**
     * @param fusoHorario the fusoHorario to set
     */
    public void setFusoHorario(String fusoHorario) {
        this.fusoHorario = fusoHorario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
}