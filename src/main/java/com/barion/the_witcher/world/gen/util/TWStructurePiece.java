package com.barion.the_witcher.world.gen.util;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

import static com.barion.the_witcher.util.TWUtil.location;

public class TWStructurePiece {
    public final ResourceLocation Resource;
    public final BlockPos Offset;
    public final int Weight;
    public TWStructurePiece(ResourceLocation resource, BlockPos offset, int weight){
        Resource = resource;
        Offset = offset;
        Weight = weight;
    }

    public static class Builder{
        private final List<TWStructurePiece> pieces;
        private BlockPos offset;
        private int weight;

        public Builder(){
            this.offset = BlockPos.ZERO;
            this.weight = 1;
            pieces = new ArrayList<>();
        }

        public Builder weight(int weight){
            this.weight = weight;
            return this;
        }
        public Builder offset(BlockPos offset){
            this.offset = offset;
            return this;
        }

        public Builder offset(int x, int y, int z) {return offset(new BlockPos(x, y, z));}

        public Builder add(String rescource) {return add(location(rescource));}
        public Builder add(ResourceLocation rescource){
            pieces.add(new TWStructurePiece(rescource, offset, weight));
            return this;
        }

        public TWStructurePiece[] build() {return pieces.toArray(new TWStructurePiece[0]);}
    }
}