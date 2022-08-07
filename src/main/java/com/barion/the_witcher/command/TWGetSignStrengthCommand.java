package com.barion.the_witcher.command;

import com.barion.the_witcher.capability.TWPlayerSignStrengthProvider;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class TWGetSignStrengthCommand{
    private static final String success = "command.the_witcher.sign_strength.get.success";

    public TWGetSignStrengthCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("the_witcher")
                .then(Commands.literal("sign_strength")
                        .then(Commands.literal("get")
                                .executes((command)-> getSignStrength(command.getSource()))
                                .then(Commands.argument("target", EntityArgument.player())
                                        .executes((command)-> getSignStrength(command.getSource(), EntityArgument.getPlayer(command, "targets")))
        ))));
    }

    private int getSignStrength(CommandSourceStack source, ServerPlayer player) {
        player.getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(signStrength->{
            source.sendSuccess(Component.translatable(success, player.getDisplayName(), signStrength.get()), true);
        });

        return 1;
    }

    private int getSignStrength(CommandSourceStack source) {
        if(source.getPlayer() == null){
            source.sendFailure(TWCommonCommandFeedback.noPlayer);
            return 1;
        }

        return getSignStrength(source, source.getPlayer());
    }
}