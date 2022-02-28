package com.barion.the_witcher.world;

import com.barion.the_witcher.TWUtil;
import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWBlocks {
    public static final DeferredRegister<Block> Registry = DeferredRegister.create(ForgeRegistries.BLOCKS, TheWitcher.ModID);

    public static final BlockBehaviour.Properties frosted = properties(Blocks.STONE).friction(0.8f);

    public static final RegistryObject<Block> SilverOre = register("silver_ore",
            block(Material.STONE, 3, 3, SoundType.STONE, true));
    public static final RegistryObject<Block> DeepslateSilverOre = register("deepslate_silver_ore",
            block(Material.STONE, 4.5f, 3, SoundType.DEEPSLATE, true));
    public static final RegistryObject<Block> SilverBlock = register("silver_block",
            block(Material.METAL, 3, 3, SoundType.METAL, true));
    public static final RegistryObject<Block> RawSilverBlock = register("raw_silver_block",
            block(Material.METAL, 5, 6, SoundType.METAL, true));

    public static final RegistryObject<Block> FrostedStone = register("frosted_stone", block(frosted));
    public static final RegistryObject<Block> DeepFrostedStone = register("deep_frosted_stone", block(frosted));
    public static final RegistryObject<Block> FrostedCobblestone = register("frosted_cobblestone", block(frosted));
    public static final RegistryObject<Block> DeepFrostedCobblestone = register("deep_frosted_cobblestone", block(frosted));

    private static BlockBehaviour.Properties properties(Block base){return BlockBehaviour.Properties.copy(base);}

    private static Block block(BlockBehaviour.Properties properties){return new Block(properties);}
    private static Block block(Block base){return new Block(BlockBehaviour.Properties.copy(base));}
    private static Block block(Material material, float hardness, float resistance, SoundType sound, boolean requiresCorrectTool){
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of(material).strength(hardness, resistance).sound(sound);
        if(requiresCorrectTool){
            properties.requiresCorrectToolForDrops();
        }
        return new Block(properties);
    }

    private static <T extends Block>RegistryObject<T> register(String name, T block){
        RegistryObject<T> registered = registerWithoutItem(name, block);
        TWItems.Registry.register(name, () -> new BlockItem(registered.get(), new Item.Properties().tab(TWUtil.TheWitcherTab)));
        return registered;
    }
    private static <T extends Block>RegistryObject<T> registerWithoutItem(String name, T block){
        return Registry.register(name, () -> block);
    }
}