package com.github.Syasyu48;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

public class MinecraftChatTranslatorPlugin extends JavaPlugin implements Listener {

    private final Set<UUID> disabledPlayers = new HashSet<>();
    private static final Pattern URL_PATTERN = Pattern.compile("(https?://\\S+|www\\.\\S+)");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("mct").setExecutor(this);
        getLogger().info("MCTが有効になりました！");
    }

    @Override
    public void onDisable() {
        getLogger().info("MCTが無効になりました！");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("toggle")) {
            if (!(sender instanceof Player player)) {
                sender.sendMessage(ChatColor.RED + "This command is for players only.");
                return true;
            }

            UUID id = player.getUniqueId();
            if (disabledPlayers.contains(id)) {
                disabledPlayers.remove(id);
                player.sendMessage(ChatColor.GREEN + "Translator enabled.");
            } else {
                disabledPlayers.add(id);
                player.sendMessage(ChatColor.YELLOW + "Translator disabled.");
            }
            return true;
        }

        sender.sendMessage(ChatColor.RED + "/" + label + " toggle");
        return true;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (disabledPlayers.contains(player.getUniqueId())) {
            return;
        }

        String originalMessage = event.getMessage();

        // ⭐ 「!」で始まる場合はそのまま表示（翻訳なし）
        if (originalMessage.startsWith("!")) {
            return; // 翻訳しない
        }

        String messageWithoutUrls = removeUrls(originalMessage);

        String translatedMessage = "";
        if (!messageWithoutUrls.isBlank()) {
            String hiragana = RomajiToHiraganaTranslator.translate(messageWithoutUrls);
            translatedMessage = GoogleCGIJapaneseConverter.convert(hiragana);
        }

        String formattedMessage = originalMessage + " " + ChatColor.GOLD + "(" + translatedMessage + ")" + ChatColor.RESET;
        event.setMessage(formattedMessage);
    }


    private static String removeUrls(String text) {
        return URL_PATTERN.matcher(text).replaceAll("");
    }
}
