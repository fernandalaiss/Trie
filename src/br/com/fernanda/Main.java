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

        System.out.println("checando");
        arvore.checarPalavra("ama");
        arvore.checarPalavra("amar");
        arvore.checarPalavra("ame");
        arvore.checarPalavra("america");
        arvore.checarPalavra("americana");

        System.out.println("buscando");
        arvore.buscarPalavrasPorPrefixo("ool", 2);

        System.out.println("removendo");
        arvore.removerPalavra("amora");

        System.out.println("checando");
        arvore.checarPalavra("ama");
        arvore.checarPalavra("amar");
        arvore.checarPalavra("ame");
        arvore.checarPalavra("america");
        arvore.checarPalavra("americana");

    }
}
