package questions106;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Q86ArrayUnion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> union = new TreeSet<>();
        Set<Integer> intersection = new TreeSet<>();
        System.out.println("Enter the Size of the Array 1: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the Element of the Arry 1: ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
            union.add(arr1[i]);
        }

        System.out.println("Enter the Size of the Array 2: ");
        int n2 = scanner.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
            union.add(arr2[i]);
            if (union.contains(arr2[i])) {
                intersection.add(arr2[i]);
            }
        }
        System.out.println("Union: ");
        for (int i : union) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Intersection: ");
        for (int i : intersection) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
}

// //This program is for the Distinct Elemnts(only once):

// package questions106;

// import java.util.Scanner;
// import java.util.Arrays;
// import java.util.List;
// import java.util.ArrayList;

// public class Q86ArrayUnion {
// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// List<Integer> union = new ArrayList<Integer>();
// List<Integer> intersection = new ArrayList<Integer>();
// System.out.println("Enter the Size of the Array 1: ");
// int n1 = scanner.nextInt();
// int[] arr1 = new int[n1];
// System.out.println("Enter the Elements of the Array 1: ");
// for (int i = 0; i < n1; i++) {
// arr1[i] = scanner.nextInt();
// }

// System.out.println("Enter the Size of the Array 2: ");
// int n2 = scanner.nextInt();
// int[] arr2 = new int[n2];
// System.out.println("Enter the Elements of the Array 2: ");
// for (int i = 0; i < n2; i++) {
// arr2[i] = scanner.nextInt();
// }

// Arrays.sort(arr1);
// Arrays.sort(arr2);

// int i = 0, j = 0;
// while (i < n1 && j < n2) {
// if (arr1[i] < arr2[j]) {
// union.add(arr1[i++]);
// } else if (arr1[i] > arr2[j]) {
// union.add(arr2[j++]);
// } else {
// union.add(arr1[i]);
// intersection.add(arr1[i]);
// i++;
// j++;
// }
// }
// while (i < n1) {
// union.add(arr1[i++]);
// }
// while (j < n2) {
// union.add(arr2[j++]);
// }
// System.out.println("Union: ");
// for (int k : union) {
// System.out.print(k + " ");
// }
// System.out.println();
// System.out.println("Intersection: ");
// for (int k : intersection) {
// System.out.print(k + " ");
// }
// scanner.close();
// }
// }
