package com.nai.atheriaKlan.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Klan {
    private String name;
    private UUID leader;
    private final Set<UUID> officers = new HashSet();
    private final Set<UUID> members = new HashSet();
    private double bank;
    private String motd;
    private final long createdAt;

    public Klan(String name, UUID leader) {
        this.name = name;
        this.leader = leader;
        this.members.add(leader);
        this.bank = 0.0D;
        this.motd = "";
        this.createdAt = System.currentTimeMillis();
    }

    public Klan(String name, UUID leader, Set<UUID> officers, Set<UUID> members, double bank, String motd, long createdAt) {
        this.name = name;
        this.leader = leader;
        this.officers.addAll(officers);
        this.members.addAll(members);
        this.bank = bank;
        this.motd = motd;
        this.createdAt = createdAt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getLeader() {
        return this.leader;
    }

    public void setLeader(UUID leader) {
        this.leader = leader;
    }

    public Set<UUID> getOfficers() {
        return this.officers;
    }

    public Set<UUID> getMembers() {
        return this.members;
    }

    public double getBank() {
        return this.bank;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }

    public String getMotd() {
        return this.motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public KlanRole getRole(UUID player) {
        if (player.equals(this.leader)) {
            return KlanRole.LIDER;
        } else if (this.officers.contains(player)) {
            return KlanRole.YONETICI;
        } else {
            return this.members.contains(player) ? KlanRole.UYE : null;
        }
    }

    public boolean isMember(UUID player) {
        return this.members.contains(player);
    }

    public boolean isOfficerOrLeader(UUID player) {
        return player.equals(this.leader) || this.officers.contains(player);
    }

    public boolean isLeader(UUID player) {
        return player.equals(this.leader);
    }

    public void addMember(UUID player) {
        this.members.add(player);
    }

    public void removeMember(UUID player) {
        this.members.remove(player);
        this.officers.remove(player);
    }

    public void addOfficer(UUID player) {
        this.officers.add(player);
    }

    public void removeOfficer(UUID player) {
        this.officers.remove(player);
    }

    public int getMemberCount() {
        return this.members.size();
    }
}