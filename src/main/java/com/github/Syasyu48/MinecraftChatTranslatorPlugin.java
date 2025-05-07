package com.github.Syasyu48;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftChatTranslatorPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("MinecraftChatTranslatorPluginが有効になりました！");
        }

    @Override
    public void onDisable() {
        getLogger().info("MinecraftChatTranslatorPluginが無効になりました！");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String originalMessage = event.getMessage();

        // ⭐ 「!」で始まる場合はそのまま表示（翻訳なし）
        if (originalMessage.startsWith("!")) {
            return; // 翻訳しない
        }

        String translatedMessage;
        if (isUrl(originalMessage)) {
            translatedMessage = "";
        } else {
            String hiragana = RomajiToHiraganaTranslator.translate(originalMessage);
            translatedMessage = GoogleCGIJapaneseConverter.convert(hiragana);
        }

        String formattedMessage = originalMessage + " " + ChatColor.GOLD + "(" + translatedMessage + ")" + ChatColor.RESET;
        event.setMessage(formattedMessage);
    }


    private boolean isUrl(String text) {
        return text.startsWith("http://") || text.startsWith("https://") || text.startsWith("www.");
    }
}
