/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.model;

/**
 *
 * @author manoeltelesps
 */
public class Aeronave {
    private int idAeronave;
    private String modelo;
    private String fabricante;
    private int capacidade;
    private StatusAeronave statusAeronave;

    public Aeronave(int idAeronave, String modelo, String fabricante, int capacidade, StatusAeronave statusAeronave) {
        this.idAeronave = idAeronave;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.capacidade = capacidade;
        this.statusAeronave = statusAeronave;
    }
}
