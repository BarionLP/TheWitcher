package com.barion.the_witcher.command;

import com.barion.the_witcher.capability.TWPlayerEnergyProvider;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;

public class TWSetEnergyCommand {
    private static final String success = "command.the_witcher.energy.set.success";

    public TWSetEnergyCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("the_witcher")
                .then(Commands.literal("energy")
                        .then(Commands.literal("set").requires((sourceStack)-> sourceStack.hasPermission(4))
                                .then(Commands.argument("amount", IntegerArgumentType.integer(0))
                                        .executes((command)-> setEnergy(command.getSource(), IntegerArgumentType.getInteger(command, "amount")))
                                        .then(Commands.argument("targets", EntityArgument.players())
                                                .executes((command)-> setEnergy(command.getSource(), EntityArgument.getPlayers(command, "targets"), IntegerArgumentType.getInteger(command, "level")))
        )))));
    }

    private int setEnergy(CommandSourceStack source, Collection<ServerPlayer> targets, int value) {
        for(ServerPlayer target : targets){
            setEnergyInternal(source, target, value);
        }

        return 1;
    }

    private int setEnergy(CommandSourceStack source, int value) {
        if(source.getPlayer() == null){
            source.sendFailure(TWCommonCommandFeedback.noPlayer);
            return 1;
        }

        setEnergyInternal(source, source.getPlayer(), value);
        return 1;
    }

    private void setEnergyInternal(CommandSourceStack source, ServerPlayer target, int value){
        target.getCapability(TWPlayerEnergyProvider.Instance).ifPresent(energy->{
            energy.set(value, target);
            source.sendSuccess(Component.translatable(success, target.getDisplayName(), value), true);
        });
    }
}