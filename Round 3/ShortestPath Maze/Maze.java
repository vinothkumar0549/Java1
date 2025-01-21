import java.util.LinkedList;
import java.util.Queue;

public class Maze {

    private char[][] arr;

    Maze(int row, int col) {
        arr = new char[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = '0';
            }
        }
    }

    class Node {

        int row, col, steps;
        Node previous;

        Node(int row, int col, int steps, Node current) {
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.previous = current;
        }
    }

    public void putMonster(int row, int col) {
        if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
            arr[row][col] = 'M';
        } else {
            System.out.println("Not Valid Row and Column");
        }
    }

    public void putTresure(int row, int col) {
        if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
            arr[row][col] = 'T';
        } else {
            System.out.println("Not Valid Row and Column");
        }
    }

    public void putAdventurer(int row, int col) {
        if (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
            arr[row][col] = 'A';
        } else {
            System.out.println("Not Valid Row and Column");
        }
    }

    public void printMaze() {
        for (char[] row : arr) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public int mazeShortestPathBFS(int row, int col) {

        if (!(row >= 0 && row < arr.length && col >= 0 && col < arr[0].length)) {
            System.out.println("Not Valid Row and Column");
            return -1;
        }

        if (arr[row][col] == 'T') {
            return 0;
        }

        int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[row][col] = true;
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(row, col, 0, null);
        queue.add(node);
        int nextrow = 0, nextcol = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                nextrow = current.row + dir[i][0];
                nextcol = current.col + dir[i][1];
                if (nextrow >= 0 && nextrow < arr.length && nextcol >= 0 && nextcol < arr[0].length
                        && !visited[nextrow][nextcol] && arr[nextrow][nextcol] != 'M') {
                    if (arr[nextrow][nextcol] == 'T') {
                        insertPath(current);
                        return current.steps + 1;
                    }
                    node = new Node(nextrow, nextcol, current.steps + 1, current);
                    queue.add(node);
                    visited[nextrow][nextcol] = true;
                }
            }
        }
        return -1;
    }

    public void insertPath(Node current) {
        while (current != null) {
            arr[current.row][current.col] = 'A';
            current = current.previous;
        }
        printMaze();
    }

}
