package murray.aoc2021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05 extends AoC2021Core {

    public Day05(String day) {
        super(day);
    }

    @Override
    void solvePart01(List<String> input) {

        List<int[]> hydroThermalVents = new ArrayList<>();
        for (String row : input) {
            hydroThermalVents.add(getXYRow(row));
        }

        // part one only wants horizontal or vertical lines, filter out rest
        Iterator<int[]> iter = hydroThermalVents.iterator();
        while (iter.hasNext()) {
            int[] line = iter.next();
            if (line[0] != line[2] && line[1] != line[3]) {
                iter.remove();
            }
        }

        // create the xy grid by finding the largest number in the hydroThermalVents
        // List
        int biggestNumber = 0;
        for (int[] is : hydroThermalVents) {
            for (int is2 : is) {
                if (is2 > biggestNumber) {
                    biggestNumber = is2;
                }
            }
        }
        // create the x/y grid
        int[][] xyGrid = new int[biggestNumber + 1][biggestNumber + 1];
        // Plot xyGrid
        for (int[] is : hydroThermalVents) {
            // if columns are equal, plot rows. 
            if (is[1] == is[3]) {
                // plot x
                int col = is[1];
                // check which is the bigger value for x coordinate
                if (is[0] < is[2]) {
                    for (int i = is[0]; i < is[2] + 1; i++) {
                        int currentValue = xyGrid[col][i];
                        currentValue++;
                        xyGrid[col][i] = currentValue;
                    }
                } else {
                    for (int i = is[2]; i < is[0] + 1; i++) {
                        int currentValue = xyGrid[col][i];
                        currentValue++;
                        xyGrid[col][i] = currentValue;
                    }
                }
            } else {
                // plot y
                int row = is[2];
                // check which is the bigger value for y coordinate
                if (is[1] < is[3]) {
                    for (int i = is[1]; i < is[3] + 1; i++) {
                        int currentValue = xyGrid[i][row];
                        currentValue++;
                        xyGrid[i][row] = currentValue;
                    }
                } else {
                    for (int i = is[3]; i < is[1] + 1; i++) {
                        int currentValue = xyGrid[i][row];
                        currentValue++;
                        xyGrid[i][row] = currentValue;
                    }
                }
            }
        }

        int numOfDangerPts = 0;
        for (int[] is : xyGrid) {
            for (int is2 : is) {
                if (is2 >= 2)
                    numOfDangerPts++;
            }
        }
        displayResult(numOfDangerPts, "1");
    }

    @Override
    void solvePart02(List<String> input) {
        // TODO Auto-generated method stub

    }

    private int[] getXYRow(String row) {
        int[] xyRow = new int[4];
        Pattern pat = Pattern.compile("\\b\\d+\\b");
        Matcher mat = pat.matcher(row);
        int counter = 0;
        while (mat.find())
            xyRow[counter++] = Integer.parseInt(mat.group());
        return xyRow;
    }

    public static void main(String[] args) {
        AoC2021Core day05 = new Day05("5");
        //day05.solvePart01(day05.getTestInput());
        day05.solvePart01(day05.getInput());

        day05.solvePart02(day05.getTestInput());
        // day05.solvePart02(day05.getInput());

    }

}
