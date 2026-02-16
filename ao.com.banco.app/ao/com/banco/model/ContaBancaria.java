package ao.com.banco.model;

abstract class ContaBancaria {

    private int numero;
    private String titular;
    private double saldo;
    private boolean status;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ContaBancaria(int numero, double saldo, String titular, boolean status) {
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

    abstract void depositar(double amount);

    abstract double sacar(double amount);
    abstract void calcularRendimento();

}
