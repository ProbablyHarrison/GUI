package me.Harrison.Main.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class setSpawn implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;
		if(c.getName().equalsIgnoreCase("setspawn")) {
			if(p.hasPermission("core.setspawn")) {
				
				Location loc = new Location(p.getWorld(), (int)p.getLocation().getX(), (int)p.getLocation().getY(), (int)p.getLocation().getZ());
				Bukkit.getWorld("world").setSpawnLocation((int)p.getLocation().getX(), (int)p.getLocation().getY(), (int)p.getLocation().getZ());
				
				p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "ADMINISTRATION " + ChatColor.RESET
						+ "// You've set spawn: " + ChatColor.GREEN + loc );
			} else {
				p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "PERMISSIONS " + ChatColor.RESET
						+ "// You don't have the required permissions to use this command, please try again when you do!");
			}
			
		}
		return false;
	}

}
