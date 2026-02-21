package ao.com.banco.model;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private int id;
    private String nome;
    private String BI;
    private String telefone;
    private ArrayList <ContaBancaria>contas=new ArrayList();

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public Cliente() {
    }

    public Cliente(String nome, String BI, String telefone) {
        this.nome = nome;
        this.BI = BI;
        this.telefone = telefone;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(BI, cliente.BI);
    }



}
