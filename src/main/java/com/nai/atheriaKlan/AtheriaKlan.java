package com.nai.atheriaKlan;

import com.nai.atheriaKlan.command.KlanCommand;
import com.nai.atheriaKlan.listener.PlayerListener;
import com.nai.atheriaKlan.manager.EconomyManager;
import com.nai.atheriaKlan.manager.InviteManager;
import com.nai.atheriaKlan.manager.KlanManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AtheriaKlan extends JavaPlugin {
    private KlanManager klanManager;
    private InviteManager inviteManager;
    private EconomyManager economyManager;

    public void onEnable() {
        this.economyManager = new EconomyManager();
        if (this.getServer().getPluginManager().getPlugin("Vault") != null) {
            try {
                if (this.economyManager.setup()) {
                    this.getLogger().info("Vault ekonomi sistemi basariyla baglandi!");
                } else {
                    this.getLogger().warning("Vault bulundu ama ekonomi saglayicisi yok!");
                }
            } catch (NoClassDefFoundError error) {
                this.getLogger().warning("Vault sinifi yuklenemedi: " + error.getMessage());
            }
        } else {
            this.getLogger().warning("Vault bulunamadi! Ekonomi ozellikleri devre disi.");
        }

        this.inviteManager = new InviteManager();
        this.klanManager = new KlanManager(this);
        KlanCommand klanCommand = new KlanCommand(this.klanManager, this.inviteManager, this.economyManager);
        Bukkit.getCommandMap().register("atheriaklan", klanCommand);
        this.getServer().getPluginManager().registerEvents(new PlayerListener(this.klanManager), this);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new com.nai.atheriaKlan.hook.KlanPlaceholder(this).register();
            this.getLogger().info("PlaceholderAPI destegi aktif edildi!");
        }

        this.getLogger().info("AtheriaKlan basariyla aktif edildi!");
    }

    public void onDisable() {
        if (this.klanManager != null) {
            this.klanManager.saveAll();
        }

        this.getLogger().info("AtheriaKlan devre disi birakildi.");
    }

    public KlanManager getKlanManager() {
        return this.klanManager;
    }
}
