package br.com.fernanda;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Trie arvore = new Trie();
        arvore.inserirPalavra("oi");
        //arvore.printTrie();
        boolean existe = arvore.checarPalavra("oi");
        System.out.println(existe);

    }
}
