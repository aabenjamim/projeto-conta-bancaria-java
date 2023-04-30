package contaBancaria;

import java.util.Scanner;

public class TelaInicial {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcao;
        String cpf;
        int numero;
        int diaAniversarioPoupanca;

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

        if (opcao == 1) {
            System.out.print("DIGITE O NÚMERO DA CONTA: ");
            numero = entrada.nextInt();
            entrada.nextLine();
            System.out.print("DIGITE O CPF DO TITULAR: ");
            cpf = entrada.nextLine();
            System.out.print("DIGITE O DIA DE ANIVERSÁRIO DA CONTA: ");
            diaAniversarioPoupanca = entrada.nextInt();
            Conta conta = new ContaPoupanca(numero, cpf, diaAniversarioPoupanca);
            System.out.println("CONTA CRIADA COM SUCESSO!");
        } else if (opcao == 2) {
            System.out.print("DIGITE O NÚMERO DA CONTA: ");
            numero = entrada.nextInt();
            entrada.nextLine();
            System.out.print("DIGITE O CPF DO TITULAR: ");
            cpf = entrada.nextLine();
            Conta conta = new ContaCorrente(numero, cpf);
            System.out.println("CONTA CRIADA COM SUCESSO!");
        } else if (opcao == 3) {
            System.out.print("DIGITE O NÚMERO DA CONTA: ");
            numero = entrada.nextInt();
            entrada.nextLine();
            System.out.print("DIGITE O CPF DO TITULAR: ");
            cpf = entrada.nextLine();
            Conta conta = new ContaEspecial(numero, cpf);
            System.out.println("CONTA CRIADA COM SUCESSO!");
        } else if (opcao == 4) {
            System.out.print("DIGITE O NÚMERO DA CONTA: ");
            numero = entrada.nextInt();
            entrada.nextLine();
            System.out.print("DIGITE O CPF DO TITULAR: ");
            cpf = entrada.nextLine();
            Conta conta = new ContaEmpresa(numero, cpf);
            System.out.println("CONTA CRIADA COM SUCESSO!");
        } else if (opcao == 5){
            System.out.print("DIGITE O NÚMERO DA CONTA: ");
            numero = entrada.nextInt();
            System.out.print("DIGITE O CPF DO TITULAR: ");
            cpf = entrada.nextLine();
            Conta conta = new ContaEstudantil(numero, cpf);
            System.out.println("CONTA CRIADA COM SUCESSO!");
        } else if(opcao == 6){
            return;
        } else{
            System.out.println("Opção inválida!");
        }

    entrada.close();

    }
}
