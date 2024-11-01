package undergardens.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class UnderCod extends AbstractFish {
    
    public UnderCod(EntityType<? extends AbstractFish> type, Level world) {
        super(type, world);
        this.setHealth(10.0F); // HPを設定（10 HP）
    }

    @Override
    protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, boolean allowEnchantments) {
        // 鱈をドロップ
        this.spawnAtLocation(Items.COD, 1); // 鱈をドロップ
    }

    @Override
    public boolean isFish() {
        return true; // このエンティティが魚であることを示す
    }

    // 追加のアトリビュート設定
    public static AttributeSupplier.Builder createAttributes() {
        return AbstractFish.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0) // HP設定
                .add(Attributes.MOVEMENT_SPEED, 0.4); // 移動速度設定
    }
    
    @Override
    public int getMaxAirSupply() {
        return 240; // 最大酸素量
    }

    @Override
    public void tick() {
        super.tick();
        // 水中での移動速度を設定
        this.setDeltaMovement(this.getDeltaMovement().add(0, 0.02, 0));
    }
}
