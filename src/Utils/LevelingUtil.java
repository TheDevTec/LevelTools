package Utils;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Straiker123.TheAPI;


public class LevelingUtil {

	 public static int getToolLevel(Player p) {
		 int level = 0;
		 @SuppressWarnings("deprecation")
		ItemStack item = p.getItemInHand();
			ItemMeta m = item.getItemMeta();
		 List<String> lore = m.getLore();
		 
		 if(lore!=null)
				for(String ss:lore) {
					if(ss.startsWith("Item level")) {
						level = TheAPI.getStringUtils().getInt(ss.replace("Item level ", ""));
					}
				}
		 return level;
	    }
	public static int getToolXP(Player p) {
		 int xp = 0;
		 @SuppressWarnings("deprecation")
		ItemStack item = p.getItemInHand();
			ItemMeta m = item.getItemMeta();
		 List<String> lore = m.getLore();
		 
		 if(lore!=null)
				for(String ss:lore) {
					if(ss.startsWith("Item xp")) {
						xp = TheAPI.getStringUtils().getInt(ss.replace("Item xp ", ""));
					}
				}
		 return xp;
	    }
	 static void setlevel(Player p, int level) {
		 int line = 0;
		 int finalline = 0;
		 @SuppressWarnings("deprecation")
			ItemStack item = p.getItemInHand();
				ItemMeta m = item.getItemMeta();
				List<String> lore = m.getLore();
				 
				 if(lore!=null)
						for(String ss:lore) {
							if(ss.startsWith("Item level")) {
								finalline = line;
							}
							line=line+1;
						}
				lore.remove(finalline);
				lore.add("Item level"+level);
				m.setLore(lore);
				item.setItemMeta(m);
	 }
}