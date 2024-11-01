package undergardens.entity;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.CreativeModeTabs;

public class UnderstonePickaxe extends PickaxeItem {
    public UnderstonePickaxe() {
        super(Tiers.DIAMOND, 4, -2.8F, new Properties().tab(CreativeModeTabs.TOOLS).durability(965)); // タブ設定を追加
    }
}
