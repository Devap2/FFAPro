package me.devap.ffapro.listeners;

import me.devap.ffapro.FFAPro;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class OnPlayerJoin implements Listener {

    private final FFAPro plugin;

    public OnPlayerJoin(FFAPro plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        // Getting the player and player name.
        Player p = e.getPlayer();
        String pname = p.getName();

        if(p.getWorld().getName().equals("world")){

            /* Getting the correct lobby location for the player to spawn to on join. */

            // Getting the lobby location from the configuration file and teleporting the player to that location.
            double lobbyLocX = (double) plugin.getConfig().getDouble("lobby-location.X");
            double lobbyLocY = (double) plugin.getConfig().getDouble("lobby-location.Y");
            double lobbyLocZ = (double) plugin.getConfig().getDouble("lobby-location.Z");

            // Creating the lobby location.
            Location lobbyLocation = new Location(p.getWorld(), lobbyLocX, lobbyLocY, lobbyLocZ);

            // Sending the player to lobby location if true in config.
            p.teleport(lobbyLocation);

            // Clearing player's inventory if true in config.
            if(plugin.getConfig().getBoolean("join-clear-inventory")){
                p.getInventory().clear();
            }
            else{
                return;
            }

            String joinMessage = plugin.getConfig().getString("join-message");
            String defaultJoinMessage = (ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.GRAY + pname + " has joined the server.");

            // Setting the player's custom join message if set in config.
            if(plugin.getConfig().getBoolean("enable-join-message")){
                e.setJoinMessage(ChatColor.GRAY + joinMessage);
            }
            else{
                return;
            }

            // Setting default settings to the player on join.
            p.setGameMode(GameMode.SURVIVAL);
            p.setHealth(20.0);
            p.setFoodLevel(20);
            p.setWalkSpeed(0.2F);
            p.setInvulnerable(false);
            p.setGlowing(false);

        }
    }
}