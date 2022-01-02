package me.PhilosophyWithJosh.manhunt;


import org.bukkit.plugin.java.JavaPlugin;

import me.PhilosophyWithJosh.manhunt.commands.hunterCommands;
import me.PhilosophyWithJosh.manhunt.commands.hunterListCommand;
import me.PhilosophyWithJosh.manhunt.commands.preyCommand;
import me.PhilosophyWithJosh.manhunt.hunter.hunter;
import me.PhilosophyWithJosh.manhunt.listeners.manhuntListeners;
import me.PhilosophyWithJosh.manhunt.prey.prey;


public class Main extends JavaPlugin
{
	public void onEnable()
	{
		new hunter(this);
		new prey(this);
		new manhuntListeners(this);
		new preyCommand(this);
		new hunterCommands(this);
		new hunterListCommand(this);
	}
}
