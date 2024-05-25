package dev.redelegends.skins.bukkit;

import dev.redelegends.skins.Core;
import dev.redelegends.skins.Language;
import dev.redelegends.skins.bukkit.api.Group;
import dev.redelegends.skins.bukkit.cmd.Commands;
import dev.redelegends.skins.bukkit.database.Database;
import dev.redelegends.skins.bukkit.listeners.BungeeSkinListener;
import dev.redelegends.skins.bukkit.listeners.Listeners;
import dev.redelegends.skins.plugin.CooldownStorage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
   private static Main instance;

   public Main() {
      instance = this;
   }

   public void onEnable() {
      this.saveDefaultConfig();
      Language.setupSettings();
      Group.makeGroups();
      Database.makeBackend();
      boolean bungee = this.getConfig().getBoolean("bungeecord");
      if (bungee) {
         BungeeSkinListener skinListener = new BungeeSkinListener();
         Bukkit.getPluginManager().registerEvents(skinListener, getInstance());
         Bukkit.getMessenger().registerOutgoingPluginChannel(getInstance(), "LegendsSkins");
         Bukkit.getMessenger().registerIncomingPluginChannel(getInstance(), "LegendsSkins", skinListener);
         Core.LOGGER.info("O plugin foi ativado.");
      } else {
         Commands.makeCommands();
         Listeners.makeListeners();
         Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CooldownStorage(), 0L, 200L);
         Core.LOGGER.info("O plugin foi ativado.");
      }
   }

   public void onDisable() {
      Core.LOGGER.info("O plugin foi desativado.");
   }

   public static Main getInstance() {
      return instance;
   }
}
