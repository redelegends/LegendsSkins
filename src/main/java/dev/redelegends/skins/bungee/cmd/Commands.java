package dev.redelegends.skins.bungee.cmd;

import dev.redelegends.skins.bungee.Main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public abstract class Commands extends Command {
   public Commands(String name, String... aliases) {
      super(name, (String)null, aliases);
      ProxyServer.getInstance().getPluginManager().registerCommand(Main.getInstance(), this);
   }

   public static void makeCommands() {
      new SkinCommand();
   }
}
