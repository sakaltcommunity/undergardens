package undergardens;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import undergardens.entities.UnderCod;

public class undergardens {
    public static final EntityType<Tarantula> TARANTULA = EntityType.Builder.of(Tarantula::new, MobCategory.MONSTER)
        .sized(1.0F, 0.5F) 
        .build("undergardens:tarantula");

    public static final EntityType<UnderCod> UNDER_COD = EntityType.Builder.of(UnderCod::new, MobCategory.WATER_CREATURE)
        .sized(1.4F, 0.9F)
        .build("undergardens:under_cod");

    public static final Block UNDER_STONE = new Block(BlockBehaviour.Properties.of(Blocks.STONE.defaultBlockState().getMaterial())
        .strength(3.0F, 6.0F).requiresCorrectToolForDrops());

    public static final Biome UNDERSTONE_BIOME = UnderstoneBiome.createUnderstoneBiome();

    public static final Item UNDERSTONE_SWORD = new SwordItem(UnderstoneTiers.UNDERSTONE, 7, -2.4F, new Item.Properties());
    public static final Item UNDERSTONE_PICKAXE = new PickaxeItem(UnderstoneTiers.UNDERSTONE, 1, -2.8F, new Item.Properties());

    public static void register() {
        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation("undergardens", "tarantula"), TARANTULA);
        System.out.println("タランチュラが登録されました");

        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation("undergardens", "under_cod"), UNDER_COD);
        System.out.println("アンダーCodが登録されました");

        Registry.register(Registry.BLOCK, new ResourceLocation("undergardens", "under_stone"), UNDER_STONE);
        System.out.println("アンダーストーンが登録されました");

        Registry.register(Registry.BIOME, new ResourceLocation("undergardens", "understone_biome"), UNDERSTONE_BIOME);
        System.out.println("アンダーストーンバイオームが登録されました");

        Registry.register(Registry.ITEM, new ResourceLocation("undergardens", "understone_sword"), UNDERSTONE_SWORD);
        Registry.register(Registry.ITEM, new ResourceLocation("undergardens", "understone_pickaxe"), UNDERSTONE_PICKAXE);

        SpawnPlacements.register(TARANTULA, SpawnPlacements.Type.ON_GROUND, null, null);
    }
}
