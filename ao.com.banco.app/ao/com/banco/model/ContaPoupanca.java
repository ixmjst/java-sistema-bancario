package ao.com.banco.model;

public class ContaPoupanca extends ContaBancaria{

    private double taxaJuros;

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public ContaPoupanca(int numero, double saldo, String titular, boolean status) {
        super(numero, saldo, titular, status);
    }


    @Override
    void depositar(double amount) {

    }

    @Override
    double sacar(double amount) {
        return 0;
    }

    @Override
    void calcularRendimento() {

    }

}
