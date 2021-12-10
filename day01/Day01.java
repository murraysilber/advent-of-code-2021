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
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    public int solvePart01() {
        int[] input = parseInput();
        int depthIncreased = 0;
        for (int i = 1; i < input.length; i++) {
            int valueA = input[i - 1];
            int valueB = input[i];
            if (valueB > valueA) {
                depthIncreased++;
            }
        }
        return depthIncreased;
    }

    public static void main(String[] args) {

        Day01 day01 = new Day01();
        System.out.println(day01.solvePart01());

    }
}