package contaBancaria;

public class ContaEspecial extends Conta {
    
    private double limite;

    public ContaEspecial(int numero, String cpf){
        super(numero, cpf);
        this.limite = 1000;
    }

    public void usarLimite(double valor) {
        double saldo = getSaldo();
        double novoSaldo = saldo + valor;
        double diferenca = Math.abs(novoSaldo);
    
        if (diferenca <= limite) {
            if (novoSaldo < 0) {
                debito(getSaldo());
                limite -= saldo;
            } else {
                credito(novoSaldo);
                limite -= valor;
            }
        } else {
            System.out.println("Não é possível utilizar o limite disponível.");
        }
    }
    
}

