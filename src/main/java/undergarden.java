package undergardens;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class undergardens {
    public static final EntityType<Tarantula> TARANTULA = EntityType.Builder.of(Tarantula::new, MobCategory.MONSTER)
        .sized(1.0F, 0.5F)  // サイズ設定
        .build("undergardens:tarantula");

    public static final EntityType<UnderCod> UNDER_COD = EntityType.Builder.of(UnderCod::new, MobCategory.WATER_CREATURE)
        .sized(0.6F, 0.4F) // サイズ設定
        .build("undergardens:under_cod");

    public static final EntityType<Rafflesia> RAFFLESIA = EntityType.Builder.of(Rafflesia::new, MobCategory.MONSTER)
        .sized(0.8F, 1.0F) // サイズ設定
        .build("undergardens:rafflesia");

    public static final Block UNDER_STONE = new Block(BlockBehaviour.Properties.of(Blocks.STONE.defaultBlockState().getMaterial())
        .strength(3.0F, 6.0F).requiresCorrectToolForDrops());

    public static final Biome UNDERSTONE_BIOME = UnderstoneBiome.createUnderstoneBiome();

    // スポーンエッグのアイテム設定
    public static final Item TARANTULA_SPAWN_EGG = new SpawnEggItem(TARANTULA, 0x000000, 0xFFFFFF, new Item.Properties().tab(ItemGroup.TAB_MISC));
    public static final Item UNDER_COD_SPAWN_EGG = new SpawnEggItem(UNDER_COD, 0x0000FF, 0xFFFFFF, new Item.Properties().tab(ItemGroup.TAB_MISC));
    public static final Item RAFFLESIA_SPAWN_EGG = new SpawnEggItem(RAFFLESIA, 0xFF00FF, 0xFFFFFF, new Item.Properties().tab(ItemGroup.TAB_MISC));

    public static void register() {
        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation("undergardens", "tarantula"), TARANTULA);
        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation("undergardens", "under_cod"), UNDER_COD);
        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation("undergardens", "rafflesia"), RAFFLESIA);
        Registry.register(Registry.BLOCK, new ResourceLocation("undergardens", "under_stone"), UNDER_STONE);
        Registry.register(Registry.BIOME, new ResourceLocation("undergardens", "understone_biome"), UNDERSTONE_BIOME);

        // スポーンエッグの登録
        Registry.register(Registry.ITEM, new ResourceLocation("undergardens", "tarantula_spawn_egg"), TARANTULA_SPAWN_EGG);
        Registry.register(Registry.ITEM, new ResourceLocation("undergardens", "under_cod_spawn_egg"), UNDER_COD_SPAWN_EGG);
        Registry.register(Registry.ITEM, new ResourceLocation("undergardens", "rafflesia_spawn_egg"), RAFFLESIA_SPAWN_EGG);
    }
}
