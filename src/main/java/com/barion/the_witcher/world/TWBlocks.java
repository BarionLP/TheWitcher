package com.barion.the_witcher.world;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class TWBlocks {
    public static final DeferredRegister<Block> Registry = DeferredRegister.create(ForgeRegistries.BLOCKS, TheWitcher.ModID);

    protected static final BlockBehaviour.Properties frosted = properties(Blocks.STONE).friction(Blocks.ICE.getFriction());
    protected static final BlockBehaviour.Properties deepFrosted = properties(Blocks.DEEPSLATE).friction(Blocks.PACKED_ICE.getFriction());

    public static final RegistryObject<Block> SilverBlock = register("silver_block", block(Blocks.IRON_BLOCK));
    public static final RegistryObject<Block> RawSilverBlock = register("raw_silver_block", block(Blocks.RAW_IRON_BLOCK));

    public static final RegistryObject<Block> FrostedCobblestone = register("frosted_cobblestone", block(frosted));
    public static final RegistryObject<StairBlock> FrostedCobblestoneStairs = register("frosted_cobblestone_stairs", stair(frosted, () -> FrostedCobblestone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> FrostedCobblestoneSlab = register("frosted_cobblestone_slab", slab(frosted));
    public static final RegistryObject<WallBlock> FrostedCobblestoneWall = register("frosted_cobblestone_wall", wall(frosted));
    public static final RegistryObject<Block> FrostedStone = register("frosted_stone", block(frosted));
    public static final RegistryObject<StairBlock> FrostedStoneStairs = register("frosted_stone_stairs", stair(frosted, () -> FrostedStone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> FrostedStoneSlab = register("frosted_stone_slab", slab(frosted));
    public static final RegistryObject<WallBlock> FrostedStoneWall = register("frosted_stone_wall", wall(frosted));
    public static final RegistryObject<Block> FrostedStoneBricks = register("frosted_stone_bricks", block(frosted));
    public static final RegistryObject<StairBlock> FrostedStoneBrickStairs = register("frosted_stone_brick_stairs", stair(frosted, () -> FrostedStoneBricks.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> FrostedStoneBrickSlab = register("frosted_stone_brick_slab", slab(frosted));
    public static final RegistryObject<WallBlock> FrostedStoneBrickWall = register("frosted_stone_brick_wall", wall(frosted));

    public static final RegistryObject<Block> DeepFrostedCobblestone = register("deep_frosted_cobblestone", block(deepFrosted));
    public static final RegistryObject<StairBlock> DeepFrostedCobblestoneStairs = register("deep_frosted_cobblestone_stairs", stair(deepFrosted, ()-> DeepFrostedCobblestone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedCobblestoneSlab = register("deep_frosted_cobblestone_slab", slab(deepFrosted));
    public static final RegistryObject<WallBlock> DeepFrostedCobblestoneWall = register("deep_frosted_cobblestone_wall", wall(deepFrosted));
    public static final RegistryObject<Block> DeepFrostedStone = register("deep_frosted_stone", block(deepFrosted));
    public static final RegistryObject<StairBlock> DeepFrostedStoneStairs = register("deep_frosted_stone_stairs", stair(deepFrosted, () -> DeepFrostedStone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedStoneSlab = register("deep_frosted_stone_slab", slab(deepFrosted));
    public static final RegistryObject<WallBlock> DeepFrostedStoneWall = register("deep_frosted_stone_wall", wall(deepFrosted));
    public static final RegistryObject<Block> DeepFrostedStoneBricks = register("deep_frosted_stone_bricks", block(deepFrosted));
    public static final RegistryObject<StairBlock> DeepFrostedStoneBrickStairs = register("deep_frosted_stone_brick_stairs", stair(deepFrosted, () -> DeepFrostedStoneBricks.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedStoneBrickSlab = register("deep_frosted_stone_brick_slab", slab(deepFrosted));
    public static final RegistryObject<WallBlock> DeepFrostedStoneBrickWall = register("deep_frosted_stone_brick_wall", wall(deepFrosted));
    public static final RegistryObject<Block> DeepFrostedStoneTiles = register("deep_frosted_stone_tiles", block(deepFrosted));
    public static final RegistryObject<StairBlock> DeepFrostedStoneTileStairs = register("deep_frosted_stone_tile_stairs", stair(deepFrosted, () -> DeepFrostedStoneTiles.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedStoneTileSlab = register("deep_frosted_stone_tile_slab", slab(deepFrosted));
    public static final RegistryObject<WallBlock> DeepFrostedStoneTileWall = register("deep_frosted_stone_tile_wall", wall(deepFrosted));

    private static BlockBehaviour.Properties properties(Block base) {return BlockBehaviour.Properties.copy(base);}

    private static Supplier<Block> block(BlockBehaviour.Properties properties) {return ()-> new Block(properties);}
    private static Supplier<StairBlock> stair(StairBlock.Properties properties, Supplier<BlockState> base) {return ()-> new StairBlock(base, properties);}
    private static Supplier<SlabBlock> slab(SlabBlock.Properties properties) {return ()-> new SlabBlock(properties);}
    private static Supplier<WallBlock> wall(WallBlock.Properties properties) {return ()-> new WallBlock(properties);}
    private static Supplier<Block> block(Block base) {return ()-> new Block(BlockBehaviour.Properties.copy(base));}

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> registered = registerWithoutItem(name, block);
        TWItems.Registry.register(name, () -> new BlockItem(registered.get(), TWItems.DefaultProperies));
        return registered;
    }

    private static <T extends Block>RegistryObject<T> registerWithoutItem(String name, Supplier<T> block) {return Registry.register(name, block);}
    public static List<Block> getAllBlocks() {return Registry.getEntries().stream().map(RegistryObject::get).toList();}
}