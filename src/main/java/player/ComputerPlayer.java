package player;

import move.Move;

public class ComputerPlayer implements Player {

    private String name;
    private Move[] availableMoves;

    public ComputerPlayer(String name, Move[] availableMoves) {
        this.name = name;
        this.availableMoves = availableMoves;
    }

    @Override
    public Move makeMove() {
        int randomIndex = (int) (Math.random() * availableMoves.length);
        return availableMoves[randomIndex];
    }

    @Override
    public String getName() {
        return name;
    }
}
