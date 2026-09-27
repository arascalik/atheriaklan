package com.nai.atheriaKlan.manager;

import com.nai.atheriaKlan.AtheriaKlan;
import com.nai.atheriaKlan.model.Klan;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import org.bukkit.configuration.file.YamlConfiguration;

public class StorageManager {
    private final File klansDir;
    private final AtheriaKlan plugin;

    public StorageManager(AtheriaKlan plugin) {
        this.plugin = plugin;
        this.klansDir = new File(plugin.getDataFolder(), "klans");
        if (!this.klansDir.exists()) {
            this.klansDir.mkdirs();
        }

    }

    public Map<String, Klan> loadAllKlans() {
        Map<String, Klan> klans = new HashMap<>();
        File[] files = this.klansDir.listFiles((dir, name) -> name.endsWith(".yml"));
        if (files == null) {
            return klans;
        }

        for (File file : files) {
            try {
                Klan klan = this.loadKlan(file);
                if (klan != null) {
                    klans.put(klan.getName().toLowerCase(Locale.ROOT), klan);
                }
            } catch (Exception exception) {
                this.plugin.getLogger().log(Level.SEVERE, "Klan dosyasi yuklenemedi: " + file.getName(), exception);
            }
        }

        return klans;
    }

    private Klan loadKlan(File file) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        String name = config.getString("name");
        String leaderStr = config.getString("leader");
        if (name != null && leaderStr != null) {
            UUID leader = UUID.fromString(leaderStr);
            Set<UUID> officers = new HashSet<>();
            for (String officerId : config.getStringList("officers")) {
                officers.add(UUID.fromString(officerId));
            }

            Set<UUID> members = new HashSet<>();
            for (String memberId : config.getStringList("members")) {
                members.add(UUID.fromString(memberId));
            }

            double bank = config.getDouble("bank", 0.0D);
            String motd = config.getString("motd", "");
            long createdAt = config.getLong("createdAt", System.currentTimeMillis());
            return new Klan(name, leader, officers, members, bank, motd, createdAt);
        } else {
            return null;
        }
    }

    public void saveKlan(Klan klan) {
        File file = new File(this.klansDir, klan.getName().toLowerCase(Locale.ROOT) + ".yml");
        YamlConfiguration config = new YamlConfiguration();
        config.set("name", klan.getName());
        config.set("leader", klan.getLeader().toString());
        config.set("officers", klan.getOfficers().stream().map(UUID::toString).toList());
        config.set("members", klan.getMembers().stream().map(UUID::toString).toList());
        config.set("bank", klan.getBank());
        config.set("motd", klan.getMotd());
        config.set("createdAt", klan.getCreatedAt());

        try {
            config.save(file);
        } catch (IOException exception) {
            this.plugin.getLogger().log(Level.SEVERE, "Klan kaydedilemedi: " + klan.getName(), exception);
        }

    }

    public void deleteKlan(String name) {
        File file = new File(this.klansDir, name.toLowerCase(Locale.ROOT) + ".yml");
        if (file.exists()) {
            file.delete();
        }

    }

    public void renameKlanFile(String oldName, String newName) {
        File oldFile = new File(this.klansDir, oldName.toLowerCase(Locale.ROOT) + ".yml");
        if (oldFile.exists()) {
            oldFile.delete();
        }

    }
}
