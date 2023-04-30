package contaBancaria;

import java.time.LocalDate;
import java.util.Scanner;

public class ContaPoupanca extends Conta{
    private int diaAniversarioPoupanca;
    Scanner entrada = new Scanner(System.in);

    private int numMov = 0;
    
    public ContaPoupanca(int numero, String cpf, int diaAniversarioPoupanca) {
        super(numero, cpf);
        this.diaAniversarioPoupanca = diaAniversarioPoupanca;
    }
    
    public void correcao(){
        if (LocalDate.now().getDayOfMonth() == diaAniversarioPoupanca) {
            double correcao = getSaldo() * 0.0005;
            super.credito(correcao);
            System.out.println("Correção de 0,05% aplicada. Saldo atual: " + getSaldo());
        }
    }

    @Override
    public void debito(double valor) {
        super.debito(valor);
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
        System.out.println("_ _ _ CONTA POUPANÇA _ _ _");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("SALDO ATUAL: R$ " + getSaldo());
        System.out.println("MOVIMENTO - D-debito ou C-Crédito: _");
        String mov = entrada.next();

        if(mov.equals("D") && numMov<10){
            System.out.println("Valor movimento: ");
            Double valor = entrada.nextDouble();
            debito(valor);
            numMov++;
            System.out.println("Novo saldo: " + getSaldo());
            correcao();
        } else if(mov.equals("C") && numMov<10){
            System.out.println("Valor movimento: ");
            Double valor = entrada.nextDouble();
            credito(valor);
            numMov++;
            System.out.println("Novo saldo: " + getSaldo());
            correcao();
        } else{
            System.out.println("Movimento inválido! ");
            correcao();
        }

        continuar();
    }

    public void continuar(){
        System.out.println("DESEJA CONTINUAR? (S/N)");
        String resposta = entrada.next();
        if(resposta.equals("S")){
            if(numMov<10){
                visualizar();
            } else{
                System.out.println("LIMITE DE MOVIMENTAÇÕES ATINGIDO.");
            }
        } else {
            System.out.println("OBRIGADA POR USAR NOSSOS SERVIÇOS.");
        }
    }
}

