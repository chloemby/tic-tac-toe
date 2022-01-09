package tictactoe.Exception;

public class UnexpectedSymbolException extends InvalidPlayerMoveException {
    public UnexpectedSymbolException(String message) {
        super(message);
    }
}
