package ao.com.banco.model;

import ao.com.banco.enums.TipoTransacao;

import java.time.LocalDate;

public class Transacao {
    TipoTransacao tipoTransacao;
    double valor;
    LocalDate data;
    String descricao;

    public Transacao() {
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Transacao(TipoTransacao tipoTransacao, double valor, LocalDate data, String descricao) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "tipoTransacao=" + tipoTransacao +
                ", valor=" + valor +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
