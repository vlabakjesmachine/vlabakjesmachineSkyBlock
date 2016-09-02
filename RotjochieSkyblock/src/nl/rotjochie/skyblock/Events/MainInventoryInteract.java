package nl.rotjochie.skyblock.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import nl.rotjochie.skyblock.Menus.IslandBiomes;
import nl.rotjochie.skyblock.Utils.MessageUtils;
import nl.rotjochie.skyblock.Utils.SkyblockMethods;

public class MainInventoryInteract implements Listener{
	
	@EventHandler
	public void onInv(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		
		Inventory inv = e.getInventory();
		
		if(inv.getName().equalsIgnoreCase("§b§lRotjochie §e§lSkyblock")){
			if(e.getCurrentItem() != null){
				e.setCancelled(true);
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lEiland Level")){
				    p.closeInventory();
					SkyblockMethods.berekenEilandLevel(p);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lWarps")){p.performCommand("warp");}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lVerander Eiland Biome")){IslandBiomes.open(p);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lTop 10 Eilanden")){p.performCommand("is top");}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lHerstart Eiland")){p.performCommand("is restart");}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lEiland Slot")){
					if(SkyblockMethods.hasIsland(p)){
						if(SkyblockMethods.isIslandOwner(p)){
							if(SkyblockMethods.getEilandStatus(p)){
								SkyblockMethods.setEilandStatus(p, false);
								p.sendMessage("§aJe hebt je eiland terug openbaar gemaakt.");
								p.closeInventory();
							}else{
								SkyblockMethods.setEilandStatus(p, true);
								p.sendMessage("§cJe hebt je eiland gesloten. Enkel jij en de eiland leden kunnen het eiland betreden.");
								p.closeInventory();
							}
						}else{
							p.sendMessage(MessageUtils.GEENTOEGANG);
						}
					 }else{
						 p.sendMessage(MessageUtils.GEENEILAND);
					 }
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lTerug Naar Je Eiland")){
				 if(SkyblockMethods.hasIsland(p)){
					SkyblockMethods.teleportToIsland(p);
					p.closeInventory();
				 }else{
					 p.sendMessage(MessageUtils.GEENEILAND);
					 p.closeInventory();
				 }
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lVerander Je Eiland Locatie")){
					 if(SkyblockMethods.hasIsland(p)){
						if(SkyblockMethods.isIslandOwner(p)){
							SkyblockMethods.setIslandTP(p);
							p.sendMessage("§aDe locatie van je eiland is verplaatst naar jou locatie.");
							p.closeInventory();
						}else{
							p.sendMessage(MessageUtils.GEENTOEGANG);
							p.closeInventory();
						}
					 }else{
						 p.sendMessage(MessageUtils.GEENEILAND);
						 p.closeInventory();
					 }
					}
				
			}
		}
		
	}

}
