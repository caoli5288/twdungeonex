package io.jerry.dungeon.handler;

import io.jerry.dungeon.util.ConfigUtil;
import io.jerry.dungeon.util.GameUtil;
import io.jerry.dungeon.util.I18n;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class CaseHandler {

	@SuppressWarnings("deprecation")
	public static void clickJoinBlock(PlayerInteractEvent e) {
		Block b = e.getClickedBlock();
		if(b == null){
			return;
		}
		Location bloc = b.getLocation();
		String loc2 = bloc.getWorld().getName() + "," + bloc.getBlockX() + "," + bloc.getBlockY() + "," + bloc.getBlockZ();
		Player p = e.getPlayer();

		for(String str : ConfigUtil.getGame()){
			String loc = ConfigUtil.getJoin_ClickBlock(str);
			if(loc != null && loc.equalsIgnoreCase(loc2) == false){
				continue;
			}

			ItemStack item = ConfigUtil.getJoin_ClickBlock_useItem(str);
			if(item != null && !item.equals(e.getPlayer().getItemInHand())){
				continue;
			}

			if(loc == null && item == null){
				continue;
			}

			double startTime = System.currentTimeMillis();

			GameUtil.startGame(str, p);

			double endTime = System.currentTimeMillis();
			double totalTime = endTime - startTime;
			totalTime = totalTime/1000;
			p.sendMessage("§3Dun> §f" + I18n.t("CaseHandler.Time",totalTime));

		}

	}

	public static void clickJoinEntity(PlayerInteractEntityEvent e) {
		Entity E = e.getRightClicked();
		if(E == null){
			return;
		}
		String Ename = E.getCustomName();
		Player p = e.getPlayer();

		for(String str : ConfigUtil.getGame()){
			String name = ConfigUtil.getJoin_ClickEntity(str);
			if(name == null || Ename == null || !Ename.equals(name)){
				continue;
			}

			double startTime = System.currentTimeMillis();

			GameUtil.startGame(str, p);

			double endTime = System.currentTimeMillis();
			double totalTime = endTime - startTime;
			totalTime = totalTime/1000;
			p.sendMessage("§3Dun> §f" + I18n.t("CaseHandler.Time",totalTime));

		}

	}

	public static void joinToLocation(PlayerMoveEvent e) {
		Location to = e.getTo();
		String toLoc = to.getWorld().getName() + "," + to.getBlockX() + "," + to.getBlockY() + "," + to.getBlockZ();
		Player p = e.getPlayer();

		for(String str : ConfigUtil.getGame()){
			String name = ConfigUtil.getJoin_ToLocation(str);
			if(name == null || !toLoc.equals(name)){
				continue;
			}

			double startTime = System.currentTimeMillis();

			GameUtil.startGame(str, p);

			double endTime = System.currentTimeMillis();
			double totalTime = endTime - startTime;
			totalTime = totalTime/1000;
			p.sendMessage("§3Dun> §f" + I18n.t("CaseHandler.Time",totalTime));

		}

	}
}
