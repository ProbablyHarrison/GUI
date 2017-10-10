package me.Harrison.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Conscructor.Chat;
import me.Harrison.Main.Main;

public final class onChatListener implements Listener  {
	
	@EventHandler
	public void testing(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String prefix = p.getName();
		
		Chat ch = new Chat();
		
		e.setFormat(Main.c("&b" + prefix + " ", " " + e.getMessage()));

		
		if(ch.getBoolean() == false) {
			p.sendMessage("Chat has been silenced!");
			e.setCancelled(true);
		}
	}

}
