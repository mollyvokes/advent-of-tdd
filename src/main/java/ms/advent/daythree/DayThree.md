## Advent of Code - Day Three

### Problem Summary

Elf has to fix a machine by identifying part numbers in a grid of numbers and symbols.
You must find the numbers. If a number is adjacent in any direction to a symbol, it is a part number.

### Thoughts and Notes

- going to be more test driven today
- this reminds me of the island pattern problem. Should implement a breadth first search, that way will find the full number then can look next to it for another number and for all the symbols around.
- should have one class for the engine schematic. This should be initialised from the file that is read in and should become an array of arrays
- the class should have a method for the search that looks at all adjacent squares
- the class should have a method that calls this search that is going through all elements



Given UP ON THIS DAY . too difficult


Had a thought - could go through and look for a symbol, then do a search of every square around it for a number.
If find a number, can use the index to look left and right of it and find the number to return !