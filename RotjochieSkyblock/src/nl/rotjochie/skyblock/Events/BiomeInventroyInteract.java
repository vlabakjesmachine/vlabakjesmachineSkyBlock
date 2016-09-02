package nl.rotjochie.skyblock.Events;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import nl.rotjochie.skyblock.Utils.SkyblockMethods;

public class BiomeInventroyInteract implements Listener{
	
	@EventHandler
	public void onInv(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		
		Inventory inv = e.getInventory();
		
		if(inv.getName().equalsIgnoreCase("§2§lVerander Je Eiland Biome")){
			if(e.getCurrentItem() != null){
				e.setCancelled(true);
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lEiland Level")){
				    p.closeInventory();
					SkyblockMethods.berekenEilandLevel(p);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Sky")){SkyblockMethods.changeBiome(p, Biome.SKY, 200);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Forest")){SkyblockMethods.changeBiome(p, Biome.FOREST, 100);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Desert")){SkyblockMethods.changeBiome(p, Biome.DESERT, 100);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Swamp")){SkyblockMethods.changeBiome(p, Biome.SWAMPLAND, 100);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Tiaga")){SkyblockMethods.changeBiome(p, Biome.COLD_TAIGA, 100);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Mushroom")){SkyblockMethods.changeBiome(p, Biome.MUSHROOM_ISLAND, 150);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Plains")){SkyblockMethods.changeBiome(p, Biome.ICE_PLAINS, 100);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Ocean")){SkyblockMethods.changeBiome(p, Biome.DEEP_OCEAN, 175);}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lBiome: Jungle")){SkyblockMethods.changeBiome(p, Biome.JUNGLE, 350);}
				
			}
		}
	}
}
