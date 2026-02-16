package ao.com.banco.model;

import ao.com.banco.enums.StatusConta;

public class ContaPoupanca extends ContaBancaria{

    private double taxaJuros;

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public ContaPoupanca(int numero, double saldo, String titular, StatusConta status) {
        super(numero, saldo, titular, status);
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
         return (this.getSaldo()*this.taxaJuros);
    }

}
