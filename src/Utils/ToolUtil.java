package Utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import LevelTools.Loader;
import me.Straiker123.TheAPI;

public class ToolUtil {

	public static void getToolXP(Player p, Material mat, Material material2) {
		String material = mat.toString();
		String block = material2.toString();
		//Bukkit.broadcastMessage(material+";  block: "+block);
		for(String tool:Loader.config.getConfigurationSection("PerToolXP.Tools").getKeys(false)) {
			if(tool.toUpperCase().equals(material)) {
				 List<String> BlockList = Loader.config.getStringList("PerToolXP.Tools."+tool+".BlockList");
		 		 for(String l: BlockList) {
		 			 if(l.startsWith(block)) {
		 				 int xp = TheAPI.getStringUtils().getInt(l.replace(block+":", ""));
		 				 LevelingUtil.addXp(p, xp);
		 				 break;
		 			 }
		 		 }
				
			}
			continue;
		}
	}
}
