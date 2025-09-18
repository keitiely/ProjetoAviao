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
    private int idVoo;
    private String numeroVoo;
    private String duracaoPrevista; // pode virar Duration depois
    private Aeronave aeronave;      // utiliza
    private Rota rota;              // segue

    public Voo(int idVoo, String numeroVoo, String duracaoPrevista, Aeronave aeronave, Rota rota) {
        this.idVoo = idVoo;
        this.numeroVoo = numeroVoo;
        this.duracaoPrevista = duracaoPrevista;
        this.aeronave = aeronave;
        this.rota = rota;
    }
}
