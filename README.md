# Final_Project

Rogue is a game where there is a dungeon with a specified size, a monster (the computer) and the player. If the monster intercepts the player, the monster attacks the player, and depending on its health, the player continues or loses the game. The original game has the player pick up weapons and then allow the player to attack the monster. The fighting is done by the computer, and is a bit random. So instead, we decided to have the player pick up traps and strategically set them up across the map to defeat the monsters instead of fighting them and letting the computer decide the outcome, regardless of how skilled the player might be. 

Features : 

Dungeon

-will be text based

-simple graphics like one letter representing the player, monster or tiles

-dimension of NxN


Player

-The player moves one space at a time

-The player can pick up traps by walking over the square with the item

-The player can place the trap by pressing on a designated key

Monster
-  AI based, can move one space at a time
- will compute the shortest path between itself and the player (manhattan distance)

Code the class Site which will specify the location of the monster and player. It will also have a methods that determines the distance between sites.
Next, we will code the class Monster that will create a new Monster and allow the Monster to move to a specified location.
Then, we will code a similar class called Rogue for the player that will do the nearly the same things as the monster class, as well as give it HP and allow it to carry traps. 
Then we will code the Dungeon class that will create an N by N dungeon with rooms and corridors that won’t be visible to the player until it is explored. Methods will include isLegalMove, isCorridor, and isRoom.
Lastly, we will write the Game class that will instantiate objects defined by the other classes, and will do the game playing. 

At first we will do this in the terminal, text-based, then we can port it over to processing for more visuals.

6/4 - finished site
6/5 - started monster, rogue, dungeon
6/6 - read in file finished for game
