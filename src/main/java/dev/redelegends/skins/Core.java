package dev.redelegends.skins;

import dev.redelegends.skins.bukkit.compatibility.BukkitConsoleLogger;
import dev.redelegends.skins.bukkit.compatibility.BukkitCore;
import dev.redelegends.skins.bungee.Main;
import dev.redelegends.skins.bungee.compatibility.BungeeConsoleLogger;
import dev.redelegends.skins.bungee.compatibility.BungeeCore;
import dev.redelegends.skins.plugin.compatibility.ConsoleLogger;
import dev.redelegends.skins.plugin.utils.LegendsLogger;
import net.md_5.bungee.api.chat.BaseComponent;

import java.io.InputStream;
import java.util.logging.Level;

public abstract class Core {
   public static final boolean BUNGEE = hasBungeeClass();
   public static final LegendsLogger LOGGER = new LegendsLogger();
   private static final Core METHODS;

   public abstract void dL(LegendsLogger var1, Level var2, String var3);

   public abstract void sM(String var1, String var2);

   public abstract void sM(String var1, BaseComponent... var2);

   public abstract String gS();

   public static void delayedLog(String message) {
      METHODS.dL(LOGGER, Level.INFO, message);
   }

   public static void delayedLog(LegendsLogger logger, Level level, String message) {
      METHODS.dL(logger, level, message);
   }

   public static String getVersion() {
      return METHODS.gS();
   }

   static boolean hasBungeeClass() {
      try {
         Class.forName("net.md_5.bungee.api.ProxyServer");
         return true;
      } catch (ClassNotFoundException var1) {
         return false;
      }
   }

   public static InputStream getResource(String name) {
      return BUNGEE ? Main.getInstance().getResourceAsStream(name) : dev.redelegends.skins.bukkit.Main.getInstance().getResource(name);
   }

   public static ConsoleLogger getConsoleLogger() {
      return (ConsoleLogger)(BUNGEE ? new BungeeConsoleLogger() : new BukkitConsoleLogger());
   }

   static {
      METHODS = (Core)(BUNGEE ? new BungeeCore() : new BukkitCore());
   }
}
