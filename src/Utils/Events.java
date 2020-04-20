package Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Events implements Listener {

	public void onBreak(BlockBreakEvent e) {
		Block block = e.getBlock();
		Material material = block.getType();
		Player p = e.getPlayer();
		
		if (p.getInventory().getItemInMainHand().getType() == Material.WOODEN_SHOVEL) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.STONE_SHOVEL) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.IRON_SHOVEL) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SHOVEL) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		}
		
		if (p.getInventory().getItemInMainHand().getType() == Material.WOODEN_PICKAXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.STONE_PICKAXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.IRON_PICKAXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_PICKAXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		}
		
		if (p.getInventory().getItemInMainHand().getType() == Material.WOODEN_AXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.STONE_AXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.IRON_AXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		} else if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE) {
			if (material.equals(block.getType())) {
				Utils.LevelingUtil.getToolXP(p);
			}
		}
	}
}
