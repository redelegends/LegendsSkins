package dev.redelegends.skins.plugin.mojang.api;

public class InvalidMojangException extends Exception {
   private static final long serialVersionUID = 1L;

   public InvalidMojangException(String msg) {
      super(msg);
   }
}
