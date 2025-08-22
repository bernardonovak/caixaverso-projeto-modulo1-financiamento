public class FinanciamentoImovel extends Financiamento {

    private final int idadeMinima = 21;
    private final int maximoParcelas = 360;
    private final int porcentagemEntrada = 20;
    private final int porcentagemLimiteParcela = 30;
    private final double jurosAno = 8;

    public FinanciamentoImovel(Cliente cliente, double valorFinanciamento) {
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
            motivoReprovacao = "Idade mínima para financiamento de imóvel é " + idadeMinima + " anos.";
            return false;
        }
        return true;
    }

    private boolean aprovarRendaMensal(){
        entradaMinima = valorBem * porcentagemEntrada / 100;
        valorFinanciado = valorBem - entradaMinima;
        double jurosTotal = valorFinanciado * (jurosAno / 100) * (maximoParcelas / 12);
        double valorFinal = valorFinanciado + jurosTotal;
        valorParcela = valorFinal / maximoParcelas;
        if(valorParcela > (cliente.getRendaMensal() * porcentagemLimiteParcela / 100 )){
            motivoReprovacao = "Valor da parcela excede 30% da renda mensal.";
            return false;
        }
        return true;
    }

}
