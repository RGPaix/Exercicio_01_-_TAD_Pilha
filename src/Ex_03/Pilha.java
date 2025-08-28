package Ex_03;

public interface Pilha<T>{
    void empilhar(T item);
    T desempilhar();
    T topo();
    Boolean vazia();
    Integer tamanho();
}
