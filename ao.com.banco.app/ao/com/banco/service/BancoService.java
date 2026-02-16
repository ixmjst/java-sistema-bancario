package ao.com.banco.service;

import ao.com.banco.enums.StatusConta;
import ao.com.banco.model.Cliente;
import ao.com.banco.model.ContaCorrente;
import ao.com.banco.model.ContaPoupanca;
import ao.com.banco.model.Transacao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BancoService {
  private static ArrayList <Cliente> clientes;
   private static void adicionarClientes(Cliente cliente){
       clientes.add(cliente);
   }


    public static void criarConta(){
        Scanner ler=new Scanner(System.in);
         Random random= new Random();
         int randomNum=random.nextInt();
        System.out.println("Tipo de conta:");
        System.out.println("1-Corrente");
        System.out.println("2-Poupanca");
        int num=ler.nextInt();
        if (num==1){
            ler.nextLine();
            System.out.println("Nome do Titular:");
            String nome=ler.nextLine();
            System.out.println("Bilhete de Identidade:");
            String bi=ler.nextLine();
            System.out.println("Telefone:");
            String numeroTelefone= ler.nextLine();
            System.out.println("Valor de Abertura(>=20.000,kz):");
            double valorAbertura=ler.nextDouble();
            while(valorAbertura<20000){
                System.out.print("Digite um valor igual ou superior: ");
                valorAbertura=ler.nextDouble();
            }
            Cliente cliente= new Cliente(nome,bi,numeroTelefone);
            ContaCorrente contaCorrente=new ContaCorrente(randomNum,valorAbertura,cliente.getNome(),StatusConta.ATIVA,50000);
            cliente.getContas().add(contaCorrente);
            adicionarClientes(cliente);


        }
        else if (num==2){
            ler.nextLine();
            System.out.println("Nome do Titular:");
            String nome=ler.nextLine();
            System.out.println("Bilhete de Identidade:");
            String bi=ler.nextLine();
            System.out.println("Telefone:");
            String numeroTelefone= ler.nextLine();
            System.out.println("Valor de Abertura(>=10.000,kz):");
            double valorAbertura=ler.nextDouble();
            while(valorAbertura<10000){
                System.out.print("Digite um valor igual ou superior: ");
                valorAbertura=ler.nextDouble();
            }
            Cliente cliente= new Cliente(nome,bi,numeroTelefone);
            ContaPoupanca contaPoupanca =new ContaPoupanca(randomNum,valorAbertura,cliente.getNome(),StatusConta.ATIVA);
            cliente.getContas().add(contaPoupanca);
            adicionarClientes(cliente);
        }
        else {
            System.out.println("Conta Inexistente");
        }

    }
    public static void transferir(){}
    public static ArrayList <Transacao> gerarExtrato(){}
    public static Cliente buscarPorNumero(){ }


}
