package com.barion.the_witcher.world.gen.feature.util;

// Tool to determine if a surface is suitable for structure generation
// created by BarionLP https://github.com/BarionLP/DungeonsEnhanced/blob/1.18.2/src/main/java/com/barion/dungeons_enhanced/world/gen/DETerrainAnalyzer.java
// version 1.0

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;

public class DETerrainAnalyzer {
    public static Settings defaultCheckSettings = new Settings(1, 3, 3);
    protected static ChunkGenerator chunkGenerator;
    protected static LevelHeightAccessor heightAccessor;

    public static boolean isPositionSuitable(ChunkPos chunkPos, ChunkGenerator chunkGenerator, GenerationType generationType, LevelHeightAccessor heightAccessor) {return isPositionSuitable(chunkPos, chunkGenerator, generationType, defaultCheckSettings, heightAccessor);}

    public static boolean isPositionSuitable(ChunkPos chunkPos, ChunkGenerator chunkGenerator, GenerationType generationType, Settings settings, LevelHeightAccessor heightAccessor) {
        int x = chunkPos.getMinBlockX();
        int z = chunkPos.getMinBlockZ();
        int y = chunkGenerator.getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, heightAccessor);

        if(generationType == GenerationType.underground) {return y > chunkGenerator.getMinY() + 20;}
        if(generationType == GenerationType.inAir) {return y < (chunkGenerator.getGenDepth() + chunkGenerator.getMinY()) - 80;}

        DETerrainAnalyzer.chunkGenerator = chunkGenerator;
        DETerrainAnalyzer.heightAccessor = heightAccessor;

        if(getBlockAt(x, y-1, z) == Blocks.WATER) {
            //DungeonsEnhanced.LOGGER.info("Canceled at " + new BlockPos(x, y, z) + " because Water");
            return false;
        }

        int columSpreading = settings.columSpreading();

        if(isColumBlocked(new BlockPos(x+columSpreading, y, z), settings)) {
            return false;
        }
        if(isColumBlocked(new BlockPos(x-columSpreading, y, z), settings)) {
            return false;
        }
        if(isColumBlocked(new BlockPos(x, y, z+columSpreading), settings)) {
            return false;
        }
        if(isColumBlocked(new BlockPos(x, y, z-columSpreading), settings)) {
            return false;
        }

        return true;
    }

    protected static boolean isColumBlocked(BlockPos pos, Settings settings){
        int maxRangePerColum = settings.maxRangePerColum();
        int stepSize = settings.stepSize();

        if(!isDownwardsFree(pos, stepSize, maxRangePerColum)){
            return isUpwardsBlocked(pos, stepSize, maxRangePerColum);
        }

        return true;
    }

    protected static boolean isUpwardsBlocked(BlockPos pos, int stepSize, int range){
        for(int i = 1; i <= range; i++){
            if(getBlockAt(pos.getX(), pos.getY() + (i * stepSize), pos.getZ()) != Blocks.AIR) {return true;}
        }

        return false;
    }

    protected static boolean isDownwardsFree(BlockPos pos, int stepSize, int range){
        for(int i = 1; i <= range; i++){
            if(getBlockAt(pos.getX(), pos.getY() - (i * stepSize), pos.getZ()) == Blocks.AIR) {return true;}
        }

        return false;
    }

    protected static Block getBlockAt(int x, int y, int z) {return chunkGenerator.getBaseColumn(x, z, heightAccessor).getBlock(y).getBlock();}

    public record Settings(int maxRangePerColum, int stepSize, int columSpreading) {}

    public enum GenerationType {onGround, inAir, underground}
}