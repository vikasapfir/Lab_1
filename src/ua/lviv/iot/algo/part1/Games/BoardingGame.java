package ua.lviv.iot.algo.part1.Games;


public class BoardingGame extends Game {

    @Override
    public String toString() {
        return "BoardingGame " + super.toString();
    }

    public BoardingGame(int maxPlayers, int minPlayers, int currentPlayers, String publisher, int releaseYear, String gameTitle) {
        super(maxPlayers, minPlayers, currentPlayers, publisher, releaseYear, gameTitle);
    }

    @Override
    public void connectPlayer() {
        if (this.getCurrentPlayers() < this.getMaxPlayers()){
            this.setCurrentPlayers(this.getCurrentPlayers() + 1);
        }
    }

    @Override
    public void disconnectPlayer() {
        if (this.getCurrentPlayers() > 0){
            this.setCurrentPlayers(this.getCurrentPlayers() - 1);
        }
    }
}
