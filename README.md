# Java Discord Bot Template

<p align="center">
  <a href="//discord.gg/5Uvxe5jteM"><img src="https://img.shields.io/discord/936242526120194108?logo=discord"></a>
  <a href="//github.com/freddev-co/Java-Discord-Bot-Template/commits/main"><img src="https://img.shields.io/github/last-commit/freddev-co/Java-Discord-Bot-Template"></a>
  <a href="//github.com/freddev-co/Java-Discord-Bot-Template/releases"><img src="https://img.shields.io/github/downloads/freddev-co/Java-Discord-Bot-Template/total"></a>
  <a href="//github.com/freddev-co/Java-Discord-Bot-Template/blob/main/LICENSE.md"><img src="https://img.shields.io/github/license/freddev-co/Java-Discord-Bot-Template"></a>
  <a href="//github.com/freddev-co/Java-Discord-Bot-Template"><img src="https://img.shields.io/github/languages/code-size/freddev-co/Java-Discord-Bot-Template"></a>
</p>

## General Information

This repository is a template that everyone can use for the start of their discord bot.

If you want to use this template it would be nice if you left a star ⭐ for this repository.

## Technologies Used

- Java `11`
- Spring Boot `2.7.16`
- Lombok
- <a href="//github.com/DV8FromTheWorld/JDA">JDA</a> ``5.2.1``
- <a href="//github.com/Chew/JDA-Chewtils">JDA Chewtils</a> ``2.0-SNAPSHOT``

## Setup

#### Clone the repository

```
git clone https://github.com/freddev-co/Java-Discord-Bot-Template
```

#### Build the project

```
mvn clean package
```

#### Run the project

```
java -jar Java-Discord-Bot-Template.jar
```

## Environment Variables

File: ``src/main/resources/application.yml``

```
server:
  port: 
discord:
  bot-name: 
  token:
  guild-id:
  owner-id:
```

| Field Name   | Usage                           |
|--------------|---------------------------------|
| ``port``     | Default: 8080                   |
| -----------  | --------                        |
| ``bot-name`` | Discord Bot Name                |
| ``token``    | Discord Bot Token               |
| ``guild-id`` | Your Discord Server To Test Bot |
| ``owner-id`` | Your Discord Account ID         |
