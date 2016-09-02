package nl.rotjochie.skyblock.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import nl.rotjochie.skyblock.Utils.ItemUtil;
import nl.rotjochie.skyblock.Utils.SkyblockMethods;

public class IslandMain {
	
	public static void open(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, "§b§lRotjochie §e§lSkyblock".replace("&", "§"));
        
        String[] TerugNaarEiland = {"§fKeer terug naar je eilands", "§fthuis locatie. Je kan je thuis","§flocatie veranderen naar elke","§flocatie op je eiland door gebruik","§fte maken van §b/is home.","§e§lKlik hier om naar je eiland te gaan."};
        String[] ZetEilandLocatie = {"§fAls je naar je eiland", "§fteleport wordt je naar", "§fdeze locatie geteleporteerd", "§e§lKlik hier om dat te veranderen."};
        String[] Uitdagingen = {"§fBekijk de lijst met §9uitdagingen", "§fdat je kan doen op je eiland om", "§fdan items, geld, perks en titles", "§fte verdienen", "§e§lKlik hier om de uitdagingen te zien."};
        String[] EilandLevel = {"§eHuidig level: §a" + SkyblockMethods.getEilandLevel(p), "§fLevel je eiland door", "§fuitbreidingen en uitdagingen", "§fte doen. Zeldzame blokken", "§fleveren meer punten op.", "§e§lKlik hier om te verversen."};
        String[] Biome = {"§eHuidige Biome: §b" + SkyblockMethods.getEilandBiome(p).toString(), "§fHet biome op je eiland", "§fheeft effect op de kleur", "§fvan het gras en het spawnen", "§fvan dieren en monsters.", "§e§lKlik hier om je biome te vernaderen."};
        String[] EilandSlotOpen = {"§eSlot Status: §7" + SkyblockMethods.getEilandStatusString(p), "§fje eiland is nu §aopen§f.", "§fAlle spelers kunnen nu je", "§feiland betreden, maar alleen", "§fjij en je eiland leden mogen", "§fhier nu bouwen.", "§e§lKlik hier om je eiland af te sluiten."};
        String[] EilandSlotGesloten = {"§eSlot Status: §8" + SkyblockMethods.getEilandStatusString(p), "§fje eiland is op dit moment §cgesloten.", "§fSpelers die niet lid zijn van je eiland", "§fkunnen nu niet je eiland binnen komen", "§e§lKlik hier om je eiland te openen."};
        String[] Top10 = {"§fDe top 10 hoogste eilanden.", "§e§lKlik om de top 10 te bekijken."};
        String[] HerstartEiland = {"§fHerstart je eiland.", "§4WAARSCHUWING! §cdit verwijderd je items en eiland!"};
        String[] Warps = {"§fEen lijst met alle warps.", "§e§lKlik om de lijst te bekijken"};
        
        
        inv.setItem(0, ItemUtil.item(Material.BED, 1, 0, "§a§lTerug Naar Je Eiland", ItemUtil.formatLore(TerugNaarEiland)));
        inv.setItem(1, ItemUtil.item(Material.WOOD_DOOR, 1, 0, "§a§lVerander Je Eiland Locatie", ItemUtil.formatLore(ZetEilandLocatie)));
        inv.setItem(2, ItemUtil.item(Material.DIAMOND_ORE, 1, 0, "§a§lUitdagingen", ItemUtil.formatLore(Uitdagingen)));
        inv.setItem(3, ItemUtil.item(Material.EXP_BOTTLE, 1, 0, "§a§lEiland Level", ItemUtil.formatLore(EilandLevel)));
        inv.setItem(4, ItemUtil.item(Material.SAPLING, 1, 3, "§a§lVerander Eiland Biome", ItemUtil.formatLore(Biome)));
     if(SkyblockMethods.getEilandStatus(p)){
        inv.setItem(5, ItemUtil.item(Material.IRON_FENCE, 1, 0, "§a§lEiland Slot", ItemUtil.formatLore(EilandSlotGesloten)));
     }else{
    	inv.setItem(5, ItemUtil.item(Material.IRON_FENCE, 1, 0, "§a§lEiland Slot", ItemUtil.formatLore(EilandSlotOpen)));
     }
        inv.setItem(6, ItemUtil.item(Material.DIAMOND_BLOCK, 1, 0, "§a§lWarps", ItemUtil.formatLore(Warps))); 
        inv.setItem(7, ItemUtil.skullitem(1, "§a§lTop 10 Eilanden", ItemUtil.formatLore(Top10), "Rotjochie")); 
        inv.setItem(8, ItemUtil.item(Material.DIRT, 1, 2, "§c§lHerstart Eiland", ItemUtil.formatLore(HerstartEiland)));
        
        p.openInventory(inv);
	}

}
