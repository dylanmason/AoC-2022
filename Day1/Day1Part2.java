import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Day1Part2 {

    public static void main(String[] args) {
        try {
            File file = new File("Day1Part1.txt");
            Scanner scan = new Scanner(file);
            int prev = 0;
            int curr = 0;
            int ans = 0;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            int index = 0;
            while (scan.hasNext()) {
                String str = scan.nextLine();
                if (str.isEmpty()) {
                    if (curr > prev) {
                        index++;
                        prev = curr;
                    }
                    arr.add(curr);
                    curr = 0;
                } else {
                    curr += Integer.parseInt(str);
                }
            }
            Collections.sort(arr, Collections.reverseOrder());
            System.out.println(arr.get(0) + arr.get(1) + arr.get(2));
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
}
