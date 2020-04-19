package Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Events implements Listener {

	@SuppressWarnings("unlikely-arg-type")
	public void onBreak(BlockBreakEvent e) {
		Block block = e.getBlock();
		Material material = block.getType();
		Player p = e.getPlayer();
		
		if (p.getInventory().getItemInMainHand().getType() == Material.WOODEN_SHOVEL) {
			if (material.equals(block)) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.STONE_SHOVEL) {
			if (material.equals(block)) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL) {
			if (material.equals(block)) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SHOVEL) {
			if (material.equals(block)) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL) {
			if (material.equals(block)) {
				Utils.LevelingUtil.getToolXP(p);
			}
		}
	}
	
}
