package nl.rotjochie.skyblock.Utils;

import org.bukkit.entity.Player;

import net.alpenblock.bungeeperms.BungeePerms;

public class MessageUtils {
	
	public static String GEENEILAND = "§cJe hebt geen eiland op dit moment.";
	public static String GEENTOEGANG = "§cJe hebt als member geen toegang hiervoor. Vraag het aan de eiland Eigenaar.";
	public static String NIETGENOEGGELDBIOME = "§cJe hebt niet genoeg geld om deze biome te kopen.";
	
	public static String[] parts(String s){
		
		final int mid = s.length() / 2;
		
		
		String[] strings = {s.substring(0, mid),s.substring(mid)};
		
		return strings;
	}

	public static String getPrefix(Player p){
		String s = "";
		
		s = BungeePerms.getInstance().getPermissionsManager().getUser(p.getName()).buildPrefix().replace("&", "§").trim().toString();
		
		return s;
	}
	
}
