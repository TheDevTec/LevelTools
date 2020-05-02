package Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import LevelTools.Loader;
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
				if(ss.startsWith(TheAPI.colorize("&aItem level &f"))) {
					level = TheAPI.getStringUtils().getInt(ss.replace(TheAPI.colorize("&aItem level &f"), ""));
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
					if(ss.startsWith(TheAPI.colorize("&aTool XP &f"))) {
						xp = TheAPI.getStringUtils().getInt(ss.replace(TheAPI.colorize("&aTool XP &f"), ""));
						break;
					}
					xp = 0;
				}
		 }else {
			 xp = 0;
		 }
		 return xp;
	    }
	
	public static void setlevel(Player p, int level) {
		 int line = 0;
		 int levelLine = 0;
		 int xpLine = 0;
		 //int xp = getToolXP(p);
		 int xp = 0;
		 @SuppressWarnings("deprecation")
			ItemStack item = p.getItemInHand();
				ItemMeta m = item.getItemMeta();
				List<String> lore = m.getLore();
				ArrayList<String> loree = new ArrayList<String>();
				 if(m.getLore()==null) {
					 loree.add(TheAPI.colorize("&aItem level &f"+level));
					 loree.add(TheAPI.colorize("&aTool XP &f"+getToolXP(p)));
					 m.setLore(loree);
					 item.setItemMeta(m);
					 return;
				 }
				 if(m.getLore()!=null) {
						for(String ss:m.getLore()) {
							if(ss.startsWith(TheAPI.colorize("&aItem level &f"))) {
								levelLine = line;
								lore.remove(levelLine);
								continue;
							}
							if(ss.startsWith(TheAPI.colorize("&aTool XP &f"))) {
								xpLine = line;
								lore.remove(xpLine);
								continue;
							}
							line=line+1;
						}
				}
				//Bukkit.broadcastMessage("Level to set: "+level);
				
				lore.add(TheAPI.colorize("&aItem level &f"+level));
				lore.add(TheAPI.colorize("&aTool XP &f"+xp));
				m.setLore(lore);
				item.setItemMeta(m);
	 }
	public static void setXP(Player p, int ammount) {
		 int line = 0;
		 int xpline = 0;
		 int levelline = 0;
		 int level = getToolLevel(p);
		 //int xp = getToolXP(p)+ammount;
		 @SuppressWarnings("deprecation")
			ItemStack item = p.getItemInHand();
				ItemMeta m = item.getItemMeta();
				List<String> lore = m.getLore();
				 
				 if(m.getLore()!=null) {
						for(String ss:m.getLore()) {
							if(ss.startsWith(TheAPI.colorize("&aTool XP &f"))) {
								xpline = line;
								lore.remove(xpline);
								continue;
							}
							if(ss.startsWith(TheAPI.colorize("&aItem level &f"))) {
								levelline = line;
								lore.remove(levelline);
								continue;
							}
							line=line+1;
						}
				//lore.remove(xpline);
				//lore.remove(levelline);
				}
				lore.add(TheAPI.colorize("&aItem level &f"+level));
				lore.add(TheAPI.colorize("&aTool XP &f"+ammount));
				m.setLore(lore);
				item.setItemMeta(m);
	 }
	 public static void addXp(Player p, int xpammount) {
		 int level = getToolLevel(p);
		 int xp = getToolXP(p);
		 int neededxp = 0;
		 if(level==0) {
			 setlevel(p, 1);
			 annoucment(p, 1);
			 return;
		 }
		 if(level<=50) neededxp = 10*level;
		 if(level>50&&level<=100) neededxp = 15*level;
		 if(level>100&&level<=150) neededxp = 20*level;
		 if(level>150&&level<=200) neededxp = 25*level;
		 if(level>300&&level<=400) neededxp = 35*level;
		 if(level>400&&level<=500) neededxp = 45*level;
		 if(level>500) neededxp = 55*level;
		 //Bukkit.broadcastMessage("XP: "+xp+ "NeededXP: "+neededxp);
		 xp = xp+xpammount;
		 //Bukkit.broadcastMessage("NevXP: "+xp);
			 if(xp<neededxp) {
				 //Bukkit.broadcastMessage("Pøidávám XP "+xpammount);
				 setXP(p, xp);
				 return;
			 }
			 if(xp>=neededxp) {
				 //Bukkit.broadcastMessage("Pøidávám LEVEL ");
				 level = level+1;
				 setlevel(p, level);
				 annoucment(p, level);
				 return;
			 }
	 }
	 public static void annoucment(Player p, int level) {
		 if(Loader.config.getBoolean("Options.LevelReach.MessageEnabled")==true) {
			 List<String> ReportP = Loader.config.getStringList("Options.LevelReach.Message");
	 		 for(String tend: ReportP) {
	 		 Loader.msg(tend.replace("%prefix%", Loader.s("Prefix")).replace("%level%", ""+level), p);
	 		 }
		 }
		 if(Loader.config.getBoolean("Options.LevelReach.SoundEnabled")==true) {
			 String sound = Loader.config.getString("Options.LevelReach.Sound").toUpperCase();
			 p.playSound(p.getLocation(), Sound.valueOf(sound), 5, 1);
		 }
	 }
}