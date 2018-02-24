package io.jerry.dungeon;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import me.baks.PartySystem.PartySystem;
import me.baks.PartySystem.PlayerList;
import org.bukkit.entity.Player;

import java.util.concurrent.ExecutionException;

public enum PartySystemHelper {

    INSTANCE;

    private final Cache<String, Party> all = CacheBuilder.newBuilder()
            .weakValues()
            .build();

    public static Party findParty(Player p) {
        String leader = PartySystem.partyLeader.get(p.getName());
        if (!(leader == null)) {
            try {
                return INSTANCE.all.get(leader, () -> {
                    Party party = new Party();
                    party.owner = leader;
                    party.list = PlayerList.getByLeader(leader).getPlayers();
                    return party;
                });
            } catch (ExecutionException ignored) {
            }
        }
        return null;
    }
}
