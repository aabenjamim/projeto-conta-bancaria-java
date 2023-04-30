package contaBancaria;

import java.util.Scanner;

public class ContaEspecial extends Conta {

    private double limite;
    int totalMovimentos = 0;
    Scanner entrada = new Scanner(System.in);

    public ContaEspecial(int numero, String cpf) {
        super(numero, cpf);
        this.limite = 1000;
    }

    @Override
    public void debito(double valor) {
        double saldo = getSaldo();
        if(valor>saldo){
            usarLimite(valor);
            super.debito(valor);
            System.out.println("NOVO SALDO: " + getSaldo());
        } else {
            super.debito(valor);
        }
    }

    public void usarLimite(double valor) {
        if (limite - valor < 0) {
            System.out.println("Não é possível usar o limite disponível.");
            return;
        } else{
            limite -= (valor-getSaldo());
            super.credito(valor-getSaldo());
            System.out.println("LIMITE ESPECIAL UTILIZADO, NOVO SALDO: " + getSaldo());
        }
    }

    @Override
    public void credito(double valor) {
        super.credito(valor);
    }

    public void visualizar(){    

        System.out.println();
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("BANCO AMARELO");
        System.out.println("SEU DINHEIRO BEM CUIDADO");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("_ _ _ CONTA ESPECIAL _ _ _");
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
                visualizar();
            } else{
                System.out.println("LIMITE DE MOVIMENTAÇÕES ATINGIDO.");
            }
        } else {
            System.out.println("OBRIGADA POR USAR NOSSOS SERVIÇOS.");
        }
    }
    
}

