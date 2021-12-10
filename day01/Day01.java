import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day01 {

    public int[] parseInput() {
        int[] input = null;
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            List<Integer> integers = new ArrayList<>();
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    integers.add(scanner.nextInt());
                } else {
                    scanner.next();
                }
            }
            input = integers.stream().mapToInt(i -> i).toArray();
            System.out.println(integers);
            scanner.close();
            ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return input;
    }

    public void solvePart01() {

    }

    public static void main(String[] args) {

        Day01 day01 = new Day01();
        day01.parseInput();

    }
}