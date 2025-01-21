// Recursion Type

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeBoard {

    char[][] snakeboard;
    Queue<Node> queue = new LinkedList<>();
    Scanner scanner;

    SnakeBoard(int row, int col) {
        this.snakeboard = new char[row][col];
        this.initialize();
        this.addFood(1, 0);
        this.addFood(3, 3);
        this.addFood(2, 4);
        this.addFood(5, 5);
        this.scanner = new Scanner(System.in);
    }

    public void initialize() {
        for (int i = 0; i < snakeboard.length; i++) {
            for (int j = 0; j < snakeboard[0].length; j++) {
                snakeboard[i][j] = '0';
            }
        }
        queue.add(new Node(0, 0));

    }

    public void addFood(int row, int col) {
        if (row >= 0 && row < snakeboard.length && col >= 0 && col < snakeboard[0].length) {
            snakeboard[row][col] = 'F';
        }
    }

    public void solveSnakeGame(int row, int col) {
        if (row >= 0 && row < snakeboard.length && col >= 0 && col < snakeboard[0].length) {
            if (snakeboard[row][col] == '.') {
                System.out.println("Sanke Bite");
                System.exit(0);
            }
            if (snakeboard[row][col] != 'F') {
                Node node = queue.poll();
                snakeboard[node.getRow()][node.getCol()] = '0';
            }
            queue.add(new Node(row, col));
            snakeboard[row][col] = '.';
            while (!queue.isEmpty()) {
                printSnakeBoard();
                System.out.println("Enter the Direction: ");
                char direction = scanner.next().charAt(0);
                if (direction == 'L') {
                    solveSnakeGame(row, col - 1);
                } else if (direction == 'R') {
                    solveSnakeGame(row, col + 1);
                } else if (direction == 'U') {
                    solveSnakeGame(row - 1, col);
                } else if (direction == 'D') {
                    solveSnakeGame(row + 1, col);
                }
            }
        } else {
            System.out.println("Game Over");
            System.exit(0);
        }
    }

    public void printSnakeBoard() {
        for (char[] row : snakeboard) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

}
