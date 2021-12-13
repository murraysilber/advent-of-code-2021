package murray.aoc2021;

import java.util.ArrayList;
import java.util.List;

public class Day03 extends AoCPuzzle {

    public Day03(String day) {
        super(day);
    }

    private int getOxygenRating(List<String> input) {
        int oxygenRating = 0;
        for (int i = 0; i < input.get(0).length(); ++i) {
            int ones = 0;
            for (String code : input) {
                if (code.charAt(i) == '1') {
                    ++ones;
                }
            }
            int zeros = input.size() - ones;
            List<String> filteredInput = new ArrayList<>();
            for (String code : input) {
                if (ones >= zeros) {
                    if (code.charAt(i) == '1') {
                        filteredInput.add(code);
                    }
                } else {
                    if (code.charAt(i) == '0') {
                        filteredInput.add(code);
                    }
                }
            }
            input = filteredInput;
            if (input.size() == 1) {
                oxygenRating = Integer.parseInt(input.get(0), 2);
                break;
            }
        }
        return oxygenRating;
    }

    private int getCO2Rating(List<String> input) {
        int co2Rating = 0;
        for (int i = 0; i < input.get(0).length(); ++i) {
            int ones = 0;
            for (String code : input) {
                if (code.charAt(i) == '1') {
                    ++ones;
                }
            }
            int zeros = input.size() - ones;
            List<String> filteredInput = new ArrayList<>();
            for (String code : input) {
                if (ones >= zeros) {
                    if (code.charAt(i) == '0') {
                        filteredInput.add(code);
                    }
                } else {
                    if (code.charAt(i) == '1') {
                        filteredInput.add(code);
                    }
                }
            }
            input = filteredInput;
            if (input.size() == 1) {
                co2Rating = Integer.parseInt(input.get(0), 2);
                break;
            }
        }
        return co2Rating;
    }

    @Override
    void solvePart01(List<String> input) {
        long powerConsumption = 0;
        String gammaRate = "";
        String epsilonRate = "";
        for (int i = 0; i < input.get(0).length(); ++i) {
            int ones = 0;
            for (String code : input) {
                if (code.charAt(i) == '1') {
                    ++ones;
                }
            }
            int zeros = input.size() - ones;
            gammaRate += ones > zeros ? '1' : '0';
            epsilonRate += ones > zeros ? '0' : '1';
        }

        powerConsumption = Long.parseLong(gammaRate, 2) * Long.parseLong(epsilonRate, 2);
        displayResult(String.valueOf(powerConsumption), "1");
        
    }

    @Override
    void solvePart02(List<String> input) {
        int oxygenGeneratorRating = getOxygenRating(input);
        int co2ScrubberRating = getCO2Rating(input);
        int lifeSupportRating = oxygenGeneratorRating * co2ScrubberRating;
        displayResult(String.valueOf(lifeSupportRating), "2");
    }

    public static void main(String[] args) {
        Day03 day03 = new Day03("3");
        day03.solvePart01(day03.getInput());
        day03.solvePart02(day03.getInput());
    }

    

}
