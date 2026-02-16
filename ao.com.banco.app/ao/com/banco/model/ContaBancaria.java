package ao.com.banco.model;

import ao.com.banco.enums.StatusConta;
import jdk.jshell.Snippet;

public abstract class ContaBancaria {

    private int numero;
    private String titular;
    private double saldo;
    private StatusConta status;

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

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public StatusConta statusConta() {
        return status;
    }

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

    abstract void depositar(double valor);

    abstract void sacar(double valor);
    abstract double calcularRendimento();

}
