/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.model;

/**
 *
 * @author manoeltelesps
 */
public class Rota {
    public int idRota;
    public Aeroporto origem;
    public Aeroporto destino;
    public double distanciaKm;

    public Rota(int idRota, Aeroporto origem, Aeroporto destino, double distanciaKm) {
        this.idRota = idRota;
        this.origem = origem;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
    }

    /**
     * @return the idRota
     */
    public int getIdRota() {
        return idRota;
    }

    /**
     * @param idRota the idRota to set
     */
    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    /**
     * @return the origem
     */
    public Aeroporto getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    /**
     * @return the destino
     */
    public Aeroporto getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    /**
     * @return the distanciaKm
     */
    public double getDistanciaKm() {
        return distanciaKm;
    }

    /**
     * @param distanciaKm the distanciaKm to set
     */
    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }
}