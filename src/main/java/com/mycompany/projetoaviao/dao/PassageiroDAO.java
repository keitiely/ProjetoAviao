/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.dao;

import com.mycompany.projetoaviao.model.Passageiro;
import com.mycompany.projetoaviao.model.Pessoa;
import com.mycompany.projetoaviao.util.Conexao;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PassageiroDAO {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public int inserir(Pessoa pessoa, Passageiro passageiro) throws Exception {
        // insere pessoa primeiro
        int idPessoa = pessoaDAO.inserir(pessoa);
        if (idPessoa <= 0) throw new Exception("Falha ao inserir pessoa");

        String sql = "INSERT INTO Passageiro (nacionalidade, idPassageiro) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, passageiro.getNacionalidade());
            stmt.setInt(2, idPessoa);
            stmt.executeUpdate();
        }
        return idPessoa;
    }

    public List<Passageiro> listar() throws Exception {
        List<Passageiro> list = new ArrayList<>();
        String sql = "SELECT * from Passageiro join Pessoa on Passageiro.idPassageiro = Pessoa.idPessoa";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Passageiro pa;
                pa = new Passageiro(
                        rs.getInt("idPessoa"),
                        rs.getString("nome"),
                        rs.getString("documento"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("nacionalidade")
                );
                list.add(pa);
            }
        }
        return list;
    }
}
