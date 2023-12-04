package ms.advent.daytwo;

import java.util.Map;
import java.util.Objects;

public class CubeBag {

    public int red;
    public int blue;
    public int green;

    public CubeBag(int redCubes, int blueCubes, int greenCubes) {
        this.red = redCubes;
        this.blue = blueCubes;
        this.green = greenCubes;
    }

    public boolean get_cubes(String colour, int numCubes) {
        if (Objects.equals(colour, "red")) {
            return this.red >= numCubes;
        } else if (Objects.equals(colour, "blue")) {
            return this.blue >= numCubes;
        } else if (Objects.equals(colour, "green")) {
            return this.green >= numCubes;
        } else {
            return false;
        }
    }

    public boolean get_possible_game(Map<String, Integer> gameResult) {
        final boolean[] possibleGame = {true};
        gameResult.forEach((colour, numCubes) -> {
            boolean possibleColour = get_cubes(colour, numCubes);
            if (!possibleColour) {
                possibleGame[0] = false;
            }
        });
        return possibleGame[0];
    }
}
