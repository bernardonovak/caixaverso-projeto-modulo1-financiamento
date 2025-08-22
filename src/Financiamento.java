public abstract class Financiamento {

    protected Cliente cliente;
    protected double valorBem;
    protected boolean aprovado = false;
    protected String motivoReprovacao;
    protected double entradaMinima;
    protected double valorFinanciado;
    protected double valorParcela;
    protected int qtdeParcelas;

    public Financiamento(Cliente cliente, double valorBem) {
        this.cliente = cliente;
        this.valorBem = valorBem;
    }

    public abstract void avaliar();

    public boolean isAprovado() {return aprovado;}

    public double getValorParcela() {
        return valorParcela;
    }

    public double getValorFinanciado() {
        return valorFinanciado;
    }

    public double getEntradaMinima() {
        return entradaMinima;
    }

    public String getMotivoReprovacao() {
        return motivoReprovacao;
    }

    public int getQtdeParcelas() {
        return qtdeParcelas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorBem() {
        return valorBem;
    }
}
