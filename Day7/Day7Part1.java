import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Day7Part1 {

    public static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        try {
            File file = new File("Day7Part1.txt");
            Scanner scan = new Scanner(file);
            int sum = 0;
            while (scan.hasNext()) {
                String str = scan.nextLine();
                if (str.substring(0, 4).equals("$ cd")) {
                    if (str.charAt(5) == '/') {
                        int num = 0;
                        while (!stack.empty()) {
                            num += stack.pop();
                            if (num <= 100000) {
                                sum += num;        
                            }
                        }
                    }
                    else if (str.charAt(5) == '.') {
                        int num = stack.pop();
                        if (num <= 100000) {
                            sum += num;
                        }
                        if (!stack.empty()) {
                            num += stack.pop();
                        }
                        stack.push(num);
                    }
                }
                else if (str.substring(0, 4).equals("$ ls")) {
                    int accumulate = 0;
                    while (scan.hasNext()) {
                        String next = scan.nextLine();
                        String[] line = next.split(" ");
                        if (line[0].charAt(0) != 'd') {
                            accumulate += Integer.parseInt(line[0]);
                        }
                        if (scan.hasNext("\\$")) {
                            break;
                        }
                    }
                    stack.push(accumulate);
                }
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
}
