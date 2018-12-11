package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    private static final String nameObj        = "name";
    private static final String alsoKnownArr   = "alsoKnownAs";
    private static final String ingredientsArr = "ingredients";
    private static final String nameStr        = "mainName";
    private static final String imageStr       = "image";
    private static final String descriptionStr = "description";
    private static final String originStr      = "placeOfOrigin";

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        ArrayList<String> alternativeNames = new ArrayList<>();
        ArrayList<String> ingredientsArray = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject(nameObj);

            JSONArray alternativeNamesArray = nameObject.getJSONArray(alsoKnownArr);
            for(int i=0;i<alternativeNamesArray.length();i++) {
                alternativeNames.add(alternativeNamesArray.get(i).toString());
            }

            JSONArray ingredients = jsonObject.getJSONArray(ingredientsArr);
            for(int i=0;i<ingredients.length();i++) {
                ingredientsArray.add(ingredients.get(i).toString());
            }

            sandwich.setMainName(nameObject.optString(nameStr,"N/A"));
            sandwich.setImage(jsonObject.optString(imageStr,""));
            sandwich.setAlsoKnownAs(alternativeNames);
            sandwich.setDescription(jsonObject.optString(descriptionStr,"N/A"));
            sandwich.setPlaceOfOrigin(jsonObject.optString(originStr,"N/A"));
            sandwich.setIngredients(ingredientsArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;

    }
}
