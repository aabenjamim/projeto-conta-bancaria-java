package contaBancaria;

import java.util.Scanner;

public class TelaInicial {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
       operacoes();
    }

    public static void operacoes() {
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

        int operacao = entrada.nextInt();
        int numero;
        String cpf;

        switch(operacao) {
            case 1:
                System.out.println("DIGITE O NÚMERO DA CONTA: ");
                numero = entrada.nextInt();
                System.out.println("DIGITE O NÚMERO DO CPF: ");
                cpf = entrada.next();
                System.out.println("DIGITE A DATA DE ANIVERSARIO DA CONTA: ");
                int diaAniversarioPoupanca = entrada.nextInt();

                ContaPoupanca cp = new ContaPoupanca(numero, cpf, diaAniversarioPoupanca);
                cp.visualizar();
                break;
            case 2:
                System.out.println("DIGITE O NÚMERO DA CONTA: ");
                numero = entrada.nextInt();
                System.out.println("DIGITE O NÚMERO DO CPF: ");
                cpf = entrada.next();
                ContaCorrente cc = new ContaCorrente(numero, cpf);
                cc.visualizar();
                break;
            case 3:
                System.out.println("DIGITE O NÚMERO DA CONTA: ");
                numero = entrada.nextInt();
                System.out.println("DIGITE O NÚMERO DO CPF: ");
                cpf = entrada.next();      
                ContaEspecial ce = new ContaEspecial(numero, cpf);
                ce.visualizar();
                break;
            case 4:
                System.out.println("DIGITE O NÚMERO DA CONTA: ");
                numero = entrada.nextInt();
                System.out.println("DIGITE O NÚMERO DO CPF: ");
                cpf = entrada.next();      
                ContaEmpresa cem = new ContaEmpresa(numero, cpf);
                cem.visualizar();
                break;
            case 5:
                System.out.println("DIGITE O NÚMERO DA CONTA: ");
                numero = entrada.nextInt();
                System.out.println("DIGITE O NÚMERO DO CPF: ");
                cpf = entrada.next();      
                ContaEstudantil ces = new ContaEstudantil(numero, cpf);
                ces.visualizar();
                break;
            case 6:
                System.out.println("OBRIGADA POR ESCOLHER NOSSO BANCO!");
                System.exit(0);
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA");
                operacoes();
                break;
        }

    }

/*entrada.close();*/
}
