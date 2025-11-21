import java.io.File;
import java.io.FileWriter;
import java.text.Normalizer;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap(26); // Cria um hashmap com vetor de capacidade igual a número de letras do alfabeto

        try { // Tenta ler o arquivo das palavras-chave e insere elas no hash map
            File arquivoPalavras = new File("src/Palavras-Chave.txt");
            Scanner scannerPalavras = new Scanner(arquivoPalavras);

            while(scannerPalavras.hasNextLine()) {
                String palavra = cleanString(scannerPalavras.nextLine());
                hashMap.insere(palavra);
            }

            scannerPalavras.close();
        }

        catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            return;
        }

        try {
            File arquivo = new File("src/texto.txt");
            Scanner input = new Scanner(arquivo);

            while(input.hasNextLine()) {
                String palavra = cleanString(input.nextLine());
                hashMap.insere(palavra);
            }


        }

        catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            return;
        }

        try {
            FileWriter writer = new FileWriter("src/Saida.txt");
            hashMap.imprime(writer);
            writer.close();
            System.out.println("Resultado salvo em 'Saida.txt'");
        } catch (Exception e) {
            System.out.println("Erro ao escrever em Saida.txt: " + e.getMessage());
        }
    }

    public static String cleanString(String input) {
        // Deixa tudo minúsculo
        String formatada = input.toLowerCase();

        // Remove acentos
        formatada = Normalizer.normalize(formatada, Normalizer.Form.NFD);
        formatada = formatada.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        // Mantém apenas letras de a-z
        formatada = formatada.replaceAll("[^a-z-]","");

        return formatada;
    }
}
