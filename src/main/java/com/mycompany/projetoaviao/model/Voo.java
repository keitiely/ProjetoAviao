/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.model;

/**
 *
 * @author manoeltelesps
 */
public class Voo {
    public int idVoo;
    public String numeroVoo;
    public String duracaoPrevista; // pode virar Duration depois
    public Aeronave aeronave;      // utiliza
    public Rota rota;              // segue

    public Voo(int idVoo, String numeroVoo, String duracaoPrevista, Aeronave aeronave, Rota rota) {
        this.idVoo = idVoo;
        this.numeroVoo = numeroVoo;
        this.duracaoPrevista = duracaoPrevista;
        this.aeronave = aeronave;
        this.rota = rota;
    }

    /**
     * @return the idVoo
     */
    public int getIdVoo() {
        return idVoo;
    }

    /**
     * @param idVoo the idVoo to set
     */
    public void setIdVoo(int idVoo) {
        this.idVoo = idVoo;
    }

    /**
     * @return the numeroVoo
     */
    public String getNumeroVoo() {
        return numeroVoo;
    }

    /**
     * @param numeroVoo the numeroVoo to set
     */
    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    /**
     * @return the duracaoPrevista
     */
    public String getDuracaoPrevista() {
        return duracaoPrevista;
    }

    /**
     * @param duracaoPrevista the duracaoPrevista to set
     */
    public void setDuracaoPrevista(String duracaoPrevista) {
        this.duracaoPrevista = duracaoPrevista;
    }

    /**
     * @return the aeronave
     */
    public Aeronave getAeronave() {
        return aeronave;
    }

    /**
     * @param aeronave the aeronave to set
     */
    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    /**
     * @return the rota
     */
    public Rota getRota() {
        return rota;
    }

    /**
     * @param rota the rota to set
     */
    public void setRota(Rota rota) {
        this.rota = rota;
    }
}
