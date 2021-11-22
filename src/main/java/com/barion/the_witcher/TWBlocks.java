package com.barion.the_witcher;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TWBlocks {
    public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, TheWitcher.ModID);


    public static final RegistryObject<Block> SilverOre = register("silver_ore",
            Block(Material.STONE, 3, 3, SoundType.STONE, true));
    public static final RegistryObject<Block> DeepslateSilverOre = register("deepslate_silver_ore",
            Block(Material.STONE, 4.5f, 3, SoundType.DEEPSLATE, true));
    public static final RegistryObject<Block> SilverBlock = register("silver_block",
            Block(Material.METAL, 3, 3, SoundType.METAL, true));
    public static final RegistryObject<Block> RawSilverBlock = register("raw_silver_block",
            Block(Material.METAL, 5, 6, SoundType.METAL, true));

    private static Block Block(Material material, float hardness, float resistance, SoundType sound, boolean requiresCorrectTool){
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of(material).strength(hardness, resistance).sound(sound);
        if(requiresCorrectTool){
            properties.requiresCorrectToolForDrops();
        }
        return new Block(properties);
    }

    private static <T extends Block>RegistryObject<T> register(String name, T block){
        RegistryObject<T> registered = registerNoItem(name, block);
        TWItems.Items.register(name, () -> new BlockItem(registered.get(), new Item.Properties().tab(TWUtil.TheWitcherTab)));
        return registered;
    }
    private static <T extends Block>RegistryObject<T> registerNoItem(String name, T block){
        return Blocks.register(name, () -> block);
    }
}