package me.PhilosophyWithJosh.manhunt.hunter;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.PhilosophyWithJosh.manhunt.*;
import me.PhilosophyWithJosh.manhunt.utils.utils;
public class hunter implements Listener
{
	private static Main plugin;
	public static ArrayList<String> hunters = new ArrayList<String>();
	public hunter (Main plugin)
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	public static boolean isHunter(Player hunt)
	{
		if(hunters.contains(hunt.getDisplayName()))
		{
			return true;
		}
		return false;
	}
	public static void quit(Player quitter)
	{
		hunters.remove(quitter.getDisplayName());
		quitter.getInventory().removeItem(new ItemStack(Material.COMPASS));
	}
	public static void addHunter(Player hunter)
	{
		hunters.add(hunter.getDisplayName());
	}
	public static void removeHunter(Player hunter)
	{
		hunters.remove(hunter.getDisplayName());
	}
	public static String getHunterList()
	{
		if(hunters.size() > 0)
		{
			String hunterList = "";
			for(int i = 0; i < hunters.size(); i++)
			{
				hunterList = hunterList + hunters.get(i) + " ";
			}
			return hunterList;
		}
		else
			return ("null and none");
	}
}
