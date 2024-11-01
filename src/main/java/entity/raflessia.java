package undergardens.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.damagesource.DamageSource;

public class Rafflesia extends Monster {
    public Rafflesia(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.setHealth(20.0F); // HP設定
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true)); // 近接攻撃AI
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1.0D)); // ランダム移動AI
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this)); // ランダム視線変更AI
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int lootingMultiplier, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, lootingMultiplier, recentlyHit);
        // ラフレシアの特殊ドロップ（例: 花びら）
        this.spawnAtLocation(new ItemStack(Items.POISONOUS_POTATO, 1));
    }

    // 属性の登録
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 20.0D) // HP
            .add(Attributes.ATTACK_DAMAGE, 3.0D); // 攻撃力
    }
}
