package ao.com.banco.service;

import ao.com.banco.enums.StatusConta;
import ao.com.banco.exceptions.ContaInativaException;
import ao.com.banco.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BancoService {
    private static final Scanner ler = new Scanner(System.in);
    private static ArrayList<Cliente> clientes;

    private static void adicionarClientes(Cliente cliente) {
        clientes.add(cliente);
    }


    public static void criarConta() {

        Random random = new Random();
        int randomNum = random.nextInt();
        System.out.println("Tipo de conta:");
        System.out.println("1-Corrente");
        System.out.println("2-Poupanca");
        int num = ler.nextInt();
        if (num == 1) {
            ler.nextLine();
            System.out.println("Nome do Titular:");
            String nome = ler.nextLine();
            System.out.println("Bilhete de Identidade:");
            String bi = ler.nextLine();
            System.out.println("Telefone:");
            String numeroTelefone = ler.nextLine();
            System.out.println("Valor de Abertura(>=20.000,kz):");
            double valorAbertura = ler.nextDouble();
            while (valorAbertura < 20000) {
                System.out.print("Digite um valor igual ou superior: ");
                valorAbertura = ler.nextDouble();
            }
            Cliente cliente = new Cliente(nome, bi, numeroTelefone);
            ContaCorrente contaCorrente = new ContaCorrente(randomNum, valorAbertura, cliente.getNome(), StatusConta.ATIVA, 50000);
            cliente.adicionarConta(contaCorrente);
            adicionarClientes(cliente);


        } else if (num == 2) {
            ler.nextLine();
            System.out.println("Nome do Titular:");
            String nome = ler.nextLine();
            System.out.println("Bilhete de Identidade:");
            String bi = ler.nextLine();
            System.out.println("Telefone:");
            String numeroTelefone = ler.nextLine();
            System.out.println("Valor de Abertura(>=10.000,kz):");
            double valorAbertura = ler.nextDouble();
            while (valorAbertura < 10000) {
                System.out.print("Digite um valor igual ou superior: ");
                valorAbertura = ler.nextDouble();
            }
            Cliente cliente = new Cliente(nome, bi, numeroTelefone);
            ContaPoupanca contaPoupanca = new ContaPoupanca(randomNum, valorAbertura, cliente.getNome(), StatusConta.ATIVA, 1.5);
            cliente.adicionarConta(contaPoupanca);
            adicionarClientes(cliente);
        } else {
            System.out.println("Conta Inexistente");
        }

    }

    public static void transferirPorNumero(int numContaOrigem, int numContaDestino, double valor) {
        try {


            ContaBancaria conta1 = buscarPorNumero(numContaOrigem);
            ContaBancaria conta2 = buscarPorNumero(numContaDestino);
            conta1.transferir(conta2, valor);
        } catch (Exception e) {
            throw new ContaInativaException("Conta Inativa");
        }
    }

   public static void mostrarClientes(){
        for (Cliente cliente: clientes) {

            System.out.println(cliente);
            System.out.print(":");
            for (ContaBancaria conta : cliente.getContas()) {
                System.out.println(conta);
            }
        }
   }

    public static void removerCliente(int id) {
        if (clientes.isEmpty()) {
            System.out.println("Lista vazia");
        } else if (clientes.contains(id)) {
            clientes.remove(id);
        }


    }

    public static ContaBancaria buscarPorNumero(int numeroConta) {
        ContaBancaria contaBancaria = null;
        if (clientes == null) {
            return null;
        }
        for (Cliente cliente : clientes) {
            for (ContaBancaria conta : cliente.getContas()) {

                if (conta.getNumero() == id) {
                    contaBancaria = conta;
                    return contaBancaria;

                }

            }
        }

        return contaBancaria;

    }


}
