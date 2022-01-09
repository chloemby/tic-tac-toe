package tictactoe.GameResolver;

import tictactoe.GameMap.GameMapInterface;
import tictactoe.Enum.GameState;

public interface GameResolverInterface {
    GameState resolve(GameMapInterface map);
}
