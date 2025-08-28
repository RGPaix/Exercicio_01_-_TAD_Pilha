package Ex_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();

        PilhaVetor<Character> pilha = new PilhaVetor<>(palavra.length());

        for (char c : palavra.toCharArray()) {
            pilha.empilhar(c);
            System.out.println("'" + c + "' empilhado");
        }

        System.out.println("\nInvertendo palavra...");
        StringBuilder palavraInvertida = new StringBuilder();
        while (!pilha.vazia()) {
            char ch = pilha.desempilhar();
            palavraInvertida.append(ch);
            System.out.println("'" + ch + "' desempilhado");
        }

        System.out.println("\nPalavra original: " + palavra);
        System.out.println("Palavra invertida: " + palavraInvertida.toString());

        sc.close();
    }
}
