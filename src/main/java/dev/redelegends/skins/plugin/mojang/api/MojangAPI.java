package dev.redelegends.skins.plugin.mojang.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.redelegends.skins.plugin.mojang.Mojang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MojangAPI extends Mojang {
   private boolean response;

   public String fastId(String name) {
      this.response = false;

      try {
         URLConnection conn = (new URL("https://api.mojang.com/users/profiles/minecraft/" + name)).openConnection();
         conn.setConnectTimeout(5000);
         BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         this.response = true;
         StringBuilder builder = new StringBuilder();

         String read;
         while((read = reader.readLine()) != null) {
            builder.append(read);
         }

         return builder.length() == 0 ? null : (new JsonParser()).parse(builder.toString()).getAsJsonObject().get("id").getAsString();
      } catch (Exception var6) {
         return null;
      }
   }

   public String fastSkinProperty(String id) {
      this.response = false;

      try {
         URLConnection conn = (new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + id + "?unsigned=false")).openConnection();
         conn.setConnectTimeout(5000);
         BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         this.response = true;
         StringBuilder builder = new StringBuilder();

         String read;
         while((read = reader.readLine()) != null) {
            builder.append(read);
         }

         String property = null;
         if (builder.length() != 0) {
            JsonObject properties = (new JsonParser()).parse(builder.toString()).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();
            String name = properties.get("name").getAsString();
            String value = properties.get("value").getAsString();
            String signature = properties.get("signature").getAsString();
            property = name + " : " + value + " : " + signature;
         }

         return builder.length() == 0 ? null : property;
      } catch (Exception var11) {
         return null;
      }
   }

   public boolean getResponse() {
      return this.response;
   }
}
