package set6;

import java.util.HashSet;

public class Q1ExtraIndexArray {
    public static void main(String[] args) {
        int[] arr1 = { -1, 0, 3, 2 };
        int[] arr2 = { 3, 4, 0, -1, 2 };
        HashSet<Integer> set = new HashSet<>();

        int[] smaller = (arr1.length < arr2.length) ? arr1 : arr2;
        int[] larger = (arr1.length > arr2.length) ? arr1 : arr2;

        String largearray = (arr1.length > arr2.length) ? "arr1" : "arr2";

        for (int i : smaller) {
            set.add(i);
        }
        for (int i = 0; i < larger.length; i++) {
            if (!set.contains(larger[i])) {
                System.out.println(larger[i] + " is the Extra Element in Array " + largearray + " at Index " + i);
            }
        }
    }
}
