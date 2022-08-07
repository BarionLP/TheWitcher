package com.barion.the_witcher.command;

import com.barion.the_witcher.capability.TWPlayerSignStrength;
import com.barion.the_witcher.capability.TWPlayerSignStrengthProvider;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;

public class TWSetSignStrengthCommand {
    private static final String success = "command.the_witcher.sign_strength.set.success";

    public TWSetSignStrengthCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("the_witcher")
                .then(Commands.literal("sign_strength")
                        .then(Commands.literal("set").requires((sourceStack)-> sourceStack.hasPermission(4))
                                .then(Commands.argument("level", IntegerArgumentType.integer(TWPlayerSignStrength.minStrength, TWPlayerSignStrength.maxStrength))
                                        .executes((command)-> setSignStrength(command.getSource(), IntegerArgumentType.getInteger(command, "level")))
                                        .then(Commands.argument("targets", EntityArgument.players())
                                                .executes((command)-> setSignStrength(command.getSource(), EntityArgument.getPlayers(command, "targets"), IntegerArgumentType.getInteger(command, "level")))
        )))));
    }

    private int setSignStrength(CommandSourceStack source, Collection<ServerPlayer> targets, int value) {
        for(ServerPlayer target : targets){
            setSignStrengthInternal(source, target, value);
        }

        return 1;
    }

    private int setSignStrength(CommandSourceStack source, int value) {
        if(source.getPlayer() == null){
            source.sendFailure(TWCommonCommandFeedback.noPlayer);
            return 1;
        }

        setSignStrengthInternal(source, source.getPlayer(), value);
        return 1;
    }

    private void setSignStrengthInternal(CommandSourceStack source, ServerPlayer target, int value){
        target.getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(signStrength->{
            signStrength.set(value, target);
            source.sendSuccess(Component.translatable(success, target.getDisplayName(), value), true);
        });
    }
}