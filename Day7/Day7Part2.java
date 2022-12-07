import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class Day7Part2 {

    public static Stack<Integer> stack = new Stack<Integer>();
    public static LinkedList<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args) {
        try {
            File file = new File("Day7Part1.txt");
            Scanner scan = new Scanner(file);
            int sum = 0;
            int totalSize = 0;
            int size = 100000000;
            while (scan.hasNext()) {
                String str = scan.nextLine();
                if (str.substring(0, 4).equals("$ cd")) {
                    if (str.charAt(5) == '/') {
                        if (!stack.empty()){
                            int num = 0;
                            while (stack.size() > 1) {
                                num = stack.pop();
                                list.addLast(num);
                                if (!stack.empty()) {
                                    num += stack.pop();
                                }
                                stack.push(num);
                            }
                            num += stack.pop();
                            list.addLast(num);
                        }
                    }
                    else if (str.charAt(5) == '.') {
                        int num = stack.pop();
                        list.addLast(num);
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
                    totalSize+=accumulate;
                    stack.push(accumulate);
                }
            }

            int freeSpace = 70000000 - totalSize;
            int neededClearance = 30000000 - freeSpace;

            for (int i = 0; i < list.size(); i++) {
                if ((neededClearance < list.get(i)) && (list.get(i) < size)) {
                    size = list.get(i);
                    System.out.println(size);
                }
            }

            System.out.println(size);

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
}
