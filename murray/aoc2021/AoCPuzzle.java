package murray.aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AoCPuzzle {

    private String day = "";
    private List<String> input;
    private List<String> testInput;
    
    public AoCPuzzle(String day) {
        this.day = day;
        setInput(parseInput());
        setTestInput(parseTestInput());
    }

    public List<String> getTestInput() {
        return testInput;
    }

    public void setTestInput(List<String> testInput) {
        this.testInput = testInput;
    }

    public List<String> getInput() {
        return input;
    }

    private void setInput(List<String> input) {
        this.input = input;
    }

    

    abstract void solvePart01(List<String> input);
    abstract void solvePart02(List<String> input);

    private List<String> parseInput() {
        List<String> input = null;
        try {
            // Trying some NIO
            input = Files.lines(Paths.get("resources/day" + day + ".txt")).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    private List<String> parseTestInput() {
        List<String> input = null;
        try {
            // Trying some NIO
            input = Files.lines(Paths.get("resources/test" + day + ".txt")).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public List<Integer> convertToInts(List<String> input)
	{
		List<Integer> ints = new ArrayList<>();
		for(String s : input)
			ints.add(Integer.parseInt(s));
		return ints;
	}

	public List<Long> convertToLongs(List<String> input)
	{
		List<Long> ints = new ArrayList<>();
		for(String s : input)
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