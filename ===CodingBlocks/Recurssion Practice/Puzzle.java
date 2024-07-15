
    import java.util.HashSet;
    import java.util.Scanner;
    
    public class Puzzle {
        private static class Cell {
            int row, col;
    
            public Cell(int r, int c) {
                this.row = r;
                this.col = c;
            }
        }
    
        public static void completeThePuzzle(char[][] puzzle, HashSet<String> set) {
            for (int r = 9; r >= 0; r--) {
                for (int c = 0; c < 10; c++) {
                    if (puzzle[r][c] != '+') {
                        completeThePuzzleHelper(puzzle, set, r, c);
                        return;
                    }
                }
            }
        }
    
        public static void completeThePuzzleHelper(char[][] puzzle, HashSet<String> set, int row, int col) {
            if (puzzle[row][col] == '-') {
                int rCount = getRHSEmptyCellsCount(puzzle, row, col);
                int lStart = getLeftStartCol(puzzle, row, col);
                int rSz = lStart == col ? rCount : rCount + (col - lStart);
    
                if (rSz > 1) {
                    for (String s : set) {
                        if (s.length() == rSz && canRightFit(puzzle, row, lStart, s)) {
                            char[][] puzzleCopy = copyPuzzle(puzzle);
                            HashSet<String> setCopy = copySet(set);
                            setCopy.remove(s);
                            rightFit(puzzleCopy, row, lStart, s);
                            Cell c = getNextCell(puzzleCopy, row, col);
                            if (c == null) {
                                printPuzzle(puzzleCopy);
                                return;
                            } else {
                                completeThePuzzleHelper(puzzleCopy, setCopy, c.row, c.col);
                            }
                        }
                    }
                } else {
                    int dCount = getDownEmptyCellsCount(puzzle, row, col);
                    int uStart = getUpStartRow(puzzle, row, col);
                    int dSz = uStart == row ? dCount : dCount + uStart - row;
    
                    for (String s : set) {
                        if (s.length() == dSz && canDownFit(puzzle, uStart, col, s)) {
                            char[][] puzzleCopy = copyPuzzle(puzzle);
                            HashSet<String> setCopy = copySet(set);
                            setCopy.remove(s);
                            downFit(puzzleCopy, uStart, col, s);
                            Cell c = getNextCell(puzzleCopy, row, col);
                            if (c == null) {
                                printPuzzle(puzzleCopy);
                                return;
                            } else {
                                completeThePuzzleHelper(puzzleCopy, setCopy, c.row, c.col);
                            }
                        }
                    }
                }
            }
        }
    
        public static void printPuzzle(char[][] puzzle) {
            for (int r = 9; r >= 0; r--) {
                for (int c = 0; c < 10; c++) {
                    System.out.print(puzzle[r][c]);
                }
                System.out.println();
            }
        }
    
        public static void downFit(char[][] puzzle, int row, int col, String s) {
            for (int r = row; r >= 0 && row - r + 1 <= s.length(); r--) {
                puzzle[r][col] = s.charAt(row - r);
            }
        }
    
        public static boolean canDownFit(char[][] puzzle, int row, int col, String s) {
            for (int r = row; r >= 0 && row - r + 1 <= s.length(); r--) {
                if (puzzle[r][col] != '-' && puzzle[r][col] != s.charAt(row - r)) {
                    return false;
                }
            }
            return true;
        }
    
        public static Cell getNextCell(char[][] puzzle, int row, int col) {
            for (int r = row; r >= 0; r--) {
                for (int c = 0; c < 10; c++) {
                    if (r == row && c >= col && puzzle[r][c] == '-') {
                        return new Cell(r, c);
                    } else if (r < row && puzzle[r][c] == '-') {
                        return new Cell(r, c);
                    }
                }
            }
            return null;
        }
    
        public static void rightFit(char[][] puzzle, int row, int col, String s) {
            for (int c = col; c < 10 && c - col + 1 <= s.length(); c++) {
                puzzle[row][c] = s.charAt(c - col);
            }
        }
    
        public static boolean canRightFit(char[][] puzzle, int row, int col, String s) {
            for (int c = col; c < 10 && c - col + 1 <= s.length(); c++) {
                if (puzzle[row][c] != '-' && puzzle[row][c] != s.charAt(c - col)) {
                    return false;
                }
            }
            return true;
        }
    
        public static int getLeftStartCol(char[][] puzzle, int row, int col) {
            while (col >= 0 && puzzle[row][col] != '+') {
                col--;
            }
            return col + 1;
        }
    
        public static int getUpStartRow(char[][] puzzle, int row, int col) {
            while (row < 10 && puzzle[row][col] != '+') {
                row++;
            }
            return row - 1;
        }
    
        public static int getDownEmptyCellsCount(char[][] puzzle, int row, int col) {
            int count = 0;
            while (row >= 0 && puzzle[row][col] != '+') {
                count++;
                row--;
            }
            return count;
        }
    
        public static int getRHSEmptyCellsCount(char[][] puzzle, int row, int col) {
            int count = 0;
            while (col < 10 && puzzle[row][col] != '+') {
                count++;
                col++;
            }
            return count;
        }
    
        public static HashSet<String> copySet(HashSet<String> set) {
            HashSet<String> setCopy = new HashSet<>();
            setCopy.addAll(set);
            return setCopy;
        }
    
        public static char[][] copyPuzzle(char[][] puzzle) {
            char[][] puzzleCopy = new char[10][10];
            for (int r = 9; r >= 0; r--) {
                for (int c = 0; c < 10; c++) {
                    puzzleCopy[r][c] = puzzle[r][c];
                }
            }
            return puzzleCopy;
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[][] puzzle = new char[10][10];
            for (int r = 9; r >= 0; r--) {
                String word = sc.nextLine();
                for (int c = 0; c < 10; c++) {
                    puzzle[r][c] = word.charAt(c);
                }
            }
            String word = sc.nextLine();
            String[] cities = word.split(";");
            HashSet<String> set = new HashSet<>();
            for (String s : cities) {
                set.add(s);
            }
            completeThePuzzle(puzzle, set);
        }
    }
    
    
