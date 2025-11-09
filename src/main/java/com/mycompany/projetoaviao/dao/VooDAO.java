/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.dao;

import com.mycompany.projetoaviao.model.Voo;
import com.mycompany.projetoaviao.util.Conexao;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class VooDAO {

    public int inserir(Voo v) throws Exception {
        String sql = "INSERT INTO Voo (duracaoPrevista, idVoo_Rota, idVoo_Aeronave) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setTime(1, Time.valueOf(v.getDuracaoPrevista()));
            stmt.setInt(2, v.getIdRota());
            stmt.setInt(3, v.getIdAeronave());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) { if (rs.next()) return rs.getInt(1); }
        }
        return -1;
    }

    public List<Voo> listar() throws Exception {
        List<Voo> list = new ArrayList<>();
        String sql = "SELECT * FROM Voo";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Voo v = new Voo(
                    rs.getInt("idVoo"),
                    rs.getString("duracaoPrevista"),
                    rs.getInt("idVoo_Rota"),
                    rs.getInt("idVoo_Aeronave")
                );
                list.add(v);
            }
        }
        return list;
    }
}