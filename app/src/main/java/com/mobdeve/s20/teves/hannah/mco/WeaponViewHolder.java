package com.mobdeve.s20.teves.hannah.mco;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class WeaponViewHolder extends RecyclerView.ViewHolder {
    TextView weaponName;
    ImageView weaponImg;
    View view;

    public WeaponViewHolder(View itemView) {
        super(itemView);
        this.weaponName = itemView.findViewById(R.id.weaponName);
        this.weaponImg = itemView.findViewById(R.id.weaponImg);
        this.view = itemView;
    }

    public void bindWeapon(WeaponData weaponData) {
        weaponName.setText(weaponData.name);

        // Load weapon image
        int weaponImageResId = weaponData.getWeaponImage(); // Map name to local drawable
        if (weaponImageResId != 0) {
            weaponImg.setImageResource(weaponImageResId); // Load from drawable
        } else {
            Glide.with(view.getContext())
                    .load(R.drawable.placeholder) // Fallback image if no mapping exists
                    .into(weaponImg);
        }
    }
}
