package net.drakune;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin implements Listener {

	private Player me;
	private boolean toggleIP;
	private TestPluginCommandExecutor myExecutor;
	
	public TestPlugin() {
		me = Bukkit.getPlayer("DR4KUN3");
		toggleIP = true;
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

	public Player getMe() {
		return me;
	}

	public boolean getToggleIP() {
		return toggleIP;
	}
	

}
