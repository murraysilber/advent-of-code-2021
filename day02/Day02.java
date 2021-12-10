package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day02 {

    public List<String> parseInput() {
        List<String> input = new ArrayList<>();
        // Pattern pattern = Pattern.compile("[a-zA-Z]+[\\s][\\d]+"); //Just an idea
        try (Scanner scanner = new Scanner(new File("day02/input.txt"))) {
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    public int solvePart01() {
        List<String> input = parseInput();
        int horizontalPosition = 0;
        int depth = 0;
        for (String command : input) {
            String[] commandSplit = command.split(" ");
            String direction = commandSplit[0];
            int units = Integer.parseInt(commandSplit[1]);
            switch (direction) {
                case "forward":
                    horizontalPosition += units;
                    break;
                case "up":
                    depth -= units;
                    break;
                case "down":
                    depth += units;
                    break;
                default:
                    break;
            }
        }
        return horizontalPosition * depth;
    }

    public int solvePart02() {
        List<String> input = parseInput();
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        for (String command : input) {
            String[] commandSplit = command.split(" ");
            String direction = commandSplit[0];
            int units = Integer.parseInt(commandSplit[1]);
            switch (direction) {
                case "forward":
                    horizontalPosition += units;
                    depth = depth + (units * aim);
                    break;
                case "up":
                    aim -= units;
                    break;
                case "down":
                    aim += units;
                    break;
                default:
                    break;
            }
        }
        return horizontalPosition * depth;
    }

    public static void main(String[] args) {
        Day02 day02 = new Day02();
        System.out.println(day02.solvePart01());
        System.out.println(day02.solvePart02());
    }

}