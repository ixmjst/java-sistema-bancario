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
        } catch (RuntimeException e) {
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
    public static void clienteServico(){
        System.out.println("Numero da Conta:");
        int numeroConta=ler.nextInt();
        ContaBancaria contaBancaria=buscarPorNumero(numeroConta);
        System.out.println("===BEM-VINDO DEVOLTA!===");
        System.out.println("1-Ver Saldo");
        System.out.println("2-Tranferir pra outra Conta( mesmo proprietario)");
        System.out.println("3-Remover Conta");
        System.out.println("4-Sacar");
        System.out.println("5-Depositar");
        System.out.println("6-Gerar extrato");
        System.out.println("(0)-Sair");
        int op = ler.nextInt();
        if (op == 1) {
            System.out.println(contaBancaria.getSaldo());
        } else if (op == 2) {
            BancoService.mostrarClientes();
        } else if (op == 3) {
            System.out.println("Digite o Valor a Sacar:");
            double valor = ler.nextDouble();
            contaBancaria.sacar(valor);

        } else if (op == 4) {
            System.out.println("Digite o numero da Conta:");
            int numero = ler.nextInt();
            BancoService.buscarPorNumero(numero);
        } else if (op == 5) {
            System.out.println("Digite a conta Origem:");
            int numContaOrigem = ler.nextInt();
            System.out.println("Digite a contaDestino:");
            int numContaDestino = ler.nextInt();
            System.out.println("Digite o valor:");
            double valor = ler.nextDouble();
            BancoService.transferirPorNumero(numContaOrigem, numContaDestino, valor);
        } else {
            System.out.println("Opcao Indisponivel");
        }




    }
    public static void BancoServiceMenu(){
        System.out.println("1-Criar Conta");
        System.out.println("2-Mostrar Clientes");
        System.out.println("3-Remover Clientes");
        System.out.println("4-Buscar por Clientes pelo Num. da Conta");
        System.out.println("5-Transferir pelo Num. da Conta");
        System.out.println("6-Efetuar Operacoes");
        System.out.println("(0)-sair");
        int op = ler.nextInt();
        if (op == 1) {
            BancoService.criarConta();
        } else if (op == 2) {
            BancoService.mostrarClientes();
        } else if (op == 3) {
            System.out.println("Digite o ID:");
            int id = ler.nextInt();
            BancoService.removerCliente(id);
        } else if (op == 4) {
            System.out.println("Digite o numero da Conta:");
            int numero = ler.nextInt();
            BancoService.buscarPorNumero(numero);
        } else if (op == 5) {
            System.out.println("Digite a conta Origem:");
            int numContaOrigem = ler.nextInt();
            System.out.println("Digite a contaDestino:");
            int numContaDestino = ler.nextInt();
            System.out.println("Digite o valor:");
            double valor = ler.nextDouble();
            BancoService.transferirPorNumero(numContaOrigem, numContaDestino, valor);
        } else {
            System.out.println("Opcao Indisponivel");
        }

    }


}
