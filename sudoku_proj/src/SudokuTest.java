/**Doug
 *The point of this project is to solve any given Sudoku puzzle using a backtracking algorithm. This runner class
 * tries to ask a user for a sudoku file input (and optionally a solution file), and catches any errors with
 * retrieving the file. It then creates a SudokuPuzzle object. The SudokuPuzzle object is essentially the representation
 * of a Sudoku puzzle, and its only attribute is a two-dimensional array that stores the current Sudoku board. The
 * SudokuSolver class contains a solve method which runs through the Sudoku board, tests if a move is possible, and if
 * none are possible, backtracks. It does this by adding a SudokuMove object to a stack each time a successful move is
 * made, and therefore being able to take the most recent move out of the stack as it pleases. The SudokuMove object
 * simply represents a move at a particular x and y value(it has attributes that represent the moves location and the
 * number to be placed there). In this project, x is used interchangeably with i and y is used interchangeably with j.
 * Once we create a solve object and call it on a SudokuPuzzle in our runner class, we print the resulting solution and
 * (if we were given a solution file) whether it is equal to the puzzles given solution.
 */
import java.util.Scanner;

public class SudokuTest {
    public static void main(String[] args){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter filename of puzzle: ");
            String myFile = scan.nextLine();
            SudokuPuzzle test = new SudokuPuzzle(myFile);
            SudokuPuzzle solution = null;

            System.out.println("Enter filename of solution (optional): ");
            String mySolution = scan.nextLine().trim();
            //if user actually entered a solution file.
            if (!mySolution.isEmpty()){
                solution = new SudokuPuzzle(mySolution);
            }
            scan.close();

            System.out.println(test);//print initial board
            SudokuSolver mySolver = new SudokuSolver(test);
            mySolver.solve();
            System.out.println(test);//print (hopefully) solved board

            if (solution!=null && test.equals(solution)){
                System.out.println("Solution is correct!");
            }else if (solution!=null && !test.equals(solution)){
                System.out.println("Solution is incorrect.");
            }
        }
        catch (Exception e) {
            System.out.println("Please enter a proper file.");
            System.exit(0);
        }
    }
}
