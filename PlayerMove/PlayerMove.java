package tictactoe.PlayerMove;

import tictactoe.Enum.CellState;

public class PlayerMove {
    private int x;
    private int y;
    private CellState cellState;

    public PlayerMove(int x, int y, CellState cellState) {
        this.x = x;
        this.y = y;
        this.cellState = cellState;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return this.x;
    }

    public CellState getCellState() {
        return cellState;
    }
}
