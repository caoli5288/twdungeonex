package io.jerry.dungeon.command;

import com.google.common.collect.Lists;
import io.jerry.dungeon.MobLocation;
import io.jerry.dungeon.util.ChatUtil;
import io.jerry.dungeon.util.ConfigUtil;
import io.jerry.dungeon.util.GameUtil;
import io.jerry.dungeon.util.GuiUtil;
import io.jerry.dungeon.util.TitleApi;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandSpec implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if((sender.isOp() && sender instanceof Player) == false){
			return false;
		}

		Player p = (Player)sender;
		if(args.length == 2){
			if(args[0].equalsIgnoreCase("Create")){
				if(ConfigUtil.hasGame(args[1])){
					p.sendMessage("§3Dun> §f已經有此副本");
					return true;
				}

				ConfigUtil.createGame(args[1]);
				GameUtil.selectGame(p, args[1]);
				p.sendMessage("§3Dun> §f成功增設");
				return true;
			}


			if(args[0].equalsIgnoreCase("Delete")){
				if(ConfigUtil.hasGame(args[1]) ==  false){
					p.sendMessage("§3Dun> §f沒有此副本");
					return true;
				}

				ConfigUtil.deleteGame(args[1]);
				p.sendMessage("§3Dun> §f已刪除副本設定檔");
				return true;
			}

			if(args[0].equalsIgnoreCase("Select")){
				if(ConfigUtil.hasGame(args[1]) ==  false){
					p.sendMessage("§3Dun> §f沒有此副本");
					return true;
				}

				GameUtil.selectGame(p, args[1]);
				p.sendMessage("§3Dun> §f已選擇副本");
				return true;
			}

			if(args[0].equalsIgnoreCase("delMob")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("§3Dun> §f請使用指令/Dun select <副本> 選擇需要設定的副本");
					return true;
				}

				try{
					List<String> list = ConfigUtil.getSpawn_EntityList(name);
					if(list == null){
						p.sendMessage("§3Dun> §f列表為空的");
						return true;
					}

					list.remove(Integer.parseInt(args[1]));
					ConfigUtil.setSpawn_EntityList(name,list);
				}catch(Exception ex){
					p.sendMessage("§3Dun> §f設置錯誤");
				}
				return true;
			}
		}


		if(args.length == 1){
			if(args[0].equalsIgnoreCase("Join")){
				ChatUtil.setJoin(p);
				return true;
			}else if(args[0].equalsIgnoreCase("Quit")){
				ChatUtil.setQuit(p);
				return true;
			}else if(args[0].equalsIgnoreCase("Set")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("§3Dun> §f請使用指令/Dun select <副本> 選擇需要設定的副本");
					return true;
				}
				p.openInventory(GuiUtil.getOptionsGui(name));
				return true;
			}else if(args[0].equalsIgnoreCase("listMob")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("§3Dun> §f請使用指令/Dun select <副本> 選擇需要設定的副本");
					return true;
				}

				List<String> list = ConfigUtil.getSpawn_EntityList(name);
				if(list == null){
					p.sendMessage("§3Dun> §f列表為空的");
					return true;
				}

				MobLocation mobLocation;
				Location location;
				for(String str : list){
					mobLocation = new MobLocation(str,p.getWorld());
					location = mobLocation.getLocation();
					p.sendMessage(" - " + location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ() + " | " + mobLocation.getMob());
				}
				return true;
			}else if(args[0].equalsIgnoreCase("listMob")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("§3Dun> §f請使用指令/Dun select <副本> 選擇需要設定的副本");
					return true;
				}


			}else if(args[0].equalsIgnoreCase("2")){
				p.sendMessage("§3Dun> §f設定指令");
				help(p,helplist2);
				p.sendMessage("§3請打/Dun <頁數> 查詢");
				return true;
			}else if(args[0].equalsIgnoreCase("3")){
				p.sendMessage("§3Dun> §f怪物指令");
				help(p,helplist3);
				p.sendMessage("§3請打/Dun <頁數> 查詢");
				return true;
			}

		}

		if(args.length == 4){
			if(args[0].equalsIgnoreCase("SetSpawn")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("§3Dun> §f請使用指令/Dun select <副本> 選擇需要設定的副本");
					return true;
				}

				try{
					ConfigUtil.setSpawn_SpawnPoint(name,
							Integer.parseInt(args[1]),
							Integer.parseInt(args[2]),
							Integer.parseInt(args[3]));
					p.sendMessage("§3Dun> §f已設定出生點");
				}catch(Exception ex){
					p.sendMessage("§3Dun> §f設置錯誤");
				}
				return true;
			}
		}

		if(args.length == 5){
			if(args[0].equalsIgnoreCase("addMob")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("§3Dun> §f請使用指令/Dun select <副本> 選擇需要設定的副本");
					return true;
				}

				try{
					String str =
							Integer.parseInt(args[2]) + "," +
									Integer.parseInt(args[3]) + "," +
									Integer.parseInt(args[4]) + "," +
									args[1];

					List<String> list = ConfigUtil.getSpawn_EntityList(name);
					list = list == null ? Lists.newArrayList() : list;
					list.add(str);
					ConfigUtil.setSpawn_EntityList(name, list);
					p.sendMessage("§3Dun> §f已新增怪物");
				}catch(Exception ex){
					p.sendMessage("§3Dun> §f設置錯誤");
				}
				return true;
			}
		}


		p.sendMessage("§3Dun> §f基本指令");
		help(p,helplist1);
		p.sendMessage("§3請打/Dun <頁數> 查詢");
		return true;
	}

	public static String[] helplist1 = {
			"/Dun §7Create <副本>","/Dun Create <副本>","創建副本設定檔",
			"/Dun §7Delete <副本>","/Dun Delete <副本>","刪除副本設定檔",
			"/Dun §7select <副本>","/Dun select <副本>","選擇副本"};

	public static String[] helplist2 = {
			"/Dun §7Join ","/Dun Join ","設定進入觸發",
			"/Dun §7Quit","/Dun Quit","設定結束觸發",
			"/Dun §7Set","/Dun Set","設定副本許可權",
			"/Dun §7setspawn <x> <y> <z>","/Dun setspawn <x> <y> <z>","設定出生點"};

	public static String[] helplist3 = {
			"/Dun §7addMob <怪物名稱> <x> <y> <z>","/Dun addMob <x> <y> <z>","新增怪物",
			"/Dun §7delMob <行>","/Dun delMob <行>","移除生成怪物列表的第幾行",
			"/Dun §7listMob","/Dun listMob","查看生成怪物列表"};


	public void help(Player p, String[] list){
		for(int i = 0; i + 2 < list.length; i = i +3){
			TitleApi.sendAction("{\"text\":\"" + list[i] + "\","
					+ "\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + list[i+1] + "\"},"
					+ "\"hoverEvent\":{\"action\":\"show_text\",\"value\":\""
					+ list[i+2]
					+ "\n點擊以查看指令"
					+ "\"}}", p);
		}
	}
}
