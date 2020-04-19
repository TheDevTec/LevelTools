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
		 
		 if(lore!=null) {
			 for(String ss:lore) {
				if(ss.startsWith("Item level")) {
					level = TheAPI.getStringUtils().getInt(ss.replace("Item level ", ""));
					break;
				}
				level = 0;
			}	
		 }else {
			 level=0;
			 }
		 return level;
	    }
	public static int getToolXP(Player p) {
		 int xp = 0;
		 @SuppressWarnings("deprecation")
		ItemStack item = p.getItemInHand();
			ItemMeta m = item.getItemMeta();
		 List<String> lore = m.getLore();
		 
		 if(lore!=null) {
				for(String ss:lore) {
					if(ss.startsWith("Xp for next level")) {
						xp = TheAPI.getStringUtils().getInt(ss.replace("Xp for next level ", ""));
						break;
					}
					xp = 0;
				}
		 }else {
			 xp = 0;
		 }
		 return xp;
	    }
	
	 static void setlevel(Player p, int level) {
		 int line = 0;
		 int levelLine = 0;
		 int xpLine = 0;
		 @SuppressWarnings("deprecation")
			ItemStack item = p.getItemInHand();
				ItemMeta m = item.getItemMeta();
				List<String> lore = m.getLore();
				 
				 if(lore!=null)
						for(String ss:lore) {
							if(ss.startsWith("Item level")) {
								levelLine = line;
							}
							if(ss.startsWith("Xp for next level")) {
								xpLine = line;
							}
							line=line+1;
						}
				lore.remove(levelLine);
				lore.remove(xpLine);
				lore.add("Item level "+level);
				lore.add("Xp for next level "+getToolXP(p));
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
				lore.add("Item level "+getToolLevel(p));
				lore.add("Xp for next level "+level);
				m.setLore(lore);
				item.setItemMeta(m);
	 }
	 static void addXp(Player p, int xpammount) {
		 int level = getToolLevel(p);
		 int xp = getToolXP(p);
		 int neededxp = 0;
		 if(level<=50) neededxp = 10*level;
		 if(level>50&&level<=100) neededxp = 15*level;
		 if(level>100&&level<=150) neededxp = 20*level;
		 if(level>150&&level<=200) neededxp = 25*level;
		 if(level>300&&level<=400) neededxp = 35*level;
		 if(level>400&&level<=500) neededxp = 45*level;
		 if(level>500) neededxp = 55*level;
			 if(level==0) {
				 setlevel(p, 1);
			 }
			 if(xp>neededxp) {
				 setXP(p, xpammount);
				 return;
			 }
			 if(xp==neededxp) {
				 setlevel(p, level+1);
				 return;
			 }
	 }
}