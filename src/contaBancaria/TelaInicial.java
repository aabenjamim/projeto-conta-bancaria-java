package contaBancaria;

import java.util.Scanner;

public class TelaInicial {

    public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);

    int opcao;

    System.out.println("BANCO AMARELO");
    System.out.println("SEU DINHEIRO BEM CUIDADO");
    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
    System.out.println("1 - CONTA POUPANÇA");
    System.out.println("2 - CONTA CORRENTE");
    System.out.println("3 - CONTA ESPECIAL");
    System.out.println("4 - CONTA EMPRESA");
    System.out.println("5 - CONTA ESTUDANTIL");
    System.out.println("6 - SAIR");
    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
    System.out.print("DIGITE O CODIGO DA OPÇÃO SELECIONADA: ");

    opcao = entrada.nextInt();

    if(opcao == 1){
       // Conta novaConta = new ContaPoupanca();
    }

/*
do {
    System.out.println("[NOME DO BANCO]");
    System.out.println("[SLOGAN]");
    System.out.println(" ");
    System.out.println("1 - CONTA POUPANÇA");
    System.out.println("2 - CONTA CORRENTE");
    System.out.println("3 - CONTA ESPECIAL");
    System.out.println("4 - CONTA EMPRESA");
    System.out.println("5 - CONTA ESTUDANTIL");
    System.out.println("6 - SAIR");
    System.out.print("DIGITE O CODIGO DA OPÇÃO SELECIONADA: ");
    opcao = scanner.nextInt();
    switch(opcao) {
        case 1:
            // Seleciona conta poupança
            break;
        case 2:
            // Seleciona conta corrente
            break;
        case 3:
            // Seleciona conta especial
            break;
        case 4:
            // Seleciona conta empresa
            break;
        case 5:
            // Seleciona conta estudantil
            break;
        case 6:
            // Sai do programa
            break;
        default:
            System.out.println("Opção inválida!");
    }
} while(opcao != 6);*/
    }

}
