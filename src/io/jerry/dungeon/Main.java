package io.jerry.dungeon;

import com.google.common.collect.Lists;
import io.jerry.dungeon.command.CommandSpec;
import io.jerry.dungeon.command.PartyC;
import io.jerry.dungeon.game.Game;
import io.jerry.dungeon.util.GameUtil;
import io.jerry.dungeon.util.I18n;
import io.jerry.dungeon.util.PartyUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends JavaPlugin{
    public static String Name;
    public static Plugin PL;
    public static FileConfiguration c;
    private static boolean useExtPartyProvider;

	public void onEnable(){
		PL = this;
		Name = this.getName();
		c = getConfig();
		c.options().copyDefaults(true);

        Plugin plugin = Bukkit.getPluginManager().getPlugin("PartySystem");
        if (!(plugin == null)) {
            useExtPartyProvider = true;
        }

        saveConfig();
		I18n.run();
		getCommand("dun").setExecutor(new CommandSpec());
		getCommand("party").setExecutor(useExtPartyProvider ? new MixedPartyHandler() : new PartyC());
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		if(c.getBoolean("ScoreBoard",true)){
			scoreboardEnable();
		}

		getLogger().info(I18n.t("Main.Done"));
	}

	public void scoreboardEnable(){
	    getServer().getScheduler().runTaskTimer(this, () -> {
            for(Player send : getOnlinePlayers()){
                Party u = PartyUtil.getTeam(send);
                if(u != null){
                    List<String> list = new ArrayList<String>();
                    String Title = "§3§l隊伍";
                    list.add("§3隊長:" + u.owner);
                    list.add("§3隊員:");
                    for(String Name : u.list){
                        list.add("§7" + Name);
                    }

                    Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
                    Objective objective = s.registerNewObjective(Title, "dummy");

                    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                    for(int i = 0; i < list.size(); i ++){
                        objective.getScore(list.get(i)).setScore(list.size() - i);
                    }
                    send.setScoreboard(s);
                }else{
                    Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
                    send.setScoreboard(s);
                }
            }
        }, 1, 10);
	}
	
	public static List<Player> getOnlinePlayers() {
	    List<Player> list = Lists.newArrayList();
	    for (World world : Bukkit.getWorlds()) {
	        list.addAll(world.getPlayers());
	    }
	    return Collections.unmodifiableList(list);
	}
	
	public void onDisable(){
		for(Game G : GameUtil.gameAll){
			G.stop();
		}
	}
	
	public static boolean isUseExtPartyProvider() {
		return useExtPartyProvider;
	}
}
