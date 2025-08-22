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

    public void imprimirResultado(){
        if(isAprovado()){
            System.out.println("Financiamento Aprovado!");
            System.out.printf("Entrada Mínima: R$ %.2f %n", entradaMinima );
            System.out.printf("Valor Financiado: R$ %.2f %n", valorFinanciado );
            System.out.printf("Número de parcelas: %d %n", qtdeParcelas);
            System.out.printf("Valor da parcela: R$ %.2f %n", valorParcela );
        }else{
            System.out.println("Financiamento Reprovado!");
            System.out.printf("Motivo: %s %n", motivoReprovacao);
        }
        System.out.println();
    }

    public void exibirFinanciamentoDetalhado(){
        cliente.imprimirInformacoesCliente();
        System.out.printf("Valor do Bem: R$ %.2f %n", valorBem);
        imprimirResultado();
        System.out.println();
    }
}
