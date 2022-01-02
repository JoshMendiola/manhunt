package me.PhilosophyWithJosh.manhunt.prey;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import me.PhilosophyWithJosh.manhunt.*;
import me.PhilosophyWithJosh.manhunt.utils.utils;
import org.bukkit.Location;
public class prey implements Listener 
{
	private static Main plugin;
	public static boolean alreadyPrey = false;
	public static Player hunted = null;
	public prey (Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	//checks if prey already exist
	public static boolean preyExist()
	{
		return alreadyPrey;
	}
	public static Location preyLoc()
	{
		if(preyExist())
		{
			return hunted.getLocation();
		}
		return null;
	}
	public static Player getPrey()
	{
		return hunted;
	}
	public static void quit()
	{
		hunted = null;
		alreadyPrey = false;
		Bukkit.broadcastMessage(utils.chat("&cThe prey has left the server"));
	}
	public static void setPrey(Player p)
	{
		hunted = p;
		alreadyPrey = true;
	}
	public static void removePrey()
	{
		hunted = null;
		alreadyPrey = false;
	}
}
