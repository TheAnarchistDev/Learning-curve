package me.TheAnarchistDev.Test;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Test Has been enabled!");
		new PlayerListener(this);

	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "Test has been disabled!");
	}
	
	
}
