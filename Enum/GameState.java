package tictactoe.Enum;

public enum GameState {
    DRAW,
    X_WINS,
    O_WINS,
    NOT_FINISHED,
    IMPOSSIBLE;
    
    public String getDescription() {
        switch (this) {
            case O_WINS:
                return "O wins";
            case X_WINS:
                return "X wins";
            case DRAW:
                return "Draw";
            case NOT_FINISHED:
                return "Game not finished";
            default:
                return "Impossible";
        }
    }
}
