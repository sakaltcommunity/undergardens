package undergardens;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeAmbience;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class UnderstoneBiome {
    public static Biome createUnderstoneBiome() {
        BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder()
            .waterColor(4159204)
            .waterFogColor(329011)
            .fogColor(12638463);

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder()
            .addFeature(/* Add features here if needed */);

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder()
            .addSpawn(MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(undergardens.TARANTULA.get(), 15, 2, 5)) // タランチュラのスポーン設定
            .addSpawn(MobCategory.WATER_CREATURE,
                new MobSpawnSettings.SpawnerData(undergardens.UNDER_COD.get(), 15, 2, 5)); // アンダーコッドのスポーン設定

        return new Biome.BiomeBuilder()
            .biomeCategory(BiomeCategory.NETHER)
            .depth(0)
            .scale(0)
            .temperature(0.4F)
            .downfall(0.0F)
            .biomeAmbience(ambienceBuilder.build())
            .generationSettings(generationBuilder.build())
            .mobSpawnSettings(spawnBuilder.build())
            .build();
    }
}
