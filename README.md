# AtheriaKlan

AtheriaKlan, Paper sunucuları için bir klan eklentisidir. Oyuncular klan kurabilir, üye davet edebilir, yönetici atayabilir, klan kasasını kullanabilir ve kendi aralarında sohbet edebilir.

## Gereksinimler ve kurulum

- Paper 1.21.11 ve Java 21
- Klan kasası için Vault ve Vault ile uyumlu bir ekonomi eklentisi
- Yer tutucular için PlaceholderAPI (isteğe bağlı)

`target/atheriaKlan-1.0-SNAPSHOT.jar` dosyasını sunucunun `plugins` klasörüne koyup sunucuyu yeniden başlatın. Vault veya PlaceholderAPI kullanacaksanız onları da sunucuya kurun. Vault olmadan klan kasasına para yatırma ve kasadan para çekme komutları çalışmaz; diğer klan komutları kullanılabilir.

Kaynak koddan derlemek için:

```bash
mvn clean package
```

Oluşturulan JAR dosyası `target` klasörüne yazılır. Klan verileri sunucuda `plugins/AtheriaKlan/klans/` altında YAML dosyaları olarak saklanır.

## Komutlar

Ana komut `/klan`; `/clan` da kullanılabilir. Komutlar oyun içindeki oyuncular içindir.

| Komut | Açıklama | Kim kullanabilir? |
| --- | --- | --- |
| `/klan` | Yardım listesini gösterir. | Her oyuncu |
| `/klan olustur <isim>` | Yeni klan kurar. İsim 3–16 karakter olmalıdır. | Klanı olmayan oyuncu |
| `/klan davet <oyuncu>` | Oyuncuyu klana davet eder. Davet 60 saniye geçerlidir. | Lider, yönetici |
| `/klan kabul` | Bekleyen daveti kabul eder. | Davet edilen oyuncu |
| `/klan reddet` | Bekleyen daveti reddeder. | Davet edilen oyuncu |
| `/klan cik` | Klandan ayrılır. Lider önce liderliği devretmeli veya klanı dağıtmalıdır. | Üye, yönetici |
| `/klan cikar <oyuncu>` | Oyuncuyu klandan çıkarır. Yöneticileri yalnızca lider çıkarabilir. | Lider, yönetici |
| `/klan bilgi [klan]` | Kendi klanının veya belirtilen klanın bilgilerini gösterir. | Her oyuncu |
| `/klan siralama` | İlk 10 klanı gösterir. | Her oyuncu |
| `/klan parayatir <miktar>` | Klan kasasına para yatırır. Vault ekonomisi gerekir. | Klan üyeleri |
| `/klan paracek <miktar>` | Klan kasasından para çeker. Vault ekonomisi gerekir. | Lider |
| `/klan lider <oyuncu>` | Liderliği çevrimiçi bir klan üyesine devreder. | Lider |
| `/klan yetki <oyuncu>` | Bir üyeye yönetici yetkisi verir veya yetkisini kaldırır. | Lider |
| `/klan isim <isim>` | Klanın adını değiştirir. | Lider |
| `/klan motd <mesaj>` | Klan mesajını ayarlar. Mesaj, üyeler sunucuya girdiğinde gösterilir. | Lider, yönetici |
| `/klan chat <mesaj>` | Çevrimiçi klan üyelerine özel mesaj gönderir. | Klan üyeleri |
| `/klan dagit` | Klanı dağıtır. | Lider |

`/klan siege` komutu şu anda yalnızca “yakında” mesajı gösterir; kuşatma sistemi henüz eklenmemiştir.

## PlaceholderAPI

PlaceholderAPI kuruluysa şu yer tutucular kullanılabilir:

| Yer tutucu | Değer |
| --- | --- |
| `%atheriaklan_name%` | Oyuncunun klan adı; klanı yoksa `Yok` |
| `%atheriaklan_rank%` | Oyuncunun klan rolü; klanı yoksa `Yok` |

## Lisans

Bu proje [MIT lisansı](LICENSE) ile yayımlanır.
