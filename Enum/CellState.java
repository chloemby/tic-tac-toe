package tictactoe.Enum;

import tictactoe.Exception.UnexpectedSymbolException;

public enum CellState {
    EMPTY, X, O;

    public static CellState getFromSymbol(String symbol) throws UnexpectedSymbolException {
        switch (symbol) {
            case "X":
                return CellState.X;
            case "O":
                return CellState.O;
            case " ":
            case "_":
                return CellState.EMPTY;
            default:
                throw new UnexpectedSymbolException("You should enter numbers!");
        }
    }

    public String getSymbol() {
        switch (this) {
            case EMPTY:
                return " ";
            case X:
                return "X";
            case O:
                return "O";
            default:
                return "";
        }
    }
}
