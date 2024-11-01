package undergardens.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Rafflesia extends Monster {

    public Rafflesia(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.setHealth(20.0F); // HP設定
    }

    // モブの属性（HPや移動速度）を定義
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
            .add(Attributes.MAX_HEALTH, 20.0)
            .add(Attributes.MOVEMENT_SPEED, 0.2) // 歩行速度
            .add(Attributes.ATTACK_DAMAGE, 3.0); // 攻撃力
    }

    // AI設定
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true)); // 近接攻撃AI
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.6)); // ランダム移動AI
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this)); // ランダム視線変更AI
    }

    // 攻撃時に毒を付与する処理
    @Override
    public boolean doHurtTarget(Entity target) {
        boolean flag = super.doHurtTarget(target);
        if (flag && target instanceof Player) {
            ((Player) target).addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1)); // 5秒間毒状態
        }
        return flag;
    }

    // ダメージ時の動作
    @Override
    public void hurt(DamageSource source, float amount) {
        super.hurt(source, amount);
        // 攻撃されたときの追加効果（例：花が揺れるアニメーションなど）を追加可能
    }
}
