package tictactoe.Exception;

public class CellOccupiedException extends InvalidPlayerMoveException {
    public CellOccupiedException(String message) {
        super(message);
    }
}
