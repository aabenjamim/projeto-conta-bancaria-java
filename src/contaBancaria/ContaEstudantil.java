package contaBancaria;

import java.util.Scanner;

public class ContaEstudantil extends Conta {
    private double limiteEstudantil;
    int totalMovimentos = 0;
    
    Scanner entrada = new Scanner(System.in);

    public ContaEstudantil(int numero, String cpf) {
        super(numero, cpf);
        this.limiteEstudantil = 0;
    }
    
    public void usarEstudantil(double valor) {
        if (limiteEstudantil + valor > 5000) {
            System.out.println("Não é possível solicitar este valor de empréstimo.");
            return;
        }
        if (totalMovimentos >= 10) {
            System.out.println("Não é possível solicitar empréstimo após 10 movimentações.");
            return;
        }

        limiteEstudantil += valor;
        totalMovimentos++;
        super.credito(valor);
    }
    
    @Override
    public void debito(double valor) {
        double saldo = getSaldo();
        if (totalMovimentos >= 10) {
            System.out.println("Não é possível realizar esta operação.");
            return;
        }
        if (saldo < valor) {
            System.out.println("SALDO INSUFICIENTE. PEDIR EMPRÉSTIMO ESTUDANTIL? S/N ");
            String resp = entrada.next(); 
            if(resp.equals("S")){
                System.out.println("QUE VALOR VOCÊ QUER SOLICITAR? S/N ");
                double emprestimo = entrada.nextDouble();
                usarEstudantil(emprestimo);
            } else{
                System.out.println("DÉBITO NÃO EFETUADO");
            }
        }
        super.debito(valor);
        totalMovimentos++;
    }

    @Override
    public void credito(double valor) {
        super.credito(valor);
        totalMovimentos++;
    }


    public void visualizar(){    

        System.out.println();
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("BANCO AMARELO");
        System.out.println("SEU DINHEIRO BEM CUIDADO");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("_ _ _ CONTA ESTUDANTIL _ _ _");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("SALDO ATUAL: R$ " + getSaldo());
        System.out.println("MOVIMENTO - D-debito ou C-Crédito: _");
        String mov = entrada.next();

        if(mov.equals("D") && totalMovimentos<10){
            System.out.println("Valor movimento: ");
            Double valor = entrada.nextDouble();
            debito(valor);
            totalMovimentos++;
            System.out.println("Novo saldo: " + getSaldo());
        } else if(mov.equals("C") && totalMovimentos<10){
            System.out.println("Valor movimento: ");
            Double valor = entrada.nextDouble();
            credito(valor);
            totalMovimentos++;
            System.out.println("Novo saldo: " + getSaldo());
        } else{
            System.out.println("Movimento inválido! ");
        }

        continuar();
    }

    public void continuar(){
        System.out.println("DESEJA CONTINUAR? (S/N)");
        String resposta = entrada.next();
        if(resposta.equals("S")){
            if(totalMovimentos<10){
                System.out.println("DESEJA SOLICITAR EMPRÉSTIMO ESTUDANTIL? S/N ");
                String resp = entrada.next(); 
                if(resp.equals("S")){
                    System.out.println("QUE VALOR VOCÊ QUER SOLICITAR EMPRESTADO? S/N ");
                    double emprestimo = entrada.nextDouble();
                    usarEstudantil(emprestimo);
                } 
                visualizar();
            } else{
                System.out.println("LIMITE DE MOVIMENTAÇÕES ATINGIDO.");
                System.out.println("DESEJA SOLICITAR EMPRÉSTIMO ESTUDANTIL? S/N ");
                String resp = entrada.next(); 
                if(resp.equals("S")){
                    System.out.println("QUE VALOR VOCÊ QUER SOLICITAR EMPRESTADO? S/N ");
                    double emprestimo = entrada.nextDouble();
                    usarEstudantil(emprestimo);
                } else{
                    System.out.println("OBRIGADA POR ESCOLHER NOSSOS SERVIÇOS!");
                }
            }
        } else {
            System.out.println("OBRIGADA POR USAR NOSSOS SERVIÇOS.");
        }
    }
    

}

