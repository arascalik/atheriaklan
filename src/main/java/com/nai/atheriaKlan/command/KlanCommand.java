package com.nai.atheriaKlan.command;

import com.nai.atheriaKlan.manager.EconomyManager;
import com.nai.atheriaKlan.manager.InviteManager;
import com.nai.atheriaKlan.manager.KlanManager;
import com.nai.atheriaKlan.manager.InviteManager.InviteData;
import com.nai.atheriaKlan.model.Klan;
import com.nai.atheriaKlan.model.KlanRole;
import com.nai.atheriaKlan.util.MessageUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KlanCommand extends Command {
    private final KlanManager klanManager;
    private final InviteManager inviteManager;
    private final EconomyManager economyManager;

    public KlanCommand(KlanManager klanManager, InviteManager inviteManager, EconomyManager economyManager) {
        super("klan", "Klan komutlari", "/<command> [alt komut]", List.of("clan"));
        this.klanManager = klanManager;
        this.inviteManager = inviteManager;
        this.economyManager = economyManager;
    }

    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (args.length == 0) {
                this.showHelp(player);
                return true;
            } else {
                String sub = args[0].toLowerCase(Locale.ROOT);
                byte var7 = -1;
                switch(sub.hashCode()) {
                    case -1362765066:
                        if (sub.equals("olustur")) {
                            var7 = 0;
                        }
                        break;
                    case -1355734390:
                        if (sub.equals("oluştur")) {
                            var7 = 1;
                        }
                        break;
                    case -934890014:
                        if (sub.equals("reddet")) {
                            var7 = 4;
                        }
                        break;
                    case -793505687:
                        if (sub.equals("paracek")) {
                            var7 = 15;
                        }
                        break;
                    case -793378835:
                        if (sub.equals("paraçek")) {
                            var7 = 16;
                        }
                        break;
                    case 98501:
                        if (sub.equals("cik")) {
                            var7 = 5;
                        }
                        break;
                    case 104701:
                        if (sub.equals("cık")) {
                            var7 = 7;
                        }
                        break;
                    case 231553:
                        if (sub.equals("çık")) {
                            var7 = 6;
                        }
                        break;
                    case 3052376:
                        if (sub.equals("chat")) {
                            var7 = 24;
                        }
                        break;
                    case 3241934:
                        if (sub.equals("isim")) {
                            var7 = 22;
                        }
                        break;
                    case 3357586:
                        if (sub.equals("motd")) {
                            var7 = 23;
                        }
                        break;
                    case 93740199:
                        if (sub.equals("bilgi")) {
                            var7 = 11;
                        }
                        break;
                    case 94662582:
                        if (sub.equals("cikar")) {
                            var7 = 8;
                        }
                        break;
                    case 95344181:
                        if (sub.equals("dagit")) {
                            var7 = 18;
                        }
                        break;
                    case 95358472:
                        if (sub.equals("davet")) {
                            var7 = 2;
                        }
                        break;
                    case 95527205:
                        if (sub.equals("dağıt")) {
                            var7 = 19;
                        }
                        break;
                    case 100620782:
                        if (sub.equals("cıkar")) {
                            var7 = 10;
                        }
                        break;
                    case 101804387:
                        if (sub.equals("kabul")) {
                            var7 = 3;
                        }
                        break;
                    case 102967668:
                        if (sub.equals("lider")) {
                            var7 = 20;
                        }
                        break;
                    case 109433325:
                        if (sub.equals("siege")) {
                            var7 = 17;
                        }
                        break;
                    case 114869830:
                        if (sub.equals("yetki")) {
                            var7 = 21;
                        }
                        break;
                    case 222525554:
                        if (sub.equals("çıkar")) {
                            var7 = 9;
                        }
                        break;
                    case 614950478:
                        if (sub.equals("siralama")) {
                            var7 = 12;
                        }
                        break;
                    case 1965423797:
                        if (sub.equals("parayatir")) {
                            var7 = 14;
                        }
                        break;
                    case 2022027542:
                        if (sub.equals("sıralama")) {
                            var7 = 13;
                        }
                }

                switch(var7) {
                    case 0:
                    case 1:
                        this.handleCreate(player, args);
                        break;
                    case 2:
                        this.handleInvite(player, args);
                        break;
                    case 3:
                        this.handleAccept(player);
                        break;
                    case 4:
                        this.handleReject(player);
                        break;
                    case 5:
                    case 6:
                    case 7:
                        this.handleLeave(player);
                        break;
                    case 8:
                    case 9:
                    case 10:
                        this.handleKick(player, args);
                        break;
                    case 11:
                        this.handleInfo(player, args);
                        break;
                    case 12:
                    case 13:
                        this.handleRanking(player);
                        break;
                    case 14:
                        this.handleDeposit(player, args);
                        break;
                    case 15:
                    case 16:
                        this.handleWithdraw(player, args);
                        break;
                    case 17:
                        this.handleSiege(player);
                        break;
                    case 18:
                    case 19:
                        this.handleDisband(player);
                        break;
                    case 20:
                        this.handleTransferLeader(player, args);
                        break;
                    case 21:
                        this.handleToggleOfficer(player, args);
                        break;
                    case 22:
                        this.handleRename(player, args);
                        break;
                    case 23:
                        this.handleMotd(player, args);
                        break;
                    case 24:
                        this.handleChat(player, args);
                        break;
                    default:
                        MessageUtil.sendError(player, "Bilinmeyen komut! /klan yazarak komutlari gorebilirsin.");
                }

                return true;
            }
        } else {
            sender.sendMessage(String.valueOf(ChatColor.RED) + "Bu komut sadece oyuncular tarafindan kullanilabilir.");
            return true;
        }
    }

    private void showHelp(Player player) {
        String var10000 = ChatColor.GRAY.toString();
        String line = var10000 + String.valueOf(ChatColor.STRIKETHROUGH) + "                                                  ";
        player.sendMessage(line);
        MessageUtil.sendRaw(player, "&6&l   ✦ &e&lATHERIA KLAN &6&l✦");
        player.sendMessage("");
        MessageUtil.sendRaw(player, " &e/klan olustur <isim> &8- &7Yeni bir klan olustur");
        MessageUtil.sendRaw(player, " &e/klan davet <oyuncu> &8- &7Oyuncuyu klana davet et");
        MessageUtil.sendRaw(player, " &e/klan kabul &8- &7Klan davetini kabul et");
        MessageUtil.sendRaw(player, " &e/klan reddet &8- &7Klan davetini reddet");
        MessageUtil.sendRaw(player, " &e/klan cik &8- &7Klandan ayril");
        MessageUtil.sendRaw(player, " &e/klan cikar <oyuncu> &8- &7Oyuncuyu klandan at");
        MessageUtil.sendRaw(player, " &e/klan bilgi [klan] &8- &7Klan bilgilerini goruntule");
        MessageUtil.sendRaw(player, " &e/klan siralama &8- &7Klan siralamasini goruntule");
        MessageUtil.sendRaw(player, " &e/klan parayatir <miktar> &8- &7Klan kasasina para yatir");
        MessageUtil.sendRaw(player, " &e/klan paracek <miktar> &8- &7Klan kasasindan para cek");
        MessageUtil.sendRaw(player, " &e/klan dagit &8- &7Klani dagit");
        MessageUtil.sendRaw(player, " &e/klan lider <oyuncu> &8- &7Liderligi devret");
        MessageUtil.sendRaw(player, " &e/klan yetki <oyuncu> &8- &7Yonetici yetkisi ver/al");
        MessageUtil.sendRaw(player, " &e/klan isim <isim> &8- &7Klan ismini degistir");
        MessageUtil.sendRaw(player, " &e/klan motd <mesaj> &8- &7Klan mesajini ayarla");
        MessageUtil.sendRaw(player, " &e/klan chat <mesaj> &8- &7Klan sohbetine mesaj gonder");
        MessageUtil.sendRaw(player, " &e/klan siege &8- &7Kusatma savasi &c(Yakinda)");
        player.sendMessage(line);
    }

    private void handleCreate(Player player, String[] args) {
        if (this.klanManager.isInKlan(player.getUniqueId())) {
            MessageUtil.sendError(player, "Zaten bir klanin var! Once klandan ayrilmalisin.");
        } else if (args.length < 2) {
            MessageUtil.sendError(player, "Kullanim: /klan olustur <isim>");
        } else {
            String name = args[1];
            if (name.length() >= 3 && name.length() <= 16) {
                if (!name.matches("[a-zA-Z0-9çÇğĞıİöÖşŞüÜ]+")) {
                    MessageUtil.sendError(player, "Klan ismi sadece harf ve rakam icermelidir.");
                } else if (this.klanManager.klanExists(name)) {
                    MessageUtil.sendError(player, "Bu isimde bir klan zaten var!");
                } else {
                    Klan klan = this.klanManager.createKlan(name, player.getUniqueId());
                    if (klan == null) {
                        MessageUtil.sendError(player, "Klan olusturulamadi!");
                    } else {
                        String var10001 = String.valueOf(ChatColor.GOLD);
                        MessageUtil.sendSuccess(player, "'" + var10001 + name + String.valueOf(ChatColor.GREEN) + "' klani basariyla olusturuldu!");
                    }
                }
            } else {
                MessageUtil.sendError(player, "Klan ismi 3-16 karakter arasinda olmalidir.");
            }
        }
    }

    private void handleInvite(Player player, String[] args) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (!klan.isOfficerOrLeader(player.getUniqueId())) {
            MessageUtil.sendError(player, "Bu komutu kullanmak icin Yonetici veya Lider olmalisin!");
        } else if (args.length < 2) {
            MessageUtil.sendError(player, "Kullanim: /klan davet <oyuncu>");
        } else {
            Player target = Bukkit.getPlayerExact(args[1]);
            if (target == null) {
                MessageUtil.sendError(player, "Oyuncu bulunamadi veya cevrimdisi!");
            } else if (target.equals(player)) {
                MessageUtil.sendError(player, "Kendini davet edemezsin!");
            } else if (this.klanManager.isInKlan(target.getUniqueId())) {
                MessageUtil.sendError(player, "Bu oyuncu zaten bir klanda!");
            } else if (this.inviteManager.hasInvite(target.getUniqueId())) {
                MessageUtil.sendError(player, "Bu oyuncunun zaten bekleyen bir daveti var!");
            } else {
                this.inviteManager.invite(target.getUniqueId(), klan.getName(), player.getUniqueId());
                MessageUtil.sendSuccess(player, target.getName() + " adli oyuncuya davet gonderildi!");
                String var10001 = String.valueOf(ChatColor.GOLD);
                MessageUtil.sendInfo(target, var10001 + player.getName() + String.valueOf(ChatColor.YELLOW) + " seni '" + String.valueOf(ChatColor.GOLD) + klan.getName() + String.valueOf(ChatColor.YELLOW) + "' klanina davet etti!");
                MessageUtil.sendRaw(target, "  &a/klan kabul &7- Kabul et  &c|  &c/klan reddet &7- Reddet");
                MessageUtil.sendRaw(target, "  &7Davetin suresi: &e60 saniye");
            }
        }
    }

    private void handleAccept(Player player) {
        if (this.klanManager.isInKlan(player.getUniqueId())) {
            MessageUtil.sendError(player, "Zaten bir klanin var!");
        } else {
            InviteData invite = this.inviteManager.getInvite(player.getUniqueId());
            if (invite == null) {
                MessageUtil.sendError(player, "Bekleyen bir davetin yok veya davetin suresi doldu!");
            } else {
                Klan klan = this.klanManager.getKlan(invite.klanName());
                if (klan == null) {
                    MessageUtil.sendError(player, "Davet edilen klan artik mevcut degil!");
                    this.inviteManager.removeInvite(player.getUniqueId());
                } else {
                    this.klanManager.addMember(klan, player.getUniqueId());
                    this.inviteManager.removeInvite(player.getUniqueId());
                    String var10001 = String.valueOf(ChatColor.GOLD);
                    MessageUtil.sendSuccess(player, "'" + var10001 + klan.getName() + String.valueOf(ChatColor.GREEN) + "' klanina katildin!");
                    String var10002 = String.valueOf(ChatColor.GREEN);
                    this.broadcastToKlan(klan, var10002 + player.getName() + String.valueOf(ChatColor.YELLOW) + " klana katildi!");
                }
            }
        }
    }

    private void handleReject(Player player) {
        InviteData invite = this.inviteManager.getInvite(player.getUniqueId());
        if (invite == null) {
            MessageUtil.sendError(player, "Bekleyen bir davetin yok!");
        } else {
            this.inviteManager.removeInvite(player.getUniqueId());
            MessageUtil.sendInfo(player, "Klan daveti reddedildi.");
            Player inviter = Bukkit.getPlayer(invite.inviter());
            if (inviter != null) {
                MessageUtil.sendInfo(inviter, player.getName() + " klan davetini reddetti.");
            }

        }
    }

    private void handleLeave(Player player) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (klan.isLeader(player.getUniqueId())) {
            MessageUtil.sendError(player, "Lider klandan ayrilamaz! Once liderligi devret veya klani dagit.");
        } else {
            String var10002 = String.valueOf(ChatColor.RED);
            this.broadcastToKlan(klan, var10002 + player.getName() + String.valueOf(ChatColor.YELLOW) + " klandan ayrildi.");
            this.klanManager.removeMember(klan, player.getUniqueId());
            MessageUtil.sendSuccess(player, "Klandan basariyla ayrildin.");
        }
    }

    private void handleKick(Player player, String[] args) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (!klan.isOfficerOrLeader(player.getUniqueId())) {
            MessageUtil.sendError(player, "Bu komutu kullanmak icin Yonetici veya Lider olmalisin!");
        } else if (args.length < 2) {
            MessageUtil.sendError(player, "Kullanim: /klan cikar <oyuncu>");
        } else {
            Player target = Bukkit.getPlayerExact(args[1]);
            UUID targetUuid;
            String targetName;
            if (target != null) {
                targetUuid = target.getUniqueId();
                targetName = target.getName();
            } else {
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[1]);
                if (!offlinePlayer.hasPlayedBefore()) {
                    MessageUtil.sendError(player, "Oyuncu bulunamadi!");
                    return;
                }

                targetUuid = offlinePlayer.getUniqueId();
                targetName = offlinePlayer.getName() != null ? offlinePlayer.getName() : args[1];
            }

            if (!klan.isMember(targetUuid)) {
                MessageUtil.sendError(player, "Bu oyuncu klaninda degil!");
            } else if (klan.isLeader(targetUuid)) {
                MessageUtil.sendError(player, "Lideri klandan atamazsin!");
            } else if (klan.getOfficers().contains(targetUuid) && !klan.isLeader(player.getUniqueId())) {
                MessageUtil.sendError(player, "Yoneticileri sadece lider atabilir!");
            } else {
                this.klanManager.removeMember(klan, targetUuid);
                String var10002 = String.valueOf(ChatColor.RED);
                this.broadcastToKlan(klan, var10002 + targetName + String.valueOf(ChatColor.YELLOW) + " klandan atildi.");
                if (target != null) {
                    MessageUtil.sendError(target, "'" + klan.getName() + "' klanindan atildin!");
                }

            }
        }
    }

    private void handleInfo(Player player, String[] args) {
        Klan klan;
        String line;
        if (args.length >= 2) {
            line = args[1];
            klan = this.klanManager.getKlan(line);
            if (klan == null) {
                MessageUtil.sendError(player, "'" + line + "' adinda bir klan bulunamadi!");
                return;
            }
        } else {
            klan = this.klanManager.getPlayerKlan(player.getUniqueId());
            if (klan == null) {
                MessageUtil.sendError(player, "Bir klana uye degilsin! Baska bir klanin bilgisi icin: /klan bilgi <isim>");
                return;
            }
        }

        String var10000 = ChatColor.GRAY.toString();
        line = var10000 + String.valueOf(ChatColor.STRIKETHROUGH) + "                                                  ";
        player.sendMessage(line);
        MessageUtil.sendRaw(player, "&6&l   ✦ &e&l" + klan.getName().toUpperCase() + " &6&l✦");
        player.sendMessage("");
        String leaderName = this.getPlayerName(klan.getLeader());
        MessageUtil.sendRaw(player, " &6Lider: &f" + leaderName);
        if (!klan.getOfficers().isEmpty()) {
            StringBuilder officers = new StringBuilder();

            UUID uuid;
            for(Iterator var7 = klan.getOfficers().iterator(); var7.hasNext(); officers.append(this.getPlayerName(uuid))) {
                uuid = (UUID)var7.next();
                if (!officers.isEmpty()) {
                    officers.append("&7, &f");
                }
            }

            MessageUtil.sendRaw(player, " &6Yoneticiler: &f" + String.valueOf(officers));
        }

        MessageUtil.sendRaw(player, " &6Uye Sayisi: &f" + klan.getMemberCount());
        EconomyManager var10001 = this.economyManager;
        MessageUtil.sendRaw(player, " &6Kasa: &f" + var10001.format(klan.getBank()));
        if (klan.getMotd() != null && !klan.getMotd().isEmpty()) {
            MessageUtil.sendRaw(player, " &6MOTD: &f" + klan.getMotd());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String var14 = sdf.format(new Date(klan.getCreatedAt()));
        MessageUtil.sendRaw(player, " &6Kurulus: &f" + var14);
        player.sendMessage(line);
        Klan playerKlan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (playerKlan != null && playerKlan.getName().equalsIgnoreCase(klan.getName())) {
            StringBuilder memberList = new StringBuilder();
            Iterator var9 = klan.getMembers().iterator();

            while(var9.hasNext()) {
                UUID uuid = (UUID)var9.next();
                if (!uuid.equals(klan.getLeader()) && !klan.getOfficers().contains(uuid)) {
                    if (!memberList.isEmpty()) {
                        memberList.append("&7, &f");
                    }

                    memberList.append(this.getPlayerName(uuid));
                }
            }

            if (!memberList.isEmpty()) {
                MessageUtil.sendRaw(player, " &6Uyeler: &f" + String.valueOf(memberList));
            }
        }

    }

    private void handleRanking(Player player) {
        List<Klan> ranking = this.klanManager.getKlanRanking();
        if (ranking.isEmpty()) {
            MessageUtil.sendInfo(player, "Henuz hicbir klan bulunmuyor.");
        } else {
            String var10000 = ChatColor.GRAY.toString();
            String line = var10000 + String.valueOf(ChatColor.STRIKETHROUGH) + "                                                  ";
            player.sendMessage(line);
            MessageUtil.sendRaw(player, "&6&l   ✦ &e&lKLAN SIRALAMA &6&l✦");
            player.sendMessage("");
            int count = Math.min(ranking.size(), 10);

            for(int i = 0; i < count; ++i) {
                Klan klan = (Klan)ranking.get(i);
                switch(i) {
                    case 0:
                        var10000 = "&6";
                        break;
                    case 1:
                        var10000 = "&f";
                        break;
                    case 2:
                        var10000 = "&c";
                        break;
                    default:
                        var10000 = "&7";
                }

                String color = var10000;
                MessageUtil.sendRaw(player, " " + color + "#" + (i + 1) + " &e" + klan.getName() + " &8- &7" + klan.getMemberCount() + " uye &8| &7Kasa: " + this.economyManager.format(klan.getBank()));
            }

            player.sendMessage(line);
        }
    }

    private void handleDeposit(Player player, String[] args) {
        if (!this.economyManager.isEnabled()) {
            MessageUtil.sendError(player, "Ekonomi sistemi aktif degil!");
        } else {
            Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
            if (klan == null) {
                MessageUtil.sendError(player, "Bir klana uye degilsin!");
            } else if (args.length < 2) {
                MessageUtil.sendError(player, "Kullanim: /klan parayatir <miktar>");
            } else {
                double amount;
                try {
                    amount = Double.parseDouble(args[1]);
                } catch (NumberFormatException var7) {
                    MessageUtil.sendError(player, "Gecerli bir miktar gir!");
                    return;
                }

                if (amount <= 0.0D) {
                    MessageUtil.sendError(player, "Miktar 0'dan buyuk olmalidir!");
                } else if (this.economyManager.getBalance(player) < amount) {
                    MessageUtil.sendError(player, "Yeterli bakiyen yok!");
                } else {
                    this.economyManager.withdraw(player, amount);
                    this.klanManager.depositBank(klan, amount);
                    String var10001 = String.valueOf(ChatColor.GOLD);
                    MessageUtil.sendSuccess(player, "Klan kasasina " + var10001 + this.economyManager.format(amount) + String.valueOf(ChatColor.GREEN) + " yatirdin.");
                    String var10002 = String.valueOf(ChatColor.GREEN);
                    this.broadcastToKlan(klan, var10002 + player.getName() + String.valueOf(ChatColor.YELLOW) + " klan kasasina " + String.valueOf(ChatColor.GOLD) + this.economyManager.format(amount) + String.valueOf(ChatColor.YELLOW) + " yatirdi.");
                }
            }
        }
    }

    private void handleWithdraw(Player player, String[] args) {
        if (!this.economyManager.isEnabled()) {
            MessageUtil.sendError(player, "Ekonomi sistemi aktif degil!");
        } else {
            Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
            if (klan == null) {
                MessageUtil.sendError(player, "Bir klana uye degilsin!");
            } else if (!klan.isLeader(player.getUniqueId())) {
                MessageUtil.sendError(player, "Bu komutu sadece klan lideri kullanabilir!");
            } else if (args.length < 2) {
                MessageUtil.sendError(player, "Kullanim: /klan paracek <miktar>");
            } else {
                double amount;
                try {
                    amount = Double.parseDouble(args[1]);
                } catch (NumberFormatException var7) {
                    MessageUtil.sendError(player, "Gecerli bir miktar gir!");
                    return;
                }

                if (amount <= 0.0D) {
                    MessageUtil.sendError(player, "Miktar 0'dan buyuk olmalidir!");
                } else if (!this.klanManager.withdrawBank(klan, amount)) {
                    EconomyManager var8 = this.economyManager;
                    MessageUtil.sendError(player, "Klan kasasinda yeterli bakiye yok! Kasa: " + var8.format(klan.getBank()));
                } else {
                    this.economyManager.deposit(player, amount);
                    String var10001 = String.valueOf(ChatColor.GOLD);
                    MessageUtil.sendSuccess(player, "Klan kasasindan " + var10001 + this.economyManager.format(amount) + String.valueOf(ChatColor.GREEN) + " cektin.");
                    String var10002 = String.valueOf(ChatColor.GOLD);
                    this.broadcastToKlan(klan, var10002 + player.getName() + String.valueOf(ChatColor.YELLOW) + " klan kasasindan " + String.valueOf(ChatColor.GOLD) + this.economyManager.format(amount) + String.valueOf(ChatColor.YELLOW) + " cekti.");
                }
            }
        }
    }

    private void handleSiege(Player player) {
        MessageUtil.sendInfo(player, "&c&lKusatma Savasi &esistemi yakinda aktif olacak!");
    }

    private void handleDisband(Player player) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (!klan.isLeader(player.getUniqueId())) {
            MessageUtil.sendError(player, "Bu komutu sadece klan lideri kullanabilir!");
        } else {
            String klanName = klan.getName();
            String var10002 = String.valueOf(ChatColor.RED);
            this.broadcastToKlan(klan, var10002 + "'" + klanName + "' klani dagitildi!");
            this.klanManager.disbandKlan(klanName);
            String var10001 = String.valueOf(ChatColor.GOLD);
            MessageUtil.sendSuccess(player, "'" + var10001 + klanName + String.valueOf(ChatColor.GREEN) + "' klani basariyla dagitildi.");
        }
    }

    private void handleTransferLeader(Player player, String[] args) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (!klan.isLeader(player.getUniqueId())) {
            MessageUtil.sendError(player, "Bu komutu sadece klan lideri kullanabilir!");
        } else if (args.length < 2) {
            MessageUtil.sendError(player, "Kullanim: /klan lider <oyuncu>");
        } else {
            Player target = Bukkit.getPlayerExact(args[1]);
            if (target == null) {
                MessageUtil.sendError(player, "Oyuncu bulunamadi veya cevrimdisi!");
            } else if (!klan.isMember(target.getUniqueId())) {
                MessageUtil.sendError(player, "Bu oyuncu klaninda degil!");
            } else if (target.equals(player)) {
                MessageUtil.sendError(player, "Zaten lidersin!");
            } else {
                this.klanManager.transferLeadership(klan, target.getUniqueId());
                String var10002 = String.valueOf(ChatColor.GOLD);
                this.broadcastToKlan(klan, var10002 + target.getName() + String.valueOf(ChatColor.YELLOW) + " yeni klan lideri oldu!");
            }
        }
    }

    private void handleToggleOfficer(Player player, String[] args) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (!klan.isLeader(player.getUniqueId())) {
            MessageUtil.sendError(player, "Bu komutu sadece klan lideri kullanabilir!");
        } else if (args.length < 2) {
            MessageUtil.sendError(player, "Kullanim: /klan yetki <oyuncu>");
        } else {
            Player target = Bukkit.getPlayerExact(args[1]);
            if (target == null) {
                MessageUtil.sendError(player, "Oyuncu bulunamadi veya cevrimdisi!");
            } else if (!klan.isMember(target.getUniqueId())) {
                MessageUtil.sendError(player, "Bu oyuncu klaninda degil!");
            } else if (klan.isLeader(target.getUniqueId())) {
                MessageUtil.sendError(player, "Liderin yetkisini degistiremezsin!");
            } else {
                boolean wasOfficer = klan.getOfficers().contains(target.getUniqueId());
                this.klanManager.toggleOfficer(klan, target.getUniqueId());
                String var10002;
                if (wasOfficer) {
                    var10002 = String.valueOf(ChatColor.RED);
                    this.broadcastToKlan(klan, var10002 + target.getName() + String.valueOf(ChatColor.YELLOW) + " artik Yonetici degil.");
                } else {
                    var10002 = String.valueOf(ChatColor.GREEN);
                    this.broadcastToKlan(klan, var10002 + target.getName() + String.valueOf(ChatColor.YELLOW) + " Yonetici olarak atandi!");
                }

            }
        }
    }

    private void handleRename(Player player, String[] args) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (!klan.isLeader(player.getUniqueId())) {
            MessageUtil.sendError(player, "Bu komutu sadece klan lideri kullanabilir!");
        } else if (args.length < 2) {
            MessageUtil.sendError(player, "Kullanim: /klan isim <yeni isim>");
        } else {
            String newName = args[1];
            if (newName.length() >= 3 && newName.length() <= 16) {
                if (!newName.matches("[a-zA-Z0-9çÇğĞıİöÖşŞüÜ]+")) {
                    MessageUtil.sendError(player, "Klan ismi sadece harf ve rakam icermelidir.");
                } else if (this.klanManager.klanExists(newName) && !newName.equalsIgnoreCase(klan.getName())) {
                    MessageUtil.sendError(player, "Bu isimde bir klan zaten var!");
                } else {
                    String oldName = klan.getName();
                    this.klanManager.renameKlan(klan, newName);
                    String var10002 = String.valueOf(ChatColor.YELLOW);
                    this.broadcastToKlan(klan, var10002 + "Klan ismi '" + String.valueOf(ChatColor.GOLD) + oldName + String.valueOf(ChatColor.YELLOW) + "' -> '" + String.valueOf(ChatColor.GOLD) + newName + String.valueOf(ChatColor.YELLOW) + "' olarak degistirildi.");
                }
            } else {
                MessageUtil.sendError(player, "Klan ismi 3-16 karakter arasinda olmalidir.");
            }
        }
    }

    private void handleMotd(Player player, String[] args) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (!klan.isOfficerOrLeader(player.getUniqueId())) {
            MessageUtil.sendError(player, "Bu komutu kullanmak icin Yonetici veya Lider olmalisin!");
        } else if (args.length < 2) {
            MessageUtil.sendError(player, "Kullanim: /klan motd <mesaj>");
        } else {
            String motd = String.join(" ", (CharSequence[])Arrays.copyOfRange(args, 1, args.length));
            this.klanManager.setMotd(klan, motd);
            String var10002 = String.valueOf(ChatColor.YELLOW);
            this.broadcastToKlan(klan, var10002 + "Klan mesaji guncellendi: " + String.valueOf(ChatColor.WHITE) + motd);
        }
    }

    private void handleChat(Player player, String[] args) {
        Klan klan = this.klanManager.getPlayerKlan(player.getUniqueId());
        if (klan == null) {
            MessageUtil.sendError(player, "Bir klana uye degilsin!");
        } else if (args.length < 2) {
            MessageUtil.sendError(player, "Kullanim: /klan chat <mesaj>");
        } else {
            String message = String.join(" ", (CharSequence[])Arrays.copyOfRange(args, 1, args.length));
            KlanRole role = klan.getRole(player.getUniqueId());
            String roleTag = role != null ? role.getDisplayName() : "Üye";
            String formatted = String.valueOf(ChatColor.GOLD) + "[" + String.valueOf(ChatColor.YELLOW) + klan.getName() + String.valueOf(ChatColor.GOLD) + "] " + String.valueOf(ChatColor.GRAY) + "[" + roleTag + "] " + String.valueOf(ChatColor.GREEN) + player.getName() + String.valueOf(ChatColor.WHITE) + ": " + message;
            Iterator var8 = klan.getMembers().iterator();

            while(var8.hasNext()) {
                UUID memberId = (UUID)var8.next();
                Player member = Bukkit.getPlayer(memberId);
                if (member != null && member.isOnline()) {
                    member.sendMessage(formatted);
                }
            }

        }
    }

    private void broadcastToKlan(Klan klan, String message) {
        Iterator var3 = klan.getMembers().iterator();

        while(var3.hasNext()) {
            UUID memberId = (UUID)var3.next();
            Player member = Bukkit.getPlayer(memberId);
            if (member != null && member.isOnline()) {
                MessageUtil.sendInfo(member, message);
            }
        }

    }

    private String getPlayerName(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) {
            return player.getName();
        } else {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(uuid);
            return offlinePlayer.getName() != null ? offlinePlayer.getName() : "Bilinmiyor";
        }
    }

    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (args.length == 1) {
                List<String> subcommands = List.of(new String[]{"olustur", "davet", "kabul", "reddet", "cik", "cikar", "bilgi", "siralama", "parayatir", "paracek", "siege", "dagit", "lider", "yetki", "isim", "motd", "chat"});
                return this.filterStartsWith(subcommands, args[0]);
            } else {
                if (args.length == 2) {
                    String sub = args[0].toLowerCase(Locale.ROOT);
                    byte var7 = -1;
                    switch(sub.hashCode()) {
                        case 93740199:
                            if (sub.equals("bilgi")) {
                                var7 = 5;
                            }
                            break;
                        case 94662582:
                            if (sub.equals("cikar")) {
                                var7 = 1;
                            }
                            break;
                        case 95358472:
                            if (sub.equals("davet")) {
                                var7 = 0;
                            }
                            break;
                        case 100620782:
                            if (sub.equals("cıkar")) {
                                var7 = 2;
                            }
                            break;
                        case 102967668:
                            if (sub.equals("lider")) {
                                var7 = 3;
                            }
                            break;
                        case 114869830:
                            if (sub.equals("yetki")) {
                                var7 = 4;
                            }
                    }

                    switch(var7) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            return this.filterStartsWith(this.getOnlinePlayerNames(), args[1]);
                        case 5:
                            return this.filterStartsWith(new ArrayList(this.klanManager.getAllKlanNames()), args[1]);
                    }
                }

                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }

    private List<String> getOnlinePlayerNames() {
        List<String> names = new ArrayList();
        Iterator var2 = Bukkit.getOnlinePlayers().iterator();

        while(var2.hasNext()) {
            Player p = (Player)var2.next();
            names.add(p.getName());
        }

        return names;
    }

    private List<String> filterStartsWith(List<String> list, String prefix) {
        String lower = prefix.toLowerCase(Locale.ROOT);
        return list.stream().filter((s) -> {
            return s.toLowerCase(Locale.ROOT).startsWith(lower);
        }).toList();
    }
}