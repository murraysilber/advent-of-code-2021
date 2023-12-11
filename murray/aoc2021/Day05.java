package murray.aoc2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Day05 extends AoCPuzzle {
    private Map<Point, Integer> grid = new HashMap<>(); // grid where lines must be plotted.
    private List<Line> lines = null;

    public Day05(String day) {
        super(day);
    }

    // create List of Lines
    private List<Line> getLines(List<String> input) {
        List<Line> lines = new ArrayList<>();
        for (String line : input) {
            String[] linePoints = line.split(" -> ");
            String[] point1 = linePoints[0].split(",");
            String[] point2 = linePoints[1].split(",");
            lines.add(new Line(new Point(point1), new Point(point2)));
        }
        return lines;
    }

    public void drawGrid() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                Integer visits = this.grid.get(new Point(j, i));
                if (visits != null) {
                    System.out.print(visits + " ");
                } else {
                    System.out.print("." + " ");
                }

            }
            System.out.println();
        }
    }

    private void plotLinesOnGrid(String puzzlePart) {
        for (Line line : this.lines) {
            Point startPoint = line.getStartPoint();
            Point endPoint = line.getEndPoint();
            if (startPoint.y == endPoint.y) { // plot horizontals
                plotHorizontalLines(startPoint, endPoint);
            } else if (startPoint.x == endPoint.x) { // plot verticals
                plotVerticalLines(startPoint, endPoint);
            } else { // plot diagonals
                if (puzzlePart.equals("2")) {
                    int xDir = endPoint.x - startPoint.x > 0 ? 1 : -1;
                    int yDir = endPoint.y - startPoint.y > 0 ? 1 : -1;
                    plotDiagonalLines(startPoint, endPoint, xDir, yDir);
                }

            }
        }
    }

    private void plotDiagonalLines(Point startPoint, Point endPoint, int xDir, int yDir) {
        for (int i = 0; i <= Math.abs(endPoint.x - startPoint.x); i++)
            this.grid.merge(new Point(startPoint.x + (xDir * i), startPoint.y + (yDir * i)), 1,
                    Integer::sum);
    }

    private void plotVerticalLines(Point startPoint, Point endPoint) {
        for (int i = Math.min(startPoint.y, endPoint.y); i <= Math.max(startPoint.y, endPoint.y); i++) {
            this.grid.merge(new Point(startPoint.x, i), 1, Integer::sum);
        }
    }

    private void plotHorizontalLines(Point startPoint, Point endPoint) {
        for (int i = Math.min(startPoint.x, endPoint.x); i <= Math.max(startPoint.x, endPoint.x); i++) {
            this.grid.merge(new Point(i, startPoint.y), 1, Integer::sum);
        }
    }

    @Override
    void solvePart01(List<String> input) {
        lines = getLines(input);
        plotLinesOnGrid("1");

        int count = 0;
        for (int visits : this.grid.values()) {
            if (visits > 1) {
                count++;
            }
        }
        displayResult(count, "1");
        //drawGrid();
    }

    @Override
    void solvePart02(List<String> input) {
        lines = getLines(input);
        plotLinesOnGrid("2");

        int count = 0;
        for (int visits : this.grid.values()) {
            if (visits > 1) {
                count++;
            }
        }
        displayResult(count, "2");
        //drawGrid();
    }

    public static void main(String[] args) {
        AoCPuzzle day05 = new Day05("5");
        //day05.solvePart01(day05.getTestInput());
        day05.solvePart01(day05.getFileInput());

       // day05.solvePart02(day05.getTestInput());
        day05.solvePart02(day05.getFileInput());

    }

    private static class Point {
        private int x;
        private int y;

        public Point(String[] coordinate) {
            x = Integer.parseInt(coordinate[0]);
            y = Integer.parseInt(coordinate[1]);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }
    }

    private static class Line {
        private Point startPoint, endPoint;

        public Line(Point point, Point point2) {
            this.startPoint = point;
            this.endPoint = point2;
        }

        public Point getEndPoint() {
            return endPoint;
        }

        public Point getStartPoint() {
            return startPoint;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "startPoint.x=" + startPoint.x +
                    ", startPoint.y=" + startPoint.y +
                    ", endPoint.x=" + endPoint.x +
                    ", endPoint.y=" + endPoint.y +
                    '}';
        }
    }
}
