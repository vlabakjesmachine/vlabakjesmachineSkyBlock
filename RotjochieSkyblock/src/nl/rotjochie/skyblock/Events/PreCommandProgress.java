package nl.rotjochie.skyblock.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import nl.rotjochie.skyblock.Menus.IslandMain;
import nl.rotjochie.skyblock.Utils.SkyblockMethods;

public class PreCommandProgress implements Listener{
	
	@EventHandler
	public void preCommand(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/is") || e.getMessage().equalsIgnoreCase("/island") || e.getMessage().equalsIgnoreCase("/askyblock:is") || e.getMessage().equalsIgnoreCase("//askyblock:island")){
		 if(SkyblockMethods.hasIsland(e.getPlayer()) == true){
			 e.setCancelled(true);
			IslandMain.open(e.getPlayer());
	     }else{
	    	 e.setCancelled(false);
	     }
	}
  }
}
