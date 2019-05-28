package net.drakune;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class TestPluginCommandExecutor implements CommandExecutor {
	
	private TestPlugin plugin;
	private boolean toggleIP;

	public TestPluginCommandExecutor(TestPlugin plugin) {
		this.plugin = plugin;
		this.toggleIP = plugin.getToggleIP();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("toggleip") && sender instanceof Player) {
			Player player = (Player) sender;
			if(!(sender.equals(Bukkit.getPlayer("DR4KUN3")))) {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Du bist nicht der Owner des Servers!");
				return true;
			}
			if(args.length == 0) {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Der Status der IP Anzeige ist auf "+toggleIP+" gestellt!");
				return true;
			}
			if(args.length > 1) {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Zu viele Argumente!");
				return true;
			}
			if(args[0].equals("true")) {
				if(toggleIP) {
					player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"IP-Anzeige ist schon auf true gestellt!");
					return true;
				}
				toggleIP = true;
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"IP's werden nun angezeigt!");
				return true;
			}
			if(args[0].equals("false")) {
				if(!(toggleIP)) {
					player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"IP-Anzeige ist schon auf false gestellt!");
					return true;
				}
				toggleIP = false;
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"IP's werden nun nicht mehr angezeigt!");
				return true;
			}
			else {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Falsche Argumente!");
				return true;
			}
		}
		if(command.getName().equalsIgnoreCase("spawn") && sender instanceof Player) {
			Player player = (Player) sender;
			player.teleport(new Location(Bukkit.getWorld("world"),-116.5,4,129.5));
			player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du wurdest zum Spawn teleportiert!");
			player.setHealth(20);
			player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du wurdest geheilt!");
			player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 70, 0, true, false, false));
			if(Bukkit.getPlayer("DR4KUN3").isOnline() && toggleIP == true) {
				Bukkit.getPlayer("DR4KUN3").sendMessage(ChatColor.YELLOW+"Spieler "+ChatColor.RED+player.getName()+ChatColor.YELLOW+" mit der IP "+player.getAddress()+" nutzte /testen!");
			}
			else {
				return true;
			}
			return true;
		}
		if(command.getName().equalsIgnoreCase("castlerush") && sender instanceof Player) {
			
		}
		if(command.getName().equalsIgnoreCase("tag")) {
			Player player = (Player) sender;
			if(args.length >= 1) {
				return true;
			}
			else {
				Bukkit.getWorld("world").setTime(1000);
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du hast die Zeit auf Tag gesetzt. "+"("+Bukkit.getWorld("world").getTime()+")");
			}
		}
		if(command.getName().equalsIgnoreCase("nacht")) {
			Player player = (Player) sender;
			if(args.length >= 1) {
				return true;
			}
			else {
				Bukkit.getWorld("world").setTime(14000);
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du hast die Zeit auf Nacht gesetzt. "+"("+Bukkit.getWorld("world").getTime()+")");
			}
		}
		if(command.getName().equalsIgnoreCase("speed") && sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length > 2) {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Zu viele Argumente!");
				return true;
			}
			if(args.length < 2) {
				if(args.length < 1) {
					player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Zu wenig Argumente!");
					return true;
				}
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Zu wenig Argumente!");
				return true;
			}
			if(args[0].equals("flug")) {
				if(Integer.parseInt(args[1]) <= 10) {
					player.setFlySpeed(Float.parseFloat(args[1])/10);
					player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Fluggeschwindigkeit wurde auf "+args[1]+" gesetzt.");
					return true;
				}
				else {
					if(args.length > 3) {
						player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.ITALIC+"Zu viele Argumente!");
						return true;
					}
					if(Integer.parseInt(args[1]) > 10) {
						player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.ITALIC+"Maximale Geschwindigkeit von 10!");
						return true;
					}
				}
			}
			if(args[0].equals("laufen")) {
				if(Integer.parseInt(args[1]) <= 10) {
					player.setWalkSpeed(Float.parseFloat(args[1])/10);
					player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Laufgeschwindigkeit wurde auf "+args[1]+" gesetzt.");
					return true;
				}
				else {
					if(args.length > 3) {
						player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.ITALIC+"Zu viele Argumente!");
						return true;
					}
					if(Integer.parseInt(args[1]) > 10) {
						player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.ITALIC+"Maximale Geschwindigkeit von 10!");
						return true;
					}
				}
			}
			else {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Falsche Argumente! (Flug/Laufen)");
				return true;
			}
			
		}
		return true;
	}

}
