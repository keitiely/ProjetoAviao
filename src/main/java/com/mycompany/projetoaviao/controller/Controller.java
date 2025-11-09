/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.controller;

import java.util.Scanner;

public class Controller {
    
     private static Scanner scan = null;
    
    public static void limparTela() {
        System.out.println("\nAperte ENTER para continuar...");
        scan.nextLine();

        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

        } catch (Exception e1) {
            // Se falhar, tenta limpar via códigos ANSI
            try {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } catch (Exception e2) {
                // Se tudo isso der errado o jeito é imprimir 50 linhas mesmo
                for (int i = 0; i < 50; i++) System.out.println();
            }
        }
    }
}
