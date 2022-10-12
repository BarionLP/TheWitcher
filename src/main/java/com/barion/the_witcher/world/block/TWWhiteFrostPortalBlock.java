package com.barion.the_witcher.world.block;

import com.ametrinstudios.ametrin.world.block.PortalBlock;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWPOIs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWWhiteFrostPortalBlock extends PortalBlock {

    public TWWhiteFrostPortalBlock() {super(11);}

    @Override
    protected PortalBlock registeredBlock() {return TWBlocks.WhiteFrostPortal.get();}
    @Override
    protected TagKey<Block> portalFrameBlocks() {return TWTags.Blocks.WhiteFrostPortalFrame;}
    @Override
    protected SimpleParticleType particle() {return ParticleTypes.SNOWFLAKE;}
    @Override
    protected ResourceKey<Level> targetLevel() {return TheWitcher.WhiteFrost;}
    @Override
    protected PoiType poi() {return TWPOIs.WhiteFrostPortal.get();}
    @Override
    protected Block defaultPortalFrameBlock() {return TWBlocks.WhiteFrostPortalFrame.get();}

    @Override
    @OnlyIn(Dist.CLIENT)
    @ParametersAreNonnullByDefault
    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource rand) {
        if (rand.nextInt(100) == 0) {
            level.playLocalSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5f, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 3; i++) {
            double x = (double)pos.getX() + rand.nextDouble();
            double y = (double)pos.getY() + rand.nextDouble();
            double z = (double)pos.getZ() + rand.nextDouble();

            level.addParticle(this.particle(), x, y, z, 0, -0.05, 0);
        }

    }
}