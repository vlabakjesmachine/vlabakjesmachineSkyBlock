package nl.rotjochie.skyblock.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemUtil {
	
	public static ItemStack item(Material mat, int amount, int metadata, String name, List<String> lore){
		ItemStack i = new ItemStack(mat, amount, (short) metadata);
		ItemMeta im = i.getItemMeta();
		
		im.setDisplayName(name.replace("&", "§"));
		im.setLore(lore);
		
		i.setItemMeta(im);
		
		return i;
	}
	
	public static List<String> formatLore(String[] strings){
		List<String> lore = new ArrayList<String>();
		for(String s : strings){
			lore.add(s);
		}
		return lore;
	}
	
	public static ItemStack skullitem(int amount, String name, List<String> lore, String owner){
		ItemStack i = new ItemStack(Material.SKULL_ITEM, amount,(short) 3);
		SkullMeta im = (SkullMeta) i.getItemMeta();
		
		im.setDisplayName(name.replace("&", "§"));
		im.setOwner(owner);
		im.setLore(lore);
		
		i.setItemMeta(im);
		
		return i;
	}

}
