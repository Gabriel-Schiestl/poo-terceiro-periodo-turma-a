package primeirobi.listas;

import java.util.Scanner; // Importar classe de Scanner
import java.util.ArrayList; // Importar classe de ArrayList

public class CalculadoraEspecializada {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int menu = 0; // Definição de inteiro para o while funcionar e seleção de operação
        int unidade; // Unidade de produto
        double pagamento; // Pagamento do cliente
        double preco; // Preço do produto
        double valor; // Valor total do produto  
        double resultado; // Resultado da operação sendo valor total ou troco
        double desconto = 0.0; // Desconto especial de compra

        // Lista de vetores
        ArrayList<Integer> quantidadedeplantas = new ArrayList<Integer>();
        ArrayList<Double> valordavenda = new ArrayList<Double>();
        ArrayList<Double> descontosaplicados = new ArrayList<Double>();

        while (menu != 4) { // While para o programa rodar até sair (selecionar 4 no menu)

        System.out.println("\nBem-vindo(a) à loja de plantas exóticas da Dona Gabrielinha!\n");// Introdução do menu
        System.out.println("[MENU] Selecione a operação desejada:"); // Seleção
        System.out.println("[1] - Calcular o Preço Total"); // Unidade multiplicado por preço
        System.out.println("[2] - Calcular o Troco"); // Pagamento menos o valor total
        System.out.println("[3] - Ler o Registro"); // Leitura de registro de compras passadas
        System.out.println("[4] - Sair\n"); // Fechar o programa
        menu = entrada.nextInt(); // Entrada de dados do menu

        switch (menu) { // Switch com seleção do menu

            case 1: 
            // [1] - Calcular o preço total

            System.out.println("\nInforme a unidade de produtos a pagar:\n");
            unidade = entrada.nextInt(); // Entrada de unidades de produtos em inteiro

            if (unidade < 0) { // Caso o unidade for negativo
                System.out.println("\nErro!\n");
                break;
            } 

            System.out.println("\nInforme o preço do produto:\n");
            preco = entrada.nextFloat(); // Entrada de preço do produto em float

            if (preco < 0) { // Caso o preço for negativo
                System.out.println("\nErro!\n");
                break;
            } 

            resultado = preco * unidade; // Multiplicação e resultado para o valor total

            desconto = 0.0; // Resetar valor de desconto

            // Desconto Especial
            if(unidade >= 10){ // Se um cliente comprar mais de 10 plantas
                desconto = resultado*0.05; // Terá 5% de desconto
                resultado = resultado - desconto; // No valor total da compra
            }
            descontosaplicados.add(desconto); // Adicionar valor do desconto no vetor de descontos

            if (resultado < 0) { // Caso o resultado for negativo
                System.out.println("\nErro!\n");
            } else {
            System.out.println("\nO valor total é de:\n");
            System.out.println("R$ " + resultado +"\n"); // Resultado preço total
            } 

            quantidadedeplantas.add(unidade); // Adicionar unidades no vetor de quantidade de plantas
            valordavenda.add(resultado); // Adicionar valor total no vetor de valores de venda

                break; // Não passar para os próximos cases

            case 2: 
            // [2] - Calcular o troco

            System.out.println("\nInforme o valor recebido pelo cliente:\n");
            pagamento = entrada.nextFloat(); // Entrada do pagamento do cliente em float

            if (pagamento < 0) { // Caso o pagamento for negativo
                System.out.println("\nErro!\n");
                break;
            } 

            System.out.println("\nInforme o valor total da compra:\n");
            valor = entrada.nextFloat(); // Entrada do valor total em float

            if (valor < 0) { // Caso o valor for negativo
                System.out.println("\nErro!\n");
                break;
            } 

            resultado = pagamento - valor; // Subtração e resultado para o troco

            if (resultado < 0) { // Caso o resultado for negativo
                System.out.println("\nErro ou o Cliente está devendo!\n");
            } else {
            System.out.println("\nO troco do cliente é de:\n");
            System.out.println("R$ " + resultado + "\n"); // Resultado troco
            }
            break; // Não passar para os próximos cases

            case 3: 
            // [3] - Ler o registro de vendas

            System.out.println("\nQuantidade de plantas vendidas:");
            // Leitor do vetor de unidades de produtos da compra
            for (int i = 0; i < quantidadedeplantas.size(); i++) {
            System.out.println(quantidadedeplantas.get(i));
            }

            System.out.println("\nValor das vendas:");
            // Leitor do vetor de valor total de compras
            for (int i = 0; i < valordavenda.size(); i++) {
            System.out.println(valordavenda.get(i));
            }

            System.out.println("\nDescontos aplicados:");
            // Leitura do vetor de descontos
            for (int i = 0; i < descontosaplicados.size(); i++) {
            System.out.println(descontosaplicados.get(i));
            }

            break; // Não passar para os próximos cases

            case 4: 
            // [4] - Sair

            System.out.println("\nPrograma Finalizado!\n"); // Encerrar o programa

            default: // Caso não haver resposta correta de 1 á 3
                break; // Fim do switch
        }

        } // Fim do while

        entrada.close(); // Fim da entrada de dados
    }
}