package com.nai.atheriaKlan.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public final class MessageUtil {
    private static final String PREFIX = ChatColor.GOLD + "[" + ChatColor.YELLOW + "Klan" + ChatColor.GOLD + "] " + ChatColor.GRAY;

    private MessageUtil() {
    }

    public static void send(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void sendError(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + ChatColor.RED + message);
    }

    public static void sendSuccess(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + ChatColor.GREEN + message);
    }

    public static void sendInfo(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + ChatColor.YELLOW + message);
    }

    public static void sendRaw(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
