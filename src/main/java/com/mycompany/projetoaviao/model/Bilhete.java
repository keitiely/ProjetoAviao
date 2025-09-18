/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.model;

/**
 *
 * @author manoeltelesps
 */
public class Bilhete {
    private int idBilhete;
    private StatusBilhete statusBilhete;
    private String lugar;          // assento
    private Passageiro passageiro; // dono (tem)
    private Voo voo;               // reservado para

    public Bilhete(int idBilhete, StatusBilhete statusBilhete, String lugar, Passageiro passageiro, Voo voo) {
        this.idBilhete = idBilhete;
        this.statusBilhete = statusBilhete;
        this.lugar = lugar;
        this.passageiro = passageiro;
        this.voo = voo;
    }
}
