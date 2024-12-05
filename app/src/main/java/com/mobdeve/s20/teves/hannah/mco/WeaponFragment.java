package com.mobdeve.s20.teves.hannah.mco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s20.teves.hannah.mco.network.RetrofitClient;
import com.mobdeve.s20.teves.hannah.mco.network.GenshinListApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeaponFragment extends Fragment {

    private RecyclerView recyclerView;
    private WeaponAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weapon, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.weaponRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2-column grid layout

        fetchWeapons(); // Fetch weapon data from API

        return view;
    }

    private void fetchWeapons() {
        // Get the API instance
        GenshinListApi genshinListApi = RetrofitClient.getGenshinListApi();

        // Make the API call
        WeaponData.getWeaponData(new Callback<List<WeaponData>>() {
            @Override
            public void onResponse(@NonNull Call<List<WeaponData>> call, @NonNull Response<List<WeaponData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Successfully fetched data
                    List<WeaponData> weaponDataList = response.body();
                    if (!weaponDataList.isEmpty()) {
                        // Set up the adapter with the fetched data
                        adapter = new WeaponAdapter(weaponDataList, false);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(getContext(), "No weapons available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Response was not successful
                    Toast.makeText(getContext(), "Failed to fetch weapons. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<WeaponData>> call, @NonNull Throwable t) {
                // Handle the error
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}
