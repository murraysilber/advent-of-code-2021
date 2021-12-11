package day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day03 {

    public List<String> parseInput() {
        List<String> input = null;

        try {
            // Trying some NIO
            input = Files.lines(Paths.get("day03/input.txt")).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public int solvePart01() {
        List<String> input = parseInput();
        int powerConsumption = 0;
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

        powerConsumption = Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
        return powerConsumption;

    }

    public int solvePart02() {
        int oxygenGeneratorRating = getOxygenRating();
        int co2ScrubberRating = getCO2Rating();
        int lifeSupportRating = oxygenGeneratorRating * co2ScrubberRating;
        return lifeSupportRating;
    }

    public int getOxygenRating() {
        int oxygenRating = 0;
        List<String> input = parseInput();
        for (int i = 0; i < input.get(0).length(); ++i) {
            int ones = 0;
            for (String code : input) {
                if (code.charAt(i) == '1') {
                    ++ones;
                }
            }
            int zeros = input.size() - ones;
            List<String> filteredInput = new ArrayList<String>();
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

    public int getCO2Rating() {
        int co2Rating = 0;
        List<String> input = parseInput();
        for (int i = 0; i < input.get(0).length(); ++i) {
            int ones = 0;
            for (String code : input) {
                if (code.charAt(i) == '1') {
                    ++ones;
                }
            }
            int zeros = input.size() - ones;
            List<String> filteredInput = new ArrayList<String>();
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

    public static void main(String[] args) {
        Day03 day03 = new Day03();
        System.out.println(day03.solvePart01());
        System.out.println(day03.solvePart02());
    }

}
