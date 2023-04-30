package contaBancaria;

public class ContaEmpresa extends Conta {

    private double emprestimoEmpresa;
    private int totalMovimentos;
    
    public ContaEmpresa(int numero, String cpf) {
        super(numero, cpf);
        this.emprestimoEmpresa = 0;
    }
    
    public void pedirEmprestimo(double valor) {
        if (emprestimoEmpresa + valor > 10000) {
            System.out.println("Não é possível solicitar este valor de empréstimo.");
            return;
        }
        if (totalMovimentos >= 10) {
            System.out.println("Não é possível solicitar empréstimo após 10 movimentações.");
            return;
        }

        emprestimoEmpresa += valor;
        super.credito(valor);
    }
    
    @Override
    public void debito(double valor) {
        double saldo = getSaldo();
        if (totalMovimentos >= 10 || saldo - valor < -emprestimoEmpresa) {
            System.out.println("Não é possível realizar esta operação.");
            return;
        }
        if (saldo < 0) {
            emprestimoEmpresa += saldo;
            debito(saldo);
        }
        super.debito(valor);
    }

    @Override
    public void credito(double valor) {
        super.credito(valor);
    }
}
