package net.atlas.SkyblockSandbox.util;

import net.atlas.SkyblockSandbox.item.SBItemStack;
import net.atlas.SkyblockSandbox.player.SBPlayer;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class NBTUtil {

    public static HashMap<SBPlayer.PlayerStat, Double> getAllStats(SBPlayer p) {
        HashMap<SBPlayer.PlayerStat, Double> statMap = new HashMap<>();
        for (SBPlayer.PlayerStat s : SBPlayer.PlayerStat.values()) {
            double tempStat = s.getBase();
            for (ItemStack i : p.getInventory().getArmorContents()) {
                if (i != null && i.hasItemMeta()) {
                    tempStat += new SBItemStack(i).getStat(s);
                }
            }
            tempStat += new SBItemStack(p.getItemInHand()).getStat(s);
            statMap.put(s, tempStat);
        }
        return statMap;
    }


    public static String getString(ItemStack item, String key) {
        if (item != null) {
            if (item.hasItemMeta()) {
                net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
                NBTTagCompound tag = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
                NBTTagCompound data = tag.getCompound("ExtraAttributes");
                if (data == null) {
                    data = new NBTTagCompound();
                }

                return data.getString(key);
            }
        }
        return "";
    }

    public static ItemStack setGenericString(ItemStack item, String key, String value) {
        if (item != null) {
            if (item.hasItemMeta()) {
                net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
                NBTTagCompound tag = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
                tag.setString(key, value);
                nmsItem.setTag(tag);

                return CraftItemStack.asBukkitCopy(nmsItem);
            }
        }
        return item;
    }

    public static String getGenericString(ItemStack item, String key) {
        if (item != null) {
            if (item.hasItemMeta()) {
                net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
                NBTTagCompound tag = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();

                return tag.getString(key);
            }
        }
        return "";
    }

    public static Integer getInteger(ItemStack item, String key) {
        if (item != null) {
            if (item.hasItemMeta()) {
                net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
                NBTTagCompound tag = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
                NBTTagCompound data = tag.getCompound("ExtraAttributes");
                if (data == null) {
                    data = new NBTTagCompound();
                }

                return data.getInt(key);
            }
        }
        return 0;
    }

    public ItemStack setInteger(ItemStack stack, int v, String key) {
        if (stack != null) {
            if (stack.hasItemMeta()) {
                net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(stack);
                NBTTagCompound tag = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
                NBTTagCompound data = tag.getCompound("ExtraAttributes");
                if (data == null) {
                    data = new NBTTagCompound();
                }

                data.setInt(key, v);
                tag.set("ExtraAttributes", data);
                nmsItem.setTag(tag);
                return CraftItemStack.asBukkitCopy(nmsItem);

            }
        }
        return null;
    }

    public static ItemStack setString(ItemStack stack, String msg, String key) {
        if (stack != null) {
            if (stack.hasItemMeta()) {
                net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(stack);
                NBTTagCompound tag = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
                NBTTagCompound data = tag.getCompound("ExtraAttributes");
                if (data == null) {
                    data = new NBTTagCompound();
                }

                data.setString(key, msg);
                tag.set("ExtraAttributes", data);
                nmsItem.setTag(tag);
                return CraftItemStack.asBukkitCopy(nmsItem);
            }
        }
        return stack;
    }
}
