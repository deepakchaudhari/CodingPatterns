package com.codingpatterns.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
 * queens attack each other.
 *
 * <p>Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * <p>Each solution contains a distinct board configuration of the n-queens' placement, where 'Q'
 * and '.' both indicate a queen and an empty space, respectively.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 4 Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above Example 2:
 *
 * <p>Input: n = 1 Output: [["Q"]]
 */
public class EightQueens {

    public static void main(String[] args) {
        int nQueens = 8;


        print2D(find_all_arrangements(nQueens));

    }

    public static void print2D(String mat[][])
    {
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                System.out.print("| "+mat[i][j] + " |");
                System.out.print("\n");

            }
            System.out.print("\n");

        }

    }



    static String[][] find_all_arrangements(int n) {
        // This is a backtracking problem.
        // All backtracking problems follow this pattern
        //		void solve(row, board, result):
        //		    if(row==board.size())  result.store(board)
        //		    for each col:
        //		        if board.isValid(row, col):
        //		            board.set(row, col)
        //		            solve(row+1, board, result)
        //		            board.unSet(row, col)

        List<String[]> result = new ArrayList<>();
        for(int col=0; col<n; col++) {
            Board b = new Board(n);
            b.set(0, col);
            solve(1, b, result);
        }

        String[][] returns = new String[result.size()][n];
        for(int i = 0; i<result.size(); i++) {
            returns[i] = result.get(i);
        }
        return returns;
    }

    private static void solve(int row, Board board, List<String[]> result) {
        if(row==board.getDim()) {
            board.store(result);
            return;
        }
        for(int col = 0; col < board.getDim(); col++) {
            if(board.isValid(row, col)) {
                board.set(row, col);
                solve(row+1, board, result);
                board.unset(row, col);
            }
        }
    }

    private static class Board {
        private final char[][] board;
        private final int dim;
        private final boolean[] takenR, takenC, takenB, takenF;

        Board(int dim) {
            this.dim = dim;
            this.board = new char[dim][dim];
            for(int i = 0; i < dim; i++) {
                Arrays.fill(board[i], '-');
            }
            this.takenR = new boolean[dim];
            this.takenC = new boolean[dim];
            this.takenB = new boolean[dim*2];
            this.takenF = new boolean[dim*2];
        }

        boolean isValid(int row, int col) {
            return !(takenR[row]||takenC[col]||takenB[row+col]||takenF[dim+row-col]);
        }

        void set(int row, int col) {
            set(row, col, 'Q', true);
        }

        void unset(int row, int col) {
            set(row, col, '-', false);
        }

        private void set(int row, int col, char c, boolean flag) {
            board[row][col] = c;
            takenR[row] = flag;
            takenC[col] = flag;
            takenB[row+col] = flag;
            takenF[dim+row-col] = flag;
        }

        void store(List<String[]> result) {
            if(isValidBoard()) {
                String[] rows = new String[board.length];
                for(int i = 0; i < board.length; i++) {
                    rows[i] = new String(board[i]);
                }
                result.add(rows);
            }
        }

        int getDim() {
            return dim;
        }

        boolean isValidBoard() {
            for(int row = 0; row<dim; row++) {
                if(!takenR[row]) {
                    // all row must be taken for the board to be valid
                    return false;
                }
            }
            return true;
        }
    }
}

