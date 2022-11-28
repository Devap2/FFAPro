package me.devap.ffapro.listeners;

import me.devap.ffapro.FFAPro;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class OnExplosion implements Listener {

    private final FFAPro plugin;

    public OnExplosion(FFAPro plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTNTExplosion(BlockExplodeEvent e){
        if(e.getBlock().equals(Material.TNT)){
            if(plugin.getConfig().getBoolean("disable-tnt-explosion")){
                e.setCancelled(true);
            }
        }
    }
}
