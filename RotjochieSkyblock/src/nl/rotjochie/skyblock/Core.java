package nl.rotjochie.skyblock;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;
import nl.rotjochie.skyblock.Events.BiomeInventroyInteract;
import nl.rotjochie.skyblock.Events.MainInventoryInteract;
import nl.rotjochie.skyblock.Events.PlayerJoin;
import nl.rotjochie.skyblock.Events.PreCommandProgress;

public class Core extends JavaPlugin{
	
	public static Economy econ = null;
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new PreCommandProgress(), this);
		getServer().getPluginManager().registerEvents(new MainInventoryInteract(), this);
		getServer().getPluginManager().registerEvents(new BiomeInventroyInteract(), this);
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		
		if (!setupEconomy() ) {
			getLogger().severe(String.format("[%s] - Disable De plugin Vault zit er nog niet in!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
	}
	
	public static Plugin getInstance(){
		return Core.getPlugin(Core.class);
	}
	
	public static boolean setupEconomy() {
		if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	public static int doubleToInt(Double d)
	{
		return d.intValue();
	}

	@SuppressWarnings("deprecation")
	public static void giveMoney(Player p, int amount){
		econ.depositPlayer(p.getName(), amount);
	}
	@SuppressWarnings("deprecation")
	public static void takeMoney(Player p, int amount){
		econ.withdrawPlayer(p.getName(), amount);
	}
	@SuppressWarnings("deprecation")
	public static boolean hasMoney(Player p, int amount){
		return econ.has(p.getName(), amount);
	}

	public static int getMoney(Player p){
		if (econ != null){
			int m = doubleToInt(Double.valueOf(econ.getBalance(p)));
			return m;
		}
		return 1;
	}
	
}
