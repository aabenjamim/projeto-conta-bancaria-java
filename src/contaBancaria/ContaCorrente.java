package contaBancaria;

import java.util.Scanner;

public class ContaCorrente extends Conta {
    private int contadorTalao;
    private int totalMovimentos;

    Scanner entrada = new Scanner(System.in);

    public ContaCorrente(int numero, String cpf) {
        super(numero, cpf);
        this.contadorTalao = 3;
        this.totalMovimentos = 0;
    }

    public void pedirTalao() {
        if (totalMovimentos >= 10) {
            System.out.println("Não é possível solicitar talão após 10 movimentações.");
            return;
        }

        if (contadorTalao > 0) {
            super.debito(30);
            contadorTalao--;
            System.out.println("CHEQUE EMITIDO COM SUCESSO!");
            continuar();
        } else {
            System.out.println("Não é possível solicitar mais talões.");
            continuar();
        }
    }

    @Override
    public void debito(double valor) {
        totalMovimentos++;
        double saldo = getSaldo();
        if (totalMovimentos >= 10 || saldo < valor) {
            System.out.println("Não é possível realizar esta operação.");
            return;
        }
        super.debito(valor);
    }

    @Override
    public void credito(double valor) {
        totalMovimentos++;
        if (totalMovimentos >= 10) {
            System.out.println("Não é possível realizar esta operação.");
            return;
        }
        super.credito(valor);
    }

    public void visualizar(){    

        System.out.println();
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("BANCO AMARELO");
        System.out.println("SEU DINHEIRO BEM CUIDADO");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("_ _ _ CONTA CORRENTE _ _ _");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("SALDO ATUAL: R$ " + getSaldo());
        System.out.println("MOVIMENTO - D-debito ou C-Crédito: _");
        String mov = entrada.next();

        if(mov.equals("D") && totalMovimentos<10){
            System.out.println("Valor movimento: ");
            Double valor = entrada.nextDouble();
            debito(valor);
            System.out.println("Novo saldo: " + getSaldo());
        } else if(mov.equals("C") && totalMovimentos<10){
            System.out.println("Valor movimento: ");
            Double valor = entrada.nextDouble();
            credito(valor);
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
            System.out.println("DESEJA SOLICITAR CHEQUE? S/N");
            String solicita = entrada.next();
            if(solicita.equals("S")){
                pedirTalao();
            } else{
                System.out.println("OBRIGADA POR USAR NOSSOS SERVIÇOS.");
            }
        }
    }
}

