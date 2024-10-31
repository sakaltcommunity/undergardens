package undergardens;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.BiomeAmbience;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class UnderstoneBiome {
    // アンダーストーンバイオームの生成
    public static Biome createUnderstoneBiome() {
        // バイオームの雰囲気
        BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder()
            .waterColor(4159204)
            .waterFogColor(329011)
            .fogColor(12638463);

        // バイオームの生成設定
        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder()
            .addFeature(/* Add features here if needed */);

        // モンスターのスポーン設定
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder()
            .addSpawn(/* Add spawn settings for Tarantula or other entities */);

        // バイオームの構築
        return new Biome.BiomeBuilder()
            .biomeCategory(BiomeCategory.NETHER)
            .depth(0)
            .scale(0)
            .temperature(2.0F)
            .downfall(0.0F)
            .biomeAmbience(ambienceBuilder.build())
            .generationSettings(generationBuilder.build())
            .mobSpawnSettings(spawnBuilder.build())
            .build();
    }
}
