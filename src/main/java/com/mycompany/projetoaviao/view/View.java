/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.view;

/**
 *
 * @author keity
 */


import com.mycompany.projetoaviao.controller.Controller;
import com.mycompany.projetoaviao.model.Funcionario;
import com.mycompany.projetoaviao.model.Passageiro;
import com.mycompany.projetoaviao.model.Voo;
import java.util.List;
import java.util.Scanner;


public class View {
    
    private static final Scanner scan = new Scanner(System.in);
    private final Controller controller;
    
    public View(Controller controller) {
        this.controller = controller;
    }
    
    public void menuPrincipal() {
        while (true) {
            System.out.println("\n== MENU ==");
            System.out.println("1. Passageiros");
            System.out.println("2. Funcionários");
            System.out.println("3. Voos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            String op = scan.nextLine();

            switch (op) {
                case "1" -> this.menuPassageiros();
                case "2" -> this.menuFuncionarios();
                case "3" -> this.menuVoos();
                case "0" -> { System.out.println("Saindo..."); return; }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    
    // ===== Passageiros =====
    private void menuPassageiros() {
        System.out.println("\n=== PASSAGEIROS ===");
        System.out.println("1. Cadastrar passageiro");
        System.out.println("2. Listar passageiros");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");
        String op = scan.nextLine();

        switch (op) {
            case "1" -> this.cadastrarPassageiro();
            case "2" -> this.listarPassageiros();
            case "0" -> { return; }
            default -> System.out.println("Opção inválida.");
        }
    }

    private void cadastrarPassageiro() {
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Documento: ");
        String documento = scan.nextLine();
        System.out.print("Endereço: ");
        String endereco = scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = scan.nextLine();
        System.out.print("Nacionalidade: ");
        String nacionalidade = scan.nextLine();

        String resp = this.controller.cadastrarPassageiro(
                nome, documento, endereco, telefone, nacionalidade
        );
        System.out.println(resp);
    }

    private void listarPassageiros() {
        List<Passageiro> lista = this.controller.listarPassageiros();
        if (lista.isEmpty()) {
            System.out.println("Nenhum passageiro cadastrado.");
            return;
        }
        System.out.println("Nome | Documento | Telefone | Nacionalidade | Data Nasc.");
        for (Passageiro p : lista) {
            System.out.println(p.getNome() + " | " + p.getDocumento() + " | " + p.getTelefone()
                    + " | " + p.getNacionalidade());
        }
    }
    
//    private static void cadastrarFuncionario() {
//        System.out.print("Nome do funcionário: ");
//        String nome = scan.nextLine();
//        Funcionario f = Controller.criarFuncionario(nome);
//        System.out.println("Funcionário criado: ID " + f.id + " | " + f.nome);
//    }
//    
//    private static void listarFuncionarios() {
//        List<Funcionario> lista = Controller.listarFuncionarios();
//        if (lista.isEmpty()) {
//            System.out.println("Nenhum funcionário cadastrado.");
//            return;
//        }
//        System.out.println("ID | Nome");
//        for (Funcionario f : lista) {
//            System.out.println(f.id + "  | " + f.nome);
//        }
//    }
//    
//    private static void adicionarFuncionarioAoVoo() {
//        listarFuncionarios();
//        System.out.print("ID do funcionário: ");
//        int idFuncionario = lerInt();
//
//        listarVoosSimples();
//        System.out.print("ID do voo: ");
//        int idVoo = lerInt();
//
//        boolean ok = Controller.adicionarFuncionarioAoVoo(idFuncionario, idVoo);
//        System.out.println(ok ? "Funcionário adicionado ao voo."
//                              : "IDs inválidos (funcionário/voo).");
//    }
    
    
    // ===== Funcionários =====
    private void menuFuncionarios() {
        System.out.println("\n=== FUNCIONÁRIOS ===");
        System.out.println("1. Cadastrar funcionário");
        System.out.println("2. Listar funcionários");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");
        String op = scan.nextLine();

        switch (op) {
            case "1" -> this.cadastrarFuncionario();
            case "2" -> this.listarFuncionarios();
            case "0" -> { return; }
            default -> System.out.println("Opção inválida.");
        }
    }

    private void cadastrarFuncionario() {
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Documento: ");
        String documento = scan.nextLine();
        System.out.print("Endereço: ");
        String endereco = scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = scan.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scan.nextLine();
        System.out.print("Cargo: ");
        String cargo = scan.nextLine();
        System.out.print("ID do Aeroporto: ");
        String idAeroporto = scan.nextLine();

        String resp = this.controller.cadastrarFuncionario(
                nome, documento, endereco, telefone, matricula, cargo, idAeroporto
        );
        System.out.println(resp);
    }
    
    private void listarFuncionarios() {
        List<Funcionario> lista = this.controller.listarFuncionarios();
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("Nome | Documento | Telefone | Matrícula | Cargo | ID Aeroporto");
        for (Funcionario f : lista) {
            System.out.println(f.getNome() + " | " + f.getDocumento() + " | " + f.getTelefone()
                    + " | " + f.getMatricula() + " | " + f.getCargo() + " | " + f.getIdAeroporto());
        }
    }

//    private static void adicionarFuncionarioAoVoo() {
//        listarFuncionarios();
//        System.out.print("ID do funcionário: ");
//        int idFuncionario = lerInt();
//
//        listarVoos();
//        System.out.print("ID do voo: ");
//        int idVoo = lerInt();
//
//        boolean ok = Controller.adicionarFuncionarioAoVoo(idFuncionario, idVoo);
//        System.out.println(ok ? "Funcionário adicionado ao voo."
//                              : "IDs inválidos (funcionário/voo).");
//    }
    
    // ===== Voos =====
    private void menuVoos() {
        System.out.println("\n=== VOOS ===");
        System.out.println("1. Cadastrar voo");
        System.out.println("2. Listar voos");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");
        String op = scan.nextLine();

        switch (op) {
            case "1" -> this.cadastrarVoo();
            case "2" -> this.listarVoos();
            case "0" -> { return; }
            default -> System.out.println("Opção inválida.");
        }
    }
    
    private void cadastrarVoo() {
        System.out.print("ID do Voo (int): ");
        String idVoo = scan.nextLine();
        System.out.print("Duração prevista (HH:MM:SS): ");
        String duracaoPrevista = scan.nextLine();
        System.out.print("ID da Aeronave (int): ");
        String idAeronave = scan.nextLine();
        System.out.print("ID da Rota (int): ");
        String idRota = scan.nextLine();

        String resp = this.controller.cadastrarVoo(idVoo, duracaoPrevista, idAeronave, idRota);
        System.out.println(resp);
    }
    
    private void listarVoos() {
        List<Voo> lista = this.controller.listarVoos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }
        System.out.println("ID | Duração | ID Aeronave | ID Rota");
        for (Voo v : lista) {
            System.out.println(v.getIdVoo() + " | " + v.getDuracaoPrevista()
                    + " | " + v.getIdAeronave() + " | " + v.getIdRota());
        }
    }
}
