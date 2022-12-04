import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2Part2 {

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

                int match = game(you, elf);
                int result = match + youWeight;
                score += result;
            }
            System.out.println(score);
        }
        catch (FileNotFoundException e) {
            System.out.println("Not found");
        }
    }

    public static int game(String you, String elf) {
        if (you.equals("Draw")) {
            if (elf.equals("Rock")) {
                return 1;
            }
            else if (elf.equals("Paper")) {
                return 2;
            }
            else if (elf.equals("Scissors")) {
                return 3;
            }
        }
        else if (you.equals("Lose")) {
            if (elf.equals("Rock")) {
                return 3;
            }
            else if (elf.equals("Paper")) {
                return 1;
            }
            else if (elf.equals("Scissors")) {
                return 2;
            }
        }
        else if (you.equals("Win")) {
            if (elf.equals("Rock")) {
                return 2;
            }
            else if (elf.equals("Paper")) {
                return 3;
            }
            else if (elf.equals("Scissors")) {
                return 1;
            }
        }
        return -100;
    } 

    public static String[] you(String you) {
        switch (you) {
            case ("X") :
                String[] arr4 = {"Lose", "0"};
                return arr4;
            case ("Y") :
                String[] arr5 = {"Draw", "3"};
                return arr5;
            case ("Z") :
                String[] arr6 = {"Win", "6"};
                return arr6;
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
