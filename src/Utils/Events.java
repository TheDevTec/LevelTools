package Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Events implements Listener {
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block block = e.getBlock();
		Material material = block.getType();
		Material item = p.getInventory().getItemInMainHand().getType();
		
		
		if(item == Material.WOODEN_SHOVEL||item == Material.STONE_SHOVEL||item == Material.IRON_SHOVEL||item == Material.GOLDEN_SHOVEL||
				item == Material.DIAMOND_SHOVEL) {
				ToolUtil.getToolXP(p, item, material);
		}
		if (item == Material.WOODEN_PICKAXE||item == Material.STONE_PICKAXE||item == Material.IRON_PICKAXE||item == Material.GOLDEN_PICKAXE||
				item== Material.DIAMOND_PICKAXE) {
				//LevelingUtil.addXp(p, 1);
				ToolUtil.getToolXP(p, item, material);
		}
		if (item == Material.WOODEN_AXE||item == Material.STONE_AXE||item == Material.IRON_AXE||item== Material.GOLDEN_AXE||
				item == Material.DIAMOND_AXE) {
				ToolUtil.getToolXP(p, item, material);
		}
	}
}
