package com.barion.the_witcher.world.block.entity;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> Registry = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TheWitcher.ModID);

    public static final RegistryObject<BlockEntityType<TWMasterSmithingTableBlockEntity>> MasterSmithingTableBlockEntity =   Registry.register("master_smithing_table_block_entity",
            ()-> BlockEntityType.Builder.of(TWMasterSmithingTableBlockEntity::new,TWBlocks.MasterSmithingTable.get()).build(null));
}