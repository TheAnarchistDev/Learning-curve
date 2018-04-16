package me.TheAnarchistDev.Test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PlayerListener implements Listener {

	main plugin = main.getPlugin(main.class);

	public PlayerListener(main Plugin) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		Player p = (Player) sender;
		if (p.getHealth() != 20) {
			if (cmd.getName().equalsIgnoreCase("heal")) {
				double healed = 20 - p.getHealth();
				p.setHealth(p.getHealth() + healed);
				p.sendMessage(ChatColor.GREEN + "You have been healed for, " + ChatColor.RED + healed + ChatColor.GREEN
						+ " Hearts");
				return true;
			}
		} else {
			p.sendMessage(ChatColor.RED + "You are at max health!");
		}
		if (p.getFoodLevel() != 20) {
			if (cmd.getName().equalsIgnoreCase("feed")) {
				double feed = 20 - p.getFoodLevel();
				p.setFoodLevel((int) (p.getFoodLevel() + feed));
				p.sendMessage(
						ChatColor.GREEN + "You have been fed for, " + ChatColor.RED + feed + ChatColor.GREEN + "Food");
				return true;
			}
		}
		if (p.getSaturation() != 20) {
			if (cmd.getName().equalsIgnoreCase("feast")) {
				double feasting = 20 - p.getSaturation();
				p.setFoodLevel(20);
				p.setSaturation((float) (p.getSaturation() + feasting));
				p.sendMessage(ChatColor.GREEN + "You have feasted and are completely full!");
				return true;
			}
		}
		return false;
	}
}
