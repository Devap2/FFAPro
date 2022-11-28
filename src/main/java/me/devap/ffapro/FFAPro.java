package me.devap.ffapro;

import com.google.common.io.ByteStreams;
import me.devap.ffapro.commands.FFAProCMDS;
import me.devap.ffapro.commands.KitCMDS;
import me.devap.ffapro.listeners.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public final class FFAPro extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Registering the listeners.
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new OnBlockBreak(this), this);
        getServer().getPluginManager().registerEvents(new OnBlockPlace(this), this);
        getServer().getPluginManager().registerEvents(new OnFoodLevelChange(this), this);
        getServer().getPluginManager().registerEvents(new OnSwapHandItems(this), this);
        getServer().getPluginManager().registerEvents(new OnItemDrop(), this);
        getServer().getPluginManager().registerEvents(new OnWeatherChange(this), this);
        getServer().getPluginManager().registerEvents(new OnExplosion(this), this);

        // Registering the commands.
        Objects.requireNonNull(getCommand("kit")).setExecutor(new KitCMDS(this));
        Objects.requireNonNull(getCommand("fp")).setExecutor(new FFAProCMDS(this));
        Objects.requireNonNull(getCommand("fp")).setTabCompleter(this);

        // Config
        // Load the configuration.
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("FFAPro plugin shutting down...");

        this.saveDefaultConfig();

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        // Creating the list of strings
        List<String> list = Arrays.asList("help", "setlobby", "updates", "reload", "kits", "info", "version", "join", "kit");
        String input = args[0].toLowerCase();

        List<String> completions = null;
        for(String s : list){
            if(s.startsWith(input)){

                if(completions == null){
                    completions = new ArrayList<>();
                }

                completions.add(s);

            }
        }

        if(completions != null)
            Collections.sort(completions);

        return completions;
    }

    public static File loadResource(Plugin plugin, String resource) {
        File folder = plugin.getDataFolder();
        if (!folder.exists())
            folder.mkdir();
        File resourceFile = new File(folder, resource);
        try {
            if (!resourceFile.exists()) {
                resourceFile.createNewFile();
                try (InputStream in = plugin.getResource(resource);
                     OutputStream out = new FileOutputStream(resourceFile)) {
                    ByteStreams.copy(in, out);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resourceFile;
    }

}
