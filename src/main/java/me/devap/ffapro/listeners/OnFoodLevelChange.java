package me.devap.ffapro.listeners;

import me.devap.ffapro.FFAPro;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class OnFoodLevelChange implements Listener {

    private final FFAPro plugin;

    public OnFoodLevelChange(FFAPro plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e){

        if(e.getEntityType().equals(EntityType.PLAYER)){
            if(plugin.getConfig().getBoolean("disable-hunger")){
                // cancel the event.
                e.setCancelled(true);
            }
        }
    }
}
