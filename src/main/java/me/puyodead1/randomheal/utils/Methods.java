package me.puyodead1.randomheal.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Methods {

	public static String formatString(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static void sendConsole(String text) {
		Bukkit.getConsoleSender().sendMessage(formatString(text));
	}
	
	public static void sendPlayerMessage(Player player, String text) {
		player.sendMessage(formatString(text));
	}
	
	public static void sendPlayerMessage(Player player, List<String> list) {
		for(String s : list) {
			player.sendMessage(formatString(s));
		}
	}
}
