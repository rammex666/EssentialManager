package fr.rammex.essentialManager;

import fr.rammex.essentialManager.commands.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EssentialManager extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("essentialmanager").setExecutor(new CommandManager());


        getMessages();

    }

    @Override
    public void onDisable() {

    }


    public void getMessages(){
        getLogger().info("------------------------");
        getLogger().info("EssentialManager is now enabled");
        getLogger().info("Version: 1.0");
        getLogger().info(".rammex");
        getLogger().info("------------------------");
    }
}
