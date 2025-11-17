# JetstreamNATS

Proje NetBeans üzerinden oluşturuldu ve NetBeans ile çalıştırılması önerilir. 
NetBeans'de kullanılan konfigürasyon dosyaları eklenmiştir.
Proje'de kullanılan Java kütüphaneleri libs altına eklenmiştir.


# Proje Requirements and Testing

Projenin doğru çalışması için NATS server'ı JetStream ile ayağa kaldırılmalıdır.
```
**C:\Users\...>nats-server -jetstream**
[15544] 2025/11/13 11:09:10.850820 [←[32mINF←[0m] Starting nats-server
[15544] 2025/11/13 11:09:10.850820 [←[32mINF←[0m]   Version:  2.12.1
[15544] 2025/11/13 11:09:10.851327 [←[32mINF←[0m]   Git:      [fab5f99]
[15544] 2025/11/13 11:09:10.851340 [←[32mINF←[0m]   Name:     NAGEBJXUUQG4NJR3AB7U457Z6SVGU5YFXOIKJMHCVSHB3BGGC6D6LCJ2
[15544] 2025/11/13 11:09:10.851340 [←[32mINF←[0m]   Node:     qsKINQ8A
[15544] 2025/11/13 11:09:10.851340 [←[32mINF←[0m]   ID:       NAGEBJXUUQG4NJR3AB7U457Z6SVGU5YFXOIKJMHCVSHB3BGGC6D6LCJ2
[15544] 2025/11/13 11:09:10.851340 [←[32mINF←[0m] Starting JetStream
[15544] 2025/11/13 11:09:10.851340 [←[0;93mWRN←[0m] Temporary storage directory used, data could be lost on system reboot
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]     _ ___ _____ ___ _____ ___ ___   _   __  __
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]  _ | | __|_   _/ __|_   _| _ \ __| /_\ |  \/  |
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m] | || | _|  | | \__ \ | | |   / _| / _ \| |\/| |
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]  \__/|___| |_| |___/ |_| |_|_\___/_/ \_\_|  |_|
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]          https://docs.nats.io/jetstream
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m] ---------------- JETSTREAM ----------------
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]   Strict:          true
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]   Max Memory:      47.74 GB
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]   Max Storage:     1.00 TB
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]   Store Directory: "C:\Users\GOZDE~1.BER\AppData\Local\Temp\nats\jetstream"
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m]   API Level:       2
[15544] 2025/11/13 11:09:10.852385 [←[32mINF←[0m] -------------------------------------------
[15544] 2025/11/13 11:09:10.853419 [←[32mINF←[0m]   Starting restore for stream '$G > LOGGER'
[15544] 2025/11/13 11:09:10.854972 [←[32mINF←[0m]   Restored 140 messages for stream '$G > LOGGER' in 2ms
[15544] 2025/11/13 11:09:10.854972 [←[32mINF←[0m]   Starting restore for stream '$G > ORDERS'
[15544] 2025/11/13 11:09:10.856016 [←[32mINF←[0m]   Restored 0 messages for stream '$G > ORDERS' in 1ms
[15544] 2025/11/13 11:09:10.856016 [←[32mINF←[0m]   Recovering 1 consumers for stream - '$G > LOGGER'
[15544] 2025/11/13 11:09:10.857617 [←[31mFTL←[0m] Error listening on port: 0.0.0.0:4222, "listen tcp 0.0.0.0:4222: bind: Only one usage of each socket address (protocol/network address/port) is normally permitted."
```
Kodu çalıştırdıktan sonra NATS CLI kurulumu yaparak consumer durumu kontrol edilebilir.


**- İhtiyaç olabilecek komutlar;**

```
**C:\Users\...>nats consumer report**
? Select a Stream LOGGER
╭──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮
│                                        Consumer report for LOGGER with 1 consumers                                       │
├───────────────┬──────┬────────────┬──────────┬─────────────┬─────────────┬─────────────┬───────────┬───────────┬─────────┤
│ Consumer      │ Mode │ Ack Policy │ Ack Wait │ Ack Pending │ Redelivered │ Unprocessed │ Ack Floor │ API Level │ Cluster │
├───────────────┼──────┼────────────┼──────────┼─────────────┼─────────────┼─────────────┼───────────┼───────────┼─────────┤
│ logs_consumer │ Pull │ Explicit   │ 30.00s   │ 2           │ 0           │ 0           │ 72        │ 0         │         │
╰───────────────┴──────┴────────────┴──────────┴─────────────┴─────────────┴─────────────┴───────────┴───────────┴─────────╯

**C:\Users\gozde.berberoglu\Desktop\nats-0.3.0-windows-amd64>nats stream report**
Obtaining Stream stats

╭──────────────────────────────────────────────────────────────────────────────────────────────────────╮
│                                             Stream Report                                            │
├────────┬─────────┬───────────┬───────────┬──────────┬────────┬──────┬─────────┬───────────┬──────────┤
│ Stream │ Storage │ Placement │ Consumers │ Messages │ Bytes  │ Lost │ Deleted │ API Level │ Replicas │
├────────┼─────────┼───────────┼───────────┼──────────┼────────┼──────┼─────────┼───────────┼──────────┤
│ ORDERS │ File    │           │ 0         │ 0        │ 0 B    │ 0    │ 0       │ 0         │          │
│ LOGGER │ File    │           │ 1         │ 140      │ 11 KiB │ 0    │ 0       │ 0         │          │
╰────────┴─────────┴───────────┴───────────┴──────────┴────────┴──────┴─────────┴───────────┴──────────╯

**C:\Users\gozde.berberoglu\Desktop\nats-0.3.0-windows-amd64>nats stream view**
? Select a Stream LOGGER
[1] Subject: logs.subtopic1 Received: 2025-11-12 15:06:33
{"logger_id": 1, "status": "message1"}


[2] Subject: logs.subtopic1 Received: 2025-11-12 15:06:33
{"logger_id": 2, "status": "message1"}


[3] Subject: logs.subtopic1 Received: 2025-11-12 15:06:33
{"logger_id": 3, "status": "message1"}


[4] Subject: logs.subtopic1 Received: 2025-11-12 15:06:33
{"logger_id": 4, "status": "message1"}


[5] Subject: logs.subtopic1 Received: 2025-11-12 15:06:33
{"logger_id": 5, "status": "message1"}


[6] Subject: logs.subtopic1 Received: 2025-11-12 15:06:44
{"logger_id": 1, "status": "message1"}


[7] Subject: logs.subtopic1 Received: 2025-11-12 15:06:44
{"logger_id": 2, "status": "message1"}


[8] Subject: logs.subtopic1 Received: 2025-11-12 15:06:44
{"logger_id": 3, "status": "message1"}


[9] Subject: logs.subtopic1 Received: 2025-11-12 15:06:44
{"logger_id": 4, "status": "message1"}


[10] Subject: logs.subtopic1 Received: 2025-11-12 15:06:44
{"logger_id": 5, "status": "message1"}

nats stream add -> Stream oluşturmak için
nats consumer add $STREMADI $CONSUMERADI --filter "$TOPICADI" --ACK explicit --pull
nats consumer rm -> Consumer'ı silmek için,
nats consumer info -> Oluşan consumer için konfigürasyonu gösterir.


## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```

```
cd existing_repo
git remote add origin https://labs.rsnet2.com.tr/midlas/personal-space/gozde/JetstreamNATS.git
git branch -M main
git push -uf origin main
```
