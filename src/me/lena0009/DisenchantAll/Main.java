package me.lena0009.DisenchantAll;

import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.vk2gpz.tokenenchant.api.CEHandler;
import com.vk2gpz.tokenenchant.api.TokenEnchantAPI;

public class Main extends JavaPlugin {
	TokenEnchantAPI teAPI = TokenEnchantAPI.getInstance();
	
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("disenchantall")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Only players can disenchant.");
				return true;
			}
			Player player = (Player) sender;
			for (ItemStack item : player.getInventory().getContents()) {
				System.out.println(teAPI.getEnchantments(item));
				Map<CEHandler, Integer> enchants = teAPI.getEnchantments(item);
				for (Map.Entry<CEHandler, Integer> enchant : enchants.entrySet()) {
					sender.sendMessage(enchant.getKey().getDisplayName() + "'s calculated cost for " + enchant.getKey().getRefundRate()*enchant.getValue() + " levels");
				}
			}
			return true;
		}
		return false;
	}

}
