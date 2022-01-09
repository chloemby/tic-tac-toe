package tictactoe.PlayerMove;

import tictactoe.Enum.CellState;
import tictactoe.Enum.Player;
import tictactoe.Exception.CellOccupiedException;
import tictactoe.Exception.InvalidCoordinateValueException;
import tictactoe.Exception.InvalidPlayerMoveException;
import tictactoe.Exception.UnexpectedSymbolException;
import tictactoe.GameMap.GameMapInterface;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PlayerMoveFacade {

    private Player currentPlayer;
    private GameMapInterface map;

    public PlayerMoveFacade(GameMapInterface map) {
        this.map = map;
        this.currentPlayer = Player.X_PLAYER;
    }

    public PlayerMove getPlayerMove() {
        PlayerMove move;
        while (true) {
            try {
                move = this.getInputPlayerCoordinates();

                this.validatePlayerMove(move);

                this.setNextPlayer();

                return move;
            } catch (InvalidPlayerMoveException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PlayerMove getInputPlayerCoordinates() throws UnexpectedSymbolException {
        System.out.print("Enter the coordinates: ");

        Scanner scanner = new Scanner(System.in);

        try {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            CellState state = CellState.getFromSymbol(this.currentPlayer.getPlayerSymbol());

            return new PlayerMove(x, y, state);
        } catch (NoSuchElementException e) {
            throw new UnexpectedSymbolException("You should enter numbers!");
        }
    }

    private void setNextPlayer() {
        if (this.currentPlayer.equals(Player.X_PLAYER)) {
            this.currentPlayer = Player.O_PLAYER;
        } else {
            this.currentPlayer = Player.X_PLAYER;
        }
    }

    private void validatePlayerMove(PlayerMove playerMove) throws InvalidPlayerMoveException {
        if (playerMove.getX() < 0 || playerMove.getY() < 0 || playerMove.getX() > this.map.getSize() - 1
                || playerMove.getY() > this.map.getSize() - 1) {
            throw new InvalidCoordinateValueException("Coordinates should be from 1 to 3!");
        }

        if (!this.map.isCellEmpty(playerMove.getX(), playerMove.getY())) {
            throw new CellOccupiedException("This cell is occupied! Choose another one!");
        }
    }
}
