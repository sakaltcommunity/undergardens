package undergardens.entity;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tiers;

public class UnderstonePickaxe extends PickaxeItem {
    public UnderstonePickaxe() {
        super(Tiers.DIAMOND, 4, -2.8F, new Properties().tab(/* Add your creative tab here */).durability(965)); // 耐久値を200に設定
    }
}
