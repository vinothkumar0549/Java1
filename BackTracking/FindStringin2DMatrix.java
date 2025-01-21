import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindStringin2DMatrix {

    static int[] rowdir = { 0, 0, 1, -1, -1, -1, 1, 1 };
    static int[] coldir = { -1, 1, 0, 0, -1, 1, -1, 1 };

    static List<List<Character>> words = new ArrayList<>();
    static List<List<Integer>> rowPosition = new ArrayList<>();
    static List<List<Integer>> colPosition = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        char[][] arr = new char[n][n];
        System.out.println("Enter the Elements in the Array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.next().charAt(0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        scanner.nextLine();
        System.out.println("Enter the String to Find: ");
        String input = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == input.charAt(0)) {
                    List<Integer> subrow = new ArrayList<>();
                    List<Integer> subcol = new ArrayList<>();
                    List<Character> word = new ArrayList<>();
                    subrow.add(i);
                    subcol.add(j);
                    word.add(arr[i][j]);
                    findWord(i, j, n, arr, 0, input, subrow, subcol, word);
                }
            }
        }

        System.out.println(rowPosition.size() + " " + colPosition.size());

        System.out.println("The Input String in the Maze: ");
        for (int i = 0; i < rowPosition.size(); i++) {
            List<Integer> rowpos = rowPosition.get(i);
            List<Integer> colpos = colPosition.get(i);
            List<Character> w = words.get(i);
            for (int j = 0; j < rowpos.size(); j++) {
                System.out.print(w.get(j) + " " + "( " + rowpos.get(j) + " , " + colpos.get(j) + " ), ");
            }
            System.out.println();
        }
        scanner.close();
    }

    static void findWord(int row, int col, int n, char[][] arr, int index, String input, List<Integer> subrow,
            List<Integer> subcol, List<Character> word) {
        int nextx, nexty;

        if (input.length() - 1 == word.size() - 1) {
            rowPosition.add(new ArrayList<>(subrow));
            colPosition.add(new ArrayList<>(subcol));
            words.add(new ArrayList<>(word));
            return;
        }

        for (int i = 0; i < 8; i++) {
            nextx = row + rowdir[i];
            nexty = col + coldir[i];

            if (isvalid(nextx, nexty, n, arr, index + 1, input)) {
                subrow.add(nextx);
                subcol.add(nexty);
                word.add(arr[nextx][nexty]);

                findWord(nextx, nexty, n, arr, index + 1, input, subrow, subcol, word);

                subrow.remove(subrow.size() - 1);
                subcol.remove(subcol.size() - 1);
                word.remove(word.size() - 1);
            }
        }
    }

    static boolean isvalid(int row, int col, int n, char[][] arr, int index, String input) {
        return (row >= 0 && row < n && col >= 0 && col < n && arr[row][col] == input.charAt(index)
                && index < input.length());
    }
}
