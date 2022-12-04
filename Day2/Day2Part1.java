import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2Part1 {

    public static void main(String[] args) {
        try {
            File file = new File("Day2Part1.txt");
            Scanner scan = new Scanner(file);

            int score = 0;

            while(scan.hasNext()) {
                String elf = scan.next();
                String you = scan.next();
                String[] youInfo = you(you);
                String[] elfInfo = elf(elf);

                you = youInfo[0];
                int youWeight = Integer.parseInt(youInfo[1]);

                elf = elfInfo[0];

                int match = winOrLose(you, elf);
                int result = match + youWeight;
                score += result;
            }
            System.out.println(score);
        }
        catch (FileNotFoundException e) {
            System.out.println("Not found");
        }
    }

    public static int winOrLose(String you, String elf) {
        if (you.equals(elf)) {
            return 3;
        }
        else if (you.equals("Rock") && elf.equals("Scissors")) {
            return 6;
        }
        else if (you.equals("Rock") && elf.equals("Paper")) {
            return 0;
        }
        else if (you.equals("Scissors") && elf.equals("Paper")) {
            return 6;
        }
        else if (you.equals("Scissors") && elf.equals("Rock")) {
            return 0;
        }
        else if (you.equals("Paper") && elf.equals("Rock")) {
            return 6;
        }
        else if (you.equals("Paper") && elf.equals("Scissors")) {
            return 0;
        }
        return -5;
    } 

    public static String[] you(String you) {
        switch (you) {
            case ("X") :
                String[] arr1 = {"Rock", "1"};
                return arr1;
            case ("Y") :
                String[] arr2 = {"Paper", "2"};
                return arr2;
            case ("Z") :
                String[] arr3 = {"Scissors", "3"};
                return arr3;
        }
        String[] arr = {"None", "-10"};
        return arr;
    }

    public static String[] elf(String elf) {
        switch (elf) {
            case ("A") :
                String[] arr4 = {"Rock", "1"};
                return arr4;
            case ("B") :
                String[] arr5 = {"Paper", "2"};
                return arr5;
            case ("C") :
                String[] arr6 = {"Scissors", "3"};
                return arr6;
        }
        String[] arr = {"None", "-10"};
        return arr;
    }
}
