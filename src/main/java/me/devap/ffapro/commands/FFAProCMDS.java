package me.devap.ffapro.commands;

import me.devap.ffapro.FFAPro;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class FFAProCMDS implements CommandExecutor {

    private final FFAPro plugin;

    public FFAProCMDS(FFAPro plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(sender != null){
            if(command.getName().equalsIgnoreCase("fp")){
                if (args.length == 0) {

                    // Sending the player the server information message.
                    p.sendMessage("");
                    p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");
                    p.sendMessage(org.bukkit.ChatColor.RED +  "FFA-Pro Plugin Help:");
                    p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");
                    p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp help " + org.bukkit.ChatColor.GRAY + "To show this page");
                    p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp info " + org.bukkit.ChatColor.GRAY + "To show the plugin information");
                    p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp updates " + org.bukkit.ChatColor.GRAY + "To show the plugin update information");
                    p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp version " + org.bukkit.ChatColor.GRAY + "To show the plugin information");
                    p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp reload " + org.bukkit.ChatColor.GRAY + "To reload the FFAPro plugin");
                    p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp setlobby " + org.bukkit.ChatColor.GRAY + "To set the ffa lobby location");
                    p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp kits " + org.bukkit.ChatColor.GRAY + "To show the current available kits.");
                    p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");

                }
                else{
                    if(args[0].equalsIgnoreCase("setlobby")){

                        Location location = p.getLocation();

                        p.sendMessage(ChatColor.GREEN + "Successfully set the free for all lobby location.");

                        // Getting the configuration file and setting the location values.
                        plugin.getConfig().set("ffa-lobby-location.World-name", Objects.requireNonNull(location.getWorld()).getName());
                        plugin.getConfig().set("ffa-lobby-location.X", location.getX());
                        plugin.getConfig().set("ffa-lobby-location.Y", location.getY());
                        plugin.getConfig().set("ffa-lobby-location.Z", location.getZ());
                        plugin.getConfig().set("ffa-lobby-location.Yaw", location.getYaw());
                        plugin.getConfig().set("ffa-lobby-location.Pitch", location.getPitch());

                        // Saving the changes made in the configuration file.
                        plugin.getConfig().options().copyDefaults(true);
                        plugin.saveConfig();
                    }
                    else if(args[0].equalsIgnoreCase("join")){

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("ffa-join-message"))));

                        /* Getting the correct lobby location for the player to spawn to on join. */

                        // Getting the lobby location from the configuration file and teleporting the player to that location.
                        double lobbyLocX = (double) plugin.getConfig().getDouble("ffa-lobby-location.X");
                        double lobbyLocY = (double) plugin.getConfig().getDouble("ffa-lobby-location.Y");
                        double lobbyLocZ = (double) plugin.getConfig().getDouble("ffa-lobby-location.Z");

                        // Creating the lobby location.
                        Location ffaLobbyLocation = new Location(p.getWorld(), lobbyLocX, lobbyLocY, lobbyLocZ);

                        // Sending the player to lobby location if true in config.
                        p.teleport(ffaLobbyLocation);

                        /* Giving the player the items */


                    }
                    else if(args[0].equalsIgnoreCase("kits")){

                        // Sending the player the server information message.
                        p.sendMessage("");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");
                        p.sendMessage(org.bukkit.ChatColor.RED +  "FFA-Pro Plugin Kits:");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp kit beast " + org.bukkit.ChatColor.GRAY + "You are a killing beast.");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp kit speed " + org.bukkit.ChatColor.GRAY + "You are a speedy boy.");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp kit axe " + org.bukkit.ChatColor.GRAY + "You wanna do as much damage as you can.");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");

                    }
                    else if(args[0].equalsIgnoreCase("info")){

                        // Sending the player the server information message.
                        p.sendMessage("");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "---------------------------");
                        p.sendMessage(org.bukkit.ChatColor.RED +  "FFA-Pro Plugin Information:");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "---------------------------");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Author: " + org.bukkit.ChatColor.GRAY + "Devap");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Developer: " + org.bukkit.ChatColor.GRAY + "Devap");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Version: " + org.bukkit.ChatColor.GRAY + "v1.0.0");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Release: " + org.bukkit.ChatColor.GRAY + "11-24-2022");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Downloads: " + org.bukkit.ChatColor.GRAY + "See spigot page.");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Language: " + org.bukkit.ChatColor.GRAY + "English.");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "---------------------------");

                    }
                    else if(args[0].equalsIgnoreCase("help")){

                        // Sending the player the server information message.
                        p.sendMessage("");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");
                        p.sendMessage(org.bukkit.ChatColor.RED +  "FFA-Pro Plugin Help:");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp help " + org.bukkit.ChatColor.GRAY + "To show this page");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp info " + org.bukkit.ChatColor.GRAY + "To show the plugin information");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp updates " + org.bukkit.ChatColor.GRAY + "To show the plugin update information");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp version " + org.bukkit.ChatColor.GRAY + "To show the plugin information");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp reload " + org.bukkit.ChatColor.GRAY + "To reload the FFAPro plugin");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp setlobby " + org.bukkit.ChatColor.GRAY + "To set the lobby location");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "/fp gui " + org.bukkit.ChatColor.GRAY + "To open the game selector gui");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "--------------------");

                    }
                    else if(args[0].equalsIgnoreCase("updates")){

                        // Sending the player the server update message.
                        p.sendMessage("");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "---------------------------");
                        p.sendMessage(org.bukkit.ChatColor.RED +  "FFA-Pro Update Information:");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "---------------------------");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Added: " + org.bukkit.ChatColor.GRAY + "New FFA Plugin");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Added: " + org.bukkit.ChatColor.GRAY + "New Bklaablalla Plugin");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Added: " + org.bukkit.ChatColor.GRAY + "New Features In Hub");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "---------------------------");

                    }
                    else if(args[0].equalsIgnoreCase("version")){

                        // Sending the player the plugin version message.
                        p.sendMessage("");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "-----------------------");
                        p.sendMessage(org.bukkit.ChatColor.RED +  "FFA-Pro Plugin Version:");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "-----------------------");
                        p.sendMessage(org.bukkit.ChatColor.GOLD + "Current Plugin Version " + org.bukkit.ChatColor.GRAY + "v1.0.0");
                        p.sendMessage(org.bukkit.ChatColor.GRAY + "-----------------------");

                    }
                    else if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("rl")) {

                        p.sendMessage(ChatColor.GRAY + "Reloading the plugin configuration file.");
                        plugin.reloadConfig();
                        plugin.saveDefaultConfig();
                        p.sendMessage(ChatColor.GREEN + "Reload complete.");

                    }
                }
            }
        }

        return false;
    }
}
