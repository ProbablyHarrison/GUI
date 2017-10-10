package me.Harrison.Main.Commands;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Spawn implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;
		
		if(p.hasPermission("core.spawn")) {
			Location spawn = Bukkit.getWorld("world").getSpawnLocation();
			p.teleport(spawn);
			p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "SPAWN " + ChatColor.RESET
					+ "// You've teleported to spawn: " + ChatColor.GREEN + spawn);
		}
		return false;
	}

}
