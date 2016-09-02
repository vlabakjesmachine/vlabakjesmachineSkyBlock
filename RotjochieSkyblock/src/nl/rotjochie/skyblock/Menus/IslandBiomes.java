package nl.rotjochie.skyblock.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import nl.rotjochie.skyblock.Utils.ItemUtil;
import nl.rotjochie.skyblock.Utils.SkyblockMethods;

public class IslandBiomes {
	
	/*
	 *  Forest €100, Desert €100, Jungle €350, Swampland €100, Tiaga €100, Mushroom €150, Plains €100, Sky €200, Ocean €175
	 *  Forest: dark_oak_sapling Desert: DEAD_BUSH jungle: jungle_sapling swampland: lilypad tiaga: carpet mushroom: red_mushroom plains: tall_grass sky: eyeofender Ocean: Prismarine_shard
	 */
	
	
	
	public static void open(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, "§2§lVerander Je Eiland Biome".replace("&", "§"));
        
        String[] Forest = {"§fDe Forest Biome is de", "§fbiome die je nodig hebt", "§fals je van bossen houd!", "§e§lKlik hier om je biome te veranderen."};
        String[] Desert = {"§fDe Desert Biome zorgt dat", "§fhet niet regent of sneeuwt", "§fop je eiland.", "§e§lKlik hier om je biome te veranderen."};
        String[] Swamp = {"§fDe Swamp Biome is donker", "§fen saai.", "§e§lKlik hier om je biome te veranderen."};
        String[] Tiaga = {"§fDe Tiaga Biome heeft sneeuw", "§fin plaats van regen.", "§e§lKlik hier om je biome te veranderen."};
        String[] Mushroom = {"§fDe Mushroom Biome is licht", "§fen kleurrijke paddenstoelen", "§e§lKlik hier om je biome te veranderen."};
        String[] Plains = {"§fDe Plains Biome heeft sneeuw", "§fin plaats van regen.", "§e§lKlik hier om je biome te veranderen."};
        String[] Ocean = {"§fOcean is een geavanceerde biome", "§e§lKlik hier om je biome te veranderen."};
        String[] Jungle = {"§fDe Jungle Biome is de biome", "§fvoor grote bomen en", "§fmooi grass.", "§e§lKlik hier om je biome te veranderen."};
        String[] Sky = {"§fDe Sky Biome geeft je", "§feiland een speciale donkere lucht.", "§e§lKlik hier om je biome te veranderen."};
        
        
        inv.setItem(0, ItemUtil.item(Material.SAPLING, 1, 1, "§a§lBiome: Forest", ItemUtil.formatLore(Forest)));
        inv.setItem(1, ItemUtil.item(Material.SAND, 1, 0, "§a§lBiome: Desert", ItemUtil.formatLore(Desert)));
        inv.setItem(2, ItemUtil.item(Material.WATER_LILY, 1, 0, "§a§lBiome: Swamp", ItemUtil.formatLore(Swamp)));
        inv.setItem(3, ItemUtil.item(Material.SNOW, 1, 0, "§a§lBiome: Tiaga", ItemUtil.formatLore(Tiaga)));
        inv.setItem(4, ItemUtil.item(Material.RED_MUSHROOM, 1, 3, "§a§lBiome: Mushroom", ItemUtil.formatLore(Mushroom)));
        inv.setItem(5, ItemUtil.item(Material.LONG_GRASS, 1, 0, "§a§lBiome: Plains", ItemUtil.formatLore(Plains)));
        inv.setItem(6, ItemUtil.item(Material.EYE_OF_ENDER, 1, 0, "§a§lBiome: Sky", ItemUtil.formatLore(Sky))); 
        inv.setItem(7, ItemUtil.item(Material.PRISMARINE_SHARD, 1, 0,"&a&lBiome: Ocean", ItemUtil.formatLore(Ocean))); 
        inv.setItem(8, ItemUtil.item(Material.SAPLING, 1, 3, "§a§lBiome: Jungle", ItemUtil.formatLore(Jungle)));
        
        p.openInventory(inv);
	}

}
