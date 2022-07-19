package com.barion.the_witcher.world.block.entity;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TWBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> Registry = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheWitcher.ModID);
}