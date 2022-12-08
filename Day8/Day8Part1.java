import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8Part1 {

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
            
            int ans = top.length();

            for (int i = 1; i < grid.length - 1; i++) {
                ans+=2;
                for (int j = 1; j < height - 1; j++) {
                    if (horizontal(j, i) || vertical(j, i)) {
                        ans++;
                    }
                }
            }
            System.out.println(ans+top.length());
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static void parse(String input, int lineNumber) {
        for (int i = 0; i < input.length(); i++) {
            grid[i][lineNumber] = Character.getNumericValue(input.charAt(i));
        }
    }

    public static boolean horizontal(int x, int y) {
        int val = grid[x][y];
        boolean before = true;
        boolean after = true;
        for (int i = 0; i < x; i++) {
            if (grid[i][y] >= val) {
                before = false;
                break;
            } 
        }

        for (int i = x + 1; i <= grid.length-1; i++) {
            if (grid[i][y] >= val) {
                after = false;
                break;
            } 
        }

        return (before || after);
    }

    public static boolean vertical(int x, int y) {
        int val = grid[x][y];
        boolean before = true;
        boolean after = true;
        for (int i = 0; i < y; i++) {
            if (grid[x][i] >= val) {
                before = false;
                break;
            } 
        }

        for (int i = y + 1; i <= height-1; i++) {
            if (grid[x][i] >= val) {
                after = false;
                break;
            } 
        }

        return (before || after);
    }
}
