package tryout.testing;

public class SudokuSimple {

    int[] mat[];
    int N = 9; // number of columns/rows;
    int SRN; // square root of N
    int K; // No. of missing digits

    // constructor
    SudokuSimple(int N, int K){
        // this.N = N;
        this.K = K;

        double SRNd = Math.sqrt(N);
        SRN = (int) SRNd;

        mat = new int[N][N];
    }

    // Sudoku Generator
    public void fillValues(){

    }

    public boolean isValidNumber(int fillingNumber){
        if(fillingNumber > 0){
            return true;
        }

        return false;
    }

    // for recursion, testing and to just show it's not solvable
    public void isNotSovable(){

    }
}
