package com.nai.atheriaKlan.manager;

import com.nai.atheriaKlan.AtheriaKlan;
import com.nai.atheriaKlan.model.Klan;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class KlanManager {
    private final Map<String, Klan> klans = new HashMap<>();
    private final Map<UUID, String> playerKlanMap = new HashMap<>();
    private final StorageManager storage;

    public KlanManager(AtheriaKlan plugin) {
        this.storage = new StorageManager(plugin);
        this.loadAll();
    }

    private void loadAll() {
        this.klans.clear();
        this.playerKlanMap.clear();
        Map<String, Klan> loaded = this.storage.loadAllKlans();
        this.klans.putAll(loaded);
        for (Klan klan : this.klans.values()) {
            for (UUID member : klan.getMembers()) {
                this.playerKlanMap.put(member, klan.getName().toLowerCase(Locale.ROOT));
            }
        }
    }

    public Klan createKlan(String name, UUID leader) {
        String key = name.toLowerCase(Locale.ROOT);
        if (this.klans.containsKey(key)) {
            return null;
        } else if (this.playerKlanMap.containsKey(leader)) {
            return null;
        } else {
            Klan klan = new Klan(name, leader);
            this.klans.put(key, klan);
            this.playerKlanMap.put(leader, key);
            this.storage.saveKlan(klan);
            return klan;
        }
    }

    public boolean disbandKlan(String name) {
        String key = name.toLowerCase(Locale.ROOT);
        Klan klan = (Klan)this.klans.remove(key);
        if (klan == null) {
            return false;
        } else {
            for (UUID member : klan.getMembers()) {
                this.playerKlanMap.remove(member);
            }

            this.storage.deleteKlan(name);
            return true;
        }
    }

    public Klan getKlan(String name) {
        return (Klan)this.klans.get(name.toLowerCase(Locale.ROOT));
    }

    public Klan getPlayerKlan(UUID player) {
        String key = (String)this.playerKlanMap.get(player);
        return key == null ? null : (Klan)this.klans.get(key);
    }

    public boolean isInKlan(UUID player) {
        return this.playerKlanMap.containsKey(player);
    }

    public boolean klanExists(String name) {
        return this.klans.containsKey(name.toLowerCase(Locale.ROOT));
    }

    public void addMember(Klan klan, UUID player) {
        klan.addMember(player);
        this.playerKlanMap.put(player, klan.getName().toLowerCase(Locale.ROOT));
        this.storage.saveKlan(klan);
    }

    public void removeMember(Klan klan, UUID player) {
        klan.removeMember(player);
        this.playerKlanMap.remove(player);
        this.storage.saveKlan(klan);
    }

    public void toggleOfficer(Klan klan, UUID player) {
        if (klan.getOfficers().contains(player)) {
            klan.removeOfficer(player);
        } else {
            klan.addOfficer(player);
        }

        this.storage.saveKlan(klan);
    }

    public void transferLeadership(Klan klan, UUID newLeader) {
        UUID oldLeader = klan.getLeader();
        klan.setLeader(newLeader);
        klan.getOfficers().remove(newLeader);
        klan.addOfficer(oldLeader);
        this.storage.saveKlan(klan);
    }

    public void renameKlan(Klan klan, String newName) {
        String oldKey = klan.getName().toLowerCase(Locale.ROOT);
        String newKey = newName.toLowerCase(Locale.ROOT);
        this.klans.remove(oldKey);
        this.storage.renameKlanFile(klan.getName(), newName);
        klan.setName(newName);
        this.klans.put(newKey, klan);
        for (UUID member : klan.getMembers()) {
            this.playerKlanMap.put(member, newKey);
        }

        this.storage.saveKlan(klan);
    }

    public void setMotd(Klan klan, String motd) {
        klan.setMotd(motd);
        this.storage.saveKlan(klan);
    }

    public void depositBank(Klan klan, double amount) {
        klan.setBank(klan.getBank() + amount);
        this.storage.saveKlan(klan);
    }

    public boolean withdrawBank(Klan klan, double amount) {
        if (klan.getBank() < amount) {
            return false;
        } else {
            klan.setBank(klan.getBank() - amount);
            this.storage.saveKlan(klan);
            return true;
        }
    }

    public List<Klan> getKlanRanking() {
        return this.klans.values().stream().sorted(Comparator.comparingInt(Klan::getMemberCount).reversed().thenComparingDouble(Klan::getBank).reversed()).collect(Collectors.toList());
    }

    public Collection<Klan> getAllKlans() {
        return this.klans.values();
    }

    public Collection<String> getAllKlanNames() {
        return this.klans.values().stream().map(Klan::getName).toList();
    }

    public void saveAll() {
        for (Klan klan : this.klans.values()) {
            this.storage.saveKlan(klan);
        }
    }
}