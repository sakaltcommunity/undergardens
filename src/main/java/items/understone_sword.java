package undergardens.entity;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.CreativeModeTabs;

public class UnderstoneSword extends SwordItem {
    public UnderstoneSword() {
        super(Tiers.DIAMOND, 7, -2.4F, new Properties().tab(CreativeModeTabs.COMBAT).durability(965)); // タブ設定を追加
    }
}
