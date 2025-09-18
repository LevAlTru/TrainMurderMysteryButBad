package dev.doctor4t.trainmurdermystery.command;

import com.mojang.brigadier.CommandDispatcher;
import dev.doctor4t.trainmurdermystery.game.TMMGameLoop;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.jetbrains.annotations.NotNull;

public class StopGameCommand {
    public static void register(@NotNull CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("tmm:stopGame")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> stopGame(context.getSource())));
    }

    private static int stopGame(@NotNull ServerCommandSource source) {
        TMMGameLoop.stopGame(source.getWorld());
        return 1;
    }
}