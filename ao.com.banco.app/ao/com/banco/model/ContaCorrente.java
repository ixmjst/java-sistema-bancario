package ao.com.banco.model;

public class ContaCorrente extends ContaBancaria{
     private double limite;


    public ContaCorrente(int numero, double saldo, String titular, boolean status, double limite) {
        super(numero, saldo, titular, status);
        this.limite = limite;
    }

    @Override
    void depositar(double amount) {
        this.setSaldo(this.getSaldo()+amount);
    }

    @Override
    double sacar(double amount) {
        return 0;
    }

    @Override
    void calcularRendimento() {

    }


}
