package br.com.fernanda;

import java.util.HashMap;

public class TrieNode {
    private boolean isWord;
    private HashMap<String, TrieNode> children;
    private String text;

    TrieNode(){
        isWord = false;
        children = new HashMap<>();
    }

    TrieNode(String text){
        isWord = false;
        this.text = text;
        children = new HashMap<>();
    }

    public boolean isWord() {
        return isWord;
    }

    public void setIsWord(boolean word) {
        isWord = word;
    }

    public TrieNode setChildren(String letra) {
        children.put(letra, new TrieNode(letra));
        return children.get(letra);
    }

    public HashMap<String, TrieNode> getChildren(){
        return children;
    }

    public boolean isChild(String letra){
        if(!children.isEmpty()) {
            return children.containsKey(letra);
        }
        return false;
    }

    public TrieNode getChild(String letra){
        return children.get(letra);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
