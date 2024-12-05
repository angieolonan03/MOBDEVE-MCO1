package com.mobdeve.s20.teves.hannah.mco;

import com.mobdeve.s20.teves.hannah.mco.network.RetrofitClient;
import com.mobdeve.s20.teves.hannah.mco.network.GenshinListApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeaponData {
    // Fields matching the API response
    int id;
    String name;
    String slug;
    String rarity;
    int atk;
    String obtain;
    String type;

    // Constructor for API response
    public WeaponData(int id, String name, String slug, String rarity, int atk, String obtain, String type) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.rarity = rarity;
        this.atk = atk;
        this.obtain = obtain;
        this.type = type;
    }

    // Getter for local image resources
    public int getWeaponImage() {
        switch (name) {
            case "Primordial Jade Winged-Spear":
                return R.drawable.primordial;
            case "Amos Bow":
                return R.drawable.amos;
            case "Wolfs Gravestone":
                return R.drawable.wolfsgravestone;
            case "Skyward Harp":
                return R.drawable.skywardharp;
            case "Aquila Favonia":
                return R.drawable.aquila;
            case "Skyward Atlas":
                return R.drawable.atlas;
            case "Skyward Blade":
                return R.drawable.blade;
            case "Sacrificial Greatsword":
                return R.drawable.greatsword;
            case "Favonius Lance":
                return R.drawable.lance;
            case "Blackcliff Longsword":
                return R.drawable.longsword;
            case "Lost Prayer of the Sacred Winds":
                return R.drawable.lost;
            case "Mappa Mare":
                return R.drawable.mappa;
            case "Skyward Pride":
                return R.drawable.pride;
            case "Crescent Pike":
                return R.drawable.pike;
            case "Prototype Rancour":
                return R.drawable.rancour;
            case "Royal Grimoire":
                return R.drawable.royal;
            case "Skyward Spine":
                return R.drawable.spine;
            case "Blackcliff Warbow":
                return R.drawable.warbow;
            case "The Alley Flash":
                return R.drawable.alley;
            case "Sacrificial Bow":
                return R.drawable.bow;
            case "Prototype Crescent":
                return R.drawable.prototypecrescent;
            case "Royal Bow":
                return R.drawable.royalbow;
            case "Royal Greatsword":
                return R.drawable.royalgreatsword;
            case "Rust":
                return R.drawable.rust;


            default:
                return R.drawable.placeholder; // Fallback image
        }
    }

    // Static method to fetch weapon data dynamically
    public static void getWeaponData(Callback<List<WeaponData>> callback) {
        GenshinListApi genshinListApi = RetrofitClient.getGenshinListApi();
        genshinListApi.getWeapons().enqueue(new Callback<List<WeaponData>>() {
            @Override
            public void onResponse(Call<List<WeaponData>> call, Response<List<WeaponData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Failed to fetch weapon data"));
                }
            }

            @Override
            public void onFailure(Call<List<WeaponData>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
}
