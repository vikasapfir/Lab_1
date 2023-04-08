package ua.lviv.iot.algo.part1.Games;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Game {
    private int maxPlayers;
    private int minPlayers;
    private int currentPlayers = 0;
    private String publisher;
    private int releaseYear;
    private String gameTitle;

    public abstract void connectPlayer();
    public abstract void disconnectPlayer();
}
