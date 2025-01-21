import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Matrix row and column: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            Maze maze = new Maze(row, col);
            System.out.println("Array Initial: ");
            maze.printMaze();
            while (true) {
                System.out.println("Enter the Row and Column for the Monster (-1,-1 ) to Exit: ");
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row == -1 && col == -1) {
                    break;
                }
                maze.putMonster(row, col);
            }
            // maze.putMonster(0, 1);
            // maze.putMonster(1, 1);//
            // maze.putMonster(2, 1);
            // maze.putMonster(3, 1);
            // maze.putMonster(4, 1);
            System.out.println("Enter the Row and Column for the Adventurer: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            maze.putAdventurer(row, col);
            // maze.putAdventurer(3, 0);
            System.out.println("Enter the Row and Col for the Tresure: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            maze.putTresure(row, col);
            // maze.putTresure(1, 3);
            System.out.println("Array Monster, Adventurer and Tresure");
            maze.printMaze();
            int steps = maze.mazeShortestPathBFS(3, 0);
            System.out.println("The Steps Neede to Reach the Treasure: " + steps);
        }
    }
}