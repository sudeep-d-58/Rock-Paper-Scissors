package player;

import move.Move;

public interface Player {

    Move makeMove();

    String getName();
}
