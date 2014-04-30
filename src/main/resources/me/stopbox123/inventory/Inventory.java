package me.stopbox123.inventory;

import net.minecraft.server.v1_7_R1.NBTTagCompound;
import net.minecraft.server.v1_7_R1.NBTTagList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventory {
	
	public static final org.bukkit.inventory.Inventory KitInventory = Bukkit.getServer().createInventory(null, 9*2, "Kit Selection");
	
	public static void Init() {
		ItemStack archer1 = new ItemStack(Material.BOW, 1);
		ItemMeta archer1m = getMeta(archer1);
		archer1m.setDisplayName(ChatColor.GRAY + " ===== " + ChatColor.GOLD + "Class: " + ChatColor.AQUA + "Archer" + ChatColor.GRAY +  " ===== ");
		archer1.setItemMeta(archer1m);
		KitInventory.addItem(archer1);
		ItemStack archer2 = new ItemStack(Material.BOW, 1);
		ItemMeta archer2m = getMeta(archer2);
		archer2m.setDisplayName(ChatColor.GRAY + " ===== " + ChatColor.GOLD + "Class: " + ChatColor.AQUA + "Archer++" + ChatColor.GRAY +  " ===== ");
		archer2.setItemMeta(archer2m);
		KitInventory.addItem(addGlow(archer2));
	}
	
	public static ItemMeta getMeta(ItemStack im) {
		return im.getItemMeta();
	}
	
    public static ItemStack addGlow(ItemStack item){ 
        net.minecraft.server.v1_7_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = null;
        if (!nmsStack.hasTag()) {
            tag = new NBTTagCompound();
            nmsStack.setTag(tag);
        }
        if (tag == null) tag = nmsStack.getTag();
        NBTTagList ench = new NBTTagList();
        tag.set("ench", ench);
        nmsStack.setTag(tag);
        return CraftItemStack.asCraftMirror(nmsStack);
    }
}
