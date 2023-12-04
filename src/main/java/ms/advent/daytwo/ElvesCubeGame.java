package ms.advent.daytwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElvesCubeGame {
    public static int get_game_index(String game) {
        String gameIndex = game.split(":")[0];
        return Integer.parseInt(gameIndex.replace("Game", "").strip());
    }


    public static Map<String, String> get_cube_values(String game) {
        String[] gameDetails = game.split(":")[1].split(";");
        String[] colours = new String[]{"red", "blue", "green"};
        Map<String, String> gameCubes = new HashMap<>();

        for (String round: gameDetails) {
            for (String eachColour: round.split(",")) {
                for (String colour: colours) {
                    if (eachColour.contains(colour)) {
                        gameCubes.put(colour, gameCubes.getOrDefault(colour, "") + eachColour.replace(colour, "").strip() + ",");
                        break;
                    }
                }
            }
        }

        return gameCubes;
    }

    public static Map<String, Integer> get_highest_cubes(String game) {
        Map<String, String> gameRounds = get_cube_values(game);
        Map<String, Integer> gameHighest = new HashMap<>();

        gameRounds.forEach((colour, numbers) -> {
            int maxCubes = Arrays.stream(numbers.split(","))
                    .mapToInt(Integer::parseInt)
                    .max()
                    .orElseThrow(() -> new IllegalArgumentException("Empty string"));
            gameHighest.put(colour, maxCubes);

        });
        return gameHighest;
    }

    public static int get_powered_min_cubes(Map<String, Integer> minCubes) {
        final int[] power = {1};
        minCubes.forEach((colour, cubeValue) -> power[0] = power[0] * cubeValue);
        return power[0];
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/day-two-cube-games.txt");
        List<String> allGames = Files.readAllLines(path);

        CubeBag bag = new CubeBag(12, 14, 13);
        int possibleIndexes = 0;
        int poweredMinimums = 0;

        for (String game: allGames) {
            Map<String, Integer> gameResults = get_highest_cubes(game);

            poweredMinimums += get_powered_min_cubes(gameResults);

            if (bag.get_possible_game(gameResults)) {
                possibleIndexes += get_game_index(game);
            }
        }

        System.out.println("the sum of the minimum powers for each game is:" + poweredMinimums);
        System.out.println("the sum of all possible game indexes is:" + possibleIndexes);
    }

}
