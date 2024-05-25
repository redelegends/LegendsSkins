package dev.redelegends.skins.bukkit.cmd;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import dev.redelegends.skins.plugin.reflection.Accessors;
import dev.redelegends.skins.plugin.reflection.MethodAccessor;
import dev.redelegends.skins.plugin.reflection.MinecraftReflection;

public abstract class Commands extends Command {
   public Commands(String name, String... aliases) {
      this(name, Arrays.asList(aliases));
   }

   public Commands(String name, List<String> aliases) {
      super(name);
      this.setAliases(aliases);
      Object simpleCommandMap = Accessors.getMethod(MinecraftReflection.getCraftBukkitClass("CraftServer"), "getCommandMap").invoke(Bukkit.getServer());
      MethodAccessor<?> register = Accessors.getMethod(simpleCommandMap.getClass(), 0, String.class, String.class, Command.class);
      register.invoke(simpleCommandMap, name, "legendsskins", this);
   }

   public static void makeCommands() {
      new SkinCommand();
   }
}
