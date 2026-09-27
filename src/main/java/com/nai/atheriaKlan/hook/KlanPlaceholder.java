package com.nai.atheriaKlan.hook;

import com.nai.atheriaKlan.AtheriaKlan;
import com.nai.atheriaKlan.model.Klan;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KlanPlaceholder extends PlaceholderExpansion {

    private final AtheriaKlan plugin;

    public KlanPlaceholder(AtheriaKlan plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "atheriaklan";
    }

    @Override
    public @NotNull String getAuthor() {
        return "nai";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String identifier) {
        if (player == null) {
            return "";
        }

        if (identifier.equalsIgnoreCase("name")) {
            Klan klan = plugin.getKlanManager().getPlayerKlan(player.getUniqueId());
            if (klan != null) {
                return klan.getName();
            }
            return "Yok";
        }

        if (identifier.equalsIgnoreCase("rank")) {
            Klan klan = plugin.getKlanManager().getPlayerKlan(player.getUniqueId());
            if (klan != null) {
                if (klan.getLeader().equals(player.getUniqueId())) {
                    return "Lider";
                } else if (klan.getOfficers().contains(player.getUniqueId())) {
                    return "Yönetici";
                } else {
                    return "Üye";
                }
            }
            return "Yok";
        }

        return null;
    }
}
