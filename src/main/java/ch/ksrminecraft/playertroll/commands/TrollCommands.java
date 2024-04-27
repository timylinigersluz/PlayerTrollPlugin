package ch.ksrminecraft.playertroll.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class TrollCommands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        // Sicherung: Überprüfen, ob genau zwei Argumente übergeben werden (Spielername & Trollgrund)
        if (strings.length != 2) {
            commandSender.sendMessage(Component.text(ChatColor.RED + "Bitte nutze den Command so: /troll <Spielername> <Trollgrund>"));
            return true;
        }

        // Sicherung: Überprüfen, ob der gennante Spieler online ist
        Player targetPlayer = Bukkit.getPlayer(strings[0]);

        if (targetPlayer == null) {
            commandSender.sendMessage(Component.text(ChatColor.RED + "Der angegebene Spieler ist nicht online!"));
            return true;
        }

        // Trollgrund extrahieren und Logik für die verschiedenen Gründe implementieren (switch - case)
        String trollGrund = strings[1].toLowerCase();

        switch (trollGrund) {
            case "tnt":
                Location location = targetPlayer.getLocation();
                TNTPrimed tnt = targetPlayer.getWorld().spawn(location, TNTPrimed.class);
                tnt.setFuseTicks(0);
                break;
            case "blitz":
                targetPlayer.getWorld().strikeLightning(targetPlayer.getLocation());
                break;
            case "zombie":
                for (int i = 0; i < 5; i++) {
                    targetPlayer.getWorld().spawnEntity(targetPlayer.getLocation(), EntityType.ZOMBIE);
                }
                break;
            case "poison":
                targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 10, 1));
                break;
            default:
                commandSender.sendMessage(Component.text(ChatColor.RED + "Ungültiger Trollgrund: Nutze tnt, blitz, poison oder zombie"));
        }

        return true;
    }
}
