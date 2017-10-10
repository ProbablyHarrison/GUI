package me.Harrison.Main.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class gameMode implements CommandExecutor {

	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		Player p = (Player) s;
		if (c.getName().equalsIgnoreCase("gm")) {
			if (p.hasPermission("core.gm")) {
				

				if (p.getGameMode().equals(GameMode.CREATIVE)) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "GAMEMODE " + ChatColor.RESET 
							+ "// Gamemode: "  + ChatColor.GREEN + "false!");
					
					return true;
				} else if (p.getGameMode().equals(GameMode.SURVIVAL)) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "GAMEMODE " + ChatColor.RESET 
							+ "// Gamemode: "  + ChatColor.GREEN + "true!");
					return true;
				}

			} else {
				p.sendMessage("" + ChatColor.GREEN + ChatColor.BOLD + "PERMISSIONS " + ChatColor.RESET
						+ "// You don't have the required permissions to use this command, please try again when you do!");
			}
		}
		return false;
	}

}
