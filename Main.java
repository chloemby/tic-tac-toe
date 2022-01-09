package tictactoe;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(3);
        
        game.start();

        while (!game.isEnded()) {
            game.makeMove();
        }
        
        System.out.println(game.end());
    }
}
