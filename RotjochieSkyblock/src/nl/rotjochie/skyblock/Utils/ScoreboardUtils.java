package nl.rotjochie.skyblock.Utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import net.alpenblock.bungeeperms.BungeePerms;
import nl.rotjochie.skyblock.Core;

public class ScoreboardUtils {
	
	public static void leegBoard(Player p){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
	    Scoreboard board = manager.getNewScoreboard();
	    Objective objective = board.registerNewObjective("test", "dummy");
	    
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    
	    p.setScoreboard(board);
	}	
	
	public static void build(final Player p){
	 
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		final Scoreboard board = manager.getNewScoreboard();
		
		Objective o = board.registerNewObjective("test", "dummy");
		Team player = board.registerNewTeam("player");
		Team rank = board.registerNewTeam("rank");
		Team level = board.registerNewTeam("level");

		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(
		        ChatColor.translateAlternateColorCodes('&', "   " + "§6§lRotjochie Skyblock" + "  "));
	   
		Score score10 = o.getScore(" ");
	    score10.setScore(10);
	    
	    Score score9 = o.getScore(
	    ChatColor.translateAlternateColorCodes('&', "&fWelkom,"));
	    score9.setScore(9);

	    player.addEntry(ChatColor.RED.toString());
	    
	    player.setPrefix(" §a" + MessageUtils.parts(p.getName())[0]);
	    player.setPrefix("§a" + MessageUtils.parts(p.getName())[1]);
	    o.getScore(ChatColor.RED.toString()).setScore(8);
	    
	    Score score7 = o.getScore("  ");
	    score7.setScore(7);
	    
	    Score score6 = o.getScore(
	    ChatColor.translateAlternateColorCodes('&', "&fJouw Rank:"));
	    score6.setScore(6);

	    o.getScore(" " + MessageUtils.getPrefix(p)).setScore(5);
	    
	    Score score4 = o.getScore("   ");
	    score4.setScore(4);
	    
	    Score score3 = o.getScore(
	    ChatColor.translateAlternateColorCodes('&', "&fEiland Level:"));
	    score3.setScore(3);

	    level.addEntry(ChatColor.GREEN.toString());
	    
	    level.setPrefix(" §e§l" + MessageUtils.parts(String.valueOf(SkyblockMethods.getEilandLevel(p)))[0]);
	    level.setSuffix("§e§l" + MessageUtils.parts(String.valueOf(SkyblockMethods.getEilandLevel(p)))[1]);
	    o.getScore(ChatColor.GREEN.toString()).setScore(2);
	    
	    o.getScore("     ").setScore(1);
	    
	    o.getScore("§cplay.rotjochie.nl").setScore(0);
	     
	     new BukkitRunnable(){
	         @Override
	              public void run(){
	          if(p.getWorld().getName().equalsIgnoreCase("skyblock")){
	           leegBoard(p);
	          }else{      
	           board.getTeam("player").setPrefix(" §a" + MessageUtils.parts(p.getName())[0]);
	           board.getTeam("player").setSuffix("§a" + MessageUtils.parts(p.getName())[1]);
	           
	           board.getTeam("rank").setPrefix(" §7" + MessageUtils.parts(MessageUtils.getPrefix(p))[0].replaceAll("&", "§"));
	           board.getTeam("rank").setSuffix("§7" + "§7" + MessageUtils.parts(MessageUtils.getPrefix(p))[1].replaceAll("&", "§"));
	           
	           board.getTeam("level").setPrefix(" §e§l" + MessageUtils.parts(String.valueOf(SkyblockMethods.getEilandLevel(p)))[0]);
	           board.getTeam("level").setSuffix("§e§l" + MessageUtils.parts(String.valueOf(SkyblockMethods.getEilandLevel(p)))[1]);
	           
	          }
	              }
	            }.runTaskTimer(Core.getInstance(), 20, 20);
	     
	     p.setScoreboard(board);
	    }

}
