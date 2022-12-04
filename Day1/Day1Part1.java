import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Part1 {

    public static void main(String[] args) {
        try {
            File file = new File("Day1Part1.txt");
            Scanner scan = new Scanner(file);
            int prev = 0;
            int curr = 0;
            int ans = 0;
            while (scan.hasNext()) {
                String str = scan.nextLine();
                if (str.isEmpty()) {
                    if (curr > prev) {
                        ans = curr;
                        prev = curr;
                    }
                    curr = 0;
                } else {
                    curr += Integer.parseInt(str);
                }
            }
            System.out.println(ans);
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
}
