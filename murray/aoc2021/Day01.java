package murray.aoc2021;

import java.util.List;

public class Day01 extends AoCPuzzle {

    public Day01(String day) {
        super(day);
    }

    @Override
    public void solvePart01(List<String> input) {
        List<Integer> depths = convertToInts(getInput());
        int depthIncreased = 0;
        for (int i = 1; i < depths.size(); i++) {
            int valueA = depths.get(i - 1);
            int valueB = depths.get(i);
            if (valueB > valueA) {
                depthIncreased++;
            }
        }
        displayResult(String.valueOf(depthIncreased), "1");
    }

    @Override
    public void solvePart02(List<String> input) {
        List<Integer> depths = this.convertToInts(getInput());
        int depthIncreased = 0;
        for (int i = 1; i < depths.size() - (depths.size() % 3); i++) {
            int depthRangeA = depths.get(i - 1) + depths.get(i) + depths.get(i + 1);
            int depthRangeB = depths.get(i) + depths.get(i + 1) + depths.get(i + 2);
            if (depthRangeB > depthRangeA) {
                depthIncreased++;
            }
        }
        displayResult(String.valueOf(depthIncreased), "2");
    }

    public static void main(String[] args) {

        AoCPuzzle day01 = new Day01("1");
        day01.solvePart01(day01.getInput());
        day01.solvePart02(day01.getInput());

    }

}