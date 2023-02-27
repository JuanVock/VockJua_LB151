/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vockjuan_lb151;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.util.ArrayUtils;

/**
 *
 * @author juanv
 */
@Named(value = "word")
@SessionScoped
public class word implements Serializable {

    private String[][] categories = {{"Hund", "Katze", "Maus"}, {"Rot", "Blau", "Grün"}, {"Deutschland", "USA", "Japan"}};
    private String[] newCategory = new String[categories.length];
    private String[][] newWord = new String[categories.length][];

    public String back() {
        return "start.xhtml";
    }

    public String[][] getCategories() {
        return categories;
    }

    public void setCategories(String[][] categories) {
        this.categories = categories;
    }

    public String[] getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(String[] newCategory) {
        this.newCategory = newCategory;
    }

    public String[][] getNewWord() {
        return newWord;
    }

    public void setNewWord(String[][] newWord) {
        this.newWord = newWord;
    }

    public void addCategory(int index) {
        String[] newCategories = Arrays.copyOf(categories[index], categories[index].length + 1);
        newCategories[newCategories.length - 1] = newCategory[index];
        categories[index] = newCategories;
        newCategory[index] = "";
        newWord[index] = Arrays.copyOf(categories[index], categories[index].length);
    }

    public void deleteCategory(int index) {
        String[][] newCategories = new String[categories.length - 1][];
        String[] newNewCategory = new String[newCategory.length - 1];
        String[][] newNewWord = new String[newWord.length - 1][];

        int j = 0;
        for (int i = 0; i < categories.length; i++) {
            if (i != index) {
                newCategories[j] = categories[i];
                newNewCategory[j] = newCategory[i];
                newNewWord[j] = new String[newWord[i].length];
                for (int k = 0; k < newWord[i].length; k++) {
                    newNewWord[j][k] = newWord[i][k];
                }
                j++;
            }
        }

        categories = newCategories;
        newCategory = newNewCategory;
        newWord = newNewWord;
    }

    public void addWord(int categoryIndex, int wordIndex) {
        String[] categoryWords = categories[categoryIndex];
        String[] newCategoryWords = newWord[categoryIndex];

        String[] newWords = Arrays.copyOf(categoryWords, categoryWords.length + 1);
        newWords[newWords.length - 1] = newCategoryWords[wordIndex];
        categories[categoryIndex] = newWords;

        String[] newCategoryWordsAfterAdd = new String[newCategoryWords.length - 1];
        int destPos = 0;
        for (int i = 0; i < newCategoryWords.length; i++) {
            if (i != wordIndex) {
                newCategoryWordsAfterAdd[destPos] = newCategoryWords[i];
                destPos++;
            }
        }
        newWord[categoryIndex] = newCategoryWordsAfterAdd;
    }

    public void deleteWord(int categoryIndex, int wordIndex) {
        String[] categoryWords = categories[categoryIndex];
        String[] newCategoryWords = newWord[categoryIndex];

        String[] newWords = new String[categoryWords.length - 1];
        int destPos = 0;
        for (int i = 0; i < categoryWords.length; i++) {
            if (i != wordIndex) {
                newWords[destPos] = categoryWords[i];
                destPos++;
            }
        }
        categories[categoryIndex] = newWords;

        String[] newCategoryWordsAfterDelete = Arrays.copyOf(newCategoryWords, newCategoryWords.length + 1);
        newCategoryWordsAfterDelete[newCategoryWordsAfterDelete.length - 1] = categoryWords[wordIndex];
        newWord[categoryIndex] = newCategoryWordsAfterDelete;
    }

    public String getRandomCategory() {
        Random random = new Random();
        int categoryIndex = random.nextInt(categories.length);
        String[] category = categories[categoryIndex];
        int wordIndex = random.nextInt(category.length);
        return category[wordIndex];
    }
}
