package ua.lviv.iot.algo.part1.Games;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Game {



    public String toCSV() {

        return this.getMaxPlayers() + "," + this.getMinPlayers() + ","
                + this.getCurrentPlayers() + "," + this.getPublisher() + ","
                + this.getReleaseYear() + "," + this.getGameTitle();
    }


    public String getHeaders() {
        return "MaxPlayers,MinPlayers,CurrentPlayers,Publisher,ReleaseYear,GameTitle";
    }

    private int maxPlayers;
    private int minPlayers;
    private int currentPlayers = 0;
    private String publisher;
    private int releaseYear;
    private String gameTitle;

    public abstract void connectPlayer();
    public abstract void disconnectPlayer();
}
