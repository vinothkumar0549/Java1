
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FindSingleStringin2DMatrixSameDir {

    static int[] rowdir = { 0, 0, -1, 1, -1, -1, 1, 1 };
    static int[] coldir = { -1, 1, 0, 0, -1, 1, -1, 1 };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Array: ");
            int n = scanner.nextInt();
            char[][] arr = new char[n][n];
            System.out.println("Enter the Elements of the Array: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.next().charAt(0);
                }
            }
            scanner.nextLine();
            System.out.println("Enter the String to Find: ");
            String input = scanner.nextLine();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(input);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == input.charAt(0)) {
                        for (int dir = 0; dir < 8; dir++) {
                            List<Integer> subrow = new ArrayList<>();
                            List<Integer> subcol = new ArrayList<>();
                            List<Character> letters = new ArrayList<>();
                            subrow.add(i);
                            subcol.add(j);
                            letters.add(arr[i][j]);
                            if (findString(i, j, n, arr, 0, input, dir, subrow, subcol, letters)) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    static boolean findString(int row, int col, int n, char[][] arr, int index, String input, int dir,
            List<Integer> subrow,
            List<Integer> subcol, List<Character> letters) {

        int nextx, nexty;
        if (input.length() - 1 == letters.size() - 1) {
            for (int i = 0; i < subrow.size(); i++) {
                System.out.print(letters.get(i) + " ( " + subrow.get(i) + " , " + subcol.get(i) + " ), ");
            }
            return true;
        }

        nextx = row + rowdir[dir];
        nexty = col + coldir[dir];

        if (isvalid(nextx, nexty, n, arr, index + 1, input)) {
            subrow.add(nextx);
            subcol.add(nexty);
            letters.add(arr[nextx][nexty]);

            if (findString(nextx, nexty, n, arr, index + 1, input, dir, subrow, subcol, letters)) {
                return true;
            }
        }
        return false;

    }

    static boolean isvalid(int row, int col, int n, char[][] arr, int index, String input) {
        return (row >= 0 && row < n && col >= 0 && col < n && arr[row][col] == input.charAt(index));
    }
}
