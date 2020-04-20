package LevelTools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LevelTools implements CommandExecutor {
	
	public static void allHelpMessages(CommandSender s) {
		Loader.Help(s, "/LT Reload", "Reload");
		Loader.Help(s, "/LT Info", "Info");
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			allHelpMessages(s);
			return true;
		}
		
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("Info")) {
				
				return true;
			}
			if (args[0].equalsIgnoreCase("Reload")) {
				Loader.msg(Loader.s("LevelTools.Reloading").replace("%prefix%", Loader.s("Prefix")), s);
				Configs.reload();
				Loader.msg(Loader.s("LevelTools.Reloaded").replace("%prefix%", Loader.s("Prefix")), s);
				return true;
			}
			allHelpMessages(s);
			return true;
		}
		if (args.length >= 1) {
			if (args[0].equalsIgnoreCase("set")) {
				
				return true;
			}
			
			if (args[0].equalsIgnoreCase("remove")) {
				
				return true;
			}
			
			if (args[0].equalsIgnoreCase("convert")) {
				
				return true;
			}
			return true;
		}
		
		return false;
	}

}
