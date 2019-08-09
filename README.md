# RandomHeal (J.A.H.P Just Another Heal Plugin)
Allows for /heal while keeping effects from RandomPackage

## Dependencies:
- None, works without any plugins

## Screenshots:
- [GIF](https://media.giphy.com/media/f5YppD6E5ilYNZTXFD/source.gif)

## Commands:
- /heal - Heals the current player
- /heal <player> - Heals the specified player
- /RandomHeal - Plugin Information

## Permission:
- RandomHeal.heal - /heal
- RandomHeal.heal.others - /heal <player>
- RandomHeal.info - /RandomHeal
  
## Config:
<details>
  <summary>Click to view</summary>
 
 ```
  messages:
  self healed: "&a&l(!) &aYou have been healed!"
  other healed: "&a&l(!) &a&l{PLAYER_NAME} &ahas been healed!" #Valid placeholders: {PLAYER_NAME} - Player name, {PLAYER_DISPLAYNAME} - Player Displayname
  other healed by: "&a&l(!) &aYou were healed by &a&l{HEALED_BY_PLAYER_NAME}" #Valid Placeholders: {HEALED_BY_PLAYER_NAME} - Player name of player that healed them, {HEALED_BY_PLAYER_DISPLAYNAME} - Player displayname of player that healed them
  no permission: "&c&l(!) &cNo Permission"
  
settings:
  tell other player they were healed: true
  ```
</details>
