package com.barion.the_witcher.world;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.entity.TWIceGhostEntity;
import com.barion.the_witcher.world.entity.TWWildHuntHoundEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWEntities {
    public static final DeferredRegister<EntityType<?>> Registry = DeferredRegister.create(ForgeRegistries.ENTITIES, TheWitcher.ModID);

    public static final RegistryObject<EntityType<TWIceGhostEntity>> IceGhost = register("ice_ghost", livingEntity(TWIceGhostEntity::new, MobCategory.MONSTER, 1, 2, 8));
    public static final RegistryObject<EntityType<TWWildHuntHoundEntity>> WildHuntHound = register("wild_hunt_hound", livingEntity(TWWildHuntHoundEntity::new, MobCategory.MONSTER, 1.3f, 1.2f, 16));

    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(IceGhost.get(), TWIceGhostEntity.createAttributes().build());
        event.put(WildHuntHound.get(), TWWildHuntHoundEntity.createAttributes().build());
    }

    private static <E extends Entity, EF extends EntityType.EntityFactory<E>> EntityType.Builder<E> boat(EF entity) {
        return entity(entity, MobCategory.MISC,1.375f,0.5625f);
    }
    private static <E extends LivingEntity, EF extends EntityType.EntityFactory<E>> EntityType.Builder<E> livingEntity(EF entity, MobCategory category, float width, float height, int trackingRange){
        return entity(entity, category, width, height).clientTrackingRange(trackingRange);
    }
    private static <E extends Entity, EF extends EntityType.EntityFactory<E>> EntityType.Builder<E> entity(EF entity, MobCategory category, float width, float height){
        return EntityType.Builder.of(entity, category).sized(width, height);
    }
    private static <E extends Entity> RegistryObject<EntityType<E>> register(String id, EntityType.Builder<E> builder) {return Registry.register(id, ()-> builder.build(TWUtil.location(id).toString()));}
}