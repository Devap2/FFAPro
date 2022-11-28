package me.devap.ffapro.commands;

import me.devap.ffapro.FFAPro;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.net.CookieManager;

public class KitCMDS implements CommandExecutor {

    private final FFAPro plugin;

    public KitCMDS(FFAPro plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(sender != null) {
            if (command.getName().equalsIgnoreCase("kit")) {
                if(args.length == 0){

                    // Sending the player the kits information message.
                    p.sendMessage(ChatColor.GRAY + "Wrong usage, try: " + ChatColor.GOLD + "/kit beast" + ChatColor.GRAY + "or" + ChatColor.GOLD + "/kit speed" + ChatColor.GRAY + "etc...");
                }
                else {
                    if (args[0].equalsIgnoreCase("beast")) {

                        /* Item-stacks for the kits. */

                        /* BEAST KIT */
                        ItemStack swordBeast = new ItemStack(Material.DIAMOND_SWORD);
                        ItemStack helmetBeast = new ItemStack(Material.DIAMOND_HELMET);
                        ItemStack chestplateBeast = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        ItemStack leggingsBeast = new ItemStack(Material.DIAMOND_LEGGINGS);
                        ItemStack bootsBeast = new ItemStack(Material.DIAMOND_BOOTS);

                        //Adding the enchantments to the items for the kit 'beast'.
                        helmetBeast.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        chestplateBeast.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        leggingsBeast.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        bootsBeast.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

                        ItemStack foodBeast = new ItemStack(Material.COOKED_BEEF, 12);

                        p.getInventory().clear();
                        p.getInventory().setItem(0, swordBeast);
                        p.getInventory().setItem(1, foodBeast);

                        p.getInventory().setHelmet(helmetBeast);
                        p.getInventory().setChestplate(chestplateBeast);
                        p.getInventory().setLeggings(leggingsBeast);
                        p.getInventory().setBoots(bootsBeast);

                        p.setWalkSpeed(0.2f);
                        p.setHealth(20.0);
                        p.setFoodLevel(20);

                    }
                    else if(args[0].equalsIgnoreCase("speed")){

                        /* SPEED KIT */
                        ItemStack swordSpeed = new ItemStack(Material.IRON_SWORD);
                        ItemStack helmetSpeed = new ItemStack(Material.IRON_HELMET);
                        ItemStack chestplateSpeed = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        ItemStack leggingsSpeed = new ItemStack(Material.IRON_LEGGINGS);
                        ItemStack bootsSpeed = new ItemStack(Material.IRON_BOOTS);

                        //Adding the enchantments to the items for the kit 'speed'.
                        swordSpeed.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
                        chestplateSpeed.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        leggingsSpeed.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        bootsSpeed.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

                        ItemStack foodSpeed = new ItemStack(Material.COOKED_PORKCHOP, 12);

                        p.getInventory().clear();
                        p.getInventory().setItem(0, swordSpeed);
                        p.getInventory().setItem(1, foodSpeed);

                        p.getInventory().setHelmet(helmetSpeed);
                        p.getInventory().setChestplate(chestplateSpeed);
                        p.getInventory().setLeggings(leggingsSpeed);
                        p.getInventory().setBoots(bootsSpeed);

                        p.setWalkSpeed(0.3f);
                        p.setHealth(20.0);
                        p.setFoodLevel(20);

                    }
                    else if(args[0].equalsIgnoreCase("knocker")){

                        /* KNOCKER KIT */
                        ItemStack swordKnocker = new ItemStack(Material.STONE_SWORD);
                        ItemStack helmetKnocker = new ItemStack(Material.CHAINMAIL_HELMET);
                        ItemStack chestplateKnocker = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemStack leggingsKnocker = new ItemStack(Material.DIAMOND_LEGGINGS);
                        ItemStack bootsKnocker = new ItemStack(Material.IRON_BOOTS);

                        //Adding the enchantments to the items for the kit 'knocker'.
                        swordKnocker.addEnchantment(Enchantment.KNOCKBACK, 2);
                        helmetKnocker.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        chestplateKnocker.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        leggingsKnocker.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        bootsKnocker.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

                        ItemStack foodKnocker = new ItemStack(Material.GOLDEN_CARROT, 12);

                        p.getInventory().clear();
                        p.getInventory().setItem(0, swordKnocker);
                        p.getInventory().setItem(1, foodKnocker);

                        p.getInventory().setHelmet(helmetKnocker);
                        p.getInventory().setChestplate(chestplateKnocker);
                        p.getInventory().setLeggings(leggingsKnocker);
                        p.getInventory().setBoots(bootsKnocker);

                        p.setWalkSpeed(0.2f);
                        p.setHealth(20.0);
                        p.setFoodLevel(20);

                    }
                    else if(args[0].equalsIgnoreCase("axe")){

                        /* AXE KIT */
                        ItemStack axeAxe = new ItemStack(Material.DIAMOND_AXE);
                        ItemStack helmetAxe = new ItemStack(Material.CHAINMAIL_HELMET);
                        ItemStack chestplateAxe = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemStack leggingsAxe = new ItemStack(Material.IRON_LEGGINGS);
                        ItemStack bootsAxe = new ItemStack(Material.IRON_BOOTS);

                        //Adding the enchantments to the items for the kit 'knocker'.
                        axeAxe.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                        helmetAxe.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                        chestplateAxe.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        leggingsAxe.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        bootsAxe.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

                        ItemStack foodAxe = new ItemStack(Material.COOKED_COD, 12);

                        p.getInventory().clear();
                        p.getInventory().setItem(0, axeAxe);
                        p.getInventory().setItem(1, foodAxe);

                        p.getInventory().setHelmet(helmetAxe);
                        p.getInventory().setChestplate(chestplateAxe);
                        p.getInventory().setLeggings(leggingsAxe);
                        p.getInventory().setBoots(bootsAxe);

                        p.setWalkSpeed(0.2f);
                        p.setHealth(20.0);
                        p.setFoodLevel(20);

                    }
                }
            }

        }
        return false;
    }
}
