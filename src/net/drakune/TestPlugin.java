package net.drakune;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.material.Wool;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {

	private boolean toggleIP = true;
	private TestPluginCommandExecutor myExecutor;
	
	public TestPlugin() {
	}
	
	public void onEnable() {
		this.getLogger().info("Das Plugin wurde erfolgreich gestartet");
		this.getServer().getPluginManager().registerEvents(this, this);
		myExecutor = new TestPluginCommandExecutor(this);
		getCommand("spawn").setExecutor(myExecutor);
		getCommand("toggleip").setExecutor(myExecutor);
		getCommand("speed").setExecutor(myExecutor);
		getCommand("tag").setExecutor(myExecutor);
		getCommand("nacht").setExecutor(myExecutor);
	}
	
	public void onDisable() {
		this.getLogger().info("Das Plugin wurde erfolgreich ausgeschaltet");
	}

	public boolean getToggleIP() {
		return toggleIP;
	}
	

}
