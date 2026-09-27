package com.nai.atheriaKlan.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InviteManager {
    private static final long INVITE_TIMEOUT_MS = 60000L;
    private final Map<UUID, InviteData> pendingInvites = new HashMap();

    public void invite(UUID player, String klanName, UUID inviter) {
        this.pendingInvites.put(player, new InviteData(klanName, inviter, System.currentTimeMillis()));
    }

    public InviteData getInvite(UUID player) {
        InviteData data = (InviteData)this.pendingInvites.get(player);
        if (data == null) {
            return null;
        } else if (System.currentTimeMillis() - data.timestamp() > 60000L) {
            this.pendingInvites.remove(player);
            return null;
        } else {
            return data;
        }
    }

    public void removeInvite(UUID player) {
        this.pendingInvites.remove(player);
    }

    public boolean hasInvite(UUID player) {
        return this.getInvite(player) != null;
    }

    public static record InviteData(String klanName, UUID inviter, long timestamp) {
    }
}