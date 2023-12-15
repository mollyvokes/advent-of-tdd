## Advent of Code - Day Six

### Problem

- you ferry across to Island Island where there is no sand, but there is a contest to win a trip to Desert Island. You sign up.
- on sign up, you get a sheet with time allowed for each race and the best distance recorded in that time. To win, you need to go further in each race than the record holder
- the boats are toys with a controller. You have to hold down a button to charge the boat, then let it go for the boat to move
- the boats go faster the longer the button was held down, but that time counts towards the total time

The input has a row with time in ms, then record distance in mm.
The starting speed is 0mm/s, and each ms you hold the button, this speed increases by 1.

For each race, find the number of ways you can beat the record time, and multiple all of these together. 

### Notes Approach

- for each, will have to calculate for every distance for every amount of time the button could be held down.
- then will compare this to the record to see if it is less
- if it is less, add it to the number of possible wins