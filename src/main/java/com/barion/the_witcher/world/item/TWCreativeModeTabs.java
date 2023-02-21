package com.barion.the_witcher.world.item;

import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.CreativeModeTabEvent;

public class TWCreativeModeTabs {
    public static CreativeModeTab WITCHER_TAB;

    public static void registerWitcherTab(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() != WITCHER_TAB) return;

        event.accept(()-> TWBlocks.RawSilverBlock.get().asItem());
        event.accept(TWItems.RawSilver::get);
        event.accept(()-> TWBlocks.SilverBlock.get().asItem());
        event.accept(TWItems.SilverIngot::get);
        event.accept(TWItems.SilverNugget::get);
        event.accept(TWItems.SilverSword::get);
        event.accept(TWItems.MasterfulSilverSword::get);

        event.accept(TWItems.SteelIngot::get);
        event.accept(TWItems.SteelNugget::get);
        event.accept(TWItems.SteelSword::get);
        event.accept(TWItems.MasterfulSteelSword::get);
        event.accept(TWItems.ReinforcedLeatherHelmet::get);
        event.accept(TWItems.ReinforcedLeatherChestplate::get);
        event.accept(TWItems.ReinforcedLeatherLeggings::get);
        event.accept(TWItems.ReinforcedLeatherBoots::get);
        event.accept(()-> TWBlocks.MasterSmithingTable.get().asItem());

        event.accept(()-> TWBlocks.PowerBlock.get().asItem());

        event.accept(()-> TWBlocks.FrostedCobblestone.get().asItem());
        event.accept(()-> TWBlocks.FrostedCobblestoneStairs.get().asItem());
        event.accept(()-> TWBlocks.FrostedCobblestoneSlab.get().asItem());
        event.accept(()-> TWBlocks.FrostedCobblestoneWall.get().asItem());
        event.accept(()-> TWBlocks.FrostedCobblestoneButton.get().asItem());
        event.accept(()-> TWBlocks.FrostedStone.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneStairs.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneSlab.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneWall.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneButton.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneBricks.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneBrickStairs.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneBrickSlab.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneBrickWall.get().asItem());
        event.accept(()-> TWBlocks.FrostedStoneBrickButton.get().asItem());
        event.accept(()-> TWBlocks.CrackedFrostedStoneBricks.get().asItem());
        event.accept(()-> TWBlocks.CrackedFrostedStoneBrickStairs.get().asItem());
        event.accept(()-> TWBlocks.CrackedFrostedStoneBrickSlab.get().asItem());
        event.accept(()-> TWBlocks.CrackedFrostedStoneBrickWall.get().asItem());
        event.accept(()-> TWBlocks.CrackedFrostedStoneBrickButton.get().asItem());

        event.accept(()-> TWBlocks.DeepFrostedCobblestone.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedCobblestoneStairs.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedCobblestoneSlab.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedCobblestoneWall.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedCobblestoneButton.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStone.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneStairs.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneSlab.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneWall.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneButton.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneBricks.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneBrickStairs.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneBrickSlab.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneBrickWall.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneBrickButton.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneBricks.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneBrickStairs.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneBrickSlab.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneBrickWall.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneBrickButton.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneTiles.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneTileStairs.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneTileSlab.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneTileWall.get().asItem());
        event.accept(()-> TWBlocks.DeepFrostedStoneTileButton.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneTiles.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneTileStairs.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneTileSlab.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneTileWall.get().asItem());
        event.accept(()-> TWBlocks.CrackedDeepFrostedStoneTileButton.get().asItem());
        event.accept(()-> TWBlocks.Icicle.get().asItem());
        event.accept(()-> TWBlocks.Larimar.get().asItem());

        event.accept(TWItems.Celandine::get);
        event.accept(TWItems.WhiteMyrtle::get);
        event.accept(TWItems.KikimoraTooth::get);
        event.accept(TWItems.HotWaterBottle::get);

        event.accept(TWItems.IceStuff::get);
        event.accept(TWItems.WildHuntKnightSpawnEgg::get);
        event.accept(TWItems.WildHuntHoundSpawnEgg::get);
        event.accept(TWItems.IceGhostSpawnEgg::get);

        event.accept(TWBlocks.HallucinatedStone.get().asItem());
        event.accept(TWBlocks.HallucinatedStoneStairs.get().asItem());
        event.accept(TWBlocks.HallucinatedStoneSlab.get().asItem());
        event.accept(TWBlocks.HallucinatedStoneWall.get().asItem());
        event.accept(TWBlocks.HallucinatedStoneButton.get().asItem());
        event.accept(TWBlocks.Alcite.get().asItem());
    }
}
