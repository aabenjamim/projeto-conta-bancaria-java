package contaBancaria;

public class ContaCorrente extends Conta {
    private int contadorTalao;
    private int totalMovimentos;

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
        } else {
            System.out.println("Não é possível solicitar mais talões.");
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
}
