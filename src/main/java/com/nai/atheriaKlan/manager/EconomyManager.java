package com.nai.atheriaKlan.manager;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class EconomyManager {
    private Economy economy;

    public boolean setup() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        } else {
            RegisteredServiceProvider<Economy> rsp = Bukkit.getServicesManager().getRegistration(Economy.class);
            if (rsp == null) {
                return false;
            } else {
                this.economy = (Economy)rsp.getProvider();
                return true;
            }
        }
    }

    public boolean isEnabled() {
        return this.economy != null;
    }

    public double getBalance(Player player) {
        return this.economy == null ? 0.0D : this.economy.getBalance(player);
    }

    public boolean withdraw(Player player, double amount) {
        return this.economy == null ? false : this.economy.withdrawPlayer(player, amount).transactionSuccess();
    }

    public boolean deposit(Player player, double amount) {
        return this.economy == null ? false : this.economy.depositPlayer(player, amount).transactionSuccess();
    }

    public String format(double amount) {
        return this.economy == null ? String.format("%.2f", amount) : this.economy.format(amount);
    }
}