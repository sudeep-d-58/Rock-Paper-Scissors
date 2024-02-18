package move;

import org.junit.jupiter.api.Test;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMoves {

    @Test
    void makeHumanMove() {
        String playerName = "Sudeep";
        Move[] moves = {new Rock(), new Paper(), new Scissors()};
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.next()).thenReturn("1");
        Player humanPlayer = new HumanPlayer(playerName, mockScanner, moves);
        Move move = humanPlayer.makeMove();
        assertNotNull(move);
        assertTrue(move instanceof Rock);
        assertEquals("Sudeep", humanPlayer.getName());
    }

    @Test
    void makeComputerMove() {
        String playerName = "Computer";
        Move[] moves = {new Rock(), new Paper(), new Scissors()};
        Player computerPlayer = new ComputerPlayer(playerName, moves);
        Move move = computerPlayer.makeMove();
        assertNotNull(move);
        assertTrue(move instanceof Rock || move instanceof Paper || move instanceof Scissors);
        assertEquals("Computer", computerPlayer.getName());
    }
}
