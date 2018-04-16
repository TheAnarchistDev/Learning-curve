package me.TheAnarchistDev.Tutorial2;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial2 extends JavaPlugin {
	// private

	@Override
	public void onEnable() {
		// getCommand(commands.cmd1).setExecutor(commands);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Tutorial2 has been enabled!");
		CommandExecutor commandExecutor=new Commands();
		
		new PlayerListener(this);

		new Commands(this);

		this.getConfig().options().copyDefaults(true);

		saveConfig();

	}

	@Override
	public void onDisable() {

		getServer().getConsoleSender().sendMessage(ChatColor.RED + "Tutorial2 has been disabled!");

		saveConfig();

	}

	public boolean getBoolean(String EggAnnouncer) {
		return false;
	}

}
