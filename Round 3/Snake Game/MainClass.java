public class MainClass {
    public static void main(String[] args) {
        // SnakeBoard snakeboard = new SnakeBoard(6, 6);
        // snakeboard.solveSnakeGame(0, 0);
        // snakeboard.printSnakeBoard();

        SnakeIterative snakeiterative = new SnakeIterative(6, 6);
        snakeiterative.initializeSnakeGame();
    }
}