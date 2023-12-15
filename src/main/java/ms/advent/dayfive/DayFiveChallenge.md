## Advent of Code - Day Five

### Summary of Problem

- the water is off because island island ran out of sand to filter it
- you wait for the ferry to get to the sand and he asks for your help with the food production problem
- Island Island Almanac arrived and it lists:
  - seeds that require planting
  - soil to use with each seed
  - fertilizer to use with each soil
  - water to use with each fertilizer
  - etc etc
- The almanac starts with a list of seeds, then maps which describe how to convert between the number types.
- Each map contains 3 numbers: destination range start, source range start, range length.
- If there is a source missing, then the destination number is the same.
- You can calculate a location by going through all the links to location at the end. 
- The gardener wants to find the lowest location number

### Notes

Need to first sort the file input so that each of the maps is separate - could do this by looking at the blanks as separates, 
and getting the numbers by removing after the : 

Can have a class that define each line i.e. dest range start, source range start, range

For each seed / input, would be comparing to the source numbers to see which it falls between - could order by source numbers.

