package com.barion.the_witcher.util.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.TWItems;
import com.barion.the_witcher.world.item.TWCreativeModeTabs;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TWEvents {
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        TWCreativeModeTabs.WITCHER_TAB = event.registerCreativeModeTab(TWUtil.location("the_witcher"),
                builder -> builder.icon(()-> TWItems.TabLogo.get().getDefaultInstance())
                        .title(Component.translatable("itemGroup.the_witcher")));
    }

    @SubscribeEvent
    public static void fillCreativeTabs(CreativeModeTabEvent.BuildContents event){
        TWCreativeModeTabs.registerWitcherTab(event);
    }
}