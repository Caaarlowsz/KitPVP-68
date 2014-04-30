package me.stopbox123.pvp;

import me.stopbox123.commands.KitPvpCommands;
import me.stopbox123.events.Events;
import me.stopbox123.inventory.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPvp extends JavaPlugin {

	public void onEnable() {
		Inventory.Init();
		Bukkit.getPluginManager().registerEvents(new Events(this), this);
		getCommand("kitpvp").setExecutor(new KitPvpCommands(this));
	}
	
}
