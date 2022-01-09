package tictactoe.Enum;

public enum Player {
    X_PLAYER, O_PLAYER;

    public String getPlayerSymbol() {
        switch (this) {
            case X_PLAYER:
                return "X";
            case O_PLAYER:
                return "O";
        }
        return "";
    }
}
