public class Cliente {

    private String nome;
    private int idade;
    private double rendaMensal;

    public Cliente() {
    }

    public Cliente(String nome, int idade, double rendaMensal) {
        this.nome = nome;
        this.idade = idade;
        this.rendaMensal = rendaMensal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}
