package nl.rotjochie.skyblock;

import org.bukkit.plugin.java.JavaPlugin;

import nl.rotjochie.skyblock.Commands.Command;

public class Core extends JavaPlugin{
	
	public void onEnable(){
		getCommand("hoi").setExecutor(new Command());
	}
	
}
