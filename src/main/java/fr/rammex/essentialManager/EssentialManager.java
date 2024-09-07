package fr.rammex.essentialManager;

import fr.rammex.essentialManager.commands.CommandManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class EssentialManager extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("essentialmanager").setExecutor(new CommandManager());

        saveDefaultConfig();
        loadFiles();
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

    private void loadFiles() {
        File langsFolder = new File(getDataFolder(), "langs");
        if (!langsFolder.exists()) {
            langsFolder.mkdirs();
        }

        File[] files = langsFolder.listFiles((dir, name) -> name.endsWith(".yml"));
        if (files != null) {
            for (File file : files) {
                loadFile(file);
            }
        }
    }

    private void loadFile(File file) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        try {
            config.load(file);
            getLogger().info("Loaded file: " + file.getName());
        } catch (IOException | InvalidConfigurationException e) {
            getLogger().severe("Could not load file: " + file.getName());
            e.printStackTrace();
        }
    }
}
