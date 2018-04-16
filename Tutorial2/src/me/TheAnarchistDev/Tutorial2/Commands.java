package me.TheAnarchistDev.Tutorial2;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.joptsimple.internal.Strings;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import net.minecraft.server.v1_12_R1.CommandExecute;

public abstract class Commands implements Listener,CommandExecutor {
	private Plugin plugin = Tutorial2.getPlugin(Tutorial2.class);
	public Commands(Tutorial2 plugin) {

	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean onCommand(CommandSender sender, Command cmd, String string, Strings[] args) {
		Plugin plugin = (Plugin) plugin.getConfig();
		if (cmd.getName().equalsIgnoreCase("EggAnnouncer")) {
			if (args[0].equals("true")||args[0].equals("false")) {
			
		plugin.getConfig().set("EggAnnouncer", args[0]);
	    saveConfig;
	
		}
			else{
				sender.sendMessage(ChatColor.RED + "You may only use true or false");
				}
		return false;
	}
		return false;

	}
}
