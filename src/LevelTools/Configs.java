package LevelTools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import me.Straiker123.ConfigAPI;
import me.Straiker123.TheAPI;

public class Configs {
	
	public static ConfigAPI config;
	public static ConfigAPI Translation;
	
	private static void translationLoading() {
		Translation = TheAPI.getConfig("LevelTools", "Translation");
		Map<String, Object> c = new HashMap<String, Object>();
		c.put("Prefix", "&aLevel&fTools");
		c.put("NotPermissionsMessage", "&4You do not have permissions");
		c.put("LevelTools.Reloading", "%prefix% &f----------&a Reloading configs&f ----------");
		c.put("LevelTools.Reloaded", "%prefix% &aConfigs reloaded successfully...");
		
		c.put("Help.Reload", "Reload config");
		c.put("Help.Info", "Info about plugin");
		
		Translation.addDefaults(c);
		Translation.create();
		Loader.Translation=Translation.getConfig();
	}

	private static void configLoading() {
		config = TheAPI.getConfig("LevelTools", "Config");
		Map<String, Object> c = new HashMap<String, Object>();
		
		c.put("HelpFormat", "%prefix% &a%command% &8&l>> &f%help%");
		
		c.put("Options.LevelReach.MessageEnabled", true);
		c.put("Options.LevelReach.Message", Arrays.asList(
				"&7--------------- %prefix% &7 ---------------",
				"&aYour tool have reached new level: &f%level%",
				"&7-------------------------------------------"));
		c.put("Options.LevelReach.SoundEnabled", true);
		c.put("Options.LevelReach.Sound", "ENTITY_PLAYER_LEVELUP");
		
		config.setHeader("+-------------------------------------------------------------------+ #\r\n" + 
				"| Plugin was created by DevTec and Rajskoo   | #\r\n" + 
				"+-------------------------------------------------------------------+ #\r\n" + 
				"Nìjakej text\n" +
				"  nìco :D\n"+
				"+-------------------------------------------+ #\r\n" + 
				"| INFO: Plugin is still in Development | #");
		config.addDefaults(c);
		config.create();
		Loader.config=config.getConfig();
	}
	
	public static void LoadConfigs() {
		configLoading();
		translationLoading();
	}
	public static void reload() {
		config.reload();
		Translation.reload();
	}

	
}
