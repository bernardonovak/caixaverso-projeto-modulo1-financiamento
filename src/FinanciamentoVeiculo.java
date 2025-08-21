public class FinanciamentoVeiculo extends Financiamento {

    private final int idadeMinima = 18;
    private final int maximoParcelas = 60;
    private final int porcentagemEntrada = 10;
    private final int porcentagemLimiteParcela = 20;
    private final double jurosMes = 1.5;

    public FinanciamentoVeiculo(Cliente cliente, double valorFinanciamento) {
        super(cliente, valorFinanciamento);
        qtdeParcelas = maximoParcelas;
        avaliar();
    }

    @Override
    public void avaliar(){
        if (aprovarIdadeMinima() && aprovarRendaMensal()){
            aprovado = true;
        }
    }

    private boolean aprovarIdadeMinima(){
        if(cliente.getIdade() < idadeMinima){
            motivoReprovacao = "Idade mínima para financiamento de imóvel é 21 anos.";
            return false;
        }
        return true;
    }

    private boolean aprovarRendaMensal(){
        entradaMinima = valorBem * porcentagemEntrada / 100;
        valorFinanciado = valorBem - entradaMinima;
        double jurosTotal = valorFinanciado * (jurosMes / 100) * qtdeParcelas;
        double valorFinal = valorFinanciado + jurosTotal;
        valorParcela = valorFinal / maximoParcelas;
        if(valorParcela > (cliente.getRendaMensal() * porcentagemLimiteParcela / 100 )){
            motivoReprovacao = "Valor da parcela excede 30% da renda mensal.";
            return false;
        }
        return true;
    }

}
