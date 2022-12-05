import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class Day5Part1 {

    public static LinkedList<String>[] list = new LinkedList[10];

    public static void main(String[] args) {
        try {
            File file = new File("Day5Part1.txt");
            Scanner scan = new Scanner(file);
            int count = 0;

            while (scan.hasNext()) {
                String str = scan.nextLine();
                if (str.isEmpty()) {
                    break;
                }
                order(str);
            }

            while (scan.hasNext()) {
                scan.next();
                int amount = scan.nextInt();
                scan.next();
                int from = scan.nextInt();
                scan.next();
                int to = scan.nextInt();
                move(amount, from, to);
            }

            for (int i = 1; i < 10; i++) {
                System.out.print(list[i].getLast() + " ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void order(String line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1, lower = 0, upper = 2, index = 1; i <= 33; i+=4, lower+=4, upper+=4, index++) {
            if ((line.charAt(i) != ' ') && (line.charAt(0) != ' ')) {
                sb.append(Character.toString(line.charAt(lower)) + Character.toString(line.charAt(i)) + Character.toString(line.charAt(upper)));
                if (list[index] == null) {
                    list[index] = new LinkedList<String>();
                }
                list[index].addFirst(sb.toString());
                sb.setLength(0);
            }
        }
    }

    public static void move(int amount, int from, int to) {
        for (int i = 0; i < amount; i++) {
            list[to].addLast(list[from].removeLast());
        }
    }
}
