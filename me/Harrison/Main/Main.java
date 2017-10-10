package me.Harrison.Main;

import org.bukkit.plugin.PluginManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import me.Harrison.Main.gameCommands.Inventory.helpListener;

public class Main extends JavaPlugin {
	
    private PluginManager _pluginmangager_ = Bukkit.getPluginManager();
    private Main plugin;
	
	public void onEnable() {
		System.out.println("Harrison's Core Plugin is now enabled!");
		onCommands();
		listeners();
	}
	
	public void onDisable() {
		System.out.println("Harrison's Core Plugin is now disabled!");
	}
	
	public void listeners() {
		Bukkit.getPluginManager().registerEvents(new helpListener(), this);
		Bukkit.getPluginManager().registerEvents(new onChatListener(), this);
	}
	
	public void onCommands() {
		getCommand("gm").setExecutor(new me.Harrison.Main.Commands.gameMode());
		getCommand("spawn").setExecutor(new me.Harrison.Main.Commands.Spawn());
		getCommand("setspawn").setExecutor(new me.Harrison.Main.Commands.setSpawn());
		getCommand("setRules").setExecutor(new me.Harrison.Main.Commands.setRules());
		getCommand("clear").setExecutor(new me.Harrison.Main.Commands.entityClear());
		getCommand("game").setExecutor(new me.Harrison.Main.gameCommands.CommandGame());
		getCommand("silence").setExecutor(new me.Harrison.Main.Commands.commandSilence());
	}
	
    public static String c(String prefix, String message) {
        return ChatColor.translateAlternateColorCodes('&', (prefix==null)?"&7":"&2"+prefix+">> &7" + message);
    }
    
    public static int t = 0;

}
