package com.mycompany.vockjuan_lb151;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "categoryBean")
@SessionScoped
public class CategoryBean {

    private List<Category> categories;
    private String categoryName;
    private Category selectedCategory;
    private String word;

    public CategoryBean() {
        categories = new ArrayList<Category>();
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        categoryNames.add("Fussballspieler");
        addWordToCategory(getCategoryByName("Fussballspieler"), "Messi");
        addWordToCategory(getCategoryByName("Fussballspieler"), "Neymar");

        categoryNames.add("tier");
        addWordToCategory(getCategoryByName("Fussballspieler"), "Hund");
        addWordToCategory(getCategoryByName("Fussballspieler"), "Ameise");

        for (Category category : categories) {
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }

    public Map<String, List<String>> getCategoryWords() {
        Map<String, List<String>> categoryWords = new HashMap<>();
        for (Category category : categories) {
            categoryWords.put(category.getName(), category.getWords());
        }
        return categoryWords;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public String getWord() {
        return word;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
    }

    public void addWordToCategory(Category category, String word) {
        if (category != null) {
            category.addWord(word);
        }
    }

    public void addCategory() {
        Category category = new Category();
        category.setName(categoryName);
        categories.add(category);
    }

    public void addWord() {
        if (selectedCategory != null) {
            selectedCategory.addWord(word);
        }
    }

    public void setSelectedCategory(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                selectedCategory = category;
                break;
            }
        }
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getRandomCategoryName() {
        List<String> categoryNames = getCategoryNames();
        int randomIndex = (int) (Math.random() * categoryNames.size());
        return categoryNames.get(randomIndex);
    }

    

    
    private Category getCategoryByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

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
}
