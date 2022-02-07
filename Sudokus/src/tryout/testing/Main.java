package tryout.testing;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        var sodoko = new Sudoku(9,1);

        sodoko.fillValues();

        sodoko.printSudoku();
    }
}
