package game;

import move.Move;
import move.Paper;
import move.Rock;
import move.Scissors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TestRockPaperScissorsFactory {

    @Test
    void createHumanPlayer() {
        String playerName = "TestPlayer";
        Move[] moves = {new Rock(), new Paper(), new Scissors()};
        Scanner mockScanner = Mockito.mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("1");
        GameFactory gameFactory = new RockPaperScissorsFactory();
        Player player = gameFactory.createHumanPlayer(playerName, moves, mockScanner);
        assertNotNull(player);
        assertTrue(player instanceof HumanPlayer);
        assertEquals(playerName, player.getName());
    }

    @Test
    void createComputerPlayer() {
        String playerName = "Computer";
        Move[] moves = {new Rock(), new Paper(), new Scissors()};
        GameFactory gameFactory = new RockPaperScissorsFactory();
        Player player = gameFactory.createComputerPlayer(playerName, moves);
        assertNotNull(player);
        assertTrue(player instanceof ComputerPlayer);
        assertEquals(playerName, player.getName());
    }

    @Test
    void getAvailableMoves() {
        GameFactory gameFactory = new RockPaperScissorsFactory();
        Move[] availableMoves = gameFactory.getAvailableMoves();
        assertNotNull(availableMoves);
        assertEquals(3, availableMoves.length);
        assertTrue(containsMove(availableMoves, "ROCK"));
        assertTrue(containsMove(availableMoves, "PAPER"));
        assertTrue(containsMove(availableMoves, "SCISSORS"));
    }

    private boolean containsMove(Move[] moves, String moveName) {
        for (Move move : moves) {
            if (move.getName().equals(moveName)) {
                return true;
            }
        }
        return false;
    }
}
