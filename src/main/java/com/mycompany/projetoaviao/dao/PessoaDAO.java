/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.dao;

import com.mycompany.projetoaviao.model.Pessoa;
import com.mycompany.projetoaviao.util.Conexao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class PessoaDAO {
    
    public int inserir(Pessoa p) throws Exception{
        //String para montar o comando de insert e cada "?" é os valores que poe dentro do try
        String sql = "INSERT INTO Pessoa (nome, documento, endereco, telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDocumento());
            stmt.setString(3, p.getEndereco());
            stmt.setString(4, p.getTelefone());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) return rs.getInt(1);
            
            } 
        }
        
        return -1;
    }
    
    public List<Pessoa> listar() throws Exception{
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pessoa";
        
        try (
              Connection conn = Conexao.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql);
              ResultSet rs = stmt.executeQuery();
                ){
          while (rs.next()){
              Pessoa p;
              p = new Pessoa(
                      rs.getInt("idPessoa"),
                      rs.getString("nome"),
                      rs.getString("documento"),
                      rs.getString("endereco"),
                      rs.getString("telefone")
              ) {};
              lista.add(p);
          }
        }
        return lista;
    
    }
    
    
}
