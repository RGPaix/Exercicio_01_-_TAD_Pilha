package Ex_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PilhaVetor<String> pilhaAcoes = new PilhaVetor<>(10);

        while (true) {
            System.out.print("Digite uma ação (ou 'Desfazer'): ");
            String acao = sc.nextLine().trim();

            if (acao.equalsIgnoreCase("Desfazer")) {
                if (!pilhaAcoes.vazia()) {
                    String desfeita = pilhaAcoes.desfazer(); // ou seu desfazer()
                    System.out.println("Ação desfeita: " + desfeita);
                } else {
                    System.out.println("Nada para desfazer.");
                }
            } else {
                pilhaAcoes.empilhar(acao);
            }

            if (!pilhaAcoes.vazia()) {
                System.out.println("Última ação: " + pilhaAcoes.topo());
            } else {
                System.out.println("Histórico vazio.");
            }
        }
    }
}
