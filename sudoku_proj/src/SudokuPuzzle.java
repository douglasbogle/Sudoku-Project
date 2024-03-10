/**Doug
 *This class represents a SudokuPuzzle. It takes a file containing a properly formatted SudokuPuzzle (0's in empty
 * spaces) and converts it to a two-dimensional array of integers and stores this as its sole attribute. It contains
 * an equals method to compare it to other SudokuPuzzles, this is mainly so that we can compare it to its solution
 * once it has been solved. It contains an isValid method which takes a SudokuMove and tests if this move is valid
 * (if the move follows the rules of Sudoku). Finally, it can be printed as a 9x9 table where, again, empty spaces
 * are shown by 0's. Appropriate getters and setters provided.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuPuzzle {
    /**
     * two dimensional representation of sudoku board
     */
    private int[][] board;

    /**
     *Takes a puzzleFile, ensures that this file actually exists, and then goes through the file putting the Sudoku
     * numbers in our two-dimensional board attribute.
     * @param puzzleFile string name of a file containing a Sudoku puzzle.
     */
    public SudokuPuzzle(String puzzleFile){
        this.board = new int[9][9];
        Scanner scan;
        try {
            scan = new Scanner(new File(puzzleFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //we assume the file has a 9x9 sudoku puzzle
        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                board[x][y] = scan.nextInt();
            }
        }
        scan.close();
    }

    /**
     * Allows us to set a board value at a specific location. Used by solve to update our board.
     * @param x coordinate
     * @param y coordinate
     * @param newVal to be assigned
     */
    public void setBoard(int x, int y, int newVal){
        board[x][y] = newVal;
    }

    /**
     * Allows us to get a board value at a specific location. Used by solve to check if we have encountered an empty
     * square.
     * @param x coordinate
     * @param y coordinate
     * @return integer, the number at the specified board index
     */
    public int getBoardVal(int x, int y){
        return board[x][y];
    }

    /**
     *Checks if two SudokuPuzzles are equal by iterating through them at the same time and returning false if the
     * values in the same spot in the two game boards aren't equal.
     * @param obj a different SudokuPuzzle (hopefully).
     * @return true or false depending on if the puzzles are equal.
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SudokuPuzzle) {
            // obj is of type T
        } else {
            return false;
        }
        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                if(!(board[x][y] == ((SudokuPuzzle) obj).board[x][y])){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *Ensures a SudokuMove is valid. Checks rows and columns by going through each of them and checking if there is
     * already a number that is equal to our sudoku move. Checking the 3x3 box is a little more complicated. It does
     * this by dividing the x and y coordinate by 3, and then multiplying by three to get the top left square in
     * whichever 3x3 box we are in. Then it just iterates through this miniature SudokuPuzzle as in solve() of
     * SudokuSolver.
     * @param a, simply a SudokuMove that is being tested for validity.
     * @return true or false depending on if it is valid or not.
     */
    public boolean isValid(SudokuMove a){
        //we cannot check if a move is valid in a square that is already full.
        if(board[a.getX()][a.getY()]!=0){
            return false;
        }
        //check 3x3 box
        for (int y = (a.getY()/3)*3; y < ((a.getY()/3)*3) + 3 && y < 9; y++) {
            for (int x = (a.getX()/3)*3; x < ((a.getX()/3)*3) + 3 && x < 9; x++) {
                if(board[x][y] == a.getNum()) {
                    return false;
                }
            }
        }

        //check column
        for (int y = 0; y < 9; y++) {
            //if num is already in column move is invalid
            if(board[a.getX()][y] == a.getNum()){return false;}
        }

        //check row
        for (int x = 0; x < 9; x++) {
            //if num is already in row move is invalid
            if(board[x][a.getY()] == a.getNum()){return false;}
        }
        //if it doesn't break any rules we can put it in!
        return true;
    }

    /**
     * @return A string representation of our SudokuPuzzle, a 9x9 board
     */
    public String toString(){
        String s = "";
        for (int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                s+= board[x][y] + " ";
            }
            s+="\n";
        }
        return s;
    }
}
