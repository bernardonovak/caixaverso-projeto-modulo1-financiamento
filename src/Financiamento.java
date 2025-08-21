public abstract class Financiamento {

    protected Cliente cliente;
    protected double valorBem;
    protected boolean aprovado = false;
    protected String motivoReprovacao;

    public Financiamento(Cliente cliente, double valorBem) {
        this.cliente = cliente;
        this.valorBem = valorBem;
    }

    public abstract void avaliar();

    public boolean isAprovado() {return aprovado;}

    public void exibirInformaçõesFinanciamento() {
        System.out.printf("Financiamento %n!", ((aprovado)?"Aprovado" : "Reprovado") );
    }
}
