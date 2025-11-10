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
    public String duracaoPrevista; // pode virar Duration depois
    public int idAeronave;      // utiliza
    public int idRota;              // segue

    public Voo(int idVoo, String duracaoPrevista, int idAeronave, int idRota) {
        this.idVoo = idVoo;
        this.duracaoPrevista = duracaoPrevista;
        this.idAeronave = idAeronave;
        this.idRota = idRota;
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
    public int getIdAeronave() {
        return idAeronave;
    }

    /**
     * @param aeronave the aeronave to set
     */
    public void setIdAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }

    /**
     * @return the rota
     */
    public int getIdRota() {
        return idRota;
    }

    /**
     * @param rota the rota to set
     */
    public void setRota(int idRota) {
        this.idRota = idRota;
    }
}
