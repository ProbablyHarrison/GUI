package me.Harrison.Main.gameCommands.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Harrison.Main.Main;

public final class helpListener implements Listener {
	
	@SuppressWarnings("deprecation")
	
	
	@EventHandler
	public static void onClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory i = e.getInventory();
		final Inventory help = Bukkit.createInventory(p, 9, Main.c("", "&c&lGame Help Menu"));

		

		if(i.getName().equals(help.getName())) {
			if(clicked.getType() == Material.BOOK) {
				e.setCancelled(true);
				p.closeInventory();
				p.performCommand("game join");
				p.sendMessage(Main.c("", " Added to the queue!"));
			}
			else if(clicked.getType() == Material.PAPER) {
				e.setCancelled(true);
				p.closeInventory();
				p.performCommand("game leave");
				p.sendMessage(Main.c("", " Left queue"));
			}
			else if(clicked.getType() == Material.DIAMOND_PICKAXE) {
				if(p.hasPermission("game.admin")) {
					e.setCancelled(true);
					p.closeInventory();
					p.performCommand("game steart");
					p.sendMessage(Main.c("", " You started the game"));
				} else {
					e.setCancelled(true);
					p.closeInventory();
					p.sendMessage(Main.c("", " You don't have permissions to do this!"));
				}
			}
		}
		
	}

}
