package com.barion.the_witcher.world;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.item.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class TWItems{
    public static final DeferredRegister<Item> Registry = DeferredRegister.create(ForgeRegistries.ITEMS, TheWitcher.ModID);
    public static final Item.Properties DefaultProperies = properties();
    public static final Item.Properties Stacks16 = properties().stacksTo(16);
    public static final Item.Properties NoStack = properties().stacksTo(1);

    public static final RegistryObject<Item> TabLogo = Registry.register("tab_logo", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RawSilver = register("raw_silver", item(DefaultProperies));
    public static final RegistryObject<Item> SilverIngot = register("silver_ingot", item(DefaultProperies));
    public static final RegistryObject<Item> SilverNugget = register("silver_nugget", item(DefaultProperies));
    public static final RegistryObject<TWSilverSwordItem> SilverSword = register("silver_sword", silverSword(12, 256, Rarity.COMMON));
    public static final RegistryObject<TWSilverSwordItem> MasterfulSilverSword = register("masterful_silver_sword", silverSword(16, 512, Rarity.RARE));

    public static final RegistryObject<Item> SteelIngot = register("steel_ingot", item(DefaultProperies));
    public static final RegistryObject<Item> SteelNugget = register("steel_nugget", item(DefaultProperies));
    public static final RegistryObject<SwordItem> SteelSword = register("steel_sword", sword(TWTiers.Steel, 0, -2, 0, Rarity.COMMON));
    public static final RegistryObject<SwordItem> MasterfulSteelSword = register("masterful_steel_sword", sword(TWTiers.Steel, 4, -1.5f, 500, Rarity.RARE));
    public static final RegistryObject<ArmorItem> ReinforcedLeatherHelmet = register("reinforced_leather_helmet", ()-> new ArmorItem(TWArmorMaterial.ReinforcedLeather, EquipmentSlot.HEAD, properties()));
    public static final RegistryObject<ArmorItem> ReinforcedLeatherChestplate = register("reinforced_leather_chestplate", ()-> new ArmorItem(TWArmorMaterial.ReinforcedLeather, EquipmentSlot.CHEST, properties()));
    public static final RegistryObject<ArmorItem> ReinforcedLeatherLeggings = register("reinforced_leather_leggings", ()-> new ArmorItem(TWArmorMaterial.ReinforcedLeather, EquipmentSlot.LEGS, properties()));
    public static final RegistryObject<ArmorItem> ReinforcedLeatherBoots = register("reinforced_leather_boots", ()-> new ArmorItem(TWArmorMaterial.ReinforcedLeather, EquipmentSlot.FEET, properties()));

    public static final RegistryObject<TWKikimoraToothItem> KikimoraTooth = register("kikimora_tooth", TWKikimoraToothItem::new);
    public static final RegistryObject<ItemNameBlockItem> WhiteMyrtle = register("white_myrtle", blockItem(TWBlocks.WhiteMyrtleBush));
    public static final RegistryObject<ItemNameBlockItem> Celandine = register("celandine", blockItem(TWBlocks.CelandineBush));
    public static final RegistryObject<Item> HotWaterBottle = register("hot_water_bottle", () -> new TWHotWaterBottleItem(properties().stacksTo(4).craftRemainder(Items.GLASS_BOTTLE).food(TWFoods.HotWaterBottle)));

    public static final RegistryObject<SpawnEggItem> WildHuntKnightSpawnEgg = register("wild_hunt_knight_spawn_egg", ()-> new ForgeSpawnEggItem(TWEntities.WildHuntKnight, -16777216, -6684673, DefaultProperies));
    public static final RegistryObject<SpawnEggItem> WildHuntHoundSpawnEgg = register("wild_hunt_hound_spawn_egg", ()-> new ForgeSpawnEggItem(TWEntities.WildHuntHound, -13421773, -16737895, DefaultProperies));
    public static final RegistryObject<SpawnEggItem> IceGhostSpawnEgg = register("ice_ghost_spawn_egg", ()-> new ForgeSpawnEggItem(TWEntities.IceGhost, -13369345, -16776961, DefaultProperies));

    private static Supplier<Item> item(Item.Properties properties) {return () -> new Item(properties);}
    private static Supplier<ItemNameBlockItem> blockItem(Supplier<? extends Block> block) {return () -> new ItemNameBlockItem(block.get(), DefaultProperies);}
    private static Supplier<TWSilverSwordItem> silverSword(int dmgBonus, int bonusUses, Rarity rarity){
        return () -> new TWSilverSwordItem(TWTiers.Silver, dmgBonus, 2, properties().defaultDurability(TWTiers.Silver.getUses() + bonusUses).rarity(rarity));
    }
    private static Supplier<SwordItem> sword(Tier tier, int dmg, float speed, int bonusUses, Rarity rarity){
        return () -> new SwordItem(tier, dmg, speed, properties().defaultDurability(tier.getUses() + bonusUses).rarity(rarity));
    }

    public static Item.Properties properties() {return new Item.Properties().tab(TWUtil.TheWitcherTab);}

    private static <I extends Item> RegistryObject<I> register(String id, Supplier<I> item) {return Registry.register(id, item);}
    public static List<Item> getAllItems() {return Registry.getEntries().stream().map(RegistryObject::get).toList();}
}