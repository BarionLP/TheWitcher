package com.barion.the_witcher.stuff;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TWItems {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, TheWitcher.ModID);

    public static final RegistryObject<Item> TabLogo = Items.register("tab_logo", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RawSilver = regItem("raw_silver");
    public static final RegistryObject<Item> SilverIngot = regItem("silver_ingot");
    public static final RegistryObject<Item> SilverNugget = regItem("silver_nugget");
    public static final RegistryObject<TWUtil.Swords.Silver> SilverSword = regSilverSword("silver_sword", 12, Rarity.COMMON);
    public static final RegistryObject<TWUtil.Swords.Silver> MasterfulSilverSword = regSilverSword("masterful_silver_sword", 16, Rarity.RARE);
    public static final RegistryObject<Item> SteelIngot = regItem("steel_ingot");
    public static final RegistryObject<Item> SteelNugget = regItem("steel_nugget");
    public static final RegistryObject<SwordItem> SteelSword = regSword("steel_sword", TWUtil.Tiers.Steel, 0, -2, 0);
    public static final RegistryObject<SwordItem> MasterfulSteelSword = regSword("masterful_steel_sword", TWUtil.Tiers.Steel, 4, -1.5f, 500, Rarity.RARE);

    private static RegistryObject<Item> regItem(String id){
        return Items.register(id, () -> new Item(new Item.Properties().tab(TWUtil.TheWitcherTab)));
    }
    private static RegistryObject<TWUtil.Swords.Silver> regSilverSword(String id, int dmgBonus, Rarity rarity){
        return Items.register(id, ()-> new TWUtil.Swords.Silver(TWUtil.Tiers.Silver, dmgBonus, 2, new Item.Properties().tab(TWUtil.TheWitcherTab).defaultDurability(1200).rarity(rarity)));
    }
    private static RegistryObject<SwordItem> regSword(String id, Tier tier, int dmg, float speed, int durability){
        return Items.register(id, ()-> new SwordItem(tier, dmg, speed, new Item.Properties().tab(TWUtil.TheWitcherTab).defaultDurability(tier.getUses() + durability)));
    }
    private static RegistryObject<SwordItem> regSword(String id, Tier tier, int dmg, float speed, int durability, Rarity rarity){
        return Items.register(id, ()-> new SwordItem(tier, dmg, speed, new Item.Properties().tab(TWUtil.TheWitcherTab).defaultDurability(tier.getUses() + durability).rarity(rarity)));
    }
}