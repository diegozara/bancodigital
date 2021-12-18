import java.util.List;

public class Banco {

    private String nome;
    private int agencia;

    public Banco(String nome, int agencia) {
        this.nome = nome;
        this.agencia = agencia;
    }

    public Banco(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
}
