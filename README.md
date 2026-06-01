<div align="center">

# BlackOut Addon Template

**Start developing addons for BlackOut CE · Fabric**

![MC](https://img.shields.io/badge/1.21.4-1A1A2E?style=flat-square&labelColor=16213E)
[![License](https://img.shields.io/badge/GPL--3.0-1A1A2E?style=flat-square&logo=gnu&logoColor=white&labelColor=16213E)](LICENSE)
[![Java](https://img.shields.io/badge/Java_21-1A1A2E?style=flat-square&logo=openjdk&logoColor=white&labelColor=16213E)](https://adoptium.net)

[BlackOut CE](https://github.com/LimonTH/Blackout-CE) ·
[Getting Started](#-getting-started) ·
[Guide](ADDON_DEV_GUIDE.md) ·
[Discord](https://discord.gg/GnNBwTMUXp)

</div>

---

## Quick Start

```bash
# 1. Clone the template
git clone https://github.com/LimonTH/Blackout-CE-addon-template
cd Blackout-CE-addon-template

# 2. Build
./gradlew build

# 3. Install
cp build/libs/*.jar ~/.minecraft/mods/
```

## Structure

```
src/main/java/com/example/template/
├── ExampleAddon.java      # Entry point (extends BlackoutAddon)
├── commands/              # Commands (auto-scanned via commandPath)
├── hud/                   # HUD elements (auto-scanned via hudPath)
├── mixins/                # Mixins
└── modules/               # Modules (auto-scanned via modulePath)
```

## Extending

Read the full **[addon development guide](ADDON_DEV_GUIDE.md)** for:

- Adding modules, commands & HUD elements
- Custom themes, menu music & backgrounds
- Event system, notifications & lifecycle hooks
- ClickGUI screens & version compatibility

## Requirements

- **JDK 21**
- **BlackOut CE** (in `mods/`)

---

<div align="center">

[![Discord](https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white)](https://discord.gg/GnNBwTMUXp)

</div>