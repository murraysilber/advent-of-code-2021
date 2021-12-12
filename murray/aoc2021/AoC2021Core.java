package murray.aoc2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AoC2021Core {

    private String day = "";
    private List<String> input;
    public AoC2021Core(String day) {
        this.day = day;
        setInput(parseInput());
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

    public void displayResult(String answer, String part) {
		System.out.println("Part " + part + ": " + answer);
    }

    

}