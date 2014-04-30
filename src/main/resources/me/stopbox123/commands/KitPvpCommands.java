package me.stopbox123.commands;

import me.stopbox123.pvp.KitPvp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class KitPvpCommands implements CommandExecutor {

	private KitPvp pvp;
	
	public KitPvpCommands(KitPvp pvp) {
		this.pvp = pvp;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You are not a player");
			return false;
		}
		
		Player p = (Player)sender;
		if (args.length == 0) {
			p.sendMessage(ChatColor.DARK_GREEN + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			p.sendMessage(ChatColor.GOLD + "                         Developed By: " + ChatColor.DARK_RED + "Stopbox123");
			PluginDescriptionFile pdf = pvp.getDescription();
			p.sendMessage(ChatColor.GOLD + "                                Version: " + ChatColor.GRAY + pdf.getVersion());
			p.sendMessage("");
			p.sendMessage(ChatColor.YELLOW + "Commands:");
			p.sendMessage("   /kitpvp join (Join KitPvp)");
			p.sendMessage("   /kitpvp leave (Leave KitPvp)");
			p.sendMessage("   /kitpvp class (Change Class)");
			p.sendMessage(ChatColor.DARK_GREEN + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		}
		
		if (args.length == 1 && args[0].equalsIgnoreCase("join")) {
			p.openInventory(me.stopbox123.inventory.Inventory.KitInventory);
		}
		return false;
	}

}
