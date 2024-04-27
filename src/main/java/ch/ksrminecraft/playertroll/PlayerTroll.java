package ch.ksrminecraft.playertroll;

import ch.ksrminecraft.playertroll.commands.TrollCommands;
import ch.ksrminecraft.playertroll.utils.TrollTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerTroll extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("troll").setExecutor(new TrollCommands());
        getCommand("troll").setTabCompleter(new TrollTabCompleter());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
