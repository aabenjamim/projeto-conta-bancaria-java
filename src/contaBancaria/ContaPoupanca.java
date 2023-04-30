package contaBancaria;

import java.time.LocalDate;

public class ContaPoupanca extends Conta{
    private int diaAniversarioPoupanca;

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
}
