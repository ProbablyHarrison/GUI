package me.Harrison.Main.gameCommands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Harrison.Main.Main;
import net.minecraft.server.v1_8_R3.PlayerInventory;

public class CommandGame implements CommandExecutor {

	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;

		@SuppressWarnings("rawtypes")
		ArrayList<Player> q = new ArrayList<Player>();

		String prefix = "&a&lGAME";
		String Error = "ERROR";
		final Inventory help = Bukkit.createInventory(p, 9, Main.c("", "&c&lGame Help Menu"));
		
		//ItemStacks
		ItemStack join = new ItemStack(Material.BOOK);
		ItemMeta jn = join.getItemMeta();
		jn.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		jn.setDisplayName(Main.c("", "&c&lJOIN QUEUE"));
		jn.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		join.setItemMeta(jn);
		help.setItem(0, join);
		
		ItemStack leave = new ItemStack(Material.PAPER);
		ItemMeta le= leave.getItemMeta();
		le.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		le.setDisplayName(Main.c("", "&c&lLEAVE QUEUE"));
		le.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		leave.setItemMeta(le);
		help.setItem(2, leave);
		
		ItemStack start = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta st = start.getItemMeta();
		st.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		st.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		if(p.hasPermission("game.admin")) {
			st.setDisplayName(Main.c("", "&c&lSTART GAME"));
		} else {
		st.setDisplayName(Main.c("", "&C&LSTART GAME (ADMIN)"));
		}
		start.setItemMeta(st);
		help.setItem(4, start);

		if (c.getName().equalsIgnoreCase("game")) {
			if (args.length == 0) {
				p.sendMessage(Main.c("&A&l" + prefix, " Please do /game help!"));
			} else if (args[0].equalsIgnoreCase("help")) {
				p.sendMessage(Main.c(prefix, " Welcome to the help menu!"));
				p.openInventory(help);

			} else if (args[0].equalsIgnoreCase("join")) {
				if (!q.contains((Player)p)) {
					p.sendMessage("test");
					q.add((Player)p);
				} else {
					p.sendMessage(Main.c(prefix, " Added to queue!"));
				}
			} else if (args[0].equals("leave")) {
				if (!q.contains(p)) {
					p.sendMessage(Main.c(prefix, " You're not in a queue!"));
				} else {
					q.remove(p);
					p.sendMessage(Main.c(prefix, " Left the queue!"));
				}
			} else if (args[0].equalsIgnoreCase("start")) {
				Bukkit.broadcastMessage(Main.c(prefix, " Game is starting!"));
				for (Player S : Bukkit.getServer().getOnlinePlayers()) {
					if (q.contains(S)) {
						S.sendMessage("Starting soon!");
					} else {
						S.sendMessage("Place 2");
					}

				}
			}
			else if(args[0].equalsIgnoreCase("list")) {
				p.sendMessage(Main.c(prefix, " Players that are in the list: &a" + q.toString()));
			}
		}
		return false;
	}

}
