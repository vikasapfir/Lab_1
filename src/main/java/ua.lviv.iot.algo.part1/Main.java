package ua.lviv.iot.algo.part1;

import ua.lviv.iot.algo.part1.Games.*;
import ua.lviv.iot.algo.part1.Managers.GameManager;
import ua.lviv.iot.algo.part1.Managers.GameWriter;

public class Main {
    public static void main(String[] args) {
        ComputerGame game1 = new ComputerGame(8, 1, 1,
                "GSC Game World", 2023, "Stalker2", true);

        BoardingGame game2 = new BoardingGame(12, 1, 1,
                "Parker Brothers", 1934, "Monopoly");

        SportsGame game3 = new SportsGame(16, 2, 5,
                "Football Association", 1863, "Football", true);

        CardGame game4 = new CardGame(8, 2, 8,
                "Mattel", 1971, "UNO", 1, 56);


        ComputerGame game5 = new ComputerGame(4, 1, 1,
                "GSC Game World", 2035, "Stalker5", true);

        GameManager manager1 = new GameManager();

        manager1.addGame(game1);
        manager1.addGame(game2);
        manager1.addGame(game3);
        manager1.addGame(game4);
        manager1.addGame(game5);

        //Через статік функцію геймменеджера виводимо ігри менеджера1
        GameManager.printAllGames(manager1.getGames());

        System.out.println();

        GameManager.printAllGames(manager1.findAllGamesWithReleaseYearGreaterThan(2020));


        System.out.println(game4.getMaxPlayers());
        System.out.println(game4.toCSV());

        GameWriter writer = new GameWriter("games.csv");

        writer.writeGamesToCSV(manager1.getGames());

    }
}