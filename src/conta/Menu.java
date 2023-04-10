import java.util.Scanner;

    public class Menu {

        public static void main(String[] args) {

            Scanner leia = new Scanner(System.in);
            int opcao = 0;

            do {
                System.out.println("----- BEM VINDO AO BANCO JLP -----");
                System.out.println("----- O que deseja fazer? -----");
                System.out.println("1. Cadastrar nova conta");
                System.out.println("2. Exibir lista de contas");
                System.out.println("3. Realizar depósito");
                System.out.println("4. Realizar saque");
                System.out.println("5. Sair");
                System.out.println("--------------------------");
                System.out.print("Digite a opção desejada: ");

                try {
                    opcao = leia.nextInt();
                } catch (Exception e) {
                    System.out.println("Opção inválida! Tente novamente.\n");
                    leia.nextLine(); // Limpa o buffer do scanner
                    continue;
                }

                switch (opcao) {
                    case 1:
                        // Implementar a funcionalidade de cadastro de conta
                        System.out.println("Funcionalidade em construção!");
                        break;
                    case 2:
                        // Implementar a funcionalidade de exibição da lista de contas
                        System.out.println("Funcionalidade em construção!");
                        break;
                    case 3:
                        // Implementar a funcionalidade de depósito em conta
                        System.out.println("Funcionalidade em construção!");
                        break;
                    case 4:
                        // Implementar a funcionalidade de saque em conta
                        System.out.println("Funcionalidade em construção!");
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.\n");
                }

            } while (opcao != 5);

            leia.close();
        }
    }
}
