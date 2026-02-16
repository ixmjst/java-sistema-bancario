package ao.com.banco.service;

import ao.com.banco.model.Cliente;
import ao.com.banco.model.Transacao;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BancoService {
  public static ArrayList <Cliente> clientes;

    public BancoService() {
    }

    public static void criarConta(){
        System.out.println("Tipo de conta:");
        System.out.printf("1-Corrente");
        System.out.printf("2-Poupanca");

    }
    public static void transferir(){}
    public static ArrayList <Transacao> gerarExtrato(){}
    public static Cliente buscarPorNumero(){ }


}
