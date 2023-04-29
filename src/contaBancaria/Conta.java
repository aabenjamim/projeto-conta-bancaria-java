package contaBancaria;

public abstract class Conta {

    private int numero;
    private String cpf;
    private double saldo;
    private boolean ativo;

    public Conta(){}

    public Conta (int numero, String cpf){
        this.numero = numero;
        this.cpf = cpf;
        this.saldo = 0;
        this.ativo = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debito (double valor){
        if(saldo >=  valor){
            saldo -= valor;
        } else {
            System.out.println("SALDO INSUFICIENTE!");
        }
    }

    public void credito (double valor){
        saldo += valor;
    }


    public void imprimirSaldo() {
        System.out.println("Saldo Atual: R$ " + saldo);
    }

}