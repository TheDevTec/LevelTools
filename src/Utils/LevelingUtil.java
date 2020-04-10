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
					if(ss.startsWith("Xp for next level")) {
						xp = TheAPI.getStringUtils().getInt(ss.replace("Xp for next level ", ""));
					}
				}
		 return xp;
	    }
	 static void setlevel(Player p, int level) {
		 int line = 0;
		 int finalline = 0;
		 int finalline2 = 0;
		 @SuppressWarnings("deprecation")
			ItemStack item = p.getItemInHand();
				ItemMeta m = item.getItemMeta();
				List<String> lore = m.getLore();
				 
				 if(lore!=null)
						for(String ss:lore) {
							if(ss.startsWith("Item level")) {
								finalline2 = line;
							}
							if(ss.startsWith("Xp for next level")) {
								finalline = line;
							}
							line=line+1;
						}
				lore.remove(finalline);
				lore.remove(finalline2);
				lore.add("Item level"+level);
				lore.add("Xp for next level"+level);
				m.setLore(lore);
				item.setItemMeta(m);
	 }
	 static void setXP(Player p, int level) {
		 int line = 0;
		 int finalline = 0;
		 int finalline2 = 0;
		 @SuppressWarnings("deprecation")
			ItemStack item = p.getItemInHand();
				ItemMeta m = item.getItemMeta();
				List<String> lore = m.getLore();
				 
				 if(lore!=null)
						for(String ss:lore) {
							if(ss.startsWith("Xp for next level")) {
								finalline = line;
							}
							if(ss.startsWith("Item level")) {
								finalline2 = line;
							}
							line=line+1;
						}
				lore.remove(finalline);
				lore.remove(finalline2);
				lore.add("Item level"+getToolLevel(p));
				lore.add("Xp for next level"+level);
				m.setLore(lore);
				item.setItemMeta(m);
	 }
}