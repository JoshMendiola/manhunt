package me.PhilosophyWithJosh.manhunt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.PhilosophyWithJosh.manhunt.*;
import me.PhilosophyWithJosh.manhunt.hunter.hunter;
import me.PhilosophyWithJosh.manhunt.utils.utils;
import me.PhilosophyWithJosh.manhunt.prey.*;
public class preyCommand implements CommandExecutor
{
	private Main plugin;
	public preyCommand(Main plugin)
	{
		this.plugin = plugin;
		plugin.getCommand("beprey").setExecutor(this);
	}
	@Override
	//sets the command sender into the prey classification
	public boolean onCommand(CommandSender sender, Command beprey, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player pt = (Player)sender;
		//handles what happens if prey already exist
			if(prey.preyExist() == false && !hunter.isHunter(pt))
			{
				//sets the command sender to a person trying to become prey, or "PT"(prey tryer)
				pt.sendMessage(utils.chat("&cYou are now classed as prey"));
				prey.setPrey(pt);
				return true;
			
			}
			else if(prey.preyExist() == true && prey.getPrey() == sender)
			{
				//sets the command sender to a person trying to become prey, or "PT"(prey tryer)
				pt.sendMessage(utils.chat("&cYou are no longer classed as prey"));
				prey.removePrey();
				return true;
				
			}
			else if(prey.preyExist() == true)
			{
				pt.sendMessage(utils.chat("&7There is already a prey character"));
				return true;		
			}
			else if(hunter.isHunter(pt))
			{
				pt.sendMessage(utils.chat("&eYou can not be prey, you are already a hunter"));
				return false;
			}
		}
		return false;
	}
}
