# JetstreamNATS

Proje NetBeans üzerinden oluşturuldu ve NetBeans ile çalıştırılması önerilir. 
NetBeans'de k[]([[[url](url)](url)](url))ullanılan konfigürasyon dosyaları eklenmiştir.
Proje'de kullanılan Java kütüphaneleri libs altına eklenmiştir.


# Proje Requirements and Testing

Projenin doğru çalışması için NATS server'ı JetStream ile ayağa kaldırılmalıdır.
Uyarı: NATS Server ortak alanda \\llfs\SFS\HSSD\FSM\FSETB\01-ORTAK\_Development'da bulunmaktadır. (nats-server-v2.12.1-windows-amd64)

**C:\Users\gozde.berberoglu\Desktop\nats-server-v2.12.1-windows-amd64>nats-server -jetstream**
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

Kodu çalıştırdıktan sonra NATS CLI kurulumu yaparak consumer durumu kontrol edilebilir.
Uyarı: NATS CLI ortak alanda \\llfs\SFS\HSSD\FSM\FSETB\01-ORTAK\_Development'da bulunmaktadır. bulunmaktadır. (nats-0.3.0-windows-amd64


**- İhtiyaç olabilecek komutlar;**

**C:\Users\gozde.berberoglu\Desktop\nats-0.3.0-windows-amd64>nats consumer report**
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


## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://labs.rsnet2.com.tr/midlas/personal-space/gozde/JetstreamNATS.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://labs.rsnet2.com.tr/midlas/personal-space/gozde/JetstreamNATS/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

# Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thanks to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README

Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
