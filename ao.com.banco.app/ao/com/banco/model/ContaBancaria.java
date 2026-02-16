package ao.com.banco.model;

import ao.com.banco.enums.StatusConta;
import jdk.jshell.Snippet;

import java.util.ArrayList;

public abstract class ContaBancaria {

    private int numero;
    private String titular;
    private double saldo;
    private StatusConta status;
    private ArrayList<Transacao> transacoes;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public StatusConta getStatus() {
        return status;
    }



    public  ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }
    public void adicionarTransacao(Transacao transacao){transacoes.add(transacao);}


    public void setStatus(StatusConta status) {
        this.status = status;
    }

    public ContaBancaria(int numero, double saldo, String titular, StatusConta status) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", status=" + status +
                '}';
    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);
    public abstract double calcularRendimento();
    public abstract void transferir(ContaBancaria contaBancaria,double valor);
    public abstract ArrayList<Transacao> gerarExtrato() ;



}
