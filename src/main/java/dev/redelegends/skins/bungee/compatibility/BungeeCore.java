package dev.redelegends.skins.bungee.compatibility;

import java.util.logging.Level;

import dev.redelegends.skins.Core;
import dev.redelegends.skins.bungee.Main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import dev.redelegends.skins.plugin.utils.LegendsLogger;

public class BungeeCore extends Core {
   public void dL(LegendsLogger logger, Level level, String message) {
   }

   public void sM(String playerName, String message) {
      ProxiedPlayer player = ProxyServer.getInstance().getPlayer(playerName);
      if (player != null) {
         player.sendMessage(TextComponent.fromLegacyText(message));
      }

   }

   public void sM(String playerName, BaseComponent... components) {
      ProxiedPlayer player = ProxyServer.getInstance().getPlayer(playerName);
      if (player != null) {
         player.sendMessage(components);
      }

   }

   public String gS() {
      return Main.getInstance().getDescription().getVersion();
   }
}
