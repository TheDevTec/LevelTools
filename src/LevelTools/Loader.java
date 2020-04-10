package LevelTools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.Straiker123.TheAPI;

public class Loader extends JavaPlugin {
	public static Loader instance;
	public static FileConfiguration config;
	public static FileConfiguration Translation;
	
	public void onLoad() {
		TheAPI.getConsole().sendMessage(TheAPI.colorize(Loader.s("Prefix")+"&7 *********************************************"));
		TheAPI.getConsole().sendMessage(TheAPI.colorize(Loader.s("Prefix")+"&a Plugin has been &fLoaded &a."));
		TheAPI.getConsole().sendMessage(TheAPI.colorize(Loader.s("Prefix")+"&7 *********************************************"));
		Configs.LoadConfigs();
	}
	public void onEnable() {	
		Configs.LoadConfigs();
		
        instance = this;
        
       Bukkit.getPluginCommand("leveltools").setExecutor(new LevelTools());
       //Bukkit.getPluginManager().registerEvents(new Events.onCommand(), this);
        
        
        TheAPI.getConsole().sendMessage(TheAPI.colorize(Loader.s("Prefix")+"&7 *********************************************"));
		TheAPI.getConsole().sendMessage(TheAPI.colorize(Loader.s("Prefix")+"&a Loadin configs, loading commands ...."));
		TheAPI.getConsole().sendMessage(TheAPI.colorize(Loader.s("Prefix")+"&7 *********************************************"));
    }
    public void onDisable() {
    	Configs.LoadConfigs();
    }
    public static String s(String s) { //pro Translation.yml
		if(Translation.getString(s)!=null)
			return Translation.getString(s);
			else {
				warn("String '"+s+"' isn't in Tranlations.yml, please report this bug on https://github.com/TheDevTec/LevelTools");
		return "&4ERROR, Missing path, See console for more informations";}
	}
    public static String con(String s) {//pro config.yml -- používat jenom na msg které jsou v configu :D
		if(config.getString(s)!=null)
			return config.getString(s);
			else {
			warn("String '"+s+"' isn't in Tranlations.yml, please report this bug on https://github.com/TheDevTec/LevelTools");
		return "&4ERROR, Missing path, See console for more informations";}
	}
    public static void warn(String s) {
    	Bukkit.getLogger().warning(TheAPI.colorize(s));
    }
    public static void Help(CommandSender s, String cmd, String help) { //builder help msg ... ukázka /scr
 	   msg(config.getString("HelpFormat")
 	    		.replace("%prefix%", Loader.s("Prefix"))
 	    		.replace("%command%", cmd).replace("%space%", " - ")
 	    		.replace("%help%", Loader.s("Help."+help)),s);
 		}
    public static boolean hasPerm(CommandSender s, String permission) {
		 if(s.hasPermission(permission)) {return true;}
			s.sendMessage(TheAPI.colorize(Loader.s("NotPermissionsMessage")
					.replace("%player%", s.getName())
					.replace("%playername%", s.getName())
					.replace("%permission%", permission)));
			return false;
	 }
	public static void broadcastMessage(String msg) {
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
	} 
    public static void msg(String string, CommandSender s) {
    	s.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
    }
}