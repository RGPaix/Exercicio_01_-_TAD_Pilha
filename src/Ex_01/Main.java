package Ex_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma expressão com parênteses: ");
        String expressao = sc.nextLine();

        PilhaVetor<Character> pilha = new PilhaVetor<>(expressao.length());

        boolean balanceado = true;

        for (char c : expressao.toCharArray()) {
            // Ignora espaços em branco
            if (c == ' ') {
                continue;
            }

            if (c == ')') {
                // Quando encontra ')', desempilha tudo até encontrar '('
                boolean encontrouAbertura = false;

                System.out.print(c + " desempilha: ");

                while (!pilha.vazia()) {
                    char desempilhado = pilha.desempilhar();
                    System.out.print(desempilhado + " ");

                    if (desempilhado == '(') {
                        encontrouAbertura = true;
                        break;
                    }
                }

                while (!pilha.vazia()) {
                    // Desempilha temporariamente para verificar
                    char elemento = pilha.desempilhar();

                    if (elemento == '+' || elemento == '-' || elemento == '*' || elemento == '/') {
                        System.out.print(elemento + " ");
                    } else {
                        // Se não for operador, reempilha e para
                        pilha.empilhar(elemento);
                        break;
                    }
                }

                System.out.println();

                if (!encontrouAbertura) {
                    balanceado = false;
                    break;
                }
            } else {
                // Empilha qualquer outro caractere (números, operadores, '(')
                pilha.empilhar(c);
                System.out.println(c + " empilhado");
            }
        }

        // Verifica se sobrou algum '(' não fechado
        while (!pilha.vazia()) {
            char restante = pilha.desempilhar();
            if (restante == '(') {
                balanceado = false;
                break;
            }
        }

        if (balanceado) {
            System.out.println("Expressão balanceada ✅");
        } else {
            System.out.println("Expressão não balanceada ❌");
        }

        sc.close();
    }
}
