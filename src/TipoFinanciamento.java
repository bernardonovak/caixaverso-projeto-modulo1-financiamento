public enum TipoFinanciamento {

    IMOVEL(1, "Financiamento de Imóvel"),
    VEICULO(2, "Financiamento de Veículo");

    private int opcao;
    private String descricao;

    TipoFinanciamento(int opcao, String descricao) {
        this.opcao = opcao;
        this.descricao = descricao;
    }
}
