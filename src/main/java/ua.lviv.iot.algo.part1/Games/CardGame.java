package ua.lviv.iot.algo.part1.Games;

public class CardGame extends Game {
    private int numberOfDecks;
    private int numberOfCardsPerDeck;


    @Override
    public String toCSV() {

        return super.toCSV() + "," + getNumberOfDecks() + "," + getNumberOfCardsPerDeck();
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ",NumberOfDecks,NumberOfCardsPerDeck";
    }

    public CardGame(int maxPlayers, int minPlayers, int currentPlayers, String publisher, int releaseYear, String gameTitle) {
        super(maxPlayers, minPlayers, currentPlayers, publisher, releaseYear, gameTitle);
    }

    public CardGame(int maxPlayers, int minPlayers, int currentPlayers, String publisher, int releaseYear, String gameTitle,
                    int numberOfDecks, int numberOfCardsPerDeck) {
        super(maxPlayers, minPlayers, currentPlayers, publisher, releaseYear, gameTitle);
        this.numberOfDecks = numberOfDecks;
        this.numberOfCardsPerDeck = numberOfCardsPerDeck;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    public void setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

    public int getNumberOfCardsPerDeck() {
        return numberOfCardsPerDeck;
    }

    public void setNumberOfCardsPerDeck(int numberOfCardsPerDeck) {
        this.numberOfCardsPerDeck = numberOfCardsPerDeck;
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

    @Override
    public String toString() {
        return "CardGame{" +
                "numberOfDecks=" + numberOfDecks +
                ", numberOfCardsPerDeck=" + numberOfCardsPerDeck +
                ", " + super.toString();
    }
}
