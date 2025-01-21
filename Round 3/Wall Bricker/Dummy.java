import java.util.HashMap;

public class Dummy { // WallBricker

    private String wall = "W";
    private String ground = "G";
    private String ball = "O";
    private String brick = "B";

    private String[][] gameboard;

    private HashMap<Integer, Integer> brickwithlife = new HashMap<>();
    int[] ballpos;
    int balllife;

    Dummy(int row, int col) { // WallBricker
        gameboard = new String[row][col];
        prepareBoard(row, col);
        gameboard[row - 1][col / 2] = ball;
        ballpos = new int[] { row - 1, col / 2 };
    }

    public void initiate(int ballrow, int ballcol, int rowdirection, int coldirection) {
        while (gameboard[ballrow][ballcol] != wall) {
            if (gameboard[ballrow][ballcol] == brick) {
                reduceBrickLife(ballrow, ballcol);
                ballGoesDown(ballrow, ballcol);
                return;
            }
            movingIllusion(ballrow, ballcol);
            ballrow += rowdirection;
            ballcol += coldirection;
        }

        wallHit(ballrow, ballcol);

        rowdirection = 0;
        coldirection = coldirection * -1;

        initiate(ballrow + rowdirection, ballcol + coldirection, rowdirection, coldirection);

    }

    public void wallHit(int row, int col) {
        gameboard[row][col] = ball;
        printGameBoard();
        gameboard[row][col] = wall;
        // printGameBoard();
    }

    public void movingIllusion(int row, int col) {
        if (gameboard[row][col] == brick) {
            reduceBrickLife(row, col);
            // ballGoesDown(row, col);
        } else {
            gameboard[row][col] = ball;
            printGameBoard();
            gameboard[row][col] = " ";
        }
    }

    public void ballGoesDown(int row, int col) {
        int rowdirection = 1;
        int coldirection = 0;

        while (row != gameboard.length - 1) {
            row += rowdirection;
            col += coldirection;
            movingIllusion(row, col);
        }
        gameboard[row][col] = ball;
        if (gameboard[ballpos[0]][ballpos[1]] == " ") {
            gameboard[ballpos[0]][ballpos[1]] = ground;
            printGameBoard();
        }
        ballpos = new int[] { row, col };
    }

    public void reduceBrickLife(int row, int col) {
        int exactbrickpos = getExactBrickPosition(row, col);
        brickwithlife.put(exactbrickpos, brickwithlife.get(exactbrickpos) - 1);
        if (brickwithlife.get(exactbrickpos) == 0) {
            brickwithlife.remove(exactbrickpos);
            if (brickwithlife.size() == 0) {
                System.out.println("Game Win"); //////
                System.exit(0);
            }
            gameboard[row][col] = " ";
        }
    }

    public void prepareBoard(int row, int col) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0 || c == 0 || c == col - 1) {
                    gameboard[r][c] = wall;
                } else if (r == row - 1) {
                    gameboard[r][c] = ground;
                } else {
                    gameboard[r][c] = " ";
                }
            }
        }
    }

    public void printGameBoard() {
        for (String[] row : gameboard) {
            for (String val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        sleep();
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getCause();
        }
    }

    public void setBricks(int row, int col, int life) {
        if (row > 0 && row < gameboard.length - 2 && col > 0 && col < gameboard[0].length - 2) {
            gameboard[row][col] = brick;
            int exactbrickpos = getExactBrickPosition(row, col);
            brickwithlife.put(exactbrickpos, life);
        } else {
            System.out.println("Not Valid Index...");
        }
    }

    public int getExactBrickPosition(int row, int col) {
        // System.out.println("Exact Pos: " + ((row * gameboard[0].length) + col + 1));
        return (row * gameboard[0].length) + col + 1;
    }

    public int[] getBallPos() {
        return ballpos;
    }

    public int getBallLife() {
        return balllife;
    }

}
