package controller;
import conta.Conta;

import java.util.ArrayList;

public class ContaController {
    private ArrayList<Conta> contas;

    public ContaController() {
        this.contas = new ArrayList<>();
    }

    public void cadastrar(Conta conta) {
        this.contas.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public void atualizar(Conta conta) {
        int index = procurarIndicePorNumero(conta.getNumero());

        if (index != -1) {
            this.contas.set(index, conta);
            System.out.println("Conta atualizada com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void deletar(int numero) {
        int index = procurarIndicePorNumero(numero);

        if (index != -1) {
            this.contas.remove(index);
            System.out.println("Conta deletada com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public Conta procurarPorNumero(int numero) {
        int index = procurarIndicePorNumero(numero);

        if (index != -1) {
            return this.contas.get(index);
        } else {
            return null;
        }
    }

    public ArrayList<Conta> listarTodas() {
        return this.contas;
    }

    private int procurarIndicePorNumero(int numero) {
        for (int i = 0; i < this.contas.size(); i++) {
            Conta conta = this.contas.get(i);
            if (conta.getNumero() == numero) {
                return i;
            }
        }

        return -1;
    }
}