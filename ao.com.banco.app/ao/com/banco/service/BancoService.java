package ao.com.banco.service;

import ao.com.banco.enums.StatusConta;
import ao.com.banco.exceptions.ContaInativaException;
import ao.com.banco.exceptions.NullLabelException;
import ao.com.banco.model.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BancoService {
    private static final Scanner ler = new Scanner(System.in);
    private static final ArrayList<Cliente> clientes = new ArrayList<>();

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
            ContaCorrente contaCorrente = new ContaCorrente(Math.abs(randomNum), valorAbertura, cliente.getNome(), StatusConta.ATIVA, 50000);
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
            ContaPoupanca contaPoupanca = new ContaPoupanca(Math.abs(randomNum), valorAbertura, cliente.getNome(), StatusConta.ATIVA, 1.5);
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

    public static void mostrarClientes() {
        try {
            for (Cliente cliente : clientes) {

                System.out.println(cliente);

            }
        } catch (RuntimeException e) {
            throw new NullLabelException("Lista Vazia");
        }
    }


    public static void removerCliente(int id) {
        try {
            if ((clientes.contains(clientes.get(id)))) {
                clientes.remove(id);
            }

        } catch (RuntimeException e) {
            throw new NullLabelException("Lista Vazia");
        }
    }

    public static ContaBancaria buscarPorNumero(int numeroConta) {
        ContaBancaria contaBancaria = null;
        if (clientes == null) {
            return null;
        } else {
            for (Cliente cliente : clientes) {
                for (ContaBancaria conta : cliente.getContas()) {

                    if (conta.getNumero() == numeroConta) {
                        contaBancaria = conta;
                        return contaBancaria;

                    }

                }
            }
        }

        return contaBancaria;

    }

    public static void clienteServico(int numeroConta) {

        if (buscarPorNumero(numeroConta) != null) {
            ContaBancaria contaBancaria = buscarPorNumero(numeroConta);

            System.out.println("===BEM-VINDO DEVOLTA!===");
            System.out.println("1-Ver Saldo");
            System.out.println("2-Tranferir pra outra Conta( mesmo proprietario)");
            System.out.println("3-Sacar");
            System.out.println("4-Depositar");
            System.out.println("5-Gerar extrato");
            System.out.println("(0)-Voltar");
            int op = ler.nextInt();


            if (op == 1) {
                if ((contaBancaria instanceof ContaPoupanca) || (contaBancaria instanceof ContaCorrente)) {
                    System.out.println("Saldo Atual: "+contaBancaria.getSaldo());
                }

                clienteServico(numeroConta);
            } else if (op == 2) {
                System.out.println("Valor:");
                double valor = ler.nextDouble();
                System.out.println("Numero da Conta Destino:");
                int numeroContaDestino = ler.nextInt();
                try {
                    ContaBancaria contaBancariaDestino = buscarPorNumero(numeroContaDestino);
                    if ((contaBancaria instanceof ContaPoupanca) || (contaBancaria instanceof ContaCorrente)) {
                        if (contaBancaria.getTitular().compareTo(contaBancariaDestino.getTitular()) == 0) {
                            contaBancaria.transferir(contaBancariaDestino, valor);
                        } else {
                            System.out.println("So e possivel pra contas cujo o  proprietario e o  mesmo");
                        }
                    }

                } catch (Exception e) {
                    throw new ContaInativaException("Conta Inativa...crie uma Segunda Conta!");
                }

            } else if (op == 3) {
                System.out.println("Digite o Valor a Sacar:");
                double valor = ler.nextDouble();
                if ((contaBancaria instanceof ContaPoupanca) || (contaBancaria instanceof ContaCorrente)) {
                    contaBancaria.sacar(valor);
                }
            } else if (op == 4) {
                System.out.println("Digite  o  Valor a depositar:");
                double valor = ler.nextDouble();
                if ((contaBancaria instanceof ContaPoupanca) || (contaBancaria instanceof ContaCorrente)) {
                    contaBancaria.depositar(valor);
                }
            } else if (op == 5) {
                if ((contaBancaria instanceof ContaPoupanca) || (contaBancaria instanceof ContaCorrente)) {
                    contaBancaria.gerarExtrato();
                }
            } else {
                System.out.println("Opcao Indisponivel");
            }
        } else {
            System.out.println("Conta Inativa...Crie uma conta antes!");
        }


    }

    public static void BancoServiceMenu() {
        System.out.println("1-Criar Conta");
        System.out.println("2-Mostrar Clientes");
        System.out.println("3-Remover Clientes");
        System.out.println("4-Buscar por Clientes pelo Num. da Conta");
        System.out.println("5-Transferir pelo Num. da Conta");
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
