package br.com.fernanda;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Trie {
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void inserirPalavra(String palavra){
        TrieNode node = root;
        for (int i = 0; i < palavra.length(); i++) {
            String letra = palavra.substring(i,i+1);

            if(node.isChild(letra)){
                node = node.getChild(letra);
            }else{
                node = node.setChildren(letra); // retorna novo nó de inserção
                if(i == palavra.length() - 1)
                    node.setIsWord(true);
            }
        }
    }
    public TrieNode checarPrefixo(String prefixo){
        TrieNode node = root;
        for(int i = 0; i < prefixo.length(); i++){
            String letra = prefixo.substring(i,i+1);

            if(node.isChild(letra)){
                node = node.getChild(letra);
            }else{
                return null;
            }
        }
        return node;
    }

    public void checarPalavra(String palavra){
        TrieNode node = checarPrefixo(palavra);
        if(node.isWord()){
            System.out.println("Palavra \""+palavra+"\" existe na árvore.");
        }else{
            System.out.println("Palavra \""+palavra+"\" não existe na árvore.");
        }
    }

    public List<String> getPalavras(List<String> lista, TrieNode node, String prefixo){
        if(node.isWord())
            lista.add(prefixo);
        for (String letra : node.getChildren().keySet()) {
            lista = getPalavras(lista, node.getChild(letra), prefixo.concat(letra));
        }
        return lista;
    }

    public void buscarPalavrasPorPrefixo(String prefixo, int maxResultados){
        List<String> lista = new ArrayList<>();

        TrieNode node = checarPrefixo(prefixo);

        if(node != null){
            lista = getPalavras(lista, node, prefixo);

            if(lista.isEmpty()){
                System.out.println("Não há palavras com o prefixo \""+prefixo+"\".");
            }else{
                Collections.sort(lista, new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        if(s.length() > t1.length())
                            return 1;
                        return -1;
                    }
                });
                if(maxResultados != -1){
                    maxResultados = Math.min(maxResultados, lista.size());
                    lista = lista.subList(0, maxResultados);
                }
                System.out.println("Palavras com o prefixo \""+prefixo+"\" ("+lista.size()+" registros):");
                for (String palavra : lista) {
                    System.out.println(palavra);
                }
            }
        }else{
            System.out.println("O prefixo \""+prefixo+"\" não existe na árvore.");
        }
    }

    public void buscarPalavrasPorPrefixo(String prefixo){
        buscarPalavrasPorPrefixo(prefixo, -1);
    }

    public void removerPalavra(String palavra){
        TrieNode node = checarPrefixo(palavra);
        if(node != null){

            System.out.println("Palavra \""+palavra+"\" removida da árvore.");
            int tam_palavra = palavra.length();
            while(palavra.length()>0){
                node = checarPrefixo(palavra);

                if(tam_palavra == palavra.length() && node.isWord()){
                    node.setIsWord(false);
                }
                if(node.getChildren().isEmpty()){
                    node = null;
                }

                palavra = palavra.substring(0,palavra.length()-1);
            }
        }else{
            System.out.println("Palavra \""+palavra+"\" não existe na árvore.");
        }
    }

}
