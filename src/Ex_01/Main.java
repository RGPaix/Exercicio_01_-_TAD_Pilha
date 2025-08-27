package Ex_05;

public class Main {
    PilhaVetor<Integer> pilha = new PilhaVetor<Integer>(10);
    public static void main(String[] args) {
        PilhaVetor<String> pilha = new PilhaVetor<String>(10);
        pilha.empilhar("Recortar");
        pilha.empilhar("Copiar");
        pilha.empilhar("Colar");
        pilha.empilhar("Imprimir");
        pilha.desfazer();
        System.out.println("Última ação: " + pilha.topo());
    }
}