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
    private int idAeroporto;
    private String fusoHorario;
    private String nome;
    private String cidade;
    private String pais;

    public Aeroporto(int idAeroporto, String fusoHorario, String nome, String cidade, String pais) {
        this.idAeroporto = idAeroporto;
        this.fusoHorario = fusoHorario;
        this.nome = nome;
        this.cidade = cidade;
        this.pais = pais;
    }
}