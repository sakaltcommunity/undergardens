package undergardens.entity;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tiers;

public class UnderstoneSword extends SwordItem {
    public UnderstoneSword() {
        super(Tiers.DIAMOND, 7, -2.4F, new Properties().tab(/* Add your creative tab here */).durability(965)); // 耐久値を200に設定
    }
}
