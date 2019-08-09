package me.puyodead1.randomheal.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.puyodead1.randomheal.RandomHeal;
import me.puyodead1.randomheal.utils.Methods;

public class RandomHealCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player player = sender instanceof Player ? (Player) sender : null;
		if (player != null) {
			if (player.hasPermission("randomheal.info")) {
				Methods.sendPlayerMessage(player,
						Arrays.asList("&d---------------------------", "&bAuthor: &ePuyodead1",
								"&bRandomHeal Version: &e" + RandomHeal.getInstance().getDescription().getVersion(),
								"&bServer Version: &e" + Bukkit.getVersion(), "&bCommands:",
								"&b  &e- /heal - Heal the current player",
								"&b  &e- /heal <player> - Heal the specified player", "&d---------------------------"));
				return true;
			} else {
				Methods.sendPlayerMessage(player, RandomHeal.getInstance().getConfig().getString("messages.no permission"));
				return false;
			}
		}
		return false;
	}
}
