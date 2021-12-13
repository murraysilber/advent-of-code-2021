package murray.aoc2021;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScratchPad {
    public static void main(String[] args) {
        String row = "665,835 -> 108,278";
        System.out.println(row.substring(0, row.indexOf(",")));
        System.out.println(row.substring(row.indexOf(",") + 1, row.indexOf(" ")));
        System.out.println(row.substring(row.indexOf(" ") + 1));

        Pattern pat = Pattern.compile("\\b\\d+\\b");

        Matcher mat = pat.matcher("665,835 -> 108,278");

        while (mat.find())
            System.out.println("Match: " + mat.group());
    }
}
