package conta;
public class Conta {
    private int numero;
    private String titular;
    private double saldo;

    public Conta(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
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
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + "]";
    }
}
