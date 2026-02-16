package ao.com.banco.model;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String BI;
    private String telefone;
    private ArrayList <ContaBancaria>contas=new ArrayList();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBI() {
        return BI;
    }

    public void setBI(String BI) {
        this.BI = BI;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", BI='" + BI + '\'' +
                ", telefone='" + telefone + '\'' +
                ", contas=" + contas +
                '}';
    }
    public void adicionarConta(ContaBancaria conta){
        this.getContas().add(conta);
    }
    public void removerConta(int id){
         ContaBancaria contaBancaria=this.contas.get(id);
         this.contas.remove(contaBancaria);
    }
    public Cliente(String nome, String BI, String telefone) {
        this.nome = nome;
        this.BI = BI;
        this.telefone = telefone;
    }
}
