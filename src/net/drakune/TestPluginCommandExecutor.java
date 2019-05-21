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
	
	@SuppressWarnings("unused")
	private TestPlugin plugin;
	private Player me;
	private boolean toggleIP;

	public TestPluginCommandExecutor(TestPlugin plugin) {
		this.plugin = plugin;
		this.me = plugin.getMe();
		this.toggleIP = plugin.getToggleIP();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("toggleip") && sender instanceof Player) {
			if(args.length > 1) {
				sender.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Zu viele Argumente!");
				return true;
			}
			if(args.length < 1) {
				sender.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Zu wenig Argumente!");
				return true;
			}
			if(args[0].equals("true")) {
				toggleIP = true;
				sender.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4]"+ChatColor.YELLOW+ChatColor.BOLD+" IP's werden nun angezeigt");
				return false;
			}
			if(args[0].equals("false")) {
				toggleIP = false;
				sender.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4]"+ChatColor.YELLOW+ChatColor.BOLD+" IP's werden nun nicht mehr angezeigt");
				return false;
			}
			else {
				sender.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Falsche Argumente! (true/false)");
				return true;
			}
		}
		if(command.getName().equalsIgnoreCase("spawn") && sender instanceof Player) {
			Player player = (Player) sender;
			player.teleport(new Location(Bukkit.getWorld("world"),-116.5,4,129.5));
			player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du wurdest zum Spawn teleportiert!");
			if(me.isOnline() && toggleIP == true) {
				me.sendMessage(ChatColor.YELLOW+"Spieler "+ChatColor.RED+player.getName()+ChatColor.YELLOW+" mit der IP "+player.getAddress()+" nutzte /testen!");
			}
			player.setHealth(20);
			player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du wurdest geheilt!");
			player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 70, 0, true, false, false));
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
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du hast die Zeit auf Tag gesetzt "+"("+Bukkit.getWorld("world").getTime()+")");
			}
		}
		if(command.getName().equalsIgnoreCase("nacht")) {
			Player player = (Player) sender;
			if(args.length >= 1) {
				return true;
			}
			else {
				Bukkit.getWorld("world").setTime(14000);
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Du hast die Zeit auf Nacht gesetzt "+"("+Bukkit.getWorld("world").getTime()+")");
			}
		}
		if(command.getName().equalsIgnoreCase("speed") && sender instanceof Player) {
			/*  
			 * WalkSpeed auch noch setzen lassen können mit z.B /speed laufen 10
			 * FlySpeed dann dementsprechend mit /speed flug 10
			 * 
			 */
			Player player = (Player) sender;
			if(args.length > 1) {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Zu viele Argumente!");
				return true;
			}
			if(args.length < 1) {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Zu wenig Argumente! (1 bis 10)");
				return true;
			}
			if(Integer.parseInt(args[0]) > 10) {
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.RED+""+ChatColor.ITALIC+"Falsche Argumente! (1 bis 10)");
				return true;
			}
			if(Integer.parseInt(args[0]) <= 10) {
				player.setFlySpeed(Float.parseFloat(args[0])/10);
				player.sendMessage(ChatColor.BOLD+""+ChatColor.DARK_PURPLE+"[DR4] "+ChatColor.YELLOW+ChatColor.BOLD+"Fluggeschwindigkeit wurde auf "+args[0]+" gesetzt");
			}
		}
		return true;
	}

}
