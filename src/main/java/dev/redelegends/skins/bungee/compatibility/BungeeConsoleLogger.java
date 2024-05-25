package dev.redelegends.skins.bungee.compatibility;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import dev.redelegends.skins.plugin.compatibility.ConsoleLogger;

public class BungeeConsoleLogger implements ConsoleLogger {
   public void sendMessage(String message) {
      ProxyServer.getInstance().getConsole().sendMessage(TextComponent.fromLegacyText(message));
   }
}
