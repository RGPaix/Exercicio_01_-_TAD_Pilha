package Ex_05;

import java.util.NoSuchElementException;

public class PilhaVetor<T> implements Pilha<T> {
    private Object[] dados;
    private Integer top;
    private int size;

    public PilhaVetor(int tamanho) {
        if (tamanho <= 0) {
            tamanho = 1;
        }
        this.size = tamanho;
        this.dados = new Object[tamanho];
        this.top = 0;
    }

    @Override
    public void empilhar(T item) {
        if (top == dados.length) {
            System.out.println("Pilha cheia.");
            return;
        }
        System.out.println("Última ação: " + item);
        dados[top++] = item;
    }

    @Override
    public T desfazer() {
        if (vazia()) throw new NoSuchElementException("Pilha vazia.");
        T item = (T) dados[top - 1];
        --top;
        System.out.println("Ação " + item + " desfeita");
        return item;
    }

    @Override
    public T topo() {
        if (vazia()) throw new NoSuchElementException("Pilha vazia.");
        return (T) dados[top - 1];
    }

    @Override
    public Boolean vazia() {
        return top == 0;
    }

    @Override
    public Integer tamanho() {
        return top;
    }
}