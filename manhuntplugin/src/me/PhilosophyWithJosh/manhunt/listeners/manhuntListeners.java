package me.PhilosophyWithJosh.manhunt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import me.PhilosophyWithJosh.manhunt.hunter.*;
import me.PhilosophyWithJosh.manhunt.prey.prey;
import me.PhilosophyWithJosh.manhunt.utils.utils;
import me.PhilosophyWithJosh.manhunt.Main;
import org.bukkit.event.block.Action;
public class manhuntListeners implements Listener
{
	private static Main plugin;
	public manhuntListeners(Main plugin) 
	{
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this,plugin);
	}
	@EventHandler
	//gives the hunters the compass which tracks the prey movement upon their hunter classification
	public void onHunterSpawn(PlayerRespawnEvent s)
	{
		if(hunter.isHunter(s.getPlayer()))
		{
			s.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
		}
	}
	@EventHandler
	//powers the compass which the hunter uses to track down and hunt the prey
	public void onHunterTrack(PlayerInteractEvent i)
	{
		Player tracker = i.getPlayer();
		Action action = i.getAction();
		if(hunter.isHunter(tracker) && prey.preyExist())
		{
			if (i.getItem().getType() == Material.COMPASS && (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK))
			{
				tracker.setCompassTarget(prey.preyLoc());
			}
		}
		else if(hunter.isHunter(tracker) && !prey.preyExist())
		{
			if (i.getItem().getType() == Material.COMPASS && (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK))
			{
				tracker.sendMessage(utils.chat("&7There is no prey to track"));
			}
		}
	}
	@EventHandler
	//handles what would happen in the event of a prey or player leaving the server
	public void onPlayerLeave(PlayerQuitEvent q)
	{
		Player quitter = q.getPlayer();
		if(quitter == prey.getPrey())
		{
			prey.quit();
		}
		else if(hunter.isHunter(quitter))			
		{
			hunter.quit(quitter);
		}
	}
}