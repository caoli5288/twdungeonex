package io.jerry.dungeon.util;

import io.jerry.dungeon.Main;
import io.jerry.dungeon.Party;
import io.jerry.dungeon.PartySystemHelper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PartyUtil {
    public static List<Party> list = new ArrayList<>();

    public static Party getTeam(Player p) {
        if (Main.isUseExtPartyProvider()) {
            return PartySystemHelper.findParty(p);
        }
        for (Party py : list) {
            if (py.list.contains(p.getName())) {
                return py;
            }
        }
        return null;
    }

    public static void sendMessage(List<String> list, String... msg) {
        Player p;
        for (String str : list) {
            p = Bukkit.getPlayer(str);
            if (p == null) {
                continue;
            }
            for (String msg2 : msg) {
                p.sendMessage("§3Party> §f" + msg2);
            }
            p.playSound(p.getLocation(), "note.pling", 1, 1);
        }
    }
}
