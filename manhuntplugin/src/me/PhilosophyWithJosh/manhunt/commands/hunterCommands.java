package me.PhilosophyWithJosh.manhunt.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.PhilosophyWithJosh.manhunt.Main;
import me.PhilosophyWithJosh.manhunt.hunter.hunter;
import me.PhilosophyWithJosh.manhunt.prey.prey;
import me.PhilosophyWithJosh.manhunt.utils.utils;

public class hunterCommands implements CommandExecutor
{
	private Main plugin;
	
	public hunterCommands(Main plugin)
	{
		this.plugin = plugin;
		plugin.getCommand("behunter").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command behunter, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player ht = (Player) sender;
			/*checks if the list of hunters already contains this hunter, or if they are already classed as prey, to
			 see if they should be added or removed */
			if(hunter.isHunter(ht) == false && ht != prey.getPrey())
			{
				ht.sendMessage(utils.chat("&cYou are now classed as a hunter"));
				hunter.addHunter(ht);
				ht.getInventory().addItem(new ItemStack(Material.COMPASS));
				return true;
			}
			else if(ht == prey.getPrey())
			{
				ht.sendMessage(utils.chat("&eYou can not be a hunter, you are already prey"));
				return false;
			}
			else
			{
				ht.sendMessage(utils.chat("&cYou are no longer classed as a hunter"));
				hunter.removeHunter(ht);
				ht.getInventory().removeItem(new ItemStack(Material.COMPASS));
				return true;
			}
		}
		return false;
	}
}
