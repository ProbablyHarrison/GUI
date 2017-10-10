package me.Harrison.Main.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class setRules implements CommandExecutor {

	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;
		
		if(c.getName().equalsIgnoreCase("setRules")) {
			for(int I = 0; I <= 100; I++) {
				@SuppressWarnings("deprecation")
				Entity rules = Bukkit.getWorld("world").spawnCreature(p.getLocation(), EntityType.CREEPER);
				rules.setCustomName("" + ChatColor.RED+ ChatColor.BOLD + "RULES");
				rules.isCustomNameVisible();
			}
					
		}
		return false;
	}

}
