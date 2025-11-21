import java.io.FileWriter;
import java.io.IOException;

public class ListaEncadeada {

    private static class Nodo {
        public int elemento;
        public Nodo proximo;

        public Nodo(int elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    private Nodo primeiro;
    private Nodo ultimo;
    private int n_elementos;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.n_elementos = 0;
    }

    public void imprime(FileWriter writer) throws IOException {

        Nodo cursor = this.primeiro;
        for (int i = 0; i < this.n_elementos; i++) {
            writer.write(cursor.elemento + " ");
            cursor = cursor.proximo;
        }

    }

    public void insereFinal(int elemento) {
        Nodo novoNodo = new Nodo(elemento);
        if (ultimo == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.proximo = novoNodo;
            ultimo = novoNodo;
        }
        n_elementos++;
    }

    public void imprimirLista() {
        Nodo atual = primeiro;
        System.out.print("Ocorrências: ");
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public boolean contem(int elemento) {

        Nodo cursor = this.primeiro;
        for (int i = 0; i < this.n_elementos; i++) {

            if (cursor.elemento == elemento) {
                return true;
            }

            cursor = cursor.proximo;
        }

        return false;
    }
}