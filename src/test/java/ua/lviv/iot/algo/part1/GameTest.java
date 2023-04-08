package ua.lviv.iot.algo.part1;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.Games.ComputerGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    
   @Test
    void testConnectPlayer1(){
       ComputerGame game1 = new ComputerGame(2, 1, 2,
               "GSC Game World", 2023, "Stalker2", true);
       game1.connectPlayer();
       assertEquals(2, game1.getCurrentPlayers());
   }


    @Test
    void testConnectPlayer2(){
        ComputerGame game1 = new ComputerGame(2, 1, 1,
                "GSC Game World", 2023, "Stalker2", true);
        game1.connectPlayer();
        assertEquals(2, game1.getCurrentPlayers());
    }


    @Test
    void testDisconnectPlayer1(){
        ComputerGame game1 = new ComputerGame(2, 1, 2,
                "GSC Game World", 2023, "Stalker2", true);
        game1.disconnectPlayer();
        assertEquals(1, game1.getCurrentPlayers());
    }



    @Test
    void testDisconnectPlayer2(){
        ComputerGame game1 = new ComputerGame(2, 1, 0,
                "GSC Game World", 2023, "Stalker2", true);
        game1.disconnectPlayer();
        assertEquals(0, game1.getCurrentPlayers());
    }
}
