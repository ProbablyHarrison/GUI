package me.Harrison.Main.Commands;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class entityClear implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;
		
		if(c.getName().equalsIgnoreCase("clear")) {
			Location loc = p.getLocation();
			
			Bukkit.getWorld("World").createExplosion(loc, 100);
		}
		
		return false;
	}
}
