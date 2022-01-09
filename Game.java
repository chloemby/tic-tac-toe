package tictactoe;

import tictactoe.Enum.GameState;
import tictactoe.GameMap.GameMap;
import tictactoe.GameMap.GameMapInterface;
import tictactoe.GameResolver.GameResolver;
import tictactoe.GameResolver.GameResolverInterface;
import tictactoe.PlayerMove.PlayerMove;
import tictactoe.PlayerMove.PlayerMoveFacade;

public class Game {
    private GameMapInterface map;
    private GameResolverInterface gameResolver;
    private PlayerMoveFacade playerMoveFacade;

    public Game (int size) {
        this.map = new GameMap(size);
        this.gameResolver = new GameResolver();
        this.playerMoveFacade = new PlayerMoveFacade(this.map);
    }

    public void start() {
        this.map.print();
    }

    public boolean isEnded() {
        return !this.gameResolver.resolve(this.map).equals(GameState.NOT_FINISHED);
    }

    public String end() {
        return this.gameResolver.resolve(this.map).getDescription();
    }

    public void makeMove() {
        PlayerMove move = this.playerMoveFacade.getPlayerMove();

        this.map.setCell(move.getX(), move.getY(), move.getCellState());

        this.map.print();
    }
}
