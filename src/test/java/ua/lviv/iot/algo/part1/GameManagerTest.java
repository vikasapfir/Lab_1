package ua.lviv.iot.algo.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.Games.*;
import ua.lviv.iot.algo.part1.Managers.GameManager;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @Test
    void testAddGame() {
        Game game = new ComputerGame(2, 1, 2,
                "GSC Game World", 2023, "Stalker2", true);
        gameManager.addGame(game);
        ArrayList<Game> games = gameManager.getGames();
        assertEquals(1, games.size());
        assertEquals(game, games.get(0));
    }

    @Test
    void testRemoveGame() {
        Game game = new ComputerGame(2, 1, 2,
                "GSC Game World", 2023, "Stalker2", true);
        gameManager.addGame(game);
        gameManager.removeGame(game);
        ArrayList<Game> games = gameManager.getGames();
        assertEquals(0, games.size());
    }

    @Test
    void testRemoveGameByIndex() {
        Game game = new ComputerGame(2, 1, 2,
                "GSC Game World", 2023, "Stalker2", true);
        gameManager.addGame(game);
        gameManager.removeGameByIndex(0);
        ArrayList<Game> games = gameManager.getGames();
        assertEquals(0, games.size());
    }

    @Test
    void testFindAllGamesWithReleaseYearGreaterThan() {
        Game game1 = new ComputerGame(2, 1, 2,
                "GSC Game World", 2023, "Stalker2", true);
        Game game2 = new ComputerGame(2, 1, 2,
                "GSC Game World", 2020, "Stalker", true);
        gameManager.addGame(game1);
        gameManager.addGame(game2);
        ArrayList<Game> games = gameManager.findAllGamesWithReleaseYearGreaterThan(2021);
        assertEquals(1, games.size());
        assertEquals(game1, games.get(0));
    }

    @Test
    void testFindAllGamesWithCurrentPlayerMoreThan() {
        Game game1 = new ComputerGame(3, 1, 2,
                "GSC Game World", 2023, "Stalker2", true);
        Game game2 = new ComputerGame(3, 1, 2,
                "GSC Game World", 2020, "Stalker", true);
        gameManager.addGame(game1);
        gameManager.addGame(game2);
        ArrayList<Game> games = gameManager.findAllGamesWithCurrentPlayerMoreThan(2);
        assertEquals(0, games.size());
        game1.connectPlayer();
        game2.connectPlayer();
        games = gameManager.findAllGamesWithCurrentPlayerMoreThan(2);
        assertEquals(2, games.size());
        assertTrue(games.contains(game1));
        assertTrue(games.contains(game2));
    }
}
