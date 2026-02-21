package ao.com.banco.model;

import ao.com.banco.enums.StatusConta;
import ao.com.banco.enums.TipoTransacao;
import ao.com.banco.exceptions.SaldoInsuficienteException;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;

public class ContaCorrente extends ContaBancaria {
    private double limite;


    public ContaCorrente(int numero, double saldo, String titular, StatusConta status, double limite) {
        super(numero, saldo, titular, status);
        this.limite = limite;
    }

    @Override
    public void depositar(double valor) {
        if ((valor > 0) && (this.getStatus() != StatusConta.INATIVA)) {
            this.setSaldo(this.getSaldo() + valor);
            this.adicionarTransacao(new Transacao(TipoTransacao.SAQUE, valor, LocalDate.now(), "Deposito"));
        } else {
            throw new SaldoInsuficienteException("Saldo deve ser maior que 0 e a conta deve estar Ativa");
        }
    }

    @Override
    public void sacar(double valor) {
        if ((valor < this.getSaldo()) && (valor > 0)) {
            this.setSaldo(this.getSaldo() - valor);
        } else if (this.getStatus() != StatusConta.ATIVA) {
            System.out.println("ERRO...Precisa ativar a conta!!");
        } else {
            throw new SaldoInsuficienteException("Saldo Insuficiente...Deposite  e Tente mais tarde! (^-^)");
        }
    }

    @Override
    public double calcularRendimento() {
        return 0.0;
    }

    @Override
    public void transferir(ContaBancaria contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        this.adicionarTransacao(new Transacao(TipoTransacao.TRANSFERENCIA, valor, LocalDate.now(), "Tranferencia"));
    }

    @Override
    public void gerarExtrato() {
        for (Transacao transacao : this.getTransacoes()) {
            System.out.println(transacao);

        }
    }


}
