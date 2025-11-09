/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.view;

/**
 *
 * @author keity
 */

import java.sql.Connection;
import com.mycompany.projetoaviao.util.Conexao;

public class View {
    public static void main(String[] args) {
       try {
            Connection conn = Conexao.getConnection();

            if (conn != null) {
                System.out.println("✅ Conexão estabelecida com sucesso!");
                conn.close();
            } else {
                System.out.println("❌ Falha ao conectar.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
