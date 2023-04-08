package ua.lviv.iot.algo.part1.Games;

public class SportsGame extends Game {

    @Override
    public String toString() {
        return "SportsGame{" +
                "hasReferee=" + hasReferee +
                ", " + super.toString();
    }

    private boolean hasReferee;

    public SportsGame(int maxPlayers, int minPlayers, int currentPlayers, String publisher, int releaseYear, String gameTitle, boolean hasReferee) {
        super(maxPlayers, minPlayers, currentPlayers, publisher, releaseYear, gameTitle);
        this.hasReferee = hasReferee;
    }


    public boolean hasReferee() {
        return hasReferee;
    }

    public void setHasReferee(boolean hasReferee) {
        this.hasReferee = hasReferee;
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