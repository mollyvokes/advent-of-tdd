## Advent of Code - Day One

### The advent story: Problems with Snow Production
There's an issue with snow production, and you need to find where the problem is. The elves have provided a map with 50 locations marked with stars. You must visit each location before December 25th arrives and collect the stars by solving puzzles.

## Day One

You had a calibration document with numbers which a long elf has turned into lines of text, mixed with letters and numbers. The original number will be the first digit and then the last digit of the new strings. i.e.:
1abc2 = 12
pqr3stu8vwx = 38
a1b2c3d4e5f = 15
treb7uchet = 77

Take the input, find each individual number and then return the sum of all these numbers.

## Psuedo Solution

### Thoughts and notes
Seems a pointer problem, need to increase a left pointer until a number is found, and decrease a right pointer until the same, and if they meet then it is the met number twice.

for each code:
left pointer = 0
right pointer = len code

    while first digit = none:
        if code [ left ] == number:
            first digit = code [left]
        else:
            left ++

    while right > left:
        if code [right ] == number:
            second digit = code [right]
        else:
            right --

    if right == None:
        right = left

    full num = concat left right     

#### Part 2

Turns out some of the numbers are written as their full string, i.e. 'one' and 'two'. With the same codes and this information, find the correct sum of the numbers.