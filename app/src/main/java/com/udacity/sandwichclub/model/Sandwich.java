package com.udacity.sandwichclub.model;

import java.util.ArrayList;

public class Sandwich {

    private String mainName;
    private ArrayList<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private ArrayList<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, ArrayList<String> alsoKnownAs, String placeOfOrigin, String description, String image, ArrayList<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public ArrayList<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(ArrayList<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }
}
