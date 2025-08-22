import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaFinanciamento {

    private static Scanner sc = new Scanner(System.in);
    private static List<Financiamento> financiamentosImovel = new ArrayList<>();
    private static List<Financiamento> financiamentosVeiculo = new ArrayList<>();

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

        imprimirResultadoFinanciamento(financiamento);
        System.out.println();
    }

    public static void imprimirResultadoFinanciamento(Financiamento financiamento){

        if(financiamento.isAprovado()){
            System.out.println("Financiamento Aprovado!");
            System.out.printf("Entrada Mínima: R$ %.2f %n", financiamento.getEntradaMinima() );
            System.out.printf("Valor Financiado: R$ %.2f %n", financiamento.getValorFinanciado() );
            System.out.printf("Número de parcelas: %d %n", financiamento.getQtdeParcelas());
            System.out.printf("Valor da parcela: R$ %.2f %n", financiamento.getValorParcela() );
        }else{
            System.out.println("Financiamento Reprovado!");
            System.out.printf("Motivo: %s %n", financiamento.getMotivoReprovacao());
        }
    }

    public static void imprimirCliente(Cliente cliente){
        System.out.printf("Nome do Cliente: %s %n", cliente.getNome());
    }

    public static void imprimirFinanciamentos(List<Financiamento> financiamentos){
        System.out.println("=== Lista de Financiamento ===");
        for (Financiamento fi : financiamentos){
            imprimirCliente(fi.getCliente());
            System.out.printf("Valor do Bem: R$ %.2f %n", fi.getValorBem());
            imprimirResultadoFinanciamento(fi);
            System.out.println();
        }
        System.out.println("---------------------");
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
                imprimirFinanciamentos(financiamentosImovel);
                break;
            case 4:
                imprimirFinanciamentos(financiamentosVeiculo);
            default:
                System.out.println("Opção Inválida!");
                break;
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

}
