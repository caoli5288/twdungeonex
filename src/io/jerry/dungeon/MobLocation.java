package io.jerry.dungeon;

import org.bukkit.Location;
import org.bukkit.World;

public class MobLocation {
    private Location location;
    private String mob;

    public MobLocation(String input, World w) {
        String[] str = input.split(",");
        location = new Location(w, Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        mob = str[3];
    }

    public Location getLocation() {
        return location;
    }

    public String getMob() {
        return mob;
    }
}