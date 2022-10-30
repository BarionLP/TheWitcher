package com.barion.the_witcher.world;

import com.ametrinstudios.ametrin.world.BlockRegistry;
import com.ametrinstudios.ametrin.world.block.AgeableBushBlock;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.fluid.TWFluids;
import com.barion.the_witcher.world.block.TWIcicleBlock;
import com.barion.the_witcher.world.block.TWMasterSmithingTableBlock;
import com.barion.the_witcher.world.block.TWPowerBlock;
import com.barion.the_witcher.world.block.TWWhiteFrostPortalBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Iterator;
import java.util.function.Supplier;

public class TWBlocks extends BlockRegistry {
    public static final DeferredRegister<Block> Registry = DeferredRegister.create(ForgeRegistries.BLOCKS, TheWitcher.ModID);

    protected static final BlockBehaviour.Properties frostedProperties = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.ICE).requiresCorrectToolForDrops().strength(1.5f, 6).sound(SoundType.STONE).friction(Blocks.ICE.getFriction());
    protected static final BlockBehaviour.Properties frostedPropertiesNoCollision = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.ICE).requiresCorrectToolForDrops().strength(1.5f, 6).sound(SoundType.STONE).friction(Blocks.ICE.getFriction()).noCollission();
    protected static final BlockBehaviour.Properties cobbledFrostedProperties = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.ICE).requiresCorrectToolForDrops().strength(2, 6).sound(SoundType.STONE).friction(Blocks.ICE.getFriction());
    protected static final BlockBehaviour.Properties deepFrostedProperties = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.ICE).requiresCorrectToolForDrops().strength(3, 6).sound(SoundType.DEEPSLATE).friction(Blocks.PACKED_ICE.getFriction());
    protected static final BlockBehaviour.Properties deepFrostedPropertiesNoCollision = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.ICE).requiresCorrectToolForDrops().strength(3, 6).sound(SoundType.DEEPSLATE).friction(Blocks.PACKED_ICE.getFriction()).noCollission();
    protected static final BlockBehaviour.Properties deepCobbledFrostedProperties = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.ICE).requiresCorrectToolForDrops().strength(3.5f, 6).sound(SoundType.DEEPSLATE).friction(Blocks.PACKED_ICE.getFriction());
    protected static final BlockBehaviour.Properties hallucinatedStoneProperties = properties(Material.STONE).color(MaterialColor.COLOR_BLACK).strength(3, 9).requiresCorrectToolForDrops();
    protected static final BlockBehaviour.Properties hallucinatedStonePropertiesNoCollision = properties(Material.STONE).color(MaterialColor.COLOR_BLACK).strength(3, 9).requiresCorrectToolForDrops();

    public static final RegistryObject<Block> SilverBlock = register("silver_block", block(Blocks.IRON_BLOCK));
    public static final RegistryObject<Block> RawSilverBlock = register("raw_silver_block", block(Blocks.RAW_IRON_BLOCK));
    public static final RegistryObject<TWMasterSmithingTableBlock> MasterSmithingTable = register("master_smithing_table", () -> new TWMasterSmithingTableBlock(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE)));

    public static final RegistryObject<TWPowerBlock> PowerBlock = register("power_block", ()-> new TWPowerBlock(properties(Blocks.GLASS).noLootTable()));

    public static final RegistryObject<Block> FrostedCobblestone = register("frosted_cobblestone", block(cobbledFrostedProperties));
    public static final RegistryObject<StairBlock> FrostedCobblestoneStairs = register("frosted_cobblestone_stairs", stair(cobbledFrostedProperties, () -> FrostedCobblestone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> FrostedCobblestoneSlab = register("frosted_cobblestone_slab", slab(cobbledFrostedProperties));
    public static final RegistryObject<WallBlock> FrostedCobblestoneWall = register("frosted_cobblestone_wall", wall(cobbledFrostedProperties));
    public static final RegistryObject<StoneButtonBlock> FrostedCobblestoneButton = register("frosted_cobblestone_button", () -> new StoneButtonBlock(frostedPropertiesNoCollision));
    public static final RegistryObject<Block> FrostedStone = register("frosted_stone", block(frostedProperties));
    public static final RegistryObject<StairBlock> FrostedStoneStairs = register("frosted_stone_stairs", stair(frostedProperties, () -> FrostedStone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> FrostedStoneSlab = register("frosted_stone_slab", slab(frostedProperties));
    public static final RegistryObject<WallBlock> FrostedStoneWall = register("frosted_stone_wall", wall(frostedProperties));
    public static final RegistryObject<StoneButtonBlock> FrostedStoneButton = register("frosted_stone_button", () -> new StoneButtonBlock(frostedPropertiesNoCollision));
    public static final RegistryObject<Block> FrostedStoneBricks = register("frosted_stone_bricks", block(frostedProperties));
    public static final RegistryObject<StairBlock> FrostedStoneBrickStairs = register("frosted_stone_brick_stairs", stair(frostedProperties, () -> FrostedStoneBricks.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> FrostedStoneBrickSlab = register("frosted_stone_brick_slab", slab(frostedProperties));
    public static final RegistryObject<WallBlock> FrostedStoneBrickWall = register("frosted_stone_brick_wall", wall(frostedProperties));
    public static final RegistryObject<StoneButtonBlock> FrostedStoneBrickButton = register("frosted_stone_brick_button", () -> new StoneButtonBlock(frostedPropertiesNoCollision));
    public static final RegistryObject<Block> CrackedFrostedStoneBricks = register("cracked_frosted_stone_bricks", block(frostedProperties));
    public static final RegistryObject<StairBlock> CrackedFrostedStoneBrickStairs = register("cracked_frosted_stone_brick_stairs", stair(frostedProperties, () -> CrackedFrostedStoneBricks.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> CrackedFrostedStoneBrickSlab = register("cracked_frosted_stone_brick_slab", slab(frostedProperties));
    public static final RegistryObject<WallBlock> CrackedFrostedStoneBrickWall = register("cracked_frosted_stone_brick_wall", wall(frostedProperties));
    public static final RegistryObject<StoneButtonBlock> CrackedFrostedStoneBrickButton = register("cracked_frosted_stone_brick_button", () -> new StoneButtonBlock(frostedPropertiesNoCollision));

    public static final RegistryObject<Block> DeepFrostedCobblestone = register("deep_frosted_cobblestone", block(deepCobbledFrostedProperties));
    public static final RegistryObject<StairBlock> DeepFrostedCobblestoneStairs = register("deep_frosted_cobblestone_stairs", stair(deepCobbledFrostedProperties, ()-> DeepFrostedCobblestone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedCobblestoneSlab = register("deep_frosted_cobblestone_slab", slab(deepCobbledFrostedProperties));
    public static final RegistryObject<WallBlock> DeepFrostedCobblestoneWall = register("deep_frosted_cobblestone_wall", wall(deepCobbledFrostedProperties));
    public static final RegistryObject<StoneButtonBlock> DeepFrostedCobblestoneButton = register("deep_frosted_cobblestone_button", () -> new StoneButtonBlock(deepFrostedPropertiesNoCollision));
    public static final RegistryObject<Block> DeepFrostedStone = register("deep_frosted_stone", block(deepFrostedProperties));
    public static final RegistryObject<StairBlock> DeepFrostedStoneStairs = register("deep_frosted_stone_stairs", stair(deepFrostedProperties, () -> DeepFrostedStone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedStoneSlab = register("deep_frosted_stone_slab", slab(deepFrostedProperties));
    public static final RegistryObject<WallBlock> DeepFrostedStoneWall = register("deep_frosted_stone_wall", wall(deepFrostedProperties));
    public static final RegistryObject<StoneButtonBlock> DeepFrostedStoneButton = register("deep_frosted_stone_button", () -> new StoneButtonBlock(deepFrostedPropertiesNoCollision));
    public static final RegistryObject<Block> DeepFrostedStoneBricks = register("deep_frosted_stone_bricks", block(deepFrostedProperties));
    public static final RegistryObject<StairBlock> DeepFrostedStoneBrickStairs = register("deep_frosted_stone_brick_stairs", stair(deepFrostedProperties, () -> DeepFrostedStoneBricks.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedStoneBrickSlab = register("deep_frosted_stone_brick_slab", slab(deepFrostedProperties));
    public static final RegistryObject<WallBlock> DeepFrostedStoneBrickWall = register("deep_frosted_stone_brick_wall", wall(deepFrostedProperties));
    public static final RegistryObject<StoneButtonBlock> DeepFrostedStoneBrickButton = register("deep_frosted_stone_brick_button", () -> new StoneButtonBlock(deepFrostedPropertiesNoCollision));
    public static final RegistryObject<Block> CrackedDeepFrostedStoneBricks = register("cracked_deep_frosted_stone_bricks", block(deepFrostedProperties));
    public static final RegistryObject<StairBlock> CrackedDeepFrostedStoneBrickStairs = register("cracked_deep_frosted_stone_brick_stairs", stair(deepFrostedProperties, () -> CrackedDeepFrostedStoneBricks.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> CrackedDeepFrostedStoneBrickSlab = register("cracked_deep_frosted_stone_brick_slab", slab(deepFrostedProperties));
    public static final RegistryObject<WallBlock> CrackedDeepFrostedStoneBrickWall = register("cracked_deep_frosted_stone_brick_wall", wall(deepFrostedProperties));
    public static final RegistryObject<StoneButtonBlock> CrackedDeepFrostedStoneBrickButton = register("cracked_deep_frosted_stone_brick_button", () -> new StoneButtonBlock(deepFrostedPropertiesNoCollision));
    public static final RegistryObject<Block> DeepFrostedStoneTiles = register("deep_frosted_stone_tiles", block(deepFrostedProperties));
    public static final RegistryObject<StairBlock> DeepFrostedStoneTileStairs = register("deep_frosted_stone_tile_stairs", stair(deepFrostedProperties, () -> DeepFrostedStoneTiles.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> DeepFrostedStoneTileSlab = register("deep_frosted_stone_tile_slab", slab(deepFrostedProperties));
    public static final RegistryObject<WallBlock> DeepFrostedStoneTileWall = register("deep_frosted_stone_tile_wall", wall(deepFrostedProperties));
    public static final RegistryObject<StoneButtonBlock> DeepFrostedStoneTileButton = register("deep_frosted_stone_tile_button", () -> new StoneButtonBlock(deepFrostedPropertiesNoCollision));
    public static final RegistryObject<Block> CrackedDeepFrostedStoneTiles = register("cracked_deep_frosted_stone_tiles", block(deepFrostedProperties));
    public static final RegistryObject<StairBlock> CrackedDeepFrostedStoneTileStairs = register("cracked_deep_frosted_stone_tile_stairs", stair(deepFrostedProperties, () -> CrackedDeepFrostedStoneTiles.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> CrackedDeepFrostedStoneTileSlab = register("cracked_deep_frosted_stone_tile_slab", slab(deepFrostedProperties));
    public static final RegistryObject<WallBlock> CrackedDeepFrostedStoneTileWall = register("cracked_deep_frosted_stone_tile_wall", wall(deepFrostedProperties));
    public static final RegistryObject<StoneButtonBlock> CrackedDeepFrostedStoneTileButton = register("cracked_deep_frosted_stone_tile_button", () -> new StoneButtonBlock(deepFrostedPropertiesNoCollision));
    public static final RegistryObject<TWIcicleBlock> Icicle = register("icicle", ()-> new TWIcicleBlock(properties(Blocks.POINTED_DRIPSTONE).sound(SoundType.GLASS).offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final RegistryObject<TWWhiteFrostPortalBlock> WhiteFrostPortal = registerWithoutItem("white_frost_portal", TWWhiteFrostPortalBlock::new);
    public static final RegistryObject<Block> WhiteFrostPortalFrame = register("white_frost_portal_frame", block(properties(Blocks.OBSIDIAN).noLootTable()));

    public static final RegistryObject<AgeableBushBlock> WhiteMyrtleBush = registerWithoutItem("white_myrtle_bush", bush(1, 6));
    public static final RegistryObject<AgeableBushBlock> CelandineBush = registerWithoutItem("celandine_bush", bush(0,12));

    public static final RegistryObject<LiquidBlock> Acid = registerWithoutItem("acid", ()-> new LiquidBlock(TWFluids.AcidSource, properties(Blocks.WATER).lightLevel(emission(5)).noLootTable()));
    public static final RegistryObject<Block> HallucinatedStone = register("hallucinated_stone", block(hallucinatedStoneProperties));
    public static final RegistryObject<StairBlock> HallucinatedStoneStairs = register("hallucinated_stone_stairs", stair(hallucinatedStoneProperties, ()-> HallucinatedStone.get().defaultBlockState()));
    public static final RegistryObject<SlabBlock> HallucinatedStoneSlab = register("hallucinated_stone_slab", slab(hallucinatedStoneProperties));
    public static final RegistryObject<WallBlock> HallucinatedStoneWall = register("hallucinated_stone_wall", wall(hallucinatedStoneProperties));
    public static final RegistryObject<StoneButtonBlock> HallucinatedStoneButton = register("hallucinated_stone_button", ()-> new StoneButtonBlock(hallucinatedStonePropertiesNoCollision));
    public static final RegistryObject<Block> Alcite = register("alcite", ()-> new Block(properties(HallucinatedStone.get()).lightLevel(emission(4))));
//
    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> registered = registerWithoutItem(name, block);
        TWItems.Registry.register(name, () -> new BlockItem(registered.get(), TWItems.DefaultProperies));
        return registered;
    }

    private static <T extends Block>RegistryObject<T> registerWithoutItem(String name, Supplier<T> block) {return Registry.register(name, block);}
    public static Iterator<Block> getAllBlocks() {return Registry.getEntries().stream().map(RegistryObject::get).iterator();}
}