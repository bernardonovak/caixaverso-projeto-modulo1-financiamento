import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaFinanciamento {

    private static Scanner sc = new Scanner(System.in);
    private static List<FinanciamentoImovel> financiamentosImovel = new ArrayList<>();
    private static List<FinanciamentoVeiculo> financiamentosVeiculo = new ArrayList<>();

    public static void main(String[] args) {
        try {
            int opcao;
            do {
                exibirMenuPrincipal();
                opcao = sc.nextInt();

                direcionarOpcaoEscohida(opcao);
            } while (opcao != 0);
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida!");
        }
    }

    public static void exibirMenuPrincipal(){
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1 - Financiamento de Imóvel");
        System.out.println("2 - Financiamento de Veículo");
        System.out.println("3 - Listar Financiamentos de Imóveis");
        System.out.println("4 - Listar Financiamentos de Veículos");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public static void informarNovoFinanciamento(TipoFinanciamento tipoFinanciamento){
        System.out.println();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        System.out.print("Renda mensal: ");
        double rendaMensal = sc.nextDouble();
        System.out.print("Valor do bem: ");
        double valorBem = sc.nextDouble();
        System.out.println();

        Cliente cliente = new Cliente(nome, idade, rendaMensal);
        Financiamento financiamento;
        if(tipoFinanciamento == TipoFinanciamento.IMOVEL){
            financiamento = new FinanciamentoImovel(cliente, valorBem);
            financiamentosImovel.add((FinanciamentoImovel) financiamento);
        } else  {
            financiamento = new FinanciamentoVeiculo(cliente, valorBem);
            financiamentosVeiculo.add((FinanciamentoVeiculo) financiamento);
        }

        financiamento.imprimirResultado();
    }

    public static void direcionarOpcaoEscohida(int opcao){
        switch (opcao) {
            case 0:
                System.out.println("Encerrando programa de Financiamento.. Obrigado!");
                break;
            case 1:
                informarNovoFinanciamento(TipoFinanciamento.IMOVEL);
                break;
            case 2:
                informarNovoFinanciamento(TipoFinanciamento.VEICULO);
                break;
            case 3:
                imprimirFinanciamentosImovel();
                break;
            case 4:
                imprimirFinanciamentosVeiculo();
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }

    public static void imprimirFinanciamentosImovel(){
        System.out.println("=== FINANCIAMENTOS DE IMÓVEL ===");
        for (Financiamento fi : financiamentosImovel){
            fi.exibirFinanciamentoDetalhado();
        }
        System.out.println("=== FIM DA LISTA ===");
        System.out.println();
    }

    public static void imprimirFinanciamentosVeiculo(){
        System.out.println("=== FINANCIAMENTOS DE VEÍCULO ===");
        for (Financiamento fi : financiamentosVeiculo){
            fi.exibirFinanciamentoDetalhado();
        }
        System.out.println("=== FIM DA LISTA ===");
        System.out.println();
    }

}
