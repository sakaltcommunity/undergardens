package undergardens;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.LevelAccessor;

public class Tarantula extends Monster {
    // コンストラクタ
    public Tarantula(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.setHealth(35.0F); // HP設定
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true)); // 近接攻撃AI
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1.0D)); // ランダム移動AI
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this)); // ランダム視線変更AI
    }

    // ダメージ設定
    @Override
    public float getAttackDamage() {
        return 2.5F; // ダメージ設定
    }

    // 属性の登録
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 35.0D) // HP
            .add(Attributes.ATTACK_DAMAGE, 2.5D); // 攻撃力
    }

    // エンティティの見た目のPNG設定
    @Override
    public String getTexturePath() {
        return "undergardens:textures/entity/tarantula.png"; // エンティティ見た目のファイルパス
    }

    // 経験値設定
    @Override
    protected int getExperienceReward(Player player) {
        return 10; // タランチュラを倒したときに10経験値を獲得
    }

    // ドロップ品の設定
    @Override
    protected void dropCustomDeathLoot(DamageSource source, int lootingMultiplier, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, lootingMultiplier, recentlyHit);
        
        // 通常ドロップ
        this.spawnAtLocation(new ItemStack(Items.STRING, 2 + this.random.nextInt(3))); // ドロップ品の紐（2-4個）

        // レアドロップ（1/10の確率で蜘蛛の目をドロップ）
        if (this.random.nextFloat() < 0.1F) {
            this.spawnAtLocation(new ItemStack(Items.SPIDER_EYE, 1)); // 蜘蛛の目をドロップ
        }
    }
}
