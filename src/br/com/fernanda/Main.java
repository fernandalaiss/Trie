package br.com.fernanda;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Trie arvore = new Trie();
        arvore.inserirPalavra("ama");
        arvore.inserirPalavra("amar");
        arvore.inserirPalavra("ame");
        arvore.inserirPalavra("america");
        arvore.inserirPalavra("americana");
        arvore.inserirPalavra("eu");
        arvore.inserirPalavra("ele");
        arvore.checarPalavra("ama");
        arvore.checarPalavra("amar");
        arvore.checarPalavra("ame");
        arvore.checarPalavra("eu");
        arvore.checarPalavra("ele");

        arvore.buscarPalavrasPorPrefixo("am", 2);

        //arvore.removerPalavra("amar");

    }
}
