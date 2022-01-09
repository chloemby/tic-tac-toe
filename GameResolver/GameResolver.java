package tictactoe.GameResolver;

import tictactoe.Enum.CellState;
import tictactoe.GameMap.GameMapInterface;
import tictactoe.Enum.GameState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class GameResolver implements GameResolverInterface {
    public GameState resolve(GameMapInterface map) {
        if (!this.isPossibleMapStatesCount(map)) {
            return GameState.IMPOSSIBLE;
        }

        HashSet<GameState> states = new HashSet<>();
        states.add(this.checkAllRows(map));
        states.add(this.checkAllDiagonals(map));
        states.add(this.checkAllColumns(map));

        var winStates = states.stream()
                .filter(state -> !state.equals(GameState.NOT_FINISHED))
                .collect(Collectors.toCollection(ArrayList::new));

        if (winStates.contains(GameState.O_WINS)
                && winStates.contains(GameState.X_WINS)) {
            return GameState.IMPOSSIBLE;
        }

        if (winStates.contains(GameState.X_WINS)) {
            return GameState.X_WINS;
        }

        if (winStates.contains(GameState.O_WINS)) {
            return GameState.O_WINS;
        }

        if (winStates.size() == 1) {
            return winStates.iterator().next();
        }

        return GameState.NOT_FINISHED;
    }

    private GameState checkAllColumns(GameMapInterface map) {
        HashSet<GameState> states = new HashSet<>();

        for (int i = 0; i < map.getSize(); i++) {
            if (map.getColumn(i).allMatch(state -> state.equals(CellState.X))) {
                states.add(GameState.X_WINS);
            }

            if (map.getColumn(i).allMatch(state -> state.equals(CellState.O))) {
                states.add(GameState.O_WINS);
            }
        }

        if (states.size() == 0) {
            return map.hasEmptyCells() ? GameState.NOT_FINISHED :  GameState.DRAW;
        }

        if (states.size() == 2) {
            return GameState.IMPOSSIBLE;
        }

        return states.iterator().next();
    }

    private GameState checkAllRows(GameMapInterface map) {
        HashSet<GameState> states = new HashSet<>();

        for (int i = 0; i < map.getSize(); i++) {
            if (map.getRow(i).allMatch(state -> state.equals(CellState.X))) {
                states.add(GameState.X_WINS);
            }

            if (map.getRow(i).allMatch(state -> state.equals(CellState.O))) {
                states.add(GameState.O_WINS);
            }
        }

        if (states.size() == 0) {
            return GameState.NOT_FINISHED;
        }

        if (states.size() == 2) {
            return GameState.IMPOSSIBLE;
        }

        return states.iterator().next();
    }

    private GameState checkAllDiagonals(GameMapInterface map) {
        HashSet<GameState> states = new HashSet<>();

        if (map.getDiagonal(true).allMatch(state -> state.equals(CellState.X))) {
            states.add(GameState.X_WINS);
        }

        if (map.getDiagonal(false).allMatch(state -> state.equals(CellState.X))) {
            states.add(GameState.X_WINS);
        }

        if (map.getDiagonal(true).allMatch(state -> state.equals(CellState.O))) {
            states.add(GameState.O_WINS);
        }

        if (map.getDiagonal(false).allMatch(state -> state.equals(CellState.O))) {
            states.add(GameState.O_WINS);
        }

        if (states.size() == 2) {
            return GameState.IMPOSSIBLE;
        }

        if (states.size() == 0) {
            return GameState.NOT_FINISHED;
        }

        return states.iterator().next();
    }

    private boolean isPossibleMapStatesCount(GameMapInterface map) {
        long oCount = map.getCellCount(CellState.O);
        long xCount = map.getCellCount(CellState.X);

        return Math.abs(oCount - xCount) <= 1;
    }
}
