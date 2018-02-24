package io.jerry.dungeon;

import io.jerry.dungeon.command.PartyC;
import me.baks.PartySystem.Commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MixedPartyHandler implements CommandExecutor {

    private final PartyC partyc = new PartyC();
    private final Commands commands = new Commands();

    @Override
    public boolean onCommand(CommandSender who, Command command, String label, String[] input) {
        if (input.length == 1 && input[0].equalsIgnoreCase("play")) {
            return partyc.onCommand(who, command, label, input);
        }
        return commands.onCommand(who, command, label, input);
    }
}
