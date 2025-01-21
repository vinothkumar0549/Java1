public class Suduko {

    int[][] arr;

    Suduko(int[][] arr) {
        this.arr = arr;
    }

    public void printDetails() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
                if ((j + 1) % (int) Math.sqrt(arr.length) == 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if ((i + 1) % (int) Math.sqrt(arr.length) == 0)
                System.out.println();
        }
    }

    public boolean solveSuduko(int row, int col) {
        if (row == arr.length) {
            col++;
            if (col == arr.length) {
                return true;
            } else {
                row = 0;
            }
        }

        if (arr[row][col] != 0) {
            return solveSuduko(row + 1, col);
        }

        for (int num = 1; num <= arr.length; num++) {
            if (isvalid(row, col, num)) {
                arr[row][col] = num;
                if (solveSuduko(row + 1, col)) {
                    return true;
                }
                arr[row][col] = 0;
            }
        }
        return false;
    }

    public boolean isvalid(int row, int col, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[row][i] == num)
                return false;
            if (arr[i][col] == num)
                return false;
        }
        int startrow = row - (row % (int) Math.sqrt(arr.length));
        int startcol = col - (col % (int) Math.sqrt(arr.length));
        for (int i = startrow; i < startrow + (int) Math.sqrt(arr.length); i++) {
            for (int j = startcol; j < startcol + (int) Math.sqrt(arr.length); j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

}