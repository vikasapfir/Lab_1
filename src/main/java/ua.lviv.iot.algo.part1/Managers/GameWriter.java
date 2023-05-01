package ua.lviv.iot.algo.part1.Managers;

import ua.lviv.iot.algo.part1.Games.Game;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameWriter {
    private String CSV_FILE_PATH = "games.csv"; // path to the CSV file

    public GameWriter(String CSV_FILE_PATH) {
        this.CSV_FILE_PATH = CSV_FILE_PATH;
    }

    public String getCSV_FILE_PATH() {
        return CSV_FILE_PATH;
    }

    public void setCSV_FILE_PATH(String CSV_FILE_PATH) {
        this.CSV_FILE_PATH = CSV_FILE_PATH;
    }

    public void writeGamesToCSV(ArrayList<Game> games) {



        //try - пробуємо виконати ділянку коду
        try {
            FileWriter writer = new FileWriter(CSV_FILE_PATH);
            writer.append("");

            //групуємо ігри за назвою класу
            Map<String, List<Game>> gamesGrouped =
                    games.stream().collect(Collectors.groupingBy(g -> g.getClass().getSimpleName()));

            //проходимося по всіх назвах класу
            for (String gameType : gamesGrouped.keySet()) {


                //робимо один раз хедер для одної групи ігор
                writer.append("GameType," + gamesGrouped.get(gameType).get(0).getHeaders());
                writer.append("\n");

                //проходимося по усіх іграх певного типу
                for (Game game : gamesGrouped.get(gameType)) {
                    writer.append(gameType + "," + game.toCSV());
                    writer.append("\n");
                }
            }

            writer.flush();
            writer.close();
            System.out.println("Games have been written to CSV file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}