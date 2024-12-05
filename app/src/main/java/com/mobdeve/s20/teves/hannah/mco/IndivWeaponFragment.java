package com.mobdeve.s20.teves.hannah.mco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s20.teves.hannah.mco.network.GenshinListApi;
import com.mobdeve.s20.teves.hannah.mco.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndivWeaponFragment extends Fragment {

    private TextView nameHolder;
    private ImageView imgHolder;
    private Button btnClose;

    private ImageView refineArrow;
    private LinearLayout refineMaterialsSection;
    private RecyclerView recyclerView;
    private RefineMaterialAdapter adapter;
    private List<RefineMaterialData> refineMaterialList;

    private boolean isRefineSectionVisible = false; // Track visibility state

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weapon_indiv, container, false);

        // Initialize Views
        nameHolder = view.findViewById(R.id.weaponName);
        imgHolder = view.findViewById(R.id.weaponImg);
        btnClose = view.findViewById(R.id.btn_close);
        refineArrow = view.findViewById(R.id.refineArrow);
        refineMaterialsSection = view.findViewById(R.id.refineMaterialsSection);
        recyclerView = view.findViewById(R.id.refineRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get weapon name from arguments
        Bundle args = getArguments();
        if (args != null) {
            String weaponName = args.getString("WEAPON_NAME");
            fetchWeaponDataByName(weaponName);
        }

        // Set OnClickListener to toggle visibility of refine materials
        refineArrow.setOnClickListener(v -> toggleRefineMaterialsVisibility());

        // Set close button functionality
        btnClose.setOnClickListener(v -> {
            WeaponFragment weaponFragment = new WeaponFragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, weaponFragment)
                    .commit();
        });

        return view;
    }

    private void toggleRefineMaterialsVisibility() {
        if (isRefineSectionVisible) {
            refineMaterialsSection.setVisibility(View.GONE);
            refineArrow.setImageResource(R.drawable.ic_arrow_down); // Arrow points down when collapsed
        } else {
            refineMaterialsSection.setVisibility(View.VISIBLE);
            refineArrow.setImageResource(R.drawable.ic_arrow_up); // Arrow points up when expanded
        }
        isRefineSectionVisible = !isRefineSectionVisible; // Toggle state
    }

    private void fetchWeaponDataByName(String weaponName) {
        GenshinListApi genshinListApi = RetrofitClient.getGenshinListApi();

        genshinListApi.getWeapons().enqueue(new Callback<List<WeaponData>>() {
            @Override
            public void onResponse(Call<List<WeaponData>> call, Response<List<WeaponData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<WeaponData> weaponDataList = response.body();
                    for (WeaponData weaponData : weaponDataList) {
                        if (weaponData.name.equalsIgnoreCase(weaponName)) {
                            displayWeaponData(weaponData);
                            return;
                        }
                    }
                    Toast.makeText(getContext(), "Weapon not found", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Failed to fetch weapon details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WeaponData>> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayWeaponData(WeaponData weaponData) {
        if (weaponData != null) {
            nameHolder.setText(weaponData.name);
            imgHolder.setImageResource(weaponData.getWeaponImage()); // Map to local drawable

            // Since API doesn't provide refinement data, handle gracefully
            refineMaterialList = new ArrayList<>();
            refineMaterialList.add(new RefineMaterialData("Base Attack", weaponData.atk)); // Example of static data
            refineMaterialList.add(new RefineMaterialData("Rarity", Integer.parseInt(weaponData.rarity))); // Example

            // Initialize and set the adapter
            adapter = new RefineMaterialAdapter(refineMaterialList);
            recyclerView.setAdapter(adapter);
        }
    }
}
