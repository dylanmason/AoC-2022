import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8Part2 {

    public static int[][] grid;
    public static int height = 99;
    public static void main(String[] args) {
        try {
            File file = new File("Day8Part1.txt");
            Scanner scan = new Scanner(file);
            String top = scan.nextLine();
            grid = new int[top.length()][height];
            int lineNumber = 0;
            parse(top, lineNumber);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                parse(line, ++lineNumber);
            }
            
            int ans = 0;

            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < height - 1; j++) {
                    int score = horizontal(j, i) * vertical(j, i);
                    if (score > ans) {
                        ans = score;
                    }
                }
            }
            System.out.println(ans);
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static void parse(String input, int lineNumber) {
        for (int i = 0; i < input.length(); i++) {
            grid[i][lineNumber] = Character.getNumericValue(input.charAt(i));
        }
    }

    public static int horizontal(int x, int y) {
        int val = grid[x][y];
        int before = 0;
        int after = 0;
        for (int i = x-1; i >= 0; i--) {
            if (grid[i][y] >= val) {
                before++;
                break;
            } 
            before++;
        }

        for (int i = x + 1; i <= grid.length-1; i++) {
            if (grid[i][y] >= val) {
                after++;
                break;
            } 
            after++;
        }
        return before * after;
    }

    public static int vertical(int x, int y) {
        int val = grid[x][y];
        int before = 0;
        int after = 0;
        for (int i = y-1; i >= 0; i--) {
            if (grid[x][i] >= val) {
                before++;
                break;
            } 
            before++;
        }

        for (int i = y + 1; i <= height-1; i++) {
            if (grid[x][i] >= val) {
                after++;
                break;
            } 
            after++;
        }
        return before * after;
    }
}
