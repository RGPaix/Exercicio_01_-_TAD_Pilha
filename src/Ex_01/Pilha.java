package Ex_05;

public interface Pilha <T>{
    void empilhar(T item);
    T desfazer();
    T topo();
    Boolean vazia();
    Integer tamanho();
}