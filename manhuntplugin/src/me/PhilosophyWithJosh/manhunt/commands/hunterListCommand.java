package me.PhilosophyWithJosh.manhunt.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.PhilosophyWithJosh.manhunt.*;
import me.PhilosophyWithJosh.manhunt.hunter.hunter;
import me.PhilosophyWithJosh.manhunt.utils.utils;
public class hunterListCommand implements CommandExecutor
{
	private Main plugin;
	public hunterListCommand(Main plugin)
	{
		this.plugin = plugin;
		plugin.getCommand("hunterlist").setExecutor(this);
	}
	public boolean onCommand(CommandSender sender, Command hunterlist, String label, String[] args)
	{
		if(hunter.getHunterList() != "null and none")
		{
			sender.sendMessage(utils.chat("&fHunters: &e" + hunter.getHunterList()));
			return true;
		}
		sender.sendMessage(utils.chat("&7There are currently no hunters"));
		return true;
	}
}
