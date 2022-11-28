package me.devap.ffapro.listeners;

import me.devap.ffapro.FFAPro;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OnBlockBreak implements Listener {

    private final FFAPro plugin;

    public OnBlockBreak(FFAPro plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        if(plugin.getConfig().getBoolean("disable-block-breaking")){
            // If the player is not op, cancel the event.
            if(!p.isOp()){
                e.setCancelled(true);
            }
        }
    }
}
