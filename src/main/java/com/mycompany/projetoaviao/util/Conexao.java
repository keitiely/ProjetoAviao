/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection() throws Exception {
        try {
            String url = "jdbc:mysql://localhost:3306/CompanhiaArea";
            String user = "root";
            String pass = "Kr36243918@";

            return DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            return null;
        }
        
       
        
    }
}
