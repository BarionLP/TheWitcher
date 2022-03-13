package com.barion.the_witcher.world;

import com.barion.the_witcher.TWUtil;
import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class TWBlocks {
    public static final DeferredRegister<Block> Registry = DeferredRegister.create(ForgeRegistries.BLOCKS, TheWitcher.ModID);

    protected static final BlockBehaviour.Properties frosted = properties(Blocks.STONE).friction(0.8f);

    public static final RegistryObject<Block> SilverOre = register("silver_ore", block(Blocks.IRON_ORE));
    public static final RegistryObject<Block> DeepslateSilverOre = register("deepslate_silver_ore", block(Blocks.DEEPSLATE_IRON_ORE));
    public static final RegistryObject<Block> SilverBlock = register("silver_block", block(Blocks.IRON_BLOCK));
    public static final RegistryObject<Block> RawSilverBlock = register("raw_silver_block", block(Blocks.RAW_IRON_BLOCK));

    public static final RegistryObject<Block> FrostedStone = register("frosted_stone", block(frosted));
    public static final RegistryObject<StairBlock> FrostedStoneStairs = register("frosted_stone_stairs", stair(frosted, () -> FrostedStone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> FrostedStoneSlab = register("frosted_stone_slab", slab(frosted));
    public static final RegistryObject<WallBlock> FrostedStoneWall = register("frosted_stone_wall", wall(frosted));
    public static final RegistryObject<Block> FrostedCobblestone = register("frosted_cobblestone", block(frosted));
    public static final RegistryObject<StairBlock> FrostedCobblestoneStairs = register("frosted_cobblestone_stairs", stair(frosted, () -> FrostedCobblestone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> FrostedCobblestoneSlab = register("frosted_cobblestone_slab", slab(frosted));
    public static final RegistryObject<WallBlock> FrostedCobblestoneWall = register("frosted_cobblestone_wall", wall(frosted));

    public static final RegistryObject<Block> DeepFrostedStone = register("deep_frosted_stone", block(frosted));
    public static final RegistryObject<StairBlock> DeepFrostedStoneStairs = register("deep_frosted_stone_stairs", stair(frosted, () -> DeepFrostedStone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedStoneSlab = register("deep_frosted_stone_slab", slab(frosted));
    public static final RegistryObject<WallBlock> DeepFrostedStoneWall = register("deep_frosted_stone_wall", wall(frosted));
    public static final RegistryObject<Block> DeepFrostedCobblestone = register("deep_frosted_cobblestone", block(frosted));
    public static final RegistryObject<StairBlock> DeepFrostedCobblestoneStairs = register("deep_frosted_cobblestone_stairs", stair(frosted, ()-> DeepFrostedCobblestone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedCobblestoneSlab = register("deep_frosted_cobblestone_slab", slab(frosted));
    public static final RegistryObject<WallBlock> DeepFrostedCobblestoneWall = register("deep_frosted_cobblestone_wall", wall(frosted));

    private static BlockBehaviour.Properties properties(Block base) {return BlockBehaviour.Properties.copy(base);}

    private static Supplier<Block> block(BlockBehaviour.Properties properties) {return ()-> new Block(properties);}
    private static Supplier<StairBlock> stair(StairBlock.Properties properties, Supplier<BlockState> base) {return ()-> new StairBlock(base, properties);}
    private static Supplier<SlabBlock> slab(SlabBlock.Properties properties) {return ()-> new SlabBlock(properties);}
    private static Supplier<WallBlock> wall(WallBlock.Properties properties) {return ()-> new WallBlock(properties);}
    private static Supplier<Block> block(Block base) {return ()-> new Block(BlockBehaviour.Properties.copy(base));}
    private static Supplier<Block> block(Material material, float hardness, float resistance, SoundType sound, boolean requiresCorrectTool){
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of(material).strength(hardness, resistance).sound(sound);
        if(requiresCorrectTool) {properties.requiresCorrectToolForDrops();}
        return ()-> new Block(properties);
    }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> registered = registerWithoutItem(name, block);
        TWItems.Registry.register(name, () -> new BlockItem(registered.get(), new Item.Properties().tab(TWUtil.TheWitcherTab)));
        return registered;
    }
    private static <T extends Block>RegistryObject<T> registerWithoutItem(String name, Supplier<T> block){
        return Registry.register(name, block);
    }

    public static List<Block> getAllBlocks(){
        return Registry.getEntries().stream().map(RegistryObject::get).toList();
    }
}