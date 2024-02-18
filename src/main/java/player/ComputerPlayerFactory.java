package player;

import move.Move;

public interface ComputerPlayerFactory {

    Player createComputerPlayer(String name, Move[] availableMoves);
}
