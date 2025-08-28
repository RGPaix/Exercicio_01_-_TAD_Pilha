package Ex_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = sc.nextInt(); // Lê como int, não String

        // Guarda o número original para mostrar no final
        int numeroOriginal = numero;

        // Cria pilha suficientemente grande (32 bits é mais que suficiente)
        PilhaVetor<Character> pilha = new PilhaVetor<>(32);

        System.out.println("\nProcesso de conversão:");

        // Caso especial: se número for 0
        if (numero == 0) {
            pilha.empilhar('0');
            System.out.println("0 ÷ 2 = 0 resto 0 → empilha '0'");
        } else {
            // Divide por 2 até chegar em 0, empilhando os restos
            while (numero > 0) {
                int resto = numero % 2;           // Resto da divisão por 2
                int quociente = numero / 2;      // Resultado da divisão

                pilha.empilhar((char)('0' + resto)); // Converte 0/1 para '0'/'1'

                System.out.println(numero + " ÷ 2 = " + quociente + " resto " + resto + " → empilha '" + resto + "'");

                numero = quociente; // Continua com o quociente
            }
        }

        // Desempilha tudo para formar o número binário
        System.out.println("\nDesempilhando para formar o binário:");
        StringBuilder binario = new StringBuilder();

        while (!pilha.vazia()) {
            char bit = pilha.desempilhar();
            binario.append(bit);
            System.out.println("Desempilha: '" + bit + "'");
        }

        System.out.println("\n=== RESULTADO ===");
        System.out.println("Número decimal: " + numeroOriginal);
        System.out.println("Número binário: " + binario.toString());

        sc.close();
    }
}
