package questions20;

public class Q20MergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 24, 36 };
        int arr2[] = { 12, 36, 48, 100 };

        int finarr[] = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                finarr[k++] = arr1[i++];
            } else { // no need to give this condition explicitly if (arr1[i] > arr2[j])
                finarr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            finarr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            finarr[k++] = arr2[j++];
        }
        for (int l = 0; l < finarr.length; l++) {
            System.out.println(finarr[l]);
        }
    }
}
