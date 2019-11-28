package br.com.fernanda;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    private boolean isWord;
    private List<TrieNode> children;
    private String text;

    TrieNode(){
        isWord = false;
        children = new ArrayList<>();
    }

    TrieNode(String text){
        isWord = false;
        this.text = text;
        children = new ArrayList<>();
    }

    public boolean isWord() {
        return isWord;
    }

    public void setIsWord(boolean word) {
        isWord = word;
    }

    public List<TrieNode> getChildren() {
        return children;
    }

    public TrieNode setChildren(String letra) {
        children.add(new TrieNode(letra));
        return getChild(letra);
    }

    public boolean isChild(String letra){
        return children.stream().filter(o -> o.getText().equals(letra)).findFirst().isPresent();
    }

    public TrieNode getChild(String letra){
        return children.get(children.indexOf(letra)+1);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String printChildren(){
        String print = "";
        for (TrieNode node : children) {
            print = print.concat(node.getText());
            print = print.concat(" ");
        }
        return print;
    }
}
