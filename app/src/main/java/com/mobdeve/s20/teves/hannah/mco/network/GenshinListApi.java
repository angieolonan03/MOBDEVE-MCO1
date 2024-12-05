package com.mobdeve.s20.teves.hannah.mco.network;

import com.mobdeve.s20.teves.hannah.mco.WeaponData;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GenshinListApi {
    @GET("weapons")
    Call<List<WeaponData>> getWeapons();
}
