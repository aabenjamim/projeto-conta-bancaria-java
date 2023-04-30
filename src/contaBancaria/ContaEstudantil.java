package contaBancaria;

public class ContaEstudantil extends Conta {
    private double limiteEstudantil;
    
    public ContaEstudantil(int numero, String cpf) {
        super(numero, cpf);
        this.limiteEstudantil = 5000;
    }
    
    public void usarEstudantil(double valor) {
        if (limiteEstudantil - valor < 0) {
            System.out.println("Não é possível realizar esta operação.");
            return;
        }
        credito(valor);
        limiteEstudantil -= valor;
    }
    
    @Override
    public void debito(double valor) {
        double saldo = getSaldo();
        if (saldo - valor < 0 || saldo - valor >= -limiteEstudantil) {
            limiteEstudantil += saldo - valor;
            debito(saldo);
        } else if (saldo - valor < -limiteEstudantil) {
            System.out.println("Não é possível realizar esta operação.");
            return;
        } else {
            debito(valor);
        }
    }

    @Override
    public void credito(double valor) {
        credito(valor);
    }
}

