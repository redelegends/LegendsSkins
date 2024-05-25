package dev.redelegends.skins.bukkit.database;

import javax.sql.rowset.CachedRowSet;

import dev.redelegends.skins.Core;
import dev.redelegends.skins.bukkit.Main;
import dev.redelegends.skins.plugin.utils.LegendsLogger;

public abstract class Database {
   private static Database instance;
   public static final LegendsLogger LOGGER;

   public abstract void closeConnection();

   public abstract void update(String var1, Object... var2);

   public abstract void execute(String var1, Object... var2);

   public abstract CachedRowSet query(String var1, Object... var2);

   public static void makeBackend() {
      String type = Main.getInstance().getConfig().getString("database.tipo");
      if (type.equalsIgnoreCase("mysql")) {
         instance = new MySQLDatabase();
      } else {
         instance = new SQLiteDatabase();
      }

   }

   public static Database getInstance() {
      return instance;
   }

   static {
      LOGGER = Core.LOGGER.getModule("DATABASE");
   }
}
