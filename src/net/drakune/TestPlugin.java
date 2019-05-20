package net.drakune;

import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Weather;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_13_R2.World;

public class TestPlugin extends JavaPlugin implements Listener {

	private Player me;
	private boolean toggleIP;
	
	public TestPlugin() {
		me = Bukkit.getPlayer("DR4KUN3");
		toggleIP = true;
	}
	
	public void onEnable() {
		this.getLogger().info("Das Plugin wurde erfolgreich gestartet");
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		this.getLogger().info("Das Plugin wurde erfolgreich ausgeschaltet");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein!");
	        return true;
		}
		else if(command.getName().equalsIgnoreCase("toggleIP") && me.isOnline() && me.isOp()) {
			if(toggleIP) {
				toggleIP = false;
				me.sendMessage(ChatColor.BOLD+""+ChatColor.YELLOW+"IP-Anzeige auf "+toggleIP+" gesetzt");
				return true;
			}
			if(!(toggleIP)) {
				toggleIP = true;
				me.sendMessage(ChatColor.BOLD+""+ChatColor.YELLOW+"IP-Anzeige auf "+toggleIP+" gesetzt");
				return true;
			}
		}
		else if(command.getName().equalsIgnoreCase("testen")) {
			Player player = (Player) sender;
			player.teleport(new Location(Bukkit.getWorld("world"),-116.5,4,129.5));
			player.sendMessage(ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du wurdest zum Spawn teleportiert!");
			if(me.isOnline() && toggleIP == true) {
				me.sendMessage(ChatColor.YELLOW+"Spieler "+ChatColor.RED+player.getName()+ChatColor.YELLOW+" mit der IP "+player.getAddress()+" nutzte /testen!");
			}
			player.setHealth(20);
			player.setFoodLevel(20);
			player.sendMessage(ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du wurdest geheilt!");
		}
		
		
		return super.onCommand(sender, command, label, args);
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		
	}

}
