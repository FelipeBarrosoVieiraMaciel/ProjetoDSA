import java.io.FileWriter;
import java.io.IOException;

public class HashMap {

    ArvoreBinBusca[] vetor;
    int nElementos;

    public HashMap(int capacidade) { // Construtor do hash map, inicializa as instâncias de ABB
        this.vetor = new ArvoreBinBusca[capacidade];
        for (int i = 0; i < vetor.length; i++) {
            this.vetor[i] = new ArvoreBinBusca();
        }
        this.nElementos = 0;
    }

    private int funcaoHash(String elemento) {
        char first = elemento.charAt(0);
        return first - 97;
    }

    public void insere(String palavra) {
        int endereco = funcaoHash(palavra);
        this.vetor[endereco].insere(palavra);
        this.nElementos++;
    }

    public void imprime(FileWriter writer) throws IOException {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i].imprimeEmOrdem(writer);
        }
    }

    public PalavraChave contem(String elemento, int linha) {
        int endereco = funcaoHash(elemento);
        return this.vetor[endereco].busca(elemento, linha);
    }
}

