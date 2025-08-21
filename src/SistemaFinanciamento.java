import java.util.Scanner;

public class SistemaFinanciamento {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1 - Financiamento de Imóvel");
            System.out.println("2 - Financiamento de Veículo");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    informarNovoFinanciamento(TipoFinanciamento.IMOVEL);
                    break;
                case 2:
                    informarNovoFinanciamento(TipoFinanciamento.VEICULO);
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);

    }

    public static void informarNovoFinanciamento(TipoFinanciamento tipoFinanciamento){
        System.out.println("Por favor digite os dados abaixo: ");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Idade: ");
        int idade = sc.nextInt();
        System.out.println("Renda mensal: ");
        double rendaMensal = sc.nextDouble();
        System.out.println("Valor do bem: ");
        double valorBem = sc.nextDouble();

        Cliente cliente = new Cliente(nome, idade, rendaMensal);
        Financiamento financiamento;
        if(tipoFinanciamento == TipoFinanciamento.IMOVEL){
            financiamento = new FinanciamentoImovel(cliente, valorBem);
        } else if (tipoFinanciamento == TipoFinanciamento.VEICULO) {
            financiamento = new FinanciamentoVeiculo(cliente, valorBem);
        }
        financiamento.avaliar();
    }
}
