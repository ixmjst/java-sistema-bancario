package ao.com.banco.model;

import ao.com.banco.enums.StatusConta;

public class ContaCorrente extends ContaBancaria{
     private double limite;


    public ContaCorrente(int numero, double saldo, String titular, StatusConta status, double limite) {
        super(numero, saldo, titular, status);
        this.limite = limite;
    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo()+valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor<this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
        }
    }

    @Override
    public double calcularRendimento() {
       return 0.0;
    }


}
