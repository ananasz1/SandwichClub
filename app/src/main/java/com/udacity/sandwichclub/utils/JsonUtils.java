package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            //create JSONObject
            JSONObject rootJsonObject = new JSONObject(json);
            JSONObject name = rootJsonObject.getJSONObject("name");

            //get names and values
            String mainName = name.getString("mainName");
            String placeOfOrigin = rootJsonObject.getString("placeOfOrigin");
            String description = rootJsonObject.getString("description");
            String imagePath = rootJsonObject.getString("image");

            JSONArray aka = name.getJSONArray("alsoKnownAs");
            ArrayList<String> akaList = new ArrayList<>();
            for (int i = 0; i < aka.length(); i++) {
                akaList.add(aka.getString(i));
            }

            JSONArray ingredients = rootJsonObject.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            Sandwich currentSandwich = new Sandwich(mainName, akaList, placeOfOrigin,description,imagePath,ingredientsList);

            return currentSandwich;



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
