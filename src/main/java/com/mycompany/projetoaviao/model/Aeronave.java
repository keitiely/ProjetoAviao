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
    public int idAeronave;
    public String modelo;
    public String fabricante;
    public int capacidade;
    public StatusAeronave statusAeronave;

    public Aeronave(int idAeronave, String modelo, String fabricante, int capacidade, StatusAeronave statusAeronave) {
        this.idAeronave = idAeronave;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.capacidade = capacidade;
        this.statusAeronave = statusAeronave;
    }

    /**
     * @return the idAeronave
     */
    public int getIdAeronave() {
        return idAeronave;
    }

    /**
     * @param idAeronave the idAeronave to set
     */
    public void setIdAeronave(int idAeronave) {
        this.idAeronave = idAeronave;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * @return the statusAeronave
     */
    public StatusAeronave getStatusAeronave() {
        return statusAeronave;
    }

    /**
     * @param statusAeronave the statusAeronave to set
     */
    public void setStatusAeronave(StatusAeronave statusAeronave) {
        this.statusAeronave = statusAeronave;
    }
}
