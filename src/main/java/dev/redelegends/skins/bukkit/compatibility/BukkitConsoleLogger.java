package dev.redelegends.skins.bukkit.compatibility;

import org.bukkit.Bukkit;
import dev.redelegends.skins.plugin.compatibility.ConsoleLogger;

public class BukkitConsoleLogger implements ConsoleLogger {
   public void sendMessage(String message) {
      Bukkit.getConsoleSender().sendMessage(message);
   }
}
