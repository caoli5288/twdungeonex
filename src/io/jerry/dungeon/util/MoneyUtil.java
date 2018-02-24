package io.jerry.dungeon.util;

import io.jerry.dungeon.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

public class MoneyUtil {
	public static Economy economy;
	
	static{
		RegisteredServiceProvider<Economy> economyProvider = 
				Main.PL.getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
        	economy = economyProvider.getProvider();
        }
	}
	
	public static Economy getEconomy(){
		return economy;
	}
}
