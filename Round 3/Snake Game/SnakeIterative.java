// Iterative 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeIterative {

    char[][] snakeboard;
    Queue<Node> snake = new LinkedList<>();
    Queue<Node> food = new LinkedList<>();
    Scanner scanner;

    SnakeIterative(int row, int col) {
        this.snakeboard = new char[row][col];
        for (int i = 0; i < snakeboard.length; i++) {
            for (int j = 0; j < snakeboard[0].length; j++) {
                snakeboard[i][j] = '0';
            }
        }
        food.add(new Node(1, 0));
        food.add(new Node(2, 4));
        food.add(new Node(3, 3));
        food.add(new Node(5, 5));
        displayFood(food.poll());
        snake.add(new Node(0, 0));
        this.scanner = new Scanner(System.in);
    }

    public void displayFood(Node node) {
        int row = node.getRow();
        int col = node.getCol();
        if (row >= 0 && row < snakeboard.length && col >= 0 && col < snakeboard[0].length) {
            snakeboard[row][col] = 'F';
        } else {
            displayFood(food.poll());
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

    public void initializeSnakeGame() {
        int row = 0, col = 0;
        snakeboard[row][col] = '.';
        while (true) {
            printSnakeBoard();
            System.out.println("Enter the Direction: ");
            char dir = scanner.next().charAt(0);
            if (dir == 'L') {
                snakeMove(row, --col);
            } else if (dir == 'R') {
                snakeMove(row, ++col);
            } else if (dir == 'U') {
                snakeMove(--row, col);
            } else if (dir == 'D') {
                snakeMove(++row, col);
            } else {
                System.out.println("Invalid Direction");
            }
        }
    }

    public void snakeMove(int row, int col) {
        if (row >= 0 && row < snakeboard.length && col >= 0 && col < snakeboard[0].length) {
            snake.add(new Node(row, col));
            if (snakeboard[row][col] == '.') {
                System.out.println("Game Over\nSnake Bite");
                System.exit(0);
            }
            if (snakeboard[row][col] != 'F') {
                Node node = snake.poll();
                snakeboard[node.getRow()][node.getCol()] = '0';
            }
            if (snakeboard[row][col] == 'F') {
                if (food.size() == 0) {
                    System.out.println("Game Win");
                    System.exit(0);
                }
                displayFood(food.poll());
            }
            snakeboard[row][col] = '.';
        } else {
            System.out.println("Game Over...\n Boundary Condition");
            System.exit(0);
        }
    }

}
