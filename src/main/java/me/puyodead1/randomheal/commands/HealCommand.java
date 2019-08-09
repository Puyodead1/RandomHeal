package me.puyodead1.randomheal.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.puyodead1.randomheal.RandomHeal;
import me.puyodead1.randomheal.utils.Methods;

public class HealCommand implements CommandExecutor {
	
	private FileConfiguration config = RandomHeal.getInstance().getConfig();
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player player = sender instanceof Player ? (Player) sender : null;
		if(player != null) {
			final int l = args.length;
			if(l == 0) {
				// Player executed /heal
				if(player.hasPermission("randomheal.heal")) {
					// Player has permission so heal them
					player.setHealth(player.getMaxHealth());
					
					Methods.sendPlayerMessage(player, config.getString("messages.self healed"));
				} else {
					Methods.sendPlayerMessage(player, config.getString("messages.no permission"));
				}
			} else if(l == 1) {
				// player executed /heal <player>
				if(player.hasPermission("randomheal.heal.others")) {
					// Player has permission to heal other players
					final Player op = Bukkit.getServer().getPlayer(args[0]) != null ? Bukkit.getServer().getPlayer(args[0]) : null;
					if(op != null) {
						// the player exists and is online, heal them
						// TODO: heal op

						op.setHealth(player.getMaxHealth());
						
						Methods.sendPlayerMessage(player, config.getString("messages.other healed").replace("{PLAYER_NAME}", op.getName()).replace("{PLAYER_DISPLAYNAME}", player.getDisplayName()));
						if(config.getBoolean("settings.tell other player they were healed")) {
							Methods.sendPlayerMessage(op, config.getString("messages.other healed by").replace("{HEALED_BY_PLAYER_NAME}", player.getName()).replace("{HEALED_BY_PLAYER_DISPLAYNAME}", player.getDisplayName()));
						}
					}
				} else {
					Methods.sendPlayerMessage(player, config.getString("messages.no permission"));
				}
			}
		}
		return false;
	}
}
