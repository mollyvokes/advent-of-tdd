## Advent of Code - Day 2

### Problem / Game

While killing time with the Elf on snow island, they suggest a game of cubes.

There is a bag with a finite amount of red, blue, and green cubes in. Each game there may be a different amount of cubes in the bag. 
The Elf will reach into the bag a few times, pull out a handful of cubes and show you. You will end up with a set of results from many games.
Given a certain starting number of cubes, figure out which games might have been possible, and sum their indexes.

### Thoughts

Will have a class for the cube bag, that can be initialised with the number of cubes. 
In this class have methods to get the colours of cubes and return if it is possible.

In main class will have a method to get the highest number of each colour cube pulled out per game to try. 
Have a feeling p2 will likely be that the cubes aren't returned to the bag so may have to update this.

