package tictactoe.Exception;

public class InvalidCoordinateValueException extends InvalidPlayerMoveException {
    public InvalidCoordinateValueException(String message) {
        super(message);
    }
}
