package com.mobdeve.s20.teves.hannah.mco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharData {
        String name;
        int charImg;

        // Requirements as a Map<String, Integer> for both ascension and talent requirements
        Map<String, Integer> ascensionRequirements; // Keys are material/enemy drop names, values are counts
        Map<String, Integer> talentRequirements; // Keys are book/enemy drop names, values are counts
        int ascensionMora; // Mora cost for ascension
        int talentMora; // Mora cost for talent upgrades
        List<String> bestArtifactSets; // Best artifact sets for the character
        List<String> bestWeapons; // Best weapons for the character
        List<String> skillPrio; // Skill priority for the character

        // Optimized constructor
        public CharData(String name,
                        int charImg,
                        Map<String, Integer> ascensionRequirements,
                        int ascensionMora,
                        Map<String, Integer> talentRequirements,
                        int talentMora,
                        List<String> bestArtifactSets,
                        List<String> bestWeapons,
                        List<String> skillPrio) {
                this.name = name;
                this.charImg = charImg;
                this.ascensionRequirements = ascensionRequirements;
                this.ascensionMora = ascensionMora;
                this.talentRequirements = talentRequirements;
                this.talentMora = talentMora;
                this.bestArtifactSets = bestArtifactSets;
                this.bestWeapons = bestWeapons;
                this.skillPrio = skillPrio;
        }

        public int getCharImg() {
                return charImg;
        }

        // Method to convert ascension materials Map to a List for RecyclerView
        public List<Map.Entry<String, Integer>> getAscensionMaterialsAsList() {
                return new ArrayList<>(ascensionRequirements.entrySet());
        }

        // Method to convert talent materials Map to a List for RecyclerView
        public List<Map.Entry<String, Integer>> getTalentMaterialsAsList() {
                return new ArrayList<>(talentRequirements.entrySet());
        }


        // Method to get a formatted string of ascension materials
        public String getAscensionMaterials() {
                StringBuilder materials = new StringBuilder();
                for (Map.Entry<String, Integer> entry : ascensionRequirements.entrySet()) {
                        materials.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }
                materials.append("Total Mora: ").append(ascensionMora);
                return materials.toString();
        }

        // Method to get a formatted string of talent materials
        public String getTalentMaterials() {
                StringBuilder materials = new StringBuilder();
                for (Map.Entry<String, Integer> entry : talentRequirements.entrySet()) {
                        materials.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }
                materials.append("Total Mora: ").append(talentMora);
                return materials.toString();
        }

        // Sample data
        public static List<CharData> getCharacterData() {
                List<CharData> charList = new ArrayList<>();

                // Create a map for ascension requirements for Aether
                Map<String, Integer> aetherAscension = new HashMap<>();
                aetherAscension.put("Vayuda Turquoise Sliver", 1);
                aetherAscension.put("Vayuda Turquoise Fragment", 9);
                aetherAscension.put("Vayuda Turquoise Chunk", 9);
                aetherAscension.put("Vayuda Turquoise Gemstone", 6);
                aetherAscension.put("Slime Condensate", 18);
                aetherAscension.put("Slime Secretions", 30);
                aetherAscension.put("Slime Concentrate", 36);
                aetherAscension.put("Qingxin", 168);
                aetherAscension.put("Juvenile Jade", 46);

                // Create a map for talent requirements for Aether
                Map<String, Integer> aetherTalents = new HashMap<>();
                aetherTalents.put("Crown of Insight", 3);
                aetherTalents.put("Teachings of Prosperity", 9);
                aetherTalents.put("Guide to Prosperity", 63);
                aetherTalents.put("Philosophies of Prosperity", 114);
                aetherTalents.put("Slime Condensate", 18);
                aetherTalents.put("Slime Secretions", 66);
                aetherTalents.put("Slime Concentrate", 93);
                aetherTalents.put("Shadow of a Warrior", 18);

                // Create lists for best artifacts, best weapons, and skill priority
                List<String> aetherBestArtifacts = new ArrayList<>();
                aetherBestArtifacts.add("Vermillion Hereafter");
                aetherBestArtifacts.add("Marechausse Hunter");

                List<String> aetherBestWeapons = new ArrayList<>();
                aetherBestWeapons.add("Primordial Jade Winged Spear");
                aetherBestWeapons.add("Staff of Homa");

                List<String> aetherSkillPrio = new ArrayList<>();
                aetherSkillPrio.add("Elemental Burst");
                aetherSkillPrio.add("Elemental Skill");

                // Add Aether to character list
                charList.add(new CharData("Xiao", R.drawable.xiao, aetherAscension, 420000, aetherTalents, 4957500,
                        aetherBestArtifacts, aetherBestWeapons, aetherSkillPrio));

                // Character 2
                Map<String, Integer> character2Ascension = new HashMap<>();
                character2Ascension.put("Shiva Jade Sliver", 1);
                character2Ascension.put("Shiva Jade Fragment", 9);
                character2Ascension.put("Shiva Jade Chunk", 9);
                character2Ascension.put("Shiva Jade Gemstone", 6);
                character2Ascension.put("Whopperflower Nectar", 18);
                character2Ascension.put("Shimmering Nectar", 30);
                character2Ascension.put("Energy Nectar", 36);
                character2Ascension.put("Qingxin", 168);
                character2Ascension.put("Hoarfrost Core", 46);

                Map<String, Integer> character2Talents = new HashMap<>();
                character2Talents.put("Crown of Insight", 3);
                character2Talents.put("Teachings of Diligence", 9);
                character2Talents.put("Guide to Diligence", 63);
                character2Talents.put("Philosophies of Diligence", 114);
                character2Talents.put("Whopperflower Nectar", 18);
                character2Talents.put("Shimmering Nectar", 66);
                character2Talents.put("Energy Nectar", 93);
                character2Talents.put("Shadow of the Warrior", 18);

                // Create lists for best artifacts, best weapons, and skill priority for Character 2
                List<String> character2BestArtifacts = new ArrayList<>();
                character2BestArtifacts.add("Blizzard Strayer");
                character2BestArtifacts.add("Wanderer's Troupe");

                List<String> character2BestWeapons = new ArrayList<>();
                character2BestWeapons.add("Amos' Bow");
                character2BestWeapons.add("Aqua Simulacra");

                List<String> character2SkillPrio = new ArrayList<>();
                character2SkillPrio.add("Elemental Burst");
                character2SkillPrio.add("Elemental Skill");

                // Add Character 2 to character list
                charList.add(new CharData("Ganyu", R.drawable.ganyu, character2Ascension, 420000, character2Talents, 4957500,
                        character2BestArtifacts, character2BestWeapons, character2SkillPrio));

                // Character 3
                Map<String, Integer> character3Ascension = new HashMap<>();
                character3Ascension.put("Agnidus Agate Sliver", 1);
                character3Ascension.put("Agnidus Agate Fragment", 9);
                character3Ascension.put("Agnidus Agate Chunk", 9);
                character3Ascension.put("Agnidus Agate Gemstone", 6);
                character3Ascension.put("Whopperflower Nectar", 18);
                character3Ascension.put("Shimmering Nectar", 30);
                character3Ascension.put("Energy Nectar", 36);
                character3Ascension.put("Silk Flower", 168);
                character3Ascension.put("Juvenile Jade", 46);

                Map<String, Integer> character3Talents = new HashMap<>();
                character3Talents.put("Crown of Insight", 3);
                character3Talents.put("Teachings of Diligence", 9);
                character3Talents.put("Guides to Diligence", 63);
                character3Talents.put("Philosophies of Diligence", 114);
                character3Talents.put("Whopperflower Nectar", 18);
                character3Talents.put("Shimmering Nectar", 66);
                character3Talents.put("Energy Nectar", 93);
                character3Talents.put("Shard of Foul Legacy", 18);

                // Create lists for best artifacts, best weapons, and skill priority for Character 3
                List<String> character3BestArtifacts = new ArrayList<>();
                character3BestArtifacts.add("Marechaussee Hunter");
                character3BestArtifacts.add("Crimson Witch of Flames");

                List<String> character3BestWeapons = new ArrayList<>();
                character3BestWeapons.add("Staff of Homa");
                character3BestWeapons.add("Primordial Jade Winged Spear");

                List<String> character3SkillPrio = new ArrayList<>();
                character3SkillPrio.add("Elemental Skill");
                character3SkillPrio.add("Elemental Burst");

                // Add Character 3 to character list
                charList.add(new CharData("Hu Tao", R.drawable.hutao, character3Ascension, 420000, character3Talents, 4957500,
                        character3BestArtifacts, character3BestWeapons, character3SkillPrio));

                // Character 4
                Map<String, Integer> character4Ascension = new HashMap<>();
                character4Ascension.put("Prithiva Topaz Sliver", 1);
                character4Ascension.put("Prithiva Topaz Fragment", 9);
                character4Ascension.put("Prithiva Topaz Chunk", 9);
                character4Ascension.put("Prithiva Topaz Gemstone", 6);
                character4Ascension.put("Slime Condensate", 18);
                character4Ascension.put("Slime Secretions", 30);
                character4Ascension.put("Slime Concentrate", 36);
                character4Ascension.put("Cor Lapis", 168);
                character4Ascension.put("Basalt Pillar", 46);

                Map<String, Integer> character4Talents = new HashMap<>();
                character4Talents.put("Crown of Insight", 3);
                character4Talents.put("Teachings of Gold", 9);
                character4Talents.put("Guide to Gold", 63);
                character4Talents.put("Philosophies of Gold", 114);
                character4Talents.put("Slime Condensate", 18);
                character4Talents.put("Slime Secretions", 66);
                character4Talents.put("Slime Concentrate", 93);
                character4Talents.put("Tusk of Monoceros Caeli", 18);

                // Create lists for best artifacts, best weapons, and skill priority for Character 3
                List<String> character4BestArtifacts = new ArrayList<>();
                character4BestArtifacts.add("Tenacity of the Millelith");
                character4BestArtifacts.add("Archaic Petra");

                List<String> character4BestWeapons = new ArrayList<>();
                character4BestWeapons.add("Vortex Vanquisher");
                character4BestWeapons.add("Staff of Homa");

                List<String> character4SkillPrio = new ArrayList<>();
                character4SkillPrio.add("Elemental Skill");
                character4SkillPrio.add("Elemental Burst");

                // Add Character 3 to character list
                charList.add(new CharData("Zhongli", R.drawable.zhongli, character4Ascension, 420000, character4Talents, 4957500,
                        character4BestArtifacts, character4BestWeapons, character4SkillPrio));

                // Character 4
                Map<String, Integer> character5Ascension = new HashMap<>();
                character5Ascension.put("Varunada Lazurite Sliver", 1);
                character5Ascension.put("Varunada Lazurite Fragment", 9);
                character5Ascension.put("Varunada Lazurite Chunk", 9);
                character5Ascension.put("Varunada Lazurite Gemstone", 6);
                character5Ascension.put("Recruit's Insignia", 18);
                character5Ascension.put("Sergeant's Insignia", 30);
                character5Ascension.put("Lieutenant's Insignia", 36);
                character5Ascension.put("Starconch", 168);
                character5Ascension.put("Runic Fang", 46);

                Map<String, Integer> character5Talents = new HashMap<>();
                character5Talents.put("Crown of Insight", 3);
                character5Talents.put("Teachings of Prosperity", 9);
                character5Talents.put("Guide to Prosperity", 63);
                character5Talents.put("Philosophies of Prosperity", 114);
                character5Talents.put("Recruit's Insignia", 18);
                character5Talents.put("Sergeant's Insignia", 66);
                character5Talents.put("Lieutenant's Insignia", 93);
                character5Talents.put("Gilded Scale", 18);

                // Create lists for best artifacts, best weapons, and skill priority for Character 3
                List<String> character5BestArtifacts = new ArrayList<>();
                character5BestArtifacts.add("Emblem of Severed Fate");
                character5BestArtifacts.add("Noblesse Oblige");

                List<String> character5BestWeapons = new ArrayList<>();
                character5BestWeapons.add("Aqua Simulacra");
                character5BestWeapons.add("Elegy for the End");

                List<String> character5SkillPrio = new ArrayList<>();
                character5SkillPrio.add("Elemental Burst");
                character5SkillPrio.add("Elemental Skill");

                // Add Character 3 to character list
                charList.add(new CharData("Yelan", R.drawable.yelan, character5Ascension, 420000, character5Talents, 4957500,
                        character5BestArtifacts, character5BestWeapons, character5SkillPrio));

                // Character 4
                Map<String, Integer> character6Ascension = new HashMap<>();
                character6Ascension.put("Shivada Jade Sliver", 1);
                character6Ascension.put("Shivada Jade Fragment", 9);
                character6Ascension.put("Shivada Jade Chunk", 9);
                character6Ascension.put("Shivada Jade Gemstone", 6);
                character6Ascension.put("Whopperflower Nectar", 18);
                character6Ascension.put("Shimmering Nectar", 30);
                character6Ascension.put("Energy Necta", 36);
                character6Ascension.put("Qingxin", 168);
                character6Ascension.put("Dragonheir's False Fin", 46);

                Map<String, Integer> character6Talents = new HashMap<>();
                character6Talents.put("Crown of Insight", 3);
                character6Talents.put("Teachings of Prosperity", 9);
                character6Talents.put("Guide to Prosperity", 63);
                character6Talents.put("Philosophies of Prosperity", 114);
                character6Talents.put("Whopperflower Nectar", 18);
                character6Talents.put("Shimmering Nectar", 66);
                character6Talents.put("Energy Nectar", 93);
                character6Talents.put("Hellfire Butterfly", 18);

                // Create lists for best artifacts, best weapons, and skill priority for Character 3
                List<String> character6BestArtifacts = new ArrayList<>();
                character6BestArtifacts.add("Noblesse Oblige");
                character6BestArtifacts.add("Blizzard Strayer");

                List<String> character6BestWeapons = new ArrayList<>();
                character6BestWeapons.add("Calamity Queller");
                character6BestWeapons.add("Engulfing Lightning");

                List<String> character6SkillPrio = new ArrayList<>();
                character6SkillPrio.add("Elemental Burst");
                character6SkillPrio.add("Elemental Skill");

                // Add Character 3 to character list
                charList.add(new CharData("Shenhe", R.drawable.shenhe, character6Ascension, 420000, character6Talents, 4957500,
                        character6BestArtifacts, character6BestWeapons, character6SkillPrio));

                // Character 4
                Map<String, Integer> character7Ascension = new HashMap<>();
                character7Ascension.put("Vajrada Amethyst Sliver", 1);
                character7Ascension.put("Vajrada Amethyst Fragment", 9);
                character7Ascension.put("Vajrada Amethyst Chunk", 9);
                character7Ascension.put("Vajrada Amethyst Gemstone", 6);
                character7Ascension.put("Old Handguard", 18);
                character7Ascension.put("Kageuchi Handguard", 30);
                character7Ascension.put("Famed Handguard", 36);
                character7Ascension.put("Amakumo Fruit", 168);
                character7Ascension.put("Storm Beads", 46);

                Map<String, Integer> character7Talents = new HashMap<>();
                character7Talents.put("Crown of Insight", 3);
                character7Talents.put("Teachings of Light", 9);
                character7Talents.put("Guide to Light", 63);
                character7Talents.put("Philosophies of Light", 114);
                character7Talents.put("Old Handguard", 18);
                character7Talents.put("Kageuchi Handguard", 66);
                character7Talents.put("Famed Handguard", 93);
                character7Talents.put("Molten Moment", 18);

                // Create lists for best artifacts, best weapons, and skill priority for Character 3
                List<String> character7BestArtifacts = new ArrayList<>();
                character7BestArtifacts.add("Emblem of Severed Fate");
                character7BestArtifacts.add("Gilded Dreams");

                List<String> character7BestWeapons = new ArrayList<>();
                character7BestWeapons.add("Engulfing Lightning");
                character7BestWeapons.add("Staff of Homa");

                List<String> character7SkillPrio = new ArrayList<>();
                character7SkillPrio.add("Elemental Skill");
                character7SkillPrio.add("Elemental Burst");

                // Add Character 3 to character list
                charList.add(new CharData("Raiden Shogun", R.drawable.raiden, character7Ascension, 420000, character7Talents, 4957500,
                        character7BestArtifacts, character7BestWeapons, character7SkillPrio));

                // Character 4
                Map<String, Integer> character8Ascension = new HashMap<>();
                character8Ascension.put("Agnidus Agate Sliver", 1);
                character8Ascension.put("Agnidus Agate Fragment", 9);
                character8Ascension.put("Agnidus Agate Chunk", 9);
                character8Ascension.put("Agnidus Agate Gemstone", 6);
                character8Ascension.put("Recruit's Insignia", 18);
                character8Ascension.put("Sergeant's Insignia", 30);
                character8Ascension.put("Lieutenant's Insignia", 36);
                character8Ascension.put("Small Lamp Grass", 168);
                character8Ascension.put("Everflame Seed", 46);

                Map<String, Integer> character8Talents = new HashMap<>();
                character8Talents.put("Crown of Insight", 3);
                character8Talents.put("Teachings of Resistance", 9);
                character8Talents.put("Guide to Resistance", 63);
                character8Talents.put("Philosophies of Resistance", 114);
                character8Talents.put("Recruit's Insignia", 18);
                character8Talents.put("Sergeant's Insignia", 66);
                character8Talents.put("Lieutenant's Insignia", 93);
                character8Talents.put("Dvalin's Plume", 18);

                // Create lists for best artifacts, best weapons, and skill priority for Character 3
                List<String> character8BestArtifacts = new ArrayList<>();
                character8BestArtifacts.add("Crimson Witch of Flames");
                character8BestArtifacts.add("Marechaussee Hunter");

                List<String> character8BestWeapons = new ArrayList<>();
                character8BestWeapons.add("Wolf's Grave Stone");
                character8BestWeapons.add("Beacon of the Reed Sea");

                List<String> character8SkillPrio = new ArrayList<>();
                character8SkillPrio.add("Elemental Skill");
                character8SkillPrio.add("Elemental Burst");

                // Add Character 3 to character list
                charList.add(new CharData("Diluc", R.drawable.diluc, character8Ascension, 420000, character8Talents, 4957500,
                        character8BestArtifacts, character8BestWeapons, character8SkillPrio));
                return charList;
        }
}

