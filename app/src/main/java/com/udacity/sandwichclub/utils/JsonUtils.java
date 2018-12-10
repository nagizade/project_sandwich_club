package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        ArrayList<String> alternativeNames = new ArrayList<>();
        ArrayList<String> ingredientsArray = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");

            JSONArray alternativeNamesArray = nameObject.getJSONArray("alsoKnownAs");
            for(int i=0;i<alternativeNamesArray.length();i++) {
                alternativeNames.add(alternativeNamesArray.get(i).toString());
            }

            JSONArray ingredients = jsonObject.getJSONArray("ingredients");
            for(int i=0;i<ingredients.length();i++) {
                ingredientsArray.add(ingredients.get(i).toString());
            }



            sandwich.setMainName(nameObject.getString("mainName"));
            sandwich.setImage(jsonObject.getString("image"));
            sandwich.setAlsoKnownAs(alternativeNames);
            sandwich.setDescription(jsonObject.getString("description"));
            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            sandwich.setIngredients(ingredientsArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;

    }
}
