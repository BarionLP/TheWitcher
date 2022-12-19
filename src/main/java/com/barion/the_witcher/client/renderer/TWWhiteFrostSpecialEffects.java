package com.barion.the_witcher.client.renderer;

import com.barion.the_witcher.util.TWConfig;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class TWWhiteFrostSpecialEffects extends DimensionSpecialEffects {
    public TWWhiteFrostSpecialEffects() {
        super(192, true, SkyType.NORMAL, false, false);
    }

    @Override
    public @NotNull Vec3 getBrightnessDependentFogColor(@NotNull Vec3 fogColor, float brightness) {return fogColor;}

    @Override
    public boolean isFoggyAt(int x, int y) {return TWConfig.CLIENT.AlwaysFoggy.get();}
}
