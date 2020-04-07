package LevelTools;

import java.util.HashMap;
import java.util.Map;

import me.Straiker123.ConfigAPI;
import me.Straiker123.TheAPI;

public class Configs {
	
	public static ConfigAPI config;
	public static ConfigAPI Translation;
	/*
	 * 	Toto je Translation.yml
	 */
	private static void translationLoading() {
		Translation = TheAPI.getConfig("LevelTools", "Translation");
		Map<String, Object> c = new HashMap<String, Object>();
		c.put("Prefix", "&aLevel&fTools");
		c.put("NotPermissionsMessage", "&4You do not have permissions");
		
		
		Translation.addDefaults(c);
		Translation.create();
		Loader.Translation=Translation.getConfig();
	}
	/*
	 * 	Toto je Config.yml
	 */
	private static void configLoading() {
		config = TheAPI.getConfig("LevelTools", "Config");
		Map<String, Object> c = new HashMap<String, Object>();
		
		c.put("HelpFormat", "%prefix% %command% >> %help%");
		
		config.setHeader("+-------------------------------------------------------------------+ #\r\n" + 
				"| Plugin was created by DevTec and Rajskooo   | #\r\n" + 
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
