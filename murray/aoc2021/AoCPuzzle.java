package murray.aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AoCPuzzle {

    private String day = "";
    private List<String> fileInput;
    private static final String FILE_LOCATION = "resources/day";

    protected AoCPuzzle(String day) {
        this.day = day;
        setFileInput(parseInput());
    }

    public List<String> getFileInput() {
        return fileInput;
    }

    private void setFileInput(List<String> input) {
        this.fileInput = input;

}
    abstract void solvePart01(List<String> input);
    abstract void solvePart02(List<String> input);

    private List<String> parseInput() {
        List<String> input = null;
        try (Stream<String> myStream = Files.lines(Paths.get(FILE_LOCATION + day + ".txt"));) {
            // Trying some NIO
            input = myStream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    public List<Integer> convertToInts(List<String> input) {
        List<Integer> ints = new ArrayList<>();
        for (String s : input)
            ints.add(Integer.parseInt(s));
        return ints;
    }

    public List<Long> convertToLongs(List<String> input) {
        List<Long> ints = new ArrayList<>();
        for (String s : input)
            ints.add(Long.parseLong(s));
        return ints;
    }

    public void displayResult(long answer, String part) {
        System.out.println("Part " + part + ": " + answer);
    }

    public void displayResult(String answer, String part) {
        System.out.println("Part " + part + ": " + answer);
    }

}
