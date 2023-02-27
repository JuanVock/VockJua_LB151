package com.mycompany.vockjuan_lb151;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Category")
@SessionScoped
public class Category {
    private String name;
    private List<String> words;

    public Category() {
        words = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void addWord(String word) {
        words.add(word);
    }
}
