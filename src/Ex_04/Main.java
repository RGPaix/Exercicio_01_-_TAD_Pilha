package Ex_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma expressão em notação polonesa reversa: ");
        String expressao = sc.nextLine();

        int resultado = avaliarExpressao(expressao);

        System.out.println("Resultado = " + resultado);

        sc.close();
    }

    public static int avaliarExpressao(String expr) {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(expr.length());
        String[] tokens = expr.split(" ");

        for (String token : tokens) {
            char c = token.charAt(0);

            if (Character.isDigit(c)) {
                pilha.empilhar(Integer.parseInt(token));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int b = pilha.desempilhar();
                int a = pilha.desempilhar();
                int resultado = 0;

                switch (c) {
                    case '+':
                        resultado = a + b;
                        break;
                    case '-':
                        resultado = a - b;
                        break;
                    case '*':
                        resultado = a * b;
                        break;
                    case '/':
                        resultado = a / b;
                        break;
                }

                pilha.empilhar(resultado);
            }
        }

        return pilha.desempilhar();
    }
}
