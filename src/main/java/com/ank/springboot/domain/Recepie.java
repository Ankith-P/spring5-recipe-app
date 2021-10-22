package com.ank.springboot.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
public class Recepie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String soruce;
    private String url;
    private String  directions;
    @Lob
    private Byte[] Image;
    // if recepie is deleted, all the related incredients in the table are also deleted using cascade
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recepie")//property on the child class
    private  Set<Ingredient> ingredients=new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @Enumerated(value=EnumType.STRING)//default uses ordinal value. to use string, we need to specify this
    private Difficulty difficulty;
    @ManyToMany
    @JoinTable(name = "recepie_category",joinColumns = @JoinColumn(name="recepie_id"),
            inverseJoinColumns = @JoinColumn(name="category_id"))
    Set<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSoruce() {
        return soruce;
    }

    public void setSoruce(String soruce) {
        this.soruce = soruce;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return Image;
    }

    public void setImage(Byte[] image) {
        Image = image;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
