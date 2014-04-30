package me.stopbox123.events;

import java.util.ArrayList;
import java.util.HashMap;

import me.stopbox123.pvp.KitPvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Events implements Listener {
	
	private ArrayList<String> KitPvpers = new ArrayList<String>();
	private HashMap<String, ItemStack[]> inv = new HashMap<String, ItemStack[]>();
	private HashMap<String, ItemStack[]> armor = new HashMap<String, ItemStack[]>();
	private HashMap<String, Double> health = new HashMap<String, Double>();
	private HashMap<String, Integer> hunger = new HashMap<String, Integer>();
	private HashMap<String, Float> sat = new HashMap<String, Float>();
	private HashMap<String, Integer> levels = new HashMap<String, Integer>();
	private HashMap<String, Float> exp = new HashMap<String, Float>();
	private HashMap<String, Location> loc = new HashMap<String, Location>();
	private KitPvp kit;
	
	public Events(KitPvp kit) {
		this.kit = kit;
	}
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onClickArcher(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		if (!(e instanceof InventoryCreativeEvent) && !(e.getInventory() == p.getInventory()) && !KitPvpers.contains(p.getName()) && e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + " ===== " + ChatColor.GOLD + "Class: " + ChatColor.AQUA + "Archer" + ChatColor.GRAY +  " ===== ")) {
			e.setCancelled(true);
			p.closeInventory();
			KitPvpers.add(p.getName());
			inv.put(p.getName(), p.getInventory().getContents());
			armor.put(p.getName(), p.getInventory().getArmorContents());
			health.put(p.getName(), p.getHealth());
			hunger.put(p.getName(), p.getFoodLevel());
			sat.put(p.getName(), p.getSaturation());
			levels.put(p.getName(), p.getLevel());
			exp.put(p.getName(), p.getExp());
			loc.put(p.getName(), p.getLocation());
			for (PotionEffect pot : p.getActivePotionEffects()) { p.removePotionEffect(pot.getType()); }
			p.setHealth(20.0);
			p.setFoodLevel(20);
			p.setSaturation(200.0F);
			p.setLevel(0);
			p.setExp(0.0F);
			p.getInventory().clear();
			ItemStack hel = new ItemStack(Material.LEATHER_HELMET, 1);
			hel.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack che = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			che.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack leg = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			leg.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack boo = new ItemStack(Material.LEATHER_BOOTS, 1);
			boo.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack arrows = new ItemStack(Material.ARROW, 128);
			ItemStack bow = new ItemStack(Material.BOW, 1);
			bow.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
			p.getInventory().setHelmet(hel);
			p.getInventory().setChestplate(che);
			p.getInventory().setLeggings(leg);
			p.getInventory().setBoots(boo);
			p.getInventory().addItem(sword);
			p.getInventory().addItem(bow);
			p.getInventory().addItem(arrows);
		} else if (KitPvpers.contains(p.getName()) && !(e.getInventory() == p.getInventory())) {
			e.setCancelled(true);
			p.closeInventory();
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onClickArcherPlus(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		if (!(e instanceof InventoryCreativeEvent) && !(e.getInventory() == p.getInventory()) && !KitPvpers.contains(p.getName()) && e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + " ===== " + ChatColor.GOLD + "Class: " + ChatColor.AQUA + "Archer++" + ChatColor.GRAY +  " ===== ")) {
			e.setCancelled(true);
			p.closeInventory();
			KitPvpers.add(p.getName());
			inv.put(p.getName(), p.getInventory().getContents());
			armor.put(p.getName(), p.getInventory().getArmorContents());
			health.put(p.getName(), p.getHealth());
			hunger.put(p.getName(), p.getFoodLevel());
			sat.put(p.getName(), p.getSaturation());
			levels.put(p.getName(), p.getLevel());
			exp.put(p.getName(), p.getExp());
			loc.put(p.getName(), p.getLocation());
			for (PotionEffect pot : p.getActivePotionEffects()) { p.removePotionEffect(pot.getType()); }
			p.setHealth(20.0);
			p.setFoodLevel(20);
			p.setSaturation(200.0F);
			p.setLevel(0);
			p.setExp(0.0F);
			p.getInventory().clear();
			ItemStack hel = new ItemStack(Material.LEATHER_HELMET, 1);
			hel.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack che = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			che.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack leg = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			leg.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack boo = new ItemStack(Material.LEATHER_BOOTS, 1);
			boo.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			ItemStack arrows = new ItemStack(Material.ARROW, 1);
			ItemStack bow = new ItemStack(Material.BOW, 1);
			bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 3);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			bow.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
			p.getInventory().setHelmet(hel);
			p.getInventory().setChestplate(che);
			p.getInventory().setLeggings(leg);
			p.getInventory().setBoots(boo);
			p.getInventory().addItem(bow);
			p.getInventory().addItem(arrows);
		} else if (KitPvpers.contains(p.getName()) && !(e.getInventory() == p.getInventory())) {
			e.setCancelled(true);
			p.closeInventory();
		}
	}

	@EventHandler
	public void onHit(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (KitPvpers.contains(p.getName())) {
				if (e.getDamage() >= p.getHealth()) {
					callDeath(p);
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onDrop(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GRAY + " ===== " + ChatColor.GOLD + "Class: " + ChatColor.AQUA + "Archer" + ChatColor.GRAY +  " ===== ")) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDisable(PluginDisableEvent e) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (KitPvpers.contains(p.getName())) {
				callDeath(p);
			}
		}
	}
	
	private void callDeath(Player p) {
		KitPvpers.remove(p.getName());
		p.getInventory().setContents(inv.get(p.getName()));
		inv.remove(p.getName());
		p.getInventory().setArmorContents(armor.get(p.getName()));
		armor.remove(p.getName());
		p.setHealth(health.get(p.getName()));
		health.remove(p.getName());
		p.setFoodLevel(hunger.get(p.getName()));
		hunger.remove(p.getName());
		p.setSaturation(sat.get(p.getName()));
		sat.remove(p.getName());
		p.setLevel(levels.get(p.getName()));
		levels.remove(p.getName());
		p.setExp(exp.get(p.getName()));
		exp.remove(p.getName());
		p.teleport(loc.get(p.getName()));
		loc.remove(p.getName());
	}
}
