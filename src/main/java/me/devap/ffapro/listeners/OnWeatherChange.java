package me.devap.ffapro.listeners;

import me.devap.ffapro.FFAPro;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class OnWeatherChange implements Listener {

    private final FFAPro plugin;

    public OnWeatherChange(FFAPro plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){
        if(plugin.getConfig().getBoolean("disable-weather-change")){
            e.setCancelled(true);
        }
    }
}
