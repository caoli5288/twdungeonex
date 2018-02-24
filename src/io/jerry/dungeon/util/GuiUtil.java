package io.jerry.dungeon.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuiUtil {
	private static List<Feel> itemFeelList = new ArrayList<Feel>();
	
	static{
		itemFeelList.add(new Feel("Animal",Material.MONSTER_EGG,I18n.t("GuiUtil.Button.Animal")));
		itemFeelList.add(new Feel("AnimalDamage",Material.RAW_CHICKEN,I18n.t("GuiUtil.Button.AnimalDamage")));
		itemFeelList.add(new Feel("Build",Material.BRICK,I18n.t("GuiUtil.Button.Build")));
		itemFeelList.add(new Feel("Click",Material.WOOD_BUTTON,I18n.t("GuiUtil.Button.Click")));
		itemFeelList.add(new Feel("Container",Material.STORAGE_MINECART,I18n.t("GuiUtil.Button.Container")));
		itemFeelList.add(new Feel("Destroy",Material.ENDER_STONE,I18n.t("GuiUtil.Button.Destroy")));
		itemFeelList.add(new Feel("Damage",Material.LEATHER_CHESTPLATE,I18n.t("GuiUtil.Button.Damage")));
		itemFeelList.add(new Feel("Explode",Material.TNT,I18n.t("GuiUtil.Button.Explode")));
		itemFeelList.add(new Feel("Fall",Material.LEATHER_BOOTS,I18n.t("GuiUtil.Button.Fall")));
		itemFeelList.add(new Feel("Healing",Material.POTION,I18n.t("GuiUtil.Button.Healing")));
		itemFeelList.add(new Feel("Inventory",Material.ENDER_PORTAL_FRAME,I18n.t("GuiUtil.Button.Inventory")));
		itemFeelList.add(new Feel("MobDamage",Material.ROTTEN_FLESH,I18n.t("GuiUtil.Button.MobDamage")));
		itemFeelList.add(new Feel("MobSpawn",Material.MOB_SPAWNER,I18n.t("GuiUtil.Button.MobSpawn")));
		itemFeelList.add(new Feel("Physical",Material.TRIPWIRE_HOOK,I18n.t("GuiUtil.Button.Physical")));
		itemFeelList.add(new Feel("PickUp",Material.APPLE,I18n.t("GuiUtil.Button.PickUp")));
		itemFeelList.add(new Feel("PvP",Material.WOOD_SWORD,I18n.t("GuiUtil.Button.PvP")));
		itemFeelList.add(new Feel("Respawn",Material.BED,I18n.t("GuiUtil.Button.Respawn")));
		itemFeelList.add(new Feel("Trample",Material.DIRT,I18n.t("GuiUtil.Button.Trample")));
	}
	
	private static class Feel{
		public Material m;
		public String l;
		public String n;
		
		public Feel(String name,Material m, String l){
			this.m = m;
			this.l = l;
			this.n = name;
		}
	}

	public static Inventory getOptionsGui(String name){
		Inventory inv = Bukkit.createInventory(null, 18, "副本許可權");
		for(Feel f : itemFeelList){
			inv.addItem(getItem(name,f));
		}
		return inv;
	}

	private static ItemStack getItem(String name,Feel f){
		boolean b = ConfigUtil.getOptions(name,f.n);

		ItemStack item = new ItemStack(f.m);
		ItemMeta im = item.getItemMeta();
		im.setDisplayName("§a" + f.n);
		im.setLore(Arrays.asList("§e" + I18n.t("GuiUtil.Info.State", (b ? "§a" + I18n.t("GuiUtil.Info.True") : "§c" + I18n.t("GuiUtil.Info.False"))),
				"§e" + f.l,
				"§2" + I18n.t("GuiUtil.Info.LeftClick"),
				"§c" + I18n.t("GuiUtil.Info.RightClick")));
		if(b){
			im.getItemFlags().add(ItemFlag.HIDE_ENCHANTS);
			im.addEnchant(Enchantment.LUCK, 1,true);
		}
		item.setItemMeta(im);


		return item;
	}

}
