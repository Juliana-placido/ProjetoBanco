import java.util.Scanner;
import java.util.Scanner;

import conta.controller.ContaController;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static ContaController contaController = new ContaController();

    public static void main(String[] args) {
        int opcao = 0;

        do {
            System.out.println("====== MENU ======");
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Atualizar conta");
            System.out.println("3 - Deletar conta");
            System.out.println("4 - Procurar conta por número");
            System.out.println("5 - Listar todas as contas");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarConta();
                    break;
                case 2:
                    atualizarConta();
                    break;
                case 3:
                    deletarConta();
                    break;
                case 4:
                    procurarContaPorNumero();
                    break;
                case 5:
                    listarContas();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 6);
    }

    private static void cadastrarConta() {
        System.out.print("Digite o número da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o saldo da conta: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        // Cria uma nova conta e a cadastra no controller
        Conta conta = new Conta(numero, saldo);
        contaController.cadastrar(conta);
    }

    private static void atualizarConta() {
        System.out.print("Digite o número da conta a ser atualizada: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        // Procura a conta pelo número informado
        Conta conta = contaController.procurarPorNumero(numero);

        if (conta != null) {
            System.out.print("Digite o novo saldo da conta: ");
            double novoSaldo = scanner.nextDouble();
            scanner.nextLine();

            // Atualiza o saldo da conta e a atualiza no controller
            conta.setSaldo(novoSaldo);
            contaController.atualizar(conta);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void deletarConta() {
        System.out.print("Digite o número da conta a ser deletada: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        // Deleta a conta pelo número informado
        contaController.deletar(numero);
    }

    private static void procurarContaPorNumero() {
        System.out.print("Digite o número da conta a ser procurada: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        // Procura a conta pelo número informado
        Conta conta = contaController.procurarPorNumero(numero);

        if (conta != null) {
            System.out.println(conta);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void listarContas() {
        // Lista todas as contas cadastradas no controller
        for (Conta conta : contaController.listarTodas()) {
            System.out.println(conta);
        }
    }
}
