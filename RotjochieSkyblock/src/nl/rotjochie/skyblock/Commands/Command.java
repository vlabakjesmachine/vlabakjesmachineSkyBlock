package nl.rotjochie.skyblock.Commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.rotjochie.skyblock.Menus.IslandMain;

public class Command implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("hoi")){
			IslandMain.open((Player)sender);
		}
		return false;
	}

}
