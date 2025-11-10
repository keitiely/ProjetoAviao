/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.projetoaviao.dao;

import com.mycompany.projetoaviao.model.Bilhete;
import com.mycompany.projetoaviao.model.Passageiro;
import com.mycompany.projetoaviao.model.StatusBilhete;
import com.mycompany.projetoaviao.model.Voo;
import com.mycompany.projetoaviao.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BilheteDAO {

    public int inserir(Bilhete bilhete) throws Exception {
        String sql = "INSERT INTO Bilhete (statusBilhete, lugar, idPassageiro, idVoo) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, bilhete.getStatusBilhete().name());
            stmt.setString(2, bilhete.getLugar());
            stmt.setInt(3, bilhete.getPassageiro().getIdPessoa());
            stmt.setInt(4, bilhete.getVoo().getIdVoo());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    public List<Bilhete> listar() throws Exception {
        List<Bilhete> list = new ArrayList<>();
        String sql = "SELECT * " +
                     "FROM Bilhete b " +
                     "JOIN Passageiro pas ON b.idPassageiro = pas.idPassageiro " +
                     "JOIN Pessoa p ON pas.idPassageiro = p.idPessoa " +
                     "JOIN Voo v ON b.idVoo = v.idVoo";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Passageiro passageiro = new Passageiro(
                    rs.getInt("idPessoa"),
                    rs.getString("nome"),
                    rs.getString("documento"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("nacionalidade")
                );
                
                Voo voo = new Voo(
                    rs.getInt("idVoo"),
                    rs.getString("duracaoPrevista"),
                    rs.getInt("idVoo_Aeronave"),
                    rs.getInt("idVoo_Rota")
                );
                
                Bilhete bilhete = new Bilhete(
                    rs.getInt("idBilhete"),
                    StatusBilhete.valueOf(rs.getString("statusBilhete")),
                    rs.getString("lugar"),
                    passageiro,
                    voo
                );
                
                list.add(bilhete);
            }
        }
        return list;
    }
    
    public boolean atualizar(Bilhete bilhete) throws Exception {
        String sql = "UPDATE Bilhete SET statusBilhete = ?, lugar = ?, idPassageiro = ?, idVoo = ? WHERE idBilhete = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, bilhete.getStatusBilhete().name());
            stmt.setString(2, bilhete.getLugar());
            stmt.setInt(3, bilhete.getPassageiro().getIdPessoa());
            stmt.setInt(4, bilhete.getVoo().getIdVoo());
            stmt.setInt(5, bilhete.getIdBilhete());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean deletar(int idBilhete) throws Exception {
        String sql = "DELETE FROM Bilhete WHERE idBilhete = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idBilhete);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }


}
