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
    public int idBilhete;
    public StatusBilhete statusBilhete;
    public String lugar;          // assento
    public Passageiro passageiro; // dono (tem)
    public Voo voo;               // reservado para

    public Bilhete(int idBilhete, StatusBilhete statusBilhete, String lugar, Passageiro passageiro, Voo voo) {
        this.idBilhete = idBilhete;
        this.statusBilhete = statusBilhete;
        this.lugar = lugar;
        this.passageiro = passageiro;
        this.voo = voo;
    }

    /**
     * @return the idBilhete
     */
    public int getIdBilhete() {
        return idBilhete;
    }

    /**
     * @param idBilhete the idBilhete to set
     */
    public void setIdBilhete(int idBilhete) {
        this.idBilhete = idBilhete;
    }

    /**
     * @return the statusBilhete
     */
    public StatusBilhete getStatusBilhete() {
        return statusBilhete;
    }

    /**
     * @param statusBilhete the statusBilhete to set
     */
    public void setStatusBilhete(StatusBilhete statusBilhete) {
        this.statusBilhete = statusBilhete;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the passageiro
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * @param passageiro the passageiro to set
     */
    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    /**
     * @return the voo
     */
    public Voo getVoo() {
        return voo;
    }

    /**
     * @param voo the voo to set
     */
    public void setVoo(Voo voo) {
        this.voo = voo;
    }
}
