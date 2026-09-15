// Last updated: 9/15/2026, 9:09:38 AM
1class Solution {
2    public void solveSudoku(char[][] board) {
3        solve(board);
4    }
5
6    private boolean solve(char[][] board) {
7        for (int row = 0; row < 9; row++) {
8            for (int col = 0; col < 9; col++) {
9                if (board[row][col] == '.') {
10                    for (char c = '1'; c <= '9'; c++) {
11                        if (isValid(board, row, col, c)) {
12                            board[row][col] = c;
13
14                            if (solve(board)) {
15                                return true;
16                            } else {
17                                board[row][col] = '.'; // Backtrack
18                            }
19                        }
20                    }
21                    return false; // No valid digit found for this cell
22                }
23            }
24        }
25        return true; // All cells filled successfully
26    }
27
28    private boolean isValid(char[][] board, int row, int col, char c) {
29        for (int i = 0; i < 9; i++) {
30            // Check row
31            if (board[row][i] == c) return false;
32            // Check column
33            if (board[i][col] == c) return false;
34            // Check 3x3 sub-grid
35            int subRow = 3 * (row / 3) + i / 3;
36            int subCol = 3 * (col / 3) + i % 3;
37            if (board[subRow][subCol] == c) return false;
38        }
39        return true;
40    }
41}