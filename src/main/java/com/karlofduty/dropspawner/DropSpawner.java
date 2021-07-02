package com.karlofduty.dropspawner;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class DropSpawner extends JavaPlugin
{
    public static FileConfiguration config;
    private static DropSpawner instance;

    @Override
    public void onEnable()
    {
        instance = this;
        File file_storage = new File(plugin.getDataFolder(), "/config.yml");
        //prevent to override the file when the file already exist
        if (!file_storage.exists() && !file_storage.isDirectory()) {saveDefaultConfig();}
        config = this.getConfig();
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public void onDisable()
    {
        // Nothing for now
    }

    public static DropSpawner getInstance() {
        return instance;
    }

    public static ConsoleCommandSender getConsole()
    {
        return instance.getServer().getConsoleSender();
    }

    public static void executeCommand(String command)
    {
        instance.getServer().dispatchCommand(getConsole(), command);
    }

    public static void log(String message)
    {
        instance.getServer().getLogger().info(message);
    }
    public static void logColoured(String message)
    {
        getConsole().sendMessage(message);
    }
    public static void logWarning(String message)
    {
        instance.getServer().getLogger().warning(message);
    }
}
