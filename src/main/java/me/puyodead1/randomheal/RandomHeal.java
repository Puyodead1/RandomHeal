package me.puyodead1.randomheal;

import org.bukkit.plugin.java.JavaPlugin;

import me.puyodead1.randomheal.commands.HealCommand;
import me.puyodead1.randomheal.commands.RandomHealCommand;
import me.puyodead1.randomheal.utils.Methods;

public class RandomHeal extends JavaPlugin {

	private static RandomHeal INSTANCE;
	public static String PREFIX = "&d[&bRandomHeal&d] &r";

	public static RandomHeal getInstance() {
		return INSTANCE;
	}

	@Override
	public void onEnable() {
		final long STARTED = System.currentTimeMillis();
		Methods.sendConsole(PREFIX + "&bRandomHeal Version &e" + this.getDescription().getVersion() + " &bby &dPuyodead1&b!");
		INSTANCE = this;
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("randomheal").setExecutor(new RandomHealCommand());
		Methods.sendConsole(PREFIX + "&bInitalized in &e" + (System.currentTimeMillis() - STARTED) + "ms.");
	}

	@Override
	public void onDisable() {
	}
}
