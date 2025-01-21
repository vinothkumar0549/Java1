import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        int[] ballpos;
        try (Scanner scanner = new Scanner(System.in)) {
            WallBricker wallbricker = new WallBricker(7, 7);
            wallbricker.setBricks(2, 2, 2);
            wallbricker.setBricks(2, 3, 2);
            wallbricker.setBricks(2, 4, 2);
            wallbricker.setBricks(3, 2, 2);
            wallbricker.setBricks(3, 3, 2);
            wallbricker.setBricks(3, 4, 2);
            wallbricker.printGameBoard();

            while (true) {
                if (wallbricker.getBallLife() <= 0) {
                    System.out.println("Game Over (Ball Life Finished)");
                    System.exit(0);
                }

                System.out.println("Enter the Direction: ");
                String direction = scanner.nextLine();

                switch (direction) {
                    case "st":
                        ballpos = wallbricker.getBallPos();
                        wallbricker.initiate(ballpos[0], ballpos[1], -1, 0);
                        break;
                    case "lt":
                        ballpos = wallbricker.getBallPos();
                        wallbricker.initiate(ballpos[0], ballpos[1], -1, -1);
                        break;
                    case "rt":
                        ballpos = wallbricker.getBallPos();
                        wallbricker.initiate(ballpos[0], ballpos[1], -1, 1);
                        break;
                    default:
                        System.out.println("Invalid Command...");
                }
            }
        }
    }

}