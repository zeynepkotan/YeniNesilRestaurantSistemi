package com.example.zeynep.bottombar.Class;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.zeynep.bottombar.Model.SepetModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zeynep on 13.04.2018.
 */

public class Sepetim {
    public static final String PREFS_NAME = "PRODUCT_APP";
    public static final String FAVORITES = "Product_Favorite";
    public void saveFavorites(Context context, List<SepetModel> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, SepetModel sepetModel) {
        ArrayList<SepetModel> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<SepetModel>();
        favorites.add(sepetModel);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, int sepetModel) {
        ArrayList<SepetModel> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(sepetModel);

           // favorites.clear();
            saveFavorites(context, favorites);

        }
    }

    public ArrayList<SepetModel> getFavorites(Context context) {
        SharedPreferences settings;
        List<SepetModel> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            SepetModel[] favoriteItems = gson.fromJson(jsonFavorites,
                    SepetModel[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<SepetModel>(favorites);
        } else
            return null;

        return (ArrayList<SepetModel>) favorites;
    }
}
