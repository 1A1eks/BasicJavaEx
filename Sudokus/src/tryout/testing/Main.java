package tryout.testing;
import org.jetbrains.annotations.NotNull;

import java.lang.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        var sodoko = new Sudoku(9,9);

        sodoko.fillValues();

        sodoko.printSudoku();

        printSudoku(sodoko.returnSudoku());

        solveSudoku(sodoko.returnSudoku());
    }

    public static void solveSudoku(int[][] mat){
        if(checkViability(mat)==false) return;

        if(solveRecursively(mat)){
            printSudoku(mat);
        };
    }

    public static boolean solveRecursively(int[][] mat){

        for (int row = 0; row<mat.length; row++) {
            for (int column = 0; column < mat.length; column++) {
                if(mat[row][column] == 0){
                    for(int numberToTry = 1; numberToTry <= 9; numberToTry++){
                        if(isValidPlacement(mat, numberToTry, row, column)){
                            mat[row][column] = numberToTry;
                            if(solveRecursively(mat)){
                                return true;
                            } else {
                                mat[row][column] = 0;
                            }
                        }
                    }
                }
            }
        }
        //wrong, just a dead end
        //System.out.println("Unsolvable Sudoku ~~ if nothing went wrong");

        //printSudoku(mat);

        return false;
    }

    public static boolean isValidPlacement(int[][] mat, int numberToTry, int row, int col){
        if(isValidColumn(mat, numberToTry, row, col) && isValidRow(mat, numberToTry, row, col)
                && isValidBox(mat, numberToTry, row, col) ){
            return true;
        } else return false;
    }

    public static boolean isValidColumn(int[][] mat, int numberToTry, int row, int col) {
        for(int j = 0; j < 9; j++){
            if(mat[row][j] == numberToTry){
                return false;
            }
        }
        return true;
    }


    public static boolean isValidRow(int[][] mat, int numberToTry, int row, int col) {
        for(int i = 0; i < 9; i++){
            if(mat[i][col] == numberToTry){
                return false;
            }
        }
        return true;
    }


    public static boolean isValidBox(int[][] mat, int numberToTry, int row, int col) {
        row = row - (row % 3);
        col = col - (col % 3);
        for(int i = row; i < row +3; i++){
            for(int j = col; j < col + 3; j++){
                if(mat[i][j] == numberToTry){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkViability(int[][] mat){

        for (int i = 0; i<mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j]>9 || mat[i][j]<0) {
                    System.out.println("Something went very very wrong");
                    return false;
                }
            }
        }
        return true;
    }

    public static void printSudoku(int[][] mat)
    {
        for (int i = 0; i<mat.length; i++)
        {
            for (int j = 0; j< mat.length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
