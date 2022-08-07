package com.barion.the_witcher.command;

import com.barion.the_witcher.capability.TWPlayerEnergyProvider;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class TWGetEnergyCommand {
    private static final String success = "command.the_witcher.energy.get.success";

    public TWGetEnergyCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("the_witcher")
                .then(Commands.literal("energy")
                        .then(Commands.literal("get")
                                .executes((command)-> getEnergy(command.getSource()))
                                .then(Commands.argument("target", EntityArgument.player())
                                        .executes((command)-> getEnergy(command.getSource(), EntityArgument.getPlayer(command, "target")))
        ))));
    }

    private int getEnergy(CommandSourceStack source, ServerPlayer player) {
        player.getCapability(TWPlayerEnergyProvider.Instance).ifPresent(energy->{
            source.sendSuccess(Component.translatable(success, player.getDisplayName(), energy.get()), true);
        });

        return 1;
    }

    private int getEnergy(CommandSourceStack source) {
        if(source.getPlayer() == null){
            source.sendFailure(TWCommonCommandFeedback.noPlayer);
            return 1;
        }

        return getEnergy(source, source.getPlayer());
    }
}