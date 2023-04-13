package ua.lviv.iot.algo.part1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.Games.BoardingGame;
import ua.lviv.iot.algo.part1.Games.ComputerGame;
import ua.lviv.iot.algo.part1.Games.Game;
import ua.lviv.iot.algo.part1.Managers.GameWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;


public class GameWriterTest {

    private static final String CSV_FILE_PATH = "games_test.csv"; // path to the test CSV file
    private GameWriter gameWriter;
    private ArrayList<Game> games;

    @BeforeEach
    public void setUp() {
        gameWriter = new GameWriter("games_test.csv");
        games = new ArrayList<>();
        games.add(new ComputerGame(4, 1, 2, "Publisher1", 2020, "Game1", true));
        games.add(new ComputerGame(6, 2, 3, "Publisher2", 2019, "Game2", false));
        games.add(new BoardingGame(3,1,2,"Publisher3",2021,"Game3"));
    }

    @Test
    public void testWriteEmptyGames() throws IOException {
        System.out.println("TestWriteEmptyGames");
        gameWriter.writeGamesToCSV(new ArrayList<>());

        BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH));
        String line;
        ArrayList<String> writtenLines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            writtenLines.add(line);
        }
        reader.close();

        assertEquals(0,writtenLines.size());

    }

    @Test
    public void testWriteGamesToCSV() throws IOException {
        System.out.println("TestWriteGames");
        gameWriter.writeGamesToCSV(games);

        BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH));
        String line;
        ArrayList<String> writtenLines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            writtenLines.add(line);
        }
        reader.close();

        assertEquals("GameType,MaxPlayers,MinPlayers,CurrentPlayers,Publisher,ReleaseYear,GameTitle,IsMultiplayer", writtenLines.get(0));
        assertEquals("ComputerGame,4,1,2,Publisher1,2020,Game1,true", writtenLines.get(1));
        assertEquals("ComputerGame,6,2,3,Publisher2,2019,Game2,false", writtenLines.get(2));
        assertEquals("GameType,MaxPlayers,MinPlayers,CurrentPlayers,Publisher,ReleaseYear,GameTitle", writtenLines.get(3));
        assertEquals("BoardingGame,3,1,2,Publisher3,2021,Game3", writtenLines.get(4));
    }

}