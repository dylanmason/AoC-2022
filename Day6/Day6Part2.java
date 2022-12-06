import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class Day6Part2 {

    public static void main(String[] args) {
        try {
            File file = new File("Day6Part1.txt");
            Scanner scan = new Scanner(file);

            String str = scan.next();

            for (int i = 0; i < str.length()-3; i++) {
                if (loop(str, i)) {
                    System.out.println(i+14);
                    return;
                }    
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static boolean loop(String str, int i) {
        for (int j = i; j < i+13; j++) {
            for (int k = j+1; k < i+14; k++) {
                if (str.charAt(j) == str.charAt(k)) {
                    return false;
                }
                else if ((str.charAt(j) != str.charAt(k)) && (j == i+12 && k == i+13)) {
                    return true;
                }
            }
        }
        return false;
    }
}
