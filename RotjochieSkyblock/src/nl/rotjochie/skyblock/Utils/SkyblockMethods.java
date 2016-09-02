package nl.rotjochie.skyblock.Utils;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import com.wasteofplastic.askyblock.ASkyBlockAPI;
import com.wasteofplastic.askyblock.Island;

import nl.rotjochie.skyblock.Core;

public class SkyblockMethods {
	
	public static void berekenEilandLevel(Player p){
		p.performCommand("is level");
	}
	
	public static void setEilandStatus(Player p, boolean b){
		Island is = ASkyBlockAPI.getInstance().getIslandAt(ASkyBlockAPI.getInstance().getIslandLocation(p.getUniqueId()));
		
		is.setLocked(b);
		is.save();
	}
	
	public static void changeBiome(Player p, Biome b, int price){
		Island is = ASkyBlockAPI.getInstance().getIslandAt(ASkyBlockAPI.getInstance().getIslandLocation(p.getUniqueId()));
		
		if(SkyblockMethods.isIslandOwner(p)){
			if(is.getBiome() != b){
				if(Core.hasMoney(p, price)){
					is.setBiome(b);
					is.save();
					p.sendMessage("§aJe eiland biome is veranderd naar §2" + b.toString() + "§a.");
					p.closeInventory();
				}else{
					p.sendMessage("§cJe heb niet genoeg geld hiervoor!");
					p.closeInventory();
				}
			}else{
				p.sendMessage("§cJe eiland heeft deze biome al op dit moment!");
				p.closeInventory();
			}
		
		}else{
			p.sendMessage(MessageUtils.GEENTOEGANG);
			p.closeInventory();
		}
	
		
	}
	
	public static int getEilandLevel(Player p){
		return ASkyBlockAPI.getInstance().getIslandLevel(p.getUniqueId());
	}
	
	public static Biome getEilandBiome(Player p){
		return ASkyBlockAPI.getInstance().getIslandAt(ASkyBlockAPI.getInstance().getIslandLocation(p.getUniqueId())).getBiome();
	}
	
	public static boolean getEilandStatus(Player p){
		return ASkyBlockAPI.getInstance().getIslandAt(ASkyBlockAPI.getInstance().getIslandLocation(p.getUniqueId())).isLocked();
	}
	
	public static void teleportToIsland(Player p){
		Island is = ASkyBlockAPI.getInstance().getIslandAt(ASkyBlockAPI.getInstance().getIslandLocation(p.getUniqueId()));
		
		Location loc = is.getSpawnPoint();
	if(is.getSpawnPoint() == null){
		p.teleport(ASkyBlockAPI.getInstance().getHomeLocation(p.getUniqueId()));
	}else{
		p.teleport(loc);
	}
}
	
	public static void setIslandTP(Player p){
		
		Island is = ASkyBlockAPI.getInstance().getIslandAt(ASkyBlockAPI.getInstance().getIslandLocation(p.getUniqueId()));
		is.setSpawnPoint(p.getLocation());
	}
	
	public static boolean hasIsland(Player p){
		
		Island is = ASkyBlockAPI.getInstance().getIslandAt(ASkyBlockAPI.getInstance().getIslandLocation(p.getUniqueId()));
		
		if(is != null && (is.getMembers().contains(p.getUniqueId()) || is.getOwner() == p.getUniqueId())){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isIslandOwner(Player p){
		return ASkyBlockAPI.getInstance().hasIsland(p.getUniqueId());
	}
	
	public static String getEilandStatusString(Player p){
		String string = "";
		
		if(getEilandStatus(p) == true){
			string = "Gesloten";
		}else{
			string = "Openbaar";
		}
		
		return string;
	}

}
