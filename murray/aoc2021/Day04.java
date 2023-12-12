package murray.aoc2021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day04 extends AoCPuzzle {

    public Day04(String day) {
        super(day);
    }

    @Override
    void solvePart01(List<String> input) {
        String[] randomNumbers = input.get(0).split(",");
        List<int[][]> boards = generateBoards(input);

        for (String num : randomNumbers) {
            int number = Integer.parseInt(num);

            // mark the board with drawn numbers
            markBoards(boards, number);

            // check if we have a winning board
            for (int[][] board : boards) {
                boolean hasWon = hasBoardWon(board);
                if (hasWon) {
                    // do calculation
                    long answer = calculateWinningScore(board) * number;
                    // Display answer
                    displayResult(answer, "1");
                    return;
                }
            }
        }
    }

    @Override
    void solvePart02(List<String> input) {
        String[] randomNumbers = input.get(0).split(",");

        List<int[][]> boards = generateBoards(input);

        for (String num : randomNumbers) {
            int number = Integer.parseInt(num);

            // mark the board with drawn numbers
            markBoards(boards, number);

            // check if we have a winning board
            // use an Iterator to avoid java.util.ConcurrentModificationException
            // could also use a normal loop, not an enhanced loop.
            Iterator<int[][]> iter = boards.iterator();
            while (iter.hasNext()) {
                int[][] board = iter.next();
                boolean hasWon = hasBoardWon(board);
                if (hasWon) {
                    if (boards.size() > 1) {
                        iter.remove();
                    } else {
                        long answer = calculateWinningScore(board) * number;
                        // Display answer
                        displayResult(answer, "2");
                        return;
                    }

                }
            }
        }
    }

    private List<int[][]> generateBoards(List<String> input) {
        List<int[][]> boards = new ArrayList<>();

        int firstLine = 2;
        int currentLine = firstLine;

        while (currentLine < input.size()) {
            int[][] board = new int[5][5];
            int boardLine = 0;
            for (int i = 0; i < 5; i++) {
                String line = input.get(currentLine + boardLine);
                for (int j = 0; j < 5; j++) {
                    int number = Integer.parseInt(line.substring(j * 3, j * 3 + 2).trim());
                    board[i][j] = number;
                }
                boardLine++;
            }
            boards.add(board);
            currentLine += 6;
        }
        return boards;
    }

    private void markBoards(List<int[][]> boards, int num) {
        for (int[][] board : boards)
            for (int row = 0; row < board.length; row++)
                for (int col = 0; col < board[row].length; col++)
                    if (board[row][col] == num)
                        board[row][col] = -1;
    }

    private boolean hasBoardWon(int[][] board) {
        boolean hasWon = true;
        // check rows
        outerRowLoop: for (int row = 0; row < board.length; row++) {
            hasWon = true;
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != -1) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon) {
                break outerRowLoop;
            }
        }

        // check columns if no winning row
        if (!hasWon) {
            outerColumnLoop: for (int col = 0; col < board.length; col++) {
                hasWon = true;
                for (int row = 0; row < board.length; row++) {
                    if (board[row][col] != -1) {
                        hasWon = false;
                        break;
                    }
                }
                if (hasWon) {
                    break outerColumnLoop;
                }
            }
        }
        return hasWon;
    }

    private int calculateWinningScore(int[][] board) {
        int winningScore = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != -1) {
                    winningScore += board[row][col];
                }
            }
        }
        return winningScore;
    }

    public static void main(String[] args) {
        AoCPuzzle day04 = new Day04("4");
        day04.solvePart01(day04.getFileInput());
        day04.solvePart02(day04.getFileInput());

    }

}
