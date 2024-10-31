package undergardens;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class undergarden {
    // タランチュラエンティティの定義
    public static final EntityType<Tarantula> TARANTULA = EntityType.Builder.of(Tarantula::new, MobCategory.MONSTER)
        .sized(1.0F, 0.5F)  // サイズ設定
        .build("undergardens:tarantula");

    // アンダーストーンブロックの定義
    public static final Block UNDER_STONE = new Block(BlockBehaviour.Properties.of(Blocks.STONE.defaultBlockState().getMaterial())
        .strength(3.0F, 6.0F).requiresCorrectToolForDrops());

    // アンダーストーンバイオームの定義
    public static final Biome UNDERSTONE_BIOME = UnderstoneBiome.createUnderstoneBiome();

    // 次元やエンティティの登録
    public static void register() {
        // タランチュラエンティティの登録
        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation("undergardens", "tarantula"), TARANTULA);
        System.out.println("タランチュラが登録されました");

        // アンダーストーンブロックの登録
        Registry.register(Registry.BLOCK, new ResourceLocation("undergardens", "under_stone"), UNDER_STONE);
        System.out.println("アンダーストーンが登録されました");

        // アンダーストーンバイオームの登録
        Registry.register(Registry.BIOME, new ResourceLocation("undergardens", "understone_biome"), UNDERSTONE_BIOME);
        System.out.println("アンダーストーンバイオームが登録されました");

        // スポーン設定
        SpawnPlacements.register(TARANTULA, SpawnPlacements.Type.ON_GROUND, 
            null, null); // 適切なスポーン設定を指定
    }
}