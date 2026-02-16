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


    public ContaPoupanca(int numero, double saldo, String titular, StatusConta status, double taxaJuros) {
        super(numero, saldo, titular, status);
    }


    @Override
    public void depositar(double valor) {
        if ((valor > 0) && (this.getStatus() != StatusConta.INATIVA)) {
            this.setSaldo(this.getSaldo() + valor);
            this.adicionarTransacao(new Transacao(TipoTransacao.SAQUE, valor, LocalDate.now(), "Deposito"));
        }
        System.out.println("Saldo deve ser maior que 0 e a conta deve estar Ativa");
    }

    @Override
    public void sacar(double valor) {
        if (valor<this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
            this.adicionarTransacao(new Transacao(TipoTransacao.SAQUE, valor, LocalDate.now(), "Levantamento"));
        } else if (this.getStatus() != StatusConta.ATIVA) {
            System.out.println("ERRO...Precisa ativar a conta!!");
        } else {
            System.out.println("N e possivel retirar o montante solicitado");
        }
    }

    @Override
    public double calcularRendimento() {
         return (this.getSaldo()*this.taxaJuros);
    }

    @Override
    public void transferir(ContaBancaria contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        this.adicionarTransacao(new Transacao(TipoTransacao.TRANSFERENCIA, valor, LocalDate.now(), "Tranferencia"));

    }

    @Override
    public void gerarExtrato() {
        for (Transacao transacao: this.getTransacoes()){
            System.out.println(transacao);

        }
    }

}
