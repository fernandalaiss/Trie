package br.com.fernanda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String arquivo = args[0];
        String prefixo = args[1];
        String quantidade = "-1";
        if(args.length > 2){
            quantidade = args[2];
        }

        Trie arvore = new Trie();

        try {
            FileReader ler = new FileReader("arquivos/"+arquivo);
            BufferedReader reader = new BufferedReader(ler);
            String linha;
            while( (linha = reader.readLine()) != null ){
                arvore.inserirPalavra(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        arvore.buscarPalavrasPorPrefixo(prefixo, Integer.parseInt(quantidade));

        arvore.removerPalavra("americana");

        arvore.checarPalavra("americana");
    }
}
