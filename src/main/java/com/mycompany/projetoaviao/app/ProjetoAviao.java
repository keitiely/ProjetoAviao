/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.app;

/**
 *
 * @author manoeltelesps
 */
import com.mycompany.projetoaviao.controller.Controller;
import com.mycompany.projetoaviao.view.View;
public class ProjetoAviao {
    
    public static void main(String[] args) {
        View view = new View(new Controller());
        view.menuPrincipal();
    }
}
