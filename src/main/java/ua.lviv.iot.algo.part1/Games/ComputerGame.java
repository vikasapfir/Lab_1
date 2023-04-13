package ua.lviv.iot.algo.part1.Games;


public class ComputerGame extends Game{



    @Override
    public String toString() {
        return "ComputerGame{" +
                "isMultiplayer=" + isMultiplayer +
                ", " + super.toString();
    }

    private boolean isMultiplayer;

    public ComputerGame(int maxPlayers, int minPlayers, int currentPlayers,
                        String publisher, int releaseYear, String gameTitle, boolean isMultiplayer) {
        super(maxPlayers, minPlayers, currentPlayers, publisher, releaseYear, gameTitle);
        this.isMultiplayer = isMultiplayer;
    }

    @Override
    public String toCSV() {

        return super.toCSV() + ',' + isMultiplayer();
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ",IsMultiplayer";
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

    public boolean isMultiplayer() {
        return isMultiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        isMultiplayer = multiplayer;
    }
}
