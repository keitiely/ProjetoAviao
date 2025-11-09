/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoaviao.view;
import java.util.Scanner;

public class View {

    private static final Scanner scan = new Scanner(System.in);

    public static void menuPrincipal() {
        while (true) {
            System.out.println("\n== MENU ==");
            System.out.println("1. Passageiros");
            System.out.println("2. Funcionários");
            System.out.println("3. Voos");
            System.out.print("Opção: ");
            String op = scan.nextLine();

            switch (op) {
                case "1" -> menuPassageiros();
                case "2" -> menuFuncionarios();
                case "3" -> menuVoos();
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    
    // ===== Passageiros =====
    private static void menuPassageiros() {
        System.out.println("\n=== PASSAGEIROS ===");
        System.out.println("1. Cadastrar passageiro");
        System.out.println("2. Listar passageiros");
        System.out.println("3. Adicionar passageiro a um voo");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");
        String op = scan.nextLine();

        switch (op) {
            case "1" -> System.out.println("Cadastrar FUNCAO TEM QUE FAZER");
            case "2" -> System.out.println("Listar TEM QUE FAZER");
            case "3" -> System.out.println("Adicionar FUNCAO TEM QUE FAZER");
            case "0" -> menuPrincipal();
            default -> System.out.println("Opção inválida.");
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
    private static void menuFuncionarios() {
        System.out.println("\n=== FUNCIONÁRIOS ===");
        System.out.println("1. Cadastrar funcionário");
        System.out.println("2. Listar funcionários");
        System.out.println("3. Adicionar funcionário a um voo");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");
        String op = scan.nextLine();

        switch (op) {
             case "1" -> System.out.println("Cadastrar FUNCAO TEM QUE FAZER");
            case "2" -> System.out.println("Listar TEM QUE FAZER");
            case "3" -> System.out.println("Adicionar FUNCAO TEM QUE FAZER");
            case "0" -> menuPrincipal();
            default -> System.out.println("Opção inválida.");
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
    private static void menuVoos() {
        System.out.println("\n=== VOOS ===");
        System.out.println("1. Cadastrar voo");
        System.out.println("2. Listar voos");
        System.out.println("3. Ver Passageiros no Voo");
        System.out.println("4. Ver Funcionários no Voo");
        System.out.println("0. Voltar");
        System.out.print("Opção: ");
        String op = scan.nextLine();

        switch (op) {
            case "1" -> System.out.println("Cadastrar FUNCAO TEM QUE FAZER");
            case "2" -> System.out.println("Listar FUNCAO TEM QUE FAZER");
            case "3" -> System.out.println("Ver Passageiros FUNCAO TEM QUE FAZER");
            case "4" -> System.out.println("Ver Funcionaros FUNCAO TEM QUE FAZER");
            case "0" -> menuPrincipal();
            default -> System.out.println("Opção inválida.");
        }
    }

//    private static void cadastrarVoo() {
//        System.out.print("Código do voo (ex: JJ1234): ");
//        String codigo = scan.nextLine();
//        Voo v = Controller.criarVoo(codigo);
//        System.out.println("Voo criado: ID " + v.id + " | " + v.codigo);
//    }

//    private static void listarVoos() {
//        List<Voo> lista = Controller.listarVoos();
//        if (lista.isEmpty()) {
//            System.out.println("Nenhum voo cadastrado.");
//            return;
//        }
//        System.out.println("ID | Código | #Passageiros | #Funcionários");
//        for (Voo v : lista) {
//            System.out.println(v.id + "  | " + v.codigo + " | "
//                    + v.passageiros.size() + "            | " + v.funcionarios.size());
//        }
//    }
}