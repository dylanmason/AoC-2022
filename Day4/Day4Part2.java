import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day4Part2 {

    public static void main(String[] args) {
        try {
            File file = new File("Day4Part1.txt");
            Scanner scan = new Scanner(file);
            int count = 0;

            while (scan.hasNext()) {
                String[] line = scan.nextLine().split(",");
                String firstHalf = line[0];
                String secondHalf = line[1];

                int firstNum = Integer.parseInt(firstHalf.substring(0, firstHalf.indexOf("-")));
                int secondNum = Integer.parseInt(firstHalf.substring(firstHalf.indexOf("-") + 1, firstHalf.length()));
                int thirdNum = Integer.parseInt(secondHalf.substring(0, secondHalf.indexOf("-")));
                int fourthNum = Integer.parseInt(secondHalf.substring(secondHalf.indexOf("-") + 1, secondHalf.length()));

                if ((firstNum <= thirdNum && secondNum >= fourthNum) || (thirdNum <= firstNum && fourthNum >= secondNum) || 
                        ((firstNum <= thirdNum && secondNum >= thirdNum) || (firstNum <= fourthNum && secondNum >= fourthNum))) {
                    count++;
                }
            }
            System.out.println(count);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
