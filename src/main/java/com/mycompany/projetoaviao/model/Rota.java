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
    private int idRota;
    private Aeroporto origem;
    private Aeroporto destino;
    private double distanciaKm;

    public Rota(int idRota, Aeroporto origem, Aeroporto destino, double distanciaKm) {
        this.idRota = idRota;
        this.origem = origem;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
    }
}