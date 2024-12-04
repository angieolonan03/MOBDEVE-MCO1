package com.mobdeve.s20.teves.hannah.mco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeaponData {
    String name;
    int weaponImg;

    Map<String, Integer> refineRequirements;
    int refineMora;
    int refineCrystal;

    // Optimized constructor
    public WeaponData(String name,
                      int weaponImg,
                      Map<String, Integer> refineRequirements,
                      int refineMora,
                      int refineCrystal) {
        this.name = name;
        this.weaponImg = weaponImg;
        this.refineRequirements = refineRequirements;
        this.refineMora = refineMora;
        this.refineCrystal = refineCrystal;
    }

    public int getWeaponImg() {
        return weaponImg;
    }

    // Method to get a formatted string of refinement materials
    public String getRefineMaterials() {
        StringBuilder materials = new StringBuilder();
        for (Map.Entry<String, Integer> entry : refineRequirements.entrySet()) {
            materials.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        materials.append("Total Mora: ").append(refineMora).append("\n");
        materials.append("Total Crystals: ").append(refineCrystal).append("\n");
        return materials.toString();
    }

    // Sample data
    public static List<WeaponData> getWeaponData() {
        List<WeaponData> weaponList = new ArrayList<>();

        // Sample data for Aether
        Map<String, Integer> aetherRefineRequirements = new HashMap<>();
        aetherRefineRequirements.put("Silver", 5);
        aetherRefineRequirements.put("Crystal Chunk", 10);
        aetherRefineRequirements.put("Weapon Material 1", 2);
        aetherRefineRequirements.put("Weapon Material 2", 3);

        weaponList.add(new WeaponData("Primordial Jade Wing Spear", R.drawable.primordial,
                aetherRefineRequirements, 10000, 2000));

        // Sample data for Character 2
        Map<String, Integer> character2RefineRequirements = new HashMap<>();
        character2RefineRequirements.put("Silver", 3);
        character2RefineRequirements.put("Crystal Chunk", 5);
        character2RefineRequirements.put("Weapon Material 1", 1);
        character2RefineRequirements.put("Weapon Material 2", 2);

        weaponList.add(new WeaponData("Amos Bow", R.drawable.amos,
                character2RefineRequirements, 8000, 1500));

        // Sample data for Character 3
        Map<String, Integer> character3RefineRequirements = new HashMap<>();
        character3RefineRequirements.put("Silver", 4);
        character3RefineRequirements.put("Crystal Chunk", 8);
        character3RefineRequirements.put("Weapon Material 1", 2);
        character3RefineRequirements.put("Weapon Material 2", 1);

        weaponList.add(new WeaponData("Staff of Homa", R.drawable.homa,
                character3RefineRequirements, 9000, 1800));

        // New weapon: Skyward Harp
        Map<String, Integer> harpRefineRequirements = new HashMap<>();
        harpRefineRequirements.put("Silver", 6);
        harpRefineRequirements.put("Crystal Chunk", 12);
        harpRefineRequirements.put("Weapon Material 1", 3);
        harpRefineRequirements.put("Weapon Material 2", 4);

        weaponList.add(new WeaponData("Skyward Harp", R.drawable.skywardharp,
                harpRefineRequirements, 11000, 2500));

        // New weapon: Wolf's Gravestone
        Map<String, Integer> wolfRefineRequirements = new HashMap<>();
        wolfRefineRequirements.put("Silver", 7);
        wolfRefineRequirements.put("Crystal Chunk", 15);
        wolfRefineRequirements.put("Weapon Material 1", 4);
        wolfRefineRequirements.put("Weapon Material 2", 5);

        weaponList.add(new WeaponData("Wolf's Gravestone", R.drawable.wolfsgravestone,
                wolfRefineRequirements, 12000, 3000));

        Map<String, Integer> freedomSwornRefineRequirements = new HashMap<>();
        freedomSwornRefineRequirements.put("Silver", 5);
        freedomSwornRefineRequirements.put("Crystal Chunk", 14);
        freedomSwornRefineRequirements.put("Weapon Material 1", 2);
        freedomSwornRefineRequirements.put("Weapon Material 2", 3);
        weaponList.add(new WeaponData("Freedom-Sworn", R.drawable.freedom,
                freedomSwornRefineRequirements, 15000, 3500));

        Map<String, Integer> thunderingPulseRefineRequirements = new HashMap<>();
        thunderingPulseRefineRequirements.put("Silver", 8);
        thunderingPulseRefineRequirements.put("Crystal Chunk", 18);
        thunderingPulseRefineRequirements.put("Weapon Material 1", 3);
        thunderingPulseRefineRequirements.put("Weapon Material 2", 4);
        weaponList.add(new WeaponData("Thundering Pulse", R.drawable.thundering,
                thunderingPulseRefineRequirements, 20000, 4000));

        Map<String, Integer> engulfingLightningRefineRequirements = new HashMap<>();
        engulfingLightningRefineRequirements.put("Silver", 6);
        engulfingLightningRefineRequirements.put("Crystal Chunk", 16);
        engulfingLightningRefineRequirements.put("Weapon Material 1", 4);
        engulfingLightningRefineRequirements.put("Weapon Material 2", 2);
        weaponList.add(new WeaponData("Engulfing Lightning", R.drawable.engulfing,
                engulfingLightningRefineRequirements, 18000, 3700));

        Map<String, Integer> elegyRefineRequirements = new HashMap<>();
        elegyRefineRequirements.put("Silver", 9);
        elegyRefineRequirements.put("Crystal Chunk", 20);
        elegyRefineRequirements.put("Weapon Material 1", 5);
        elegyRefineRequirements.put("Weapon Material 2", 4);
        weaponList.add(new WeaponData("Elegy for the End", R.drawable.elegy,
                elegyRefineRequirements, 25000, 5000));

        Map<String, Integer> vortexVanquisherRefineRequirements = new HashMap<>();
        vortexVanquisherRefineRequirements.put("Silver", 7);
        vortexVanquisherRefineRequirements.put("Crystal Chunk", 19);
        vortexVanquisherRefineRequirements.put("Weapon Material 1", 4);
        vortexVanquisherRefineRequirements.put("Weapon Material 2", 5);
        weaponList.add(new WeaponData("Vortex Vanquisher", R.drawable.vortex,
                vortexVanquisherRefineRequirements, 22000, 4500));



        return weaponList;
    }
}
