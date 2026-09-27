package com.nai.atheriaKlan.listener;

import com.nai.atheriaKlan.manager.KlanManager;
import com.nai.atheriaKlan.model.Klan;
import com.nai.atheriaKlan.util.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    private final KlanManager klanManager;

    public PlayerListener(KlanManager klanManager) {
        this.klanManager = klanManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan != null) {
            MessageUtil.sendRaw(player, "&6&l✦ &e" + klan.getName() + " &6&l✦");
            if (klan.getMotd() != null && !klan.getMotd().isEmpty()) {
                MessageUtil.sendRaw(player, "&7MOTD: &f" + klan.getMotd());
            }

        }
    }
}