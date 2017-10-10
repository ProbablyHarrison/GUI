package me.Harrison.Main.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Conscructor.Chat;
import me.Harrison.Main.Main;

public class commandSilence implements CommandExecutor {

	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
	Player p = (Player) s;
	Chat ch = new Chat();
	
		if(c.getName().equalsIgnoreCase("silence")) {
			if(ch.getBoolean() == true) {
				ch.setBoolean(false);
				Bukkit.broadcastMessage(Main.c("", " Chat has been silenced!"));
			} else {
				ch.setBoolean(true);
				Bukkit.broadcastMessage(Main.c("", " Chat has been unlocked"));
			}
		
		
			return false;
		}
	}

}
