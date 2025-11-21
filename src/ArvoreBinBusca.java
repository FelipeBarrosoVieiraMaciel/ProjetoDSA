import java.io.FileWriter;
import java.io.IOException;

public class ArvoreBinBusca {

    class Nodo {

        public PalavraChave palavra;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(PalavraChave palavra) {
            this.palavra = palavra;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    public Nodo raiz;
    public int n_elementos;

    public ArvoreBinBusca() {
        this.raiz = null;
        this.n_elementos = 0;
    }

    public void insere(String elemento) {
        PalavraChave chave = new PalavraChave(elemento);
        this.insere(chave, this.raiz);
    }

    public void insere(PalavraChave palavra, Nodo nodo) {

        Nodo novo = new Nodo(palavra);

        if (nodo == null) {
            this.raiz = novo;
            this.n_elementos++;
            return;
        }

        if (palavra.chave.compareTo(nodo.palavra.chave) < 0) {
            if (nodo.esquerdo == null) {
                nodo.esquerdo = novo;
                this.n_elementos++;
                return;
            } else {
                this.insere(palavra, nodo.esquerdo);
            }
        }

        if (palavra.chave.compareTo(nodo.palavra.chave) > 0) {
            if (nodo.direito == null) {
                nodo.direito = novo;
                this.n_elementos++;
                return;
            } else {
                this.insere(palavra, nodo.direito);
            }
        }
    }

    private int altura(Nodo nodo) {

        if (nodo == null) {
            return -1;
        }

        int alturaEsquerda = this.altura(nodo.esquerdo) + 1;
        int alturaDireita = this.altura(nodo.direito) + 1;

        int altura = alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;

        return altura;

    }

    public PalavraChave busca(String elemento, int linha) {
        PalavraChave chave = new PalavraChave(elemento);
        return this.busca(chave, this.raiz, linha);

    }

    public PalavraChave busca(PalavraChave elemento, Nodo nodo, int linha) {

        if (nodo == null) {
            return null;
        }

        if (elemento.chave.compareTo(nodo.palavra.chave) < 0) {
            return this.busca(elemento, nodo.esquerdo, linha);
        } else if (elemento.chave.compareTo(nodo.palavra.chave) > 0) {
            return this.busca(elemento, nodo.direito, linha);
        } else {
            if(!nodo.palavra.lista.contem(linha)){
                nodo.palavra.lista.insereFinal(linha);
            }
            return elemento;
        }
    }

    public void imprimeEmOrdem(FileWriter writer) throws IOException {
        emOrdem(this.raiz, writer);
    }

    public void emOrdem(Nodo nodo, FileWriter writer) throws IOException {

        if (nodo == null)
            return;

        this.emOrdem(nodo.esquerdo,writer);
        writer.write(nodo.palavra.chave + " ");
        nodo.palavra.lista.imprime(writer);
        writer.write("\n");
        this.emOrdem(nodo.direito,writer);
    }



}