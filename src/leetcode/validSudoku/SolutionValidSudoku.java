package leetcode.validSudoku;

import java.util.*;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * <p>
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 */

public class SolutionValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean isValidSudoku = isValidSudoku_v2(board);
        System.out.println("isValidSudoku " + isValidSudoku);
    }

    public static boolean isValidSudoku_v2(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku_v1(char[][] board) {

        Map<Integer, List<Character>> rows = getRows(board);
        Map<Integer, List<Character>> columns = getColumns(board);
        Map<String, List<Character>> subBoxes = getSubBoxes(board);

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                char value = board[x][y];

                if (value == '.') {
                    continue;
                }

                if (isValid(rows.get(x), value)) {
                    return false;
                }

                if (isValid(columns.get(y), value)) {
                    return false;
                }

                String subBoxKey = getSubBoxKey(x, y);
                System.out.println("subBoxKey = " + subBoxKey);
                if (isValid(subBoxes.get(subBoxKey), value)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValid(List<Character> characters, char value) {
        long count = characters.stream().filter(v -> v.equals(value)).count();
        return count > 1;
    }

    public static String getSubBoxKey(int x, int y) {
        String sectionX = getFirstSectionIndex(x);
        String sectionY = getFirstSectionIndex(y);

        return sectionX + "." + sectionY;
    }

    public static String getFirstSectionIndex(int index) {
        switch (index) {
            case 0:
            case 1:
            case 2:
                return "0";
            case 3:
            case 4:
            case 5:
                return "3";
            case 6:
            case 7:
            case 8:
                return "6";
            default:
                return "";
        }
    }

    public static Map<Integer, List<Character>> getRows(char[][] board) {

        Map<Integer, List<Character>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            List<Character> list = new ArrayList<>(Arrays.asList(board[i][0], board[i][1], board[i][2], board[i][3],
                    board[i][4], board[i][5], board[i][6], board[i][7], board[i][8]));
            list.removeIf(value -> value.equals('.'));
            map.put(i, list);
        }
        return map;
    }

    public static Map<Integer, List<Character>> getColumns(char[][] board) {

        Map<Integer, List<Character>> map = new HashMap<>();

        for (int i = 0; i < board[0].length; i++) {
            List<Character> list = new ArrayList<>(Arrays.asList(board[0][i], board[1][i], board[2][i], board[3][i],
                    board[4][i], board[5][i], board[6][i], board[7][i], board[8][i]));
            list.removeIf(value -> value.equals('.'));
            map.put(i, list);
        }
        return map;
    }


    public static Map<String, List<Character>> getSubBoxes(char[][] board) {

        Map<String, List<Character>> map = new HashMap<>();
        int x = 0;
        int y = 0;

        for (int i = 1; i <= 9; i++) {
            List<Character> list = new ArrayList<>(Arrays.asList(board[x][y], board[x][y + 1], board[x][y + 2], board[x + 1][y],
                    board[x + 1][y + 1], board[x + 1][y + 2], board[x + 2][y], board[x + 2][y + 1], board[x + 2][y + 2]));
            list.removeIf(value -> value.equals('.'));
            map.put(x + "." + y, list);

            if (i % 3 == 0) {
                x += 3;
                y = 0;
            } else {
                y += 3;
            }
        }
        return map;
    }
}
