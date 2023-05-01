package ua.lviv.iot.algo.part1.Managers;

import ua.lviv.iot.algo.part1.Games.Game;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameManager {

    private ArrayList<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public void removeGameByIndex(int index) {
        games.remove(index);
    }

    public ArrayList<Game> findAllGamesWithReleaseYearGreaterThan(int releaseYear) {

        return games.stream()
                .filter(game -> game.getReleaseYear() > releaseYear)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    public ArrayList<Game> findAllGamesWithCurrentPlayerMoreThan(int currentPlayers) {

        return games.stream()
                .filter(game -> game.getCurrentPlayers() > currentPlayers)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public static void printAllGames(ArrayList<Game> games) {
        for (Game game : games) {
            System.out.println(game.toString());
        }
    }
}

