package com.barion.the_witcher.world;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.entity.TWIceGhost;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWEntities {
    public static final DeferredRegister<EntityType<?>> Registry = DeferredRegister.create(ForgeRegistries.ENTITIES, TheWitcher.ModID);

    public static final RegistryObject<EntityType<TWIceGhost>> IceGhost = register("ice_ghost", TWIceGhost::new, MobCategory.MONSTER, 1, 2);

    @ParametersAreNonnullByDefault
    private static <E extends Entity>RegistryObject<EntityType<E>> register(String name, EntityType.EntityFactory<E> entity, MobCategory category, float size, float height){
        return Registry.register(name, ()-> EntityType.Builder.of(entity, category).sized(size, height).build(new ResourceLocation(TheWitcher.ModID, name).toString()));
    }
}