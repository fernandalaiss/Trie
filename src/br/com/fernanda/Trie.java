package br.com.fernanda;

import java.util.List;

public class Trie {
    private TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void inserirPalavra(String palavra){
        TrieNode node = root;
        for (int i = 0; i < palavra.length(); i++) {
            String letra = palavra.substring(i,i+1);

            if(!node.isChild(letra)){
                node = node.setChildren(letra); // retorna novo nó de inserção
                if(i == palavra.length() - 1)
                    node.setIsWord(true);
            }
        }
    }

    public boolean checarPalavra(String palavra){
        TrieNode node = root;
        for(int i = 0; i < palavra.length(); i++){
            String letra = palavra.substring(i,i+1);

            if(node.isChild(letra)){
                node = node.getChild(letra);
                if(i == palavra.length()-2 && node.isWord()){
                    System.out.println("Palavra \""+palavra+"\" existe na árvore.");
                    return true;
                }
            }else{
                System.out.println("Palavra \""+palavra+"\" não existe na árvore.");
                System.out.println("Letra: "+letra+"\nÍndice: "+i);
                return false;
            }
        }
    }

    public void removerPalavra(){

    }

    public String buscarPalavrasPorPrefixo(String prefixo){
        return "não há palavras cadastradas";
    }

    public String buscarPalavrasPorPrefixo(String prefixo, int maxResultados){
        return "não há palavras cadastradas";
    }

    public void printTrie(){
        System.out.println(root.printChildren());
    }
}
