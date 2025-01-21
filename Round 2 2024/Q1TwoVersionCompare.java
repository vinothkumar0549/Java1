import java.util.ArrayList;
//import java.util.Scanner;

public class Q1TwoVersionCompare {
    public static void main(String[] args) {
        String v1 = "1.0.1";
        String v2 = "1.0.0.1";

        // String[] version1 = v1.split("\\.");
        // String[] version2 = v2.split("\\.");

        String[] version1 = versionsplit(v1);
        String[] version2 = versionsplit(v2);

        for (int i = 0; i < Math.max(version1.length, version2.length); i++) {
            int num1 = (i < version1.length) ? Integer.parseInt(version1[i]) : 0;
            int num2 = (i < version2.length) ? Integer.parseInt(version2[i]) : 0;
            // System.out.println(num1 + " " + num2);
            if (num1 > num2) {
                System.out.println("Downgrade");
                return;
            } else if (num1 < num2) {
                System.out.println("Upgrade");
                return;
            }
        }
        System.out.println("Equal");

    }

    static String[] versionsplit(String v) {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < v.length(); i++) {
            if (v.charAt(i) == '.') {
                list.add(builder.toString());
                builder.setLength(0);
                continue;
            }
            builder.append(v.charAt(i));
        }
        list.add(builder.toString());
        return list.toArray(new String[0]);
    }

    // static String[] versionsplit(String v) {
    // ArrayList<String> list = new ArrayList<>();
    // Scanner scanner = new Scanner(v);
    // scanner.useDelimiter("\\.");
    // while (scanner.hasNext()) {
    // list.add(scanner.next());
    // }
    // scanner.close();
    // return list.toArray(new String[list.size()]);
    // }
}