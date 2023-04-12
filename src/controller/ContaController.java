package conta.controller;

import java.util.ArrayList;

import conta.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {
    private ArrayList<Conta> contas;

    public ContaController() {
        this.contas = new ArrayList<>();
    }

    public void cadastrar(Conta conta) {
        this.contas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public void atualizar(Conta conta) {
        var index = procurarIndicePorNumero(conta.getNumero());

        if (index != -1) {
            this.contas.set(index, conta);
            System.out.println("Conta atualizada com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void deletar(int numero) {
        var index = procurarIndicePorNumero(numero);

        if (index != -1) {
            this.contas.remove(index);
            System.out.println("Conta deletada com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public Conta procurarPorNumero(int numero) {
        var index = procurarIndicePorNumero(numero);

        if (index != -1) {
            return this.contas.get(index);
        } else {
            return null;
        }
    }

    public ArrayList<Conta> listarTodas() {
        return this.contas;
    }

    public void sacar(int numero, float valor) {
        var conta = procurarPorNumero(numero);

        if (conta != null) {
            conta.sacar(valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void depositar(int numero, float valor) {
        var conta = procurarPorNumero(numero);

        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        var contaOrigem = procurarPorNumero(numeroOrigem);
        var contaDestino = procurarPorNumero(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Conta(s) não encontrada(s)!");
        }
    }

    private int procurarIndicePorNumero(int numero) {
        for (var i = 0; i < this.contas.size(); i++) {
            var conta = this.contas.get(i);
            if (conta.getNumero() == numero) {
                return i;
            }
        }

        return -1;
    }
}