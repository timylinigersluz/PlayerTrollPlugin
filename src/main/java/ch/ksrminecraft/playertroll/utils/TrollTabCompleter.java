package ch.ksrminecraft.playertroll.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrollTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        // Überprüfen, ob der erste Teil des Befehls (also der Spielername) eingegeben wird.
        if (strings.length == 1) {
            List<String> playerNames = new ArrayList<>();

            // Array mit allen Online-Spielern erstellen
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            // Spielerliste erstellen und zurückgeben
            for (Player player : players) {
                playerNames.add(player.getName());
            }

            return playerNames;
        } else if (strings.length == 2) {
            List<String> arguments = new ArrayList<>(Arrays.asList("tnt", "blitz", "zombie", "poison"));

            return arguments;
        }

        return null;
    }
}
