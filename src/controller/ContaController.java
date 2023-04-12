package controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController {
    private ContaRepository contaRepository;

    public ContaController() {
        this.contaRepository = new ContaRepository();
    }

    public void cadastrar(Conta conta) {
        this.contaRepository.adicionar(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public void atualizar(Conta conta) {
        if (this.contaRepository.atualizar(conta)) {
            System.out.println("Conta atualizada com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void deletar(int numero) {
        if (this.contaRepository.remover(numero)) {
            System.out.println("Conta deletada com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public Conta procurarPorNumero(int numero) {
        return this.contaRepository.procurarPorNumero(numero);
    }

    public ArrayList<Conta> listarTodas() {
        return this.contaRepository.listarTodas();
    }

    public void sacar(int numero, double valor) {
        Conta conta = this.procurarPorNumero(numero);

        if (conta != null) {
            if (conta.sacar(valor)) {
                this.atualizar(conta);
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void depositar(int numero, double valor) {
        Conta conta = this.procurarPorNumero(numero);

        if (conta != null) {
            conta.depositar(valor);
            this.atualizar(conta);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor) {
        Conta origem = this.procurarPorNumero(numeroOrigem);
        Conta destino = this.procurarPorNumero(numeroDestino);

        if (origem != null && destino != null) {
            if (origem.transferir(destino, valor)) {
                this.atualizar(origem);
                this.atualizar(destino);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Conta(s) não encontrada(s)!");
        }
    }
}