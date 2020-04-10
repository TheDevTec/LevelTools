package LevelTools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LevelTools implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			
			return true;
		}
		
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("info")) {
				
				return true;
			}
			
			if (args[0].equalsIgnoreCase("reload")) {
				Loader.msg(Loader.s("LevelTools.Reloading").replace("%prefix%", Loader.s("Prefix")), s);
				Configs.reload();
				Loader.msg(Loader.s("LevelTools.Reloaded").replace("%prefix%", Loader.s("Prefix")), s);
				return true;
			}
			return true;
		}
		
		if (args.length <= 3) {
			
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
