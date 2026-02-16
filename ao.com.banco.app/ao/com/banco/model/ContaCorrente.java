package ao.com.banco.model;

import ao.com.banco.enums.StatusConta;

public class ContaCorrente extends ContaBancaria{
     private double limite;


    public ContaCorrente(int numero, double saldo, String titular, StatusConta status, double limite) {
        super(numero, saldo, titular, status);
        this.limite = limite;
    }

    @Override
    void depositar(double amount) {
        this.setSaldo(this.getSaldo()+amount);
    }

    @Override
    void sacar(double amount) {
        if (amount<this.getSaldo()) {
            this.setSaldo(this.getSaldo() - amount);
        }
    }

    @Override
    double calcularRendimento() {
       return 0.0;
    }


}
