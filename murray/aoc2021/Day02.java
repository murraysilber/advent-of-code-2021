package murray.aoc2021;

import java.util.List;

public class Day02 extends AoCPuzzle {

    public Day02(String day) {
        super(day);
    }

    @Override
    public void solvePart01(List<String> input) {
        int horizontalPosition = 0;
        int depth = 0;
        for (String command : input) {
            String direction = command.substring(0, command.indexOf(' ')).trim();
            int units = Integer.parseInt(command.substring(command.indexOf(' ')).trim());
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
        displayResult(String.valueOf(horizontalPosition * depth), "1");
    }

    @Override
    public void solvePart02(List<String> input) {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        for (String command : input) {
            String direction = command.substring(0, command.indexOf(' ')).trim();
            int units = Integer.parseInt(command.substring(command.indexOf(' ')).trim());
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
        displayResult(String.valueOf(horizontalPosition * depth), "2");
    }

    public static void main(String[] args) {
        AoCPuzzle day02 = new Day02("2");
        day02.solvePart01(day02.getFileInput());
        day02.solvePart02(day02.getFileInput());
    }
}
