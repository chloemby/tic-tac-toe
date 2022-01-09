package tictactoe.GameMap;

import tictactoe.Enum.CellState;
import tictactoe.Exception.TicTacToeException;

import java.util.stream.Stream;

public interface GameMapInterface {
    int getSize();
    void print();
    void setCell(int x, int y, CellState state);
    long getCellCount(CellState state);
    Stream<CellState> getRow(int row);
    Stream<CellState> getColumn(int column);
    Stream<CellState> getDiagonal(boolean isMain);
    boolean hasEmptyCells();
    boolean isCellEmpty(int x, int y);
}
