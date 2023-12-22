## Advent of Code - Day 7

### Overview of Problem

- You arrive at the desert and an elf asks for parts. She explains there are lots of rocks blocking Island Island which are normally moved by machines but she needs parts to fix them
- For the journey, she teaches you a game of Camel Cards. Its like poker.
- You get a list of hands and you should order them based on their strength
- Each hand has 5 cards, with the value corresponding to decreasing order (A highest).
- Each hand is a type. i.e., 5 of a kind, 4 of a kind, full house, 3 of a kind, 2 pair, 1 pair, high card
- The above ordering of hand type take priority in comparing strength
- If they have the same type, there is a different ruling: 
  - Compare first card in each hand. If they are different, the one with the highest is strongest
  - If they are the same, continue on for subsequent cards
- To play, you get your hands and a bid for each one. Each hand wins the bid multiplied by its rank. I.e. last hand has rank 1, so x1.
- Add up all the big times their position and you have your winnings!

### Breakdown of Problem

- need to take each hard and figure out each what value it is - could start by seeing how many of the same number are in each hand ? and if not, check for the order - probably sort the cards first. 

### P2 

Jack is now a wildcard and will be whatever card would make the hand strongest. But individually they become the weakest - so have value 1.
When you compare 2 hands of same type, J should be seen as a 1 

- need to change J to value 1
- need to consider number of 1's and add it to the highest value other repeating cards