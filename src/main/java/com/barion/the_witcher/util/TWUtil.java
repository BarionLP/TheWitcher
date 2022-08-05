package com.barion.the_witcher.util;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.gen.util.TWStructurePiece;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.Objects;

public class TWUtil {
    public static final Logger Logger = LogUtils.getLogger();

    public static boolean shouldAppendS(String name) {return ((name.contains("brick") && !name.contains("bricks")) || (name.contains("tile") && !name.contains("tiles")));}
    public static boolean isWood(String name) {return (name.contains("wood") || name.contains("hyphae"));}
    public static boolean isLog(String name) {return (name.contains("log") || name.contains("stem"));}
    public static boolean isWooden(String name) {return isLog(name) || isWood(name) || name.contains("plank");}
    public static TWStructurePiece.Builder pieceBuilder() {return new TWStructurePiece.Builder();}

    public static TWStructurePiece getRandomPiece(TWStructurePiece[] variants, int maxWeight, RandomSource rand){
        int piece = 0;
        if(variants.length > 1) {
            int i = rand.nextInt(maxWeight+1);
            for (int j = 0; j < variants.length; j++) {
                if (variants[j].Weight >= i) {
                    piece = j;
                    break;
                } else {
                    i -= variants[j].Weight;
                }
            }
        }
        return variants[piece];
    }

    public static int getMaxWeight(TWStructurePiece[] variants){
        int i = 0;
        for (TWStructurePiece piece : variants){
            i += piece.Weight;
        }
        return i;
    }

    public static String getItemName(Item item) {return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();}
    public static String getBlockName(Block block) {return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();}

    public static ResourceLocation location(String key) {return new ResourceLocation(TheWitcher.ModID, key);}
}