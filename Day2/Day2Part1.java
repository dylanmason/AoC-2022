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
                char elf = scan.next().charAt(0);
                char you = scan.next().charAt(0);

                score += (elf == 'A' && you == 'X') ? 4 : (elf == 'A' && you == 'Y') ? 8 :
                    (elf == 'A' && you == 'Z') ? 3 : (elf == 'B' && you == 'X') ? 1 :
                    (elf == 'B' && you == 'Y') ? 5 : (elf == 'B' && you == 'Z') ? 9 :
                    (elf == 'C' && you == 'X') ? 7 : (elf == 'C' && you == 'Y') ? 2 :
                    (elf == 'C' && you == 'Z') ? 6 : 0;
            }
            System.out.println(score);
        }
        catch (FileNotFoundException e) {
            System.out.println("Not found");
        }
    }
}
