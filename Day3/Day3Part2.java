import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day3Part2 {

    public static void main(String[] args) {
        try {
           File file = new File("Day3Part1.txt");
           Scanner scan = new Scanner(file);

           int sum = 0;

           while (scan.hasNext()) {
               String first = scan.nextLine();
               String second = scan.nextLine();
               String third = scan.nextLine();
               sum += letter(first, second, third);
           }

           System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static int letter(String first, String second, String third) {
        for (int i = 0; i < first.length(); i++) {
                if (second.contains(Character.toString(first.charAt(i))) && third.contains(Character.toString(first.charAt(i)))) {
                    return value(first.charAt(i));
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
