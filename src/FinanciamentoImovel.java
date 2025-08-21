public class FinanciamentoImovel extends Financiamento {

    private final int idadeMinima = 21;
    private final int maximoParcelas = 30;
    private final int porcentagemEntrada = 20;
    private final int porcentagemLimiteParcela = 30;
    private final double jurosAno = 8;

    public FinanciamentoImovel(Cliente cliente, double valorFinanciamento) {
        super(cliente, valorFinanciamento);
    }

    @Override
    public void avaliar(){
        if (aprovarIdadeMinima() && aprovarRendaMensal()){
            aprovado = true;
        }
    }

    private boolean aprovarIdadeMinima(){
        if(cliente.getIdade() < idadeMinima){
            this.motivoReprovacao = "Idade mínima para financiamento de imóvel é 21 anos.";
            return false;
        }
        return true;
    }

    private boolean aprovarRendaMensal(){
        double valorEntrada = valorBem * porcentagemEntrada / 100;
        double valorFinanciamento = valorBem - valorEntrada;
        double valorParcela = valorFinanciamento / maximoParcelas;
        if(valorParcela > (cliente.getRendaMensal() * porcentagemLimiteParcela / 100 )){
            motivoReprovacao = "Valor da parcela excede 30% da renda mensal.";
            return false;
        }
        return true;
    }
}
