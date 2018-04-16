package me.TheAnarchistDev.Tutorial2;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

	Tutorial2 configGetter;

	public PlayerListener(Tutorial2 plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		configGetter = plugin;

	}

	@EventHandler
	public void EggInHand(PlayerItemHeldEvent e) {
		Player p = (e.getPlayer());
		ItemStack item = p.getInventory().getItem(e.getNewSlot());

		if (configGetter.getBoolean("EggAnnouncer.true")) {
			if (!(p.hasPermission("Egg.Throw"))) {
				if (item != null && item.getType() == Material.EGG) {
					p.sendMessage(ChatColor.RED + "You may NOT throw eggs!");
				}
			}
		} else {

		}

		if (p.hasPermission("Egg.Throw")) {

			if (item != null && item.getType() == Material.EGG) {

				p.sendMessage(ChatColor.GREEN + "You may throw eggs!");

				return;

			}

			else {

			}
		}
		return;
	}


	@EventHandler
	public void onThrow(PlayerEggThrowEvent e) {

		Player p = e.getPlayer();
		if (!p.hasPermission("Egg.throw")) {

			p.sendMessage(ChatColor.DARK_RED + "Do not throw eggs!");
			e.setHatching(false);

			return;
		} else {
			if (e.isHatching())
				p.sendMessage(ChatColor.GREEN + "Egg throw Successful! Chicken has been Hatched!");

			if (configGetter.getBoolean("EggAnnouncer.true")) {
				if (!e.isHatching())
					p.sendMessage(ChatColor.DARK_RED + "Egg Throw UnSuccessful...");
			}
			return;
		}

	}
}
