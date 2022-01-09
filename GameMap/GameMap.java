package tictactoe.GameMap;

import tictactoe.Enum.CellState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO: implement iterator
 */
public class GameMap implements GameMapInterface {
    private CellState[][] map;
    private int size;

    public GameMap(int mapSize) {
        this.size = mapSize;
        this.map = new CellState[this.size][this.size];

        this.fillWithEmptyValue();
    }

    public int getSize() {
        return this.size;
    }

    public void print() {
        this.printUpBorder();

        for (CellState[] row : this.map) {
            this.printRow(row);
        }

        this.printLowBorder();
    }

    private void fillWithEmptyValue() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map.length; j++) {
                this.map[i][j] = CellState.EMPTY;
            }
        }
    }

    public void setCell(int x, int y, CellState state) {
        this.map[x][y] = state;
    }

    public long getCellCount(CellState state) {
        return Arrays.stream(this.map)
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(state))
                .count();
    }

    public Stream<CellState> getRow(int row) {
        return Arrays.stream(this.map[row]);
    }

    public Stream<CellState> getColumn(int column) {
        return Arrays.stream(this.map).map(row -> row[column]);
    }

    public Stream<CellState> getDiagonal(boolean isMain) {
        ArrayList<CellState> result = new ArrayList<>();

        int coef = isMain ? 0 : this.size - 1;

        for (int i = 0; i < this.size; i++) {
            result.add(this.map[i][Math.abs(i - coef)]);
        }

        return result.stream();
    }

    public boolean hasEmptyCells() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.map[i][j].equals(CellState.EMPTY)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCellEmpty(int x, int y) {
        return this.map[x][y].equals(CellState.EMPTY);
    }

    private void printUpBorder() {
        System.out.println("-".repeat(this.size * this.size));
    }

    private void printLowBorder() {
        System.out.println("-".repeat(this.size * this.size));
    }

    private void printRow(CellState[] states) {
        String values = Arrays.stream(states)
                .map(CellState::getSymbol)
                .collect(Collectors.joining(" "));

        System.out.printf("| %s |\n", values);
    }
}
