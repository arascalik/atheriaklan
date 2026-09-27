package com.nai.atheriaKlan.model;

public enum KlanRole {
    UYE("Üye", 0),
    YONETICI("Yönetici", 1),
    LIDER("Lider", 2);

    private final String displayName;
    private final int level;

    private KlanRole(String displayName, int level) {
        this.displayName = displayName;
        this.level = level;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isAtLeast(KlanRole other) {
        return this.level >= other.level;
    }


}