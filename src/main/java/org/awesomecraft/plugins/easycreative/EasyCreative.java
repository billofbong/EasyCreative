package org.awesomecraft.plugins.easycreative;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EasyCreative extends JavaPlugin {
    public void onDisable() {
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        getCommand("gms").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                Player player = (Player)cs;
                if(args.length > 0) {
                    return false;
                }
                if(cs instanceof Player) {
                if(player.isOp()) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to survival.");
                }
                else{
                player.sendMessage(ChatColor.RED + "You must be opped to do that.");
                }
                }
                else{
                System.out.println("You must be ingame to use this.");                   
                }
                
                return true;
            }
        });
            getCommand("gmc").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                Player player = (Player)cs;
                if(args.length > 0) {
                    return false;
                }
                if(cs instanceof Player) {
               if(player.isOp()) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.GREEN + "Gamemode set to creative.");
                }
                else{
                player.sendMessage(ChatColor.RED + "You must be opped to do that.");
                }
                }
                else{
                System.out.println("You must be ingame to use this.");                   
                }
               
                return true;
            }
        });
        getCommand("gmhelp").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                 if(args.length > 0) {
                     return false;
                 }
                 if(cs instanceof Player) {              
                 cs.sendMessage(ChatColor.GREEN + "/gmc: sets you in creative.");
                 cs.sendMessage(ChatColor.GREEN + "Aliases: gamemodecreative, creative");
                 cs.sendMessage(ChatColor.GREEN + "/gms: sets you in survival.");
                 cs.sendMessage(ChatColor.GREEN + "Aliases: gamemodesurvival, survival");
                 }
                 else{
                     System.out.println("You must be ingame to use this.");
                 }
                 
                 return true;
            }
        });

        System.out.println(this + " is now enabled!");
    }
}
