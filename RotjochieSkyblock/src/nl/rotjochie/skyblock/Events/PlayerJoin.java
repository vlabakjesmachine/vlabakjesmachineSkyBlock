package nl.rotjochie.skyblock.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import nl.rotjochie.skyblock.Utils.ScoreboardUtils;

public class PlayerJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		ScoreboardUtils.build(e.getPlayer());
	}

}
