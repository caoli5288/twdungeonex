package io.jerry.dungeon;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Party {
	public List<String> list = new ArrayList<>();
	public String owner;
	public List<String> addList = new ArrayList<>();

	public boolean isOwner(Player p){
		return owner.equals(p.getName());
	}
	
	public boolean isMember(String s){
		return list.contains(s);
	}
	
	public void remove(String s) {
		list.remove(s);
	}
	
	public int size(){
		return list.size();
	}
}
