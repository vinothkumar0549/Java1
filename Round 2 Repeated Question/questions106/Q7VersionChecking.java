package questions106;

import java.util.ArrayList;

public class Q7VersionChecking {
    public static void main(String[] args) {
        String version1 = "4.9.2";
        String version2 = "4.8.4";

        String[] arr1 = splitversion(version1);
        String[] arr2 = splitversion(version2);

        for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {
            int num1 = (i < arr1.length) ? Integer.parseInt(arr1[i]) : 0;
            int num2 = (i < arr2.length) ? Integer.parseInt(arr2[i]) : 0;
            if (num1 < num2) {
                System.out.println("Upgraded...");
                return;
            }
            if (num1 > num2) {
                System.out.println("Downgraded...");
                return;
            }
        }
        System.out.println("Equal...");
    }

    static String[] splitversion(String version) {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < version.length(); i++) {
            if (version.charAt(i) == '.') {
                list.add(builder.toString());
                builder.setLength(0);
                continue;
            }
            builder.append(version.charAt(i));
        }
        list.add(builder.toString());
        return list.toArray(new String[0]);
    }
}