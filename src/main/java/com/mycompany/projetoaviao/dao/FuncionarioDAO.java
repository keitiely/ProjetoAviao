/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.dao;

import com.mycompany.projetoaviao.model.Funcionario;
import com.mycompany.projetoaviao.model.Pessoa;
import com.mycompany.projetoaviao.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public int inserir(Pessoa pessoa, Funcionario funcionario) throws Exception {
        int idPessoa = pessoaDAO.inserir(pessoa);
        if (idPessoa <= 0) throw new Exception("Falha ao inserir pessoa");

        String sql = "INSERT INTO Funcionario (matricula, cargo, idFuncionario, idFuncionario_Aeroporto) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getCargo());
            stmt.setInt(3, idPessoa);
            stmt.setInt(4, funcionario.getIdAeroporto());
            stmt.executeUpdate();
        }
        return idPessoa;
    }

    public List<Funcionario> listar() throws Exception {
        List<Funcionario> list = new ArrayList<>();
        String sql = "SELECT p.*, f.idFuncionario, f.matricula, f.cargo, f.idFuncionario_Aeroporto" +  
                      "FROM Pessoa p " +
                      "INNER JOIN Funcionario f ON p.idPessoa = f.idFuncionario";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Funcionario f;
                f = new Funcionario(
                        rs.getInt("idPessoa"),
                        rs.getString("nome"),
                        rs.getString("documento"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("matricula"),
                        rs.getString("cargo"),
                        rs.getInt("idFuncionario_Aeroporto")
                );
                list.add(f);
            }
        }
        return list;
    }
}

