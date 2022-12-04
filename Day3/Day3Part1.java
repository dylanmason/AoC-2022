import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3Part1 {

    public static void main(String[] args) {
        try {
           File file = new File("Day3Part1.txt");
           Scanner scan = new Scanner(file);

           int sum = 0;

           while (scan.hasNext()) {
               String str = scan.nextLine();
               String first = str.substring(0, (str.length()/2));
               String second = str.substring(str.length()/2, str.length());
               sum += letter(first, second);
           }

           System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static int letter(String first, String second) {
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    return value(first.charAt(i));
                }
            }
        }
        return 0;
    }

    public static int value(char c) {
        if (c <= 90) {
            return c - 38;
        }
        else {
            return c - 96;
        }
    }
}
