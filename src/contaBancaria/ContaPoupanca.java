package contaBancaria;

import java.time.LocalDate;
import java.util.Scanner;

public class ContaPoupanca extends Conta{
    private int diaAniversarioPoupanca;

    Scanner entrada = new Scanner(System.in);

    public ContaPoupanca(int numero, String cpf, int diaAniversarioPoupanca) {
        super(numero, cpf);
        this.diaAniversarioPoupanca = diaAniversarioPoupanca;
    }
    
    public void correcao(){
        if (LocalDate.now().getDayOfMonth() == diaAniversarioPoupanca) {
            double correcao = getSaldo() * 0.0005;
            credito(correcao);
            System.out.printf("Correção de 0,05% aplicada. Saldo atual: " + getSaldo());
        }
    }

    @Override
    public void debito(double valor) {
        valor = entrada.nextDouble();
        super.debito(valor);
    }

    @Override
    public void credito(double valor) {
        valor = entrada.nextDouble();
        super.credito(valor);
    }
}
