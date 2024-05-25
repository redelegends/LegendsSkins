package dev.redelegends.skins.bungee.database;

import javax.sql.rowset.CachedRowSet;

import dev.redelegends.skins.Core;
import dev.redelegends.skins.plugin.utils.LegendsLogger;

public abstract class Database {
   private static Database instance;
   public static final LegendsLogger LOGGER;

   public abstract void closeConnection();

   public abstract void update(String var1, Object... var2);

   public abstract void execute(String var1, Object... var2);

   public abstract CachedRowSet query(String var1, Object... var2);

   public static void makeBackend() {
      instance = new MySQLDatabase();
   }

   public static Database getInstance() {
      return instance;
   }

   static {
      LOGGER = Core.LOGGER.getModule("DATABASE");
   }
}
