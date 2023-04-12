package conta;
public abstract class Conta {

    private int numero;
    private String titular;
    protected double saldo;

    public Conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    public abstract double calcularSaldo();

    @Override
    public String toString() {
        return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + "]";
    }
}