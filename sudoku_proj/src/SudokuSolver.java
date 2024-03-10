/**Doug
 *The SudokuSolver class takes a SudokuPuzzle and solves it, using an ArrayDequeue (essentially a stack) to store
 * every move that is made so that the solve method and nextMove method can backtrack through the puzzle and fix
 * incorrect moves. It essentially repeats this process, brute-forcing the solution to the SudokuPuzzle.
 */
import java.util.ArrayDeque;

public class SudokuSolver {
    /**
     *This is the SudokuPuzzle that we are trying to solve. It is passed to our constructor by the user.
     */
    SudokuPuzzle toSolve;
    /**
     *This ArrayDeque of SudokuMoves essentially functions like a stack which we use to store our previous SudokuMoves
     * so that we may backtrack when necessary.
     */
    ArrayDeque<SudokuMove> stack;

    public SudokuSolver(SudokuPuzzle a){
        this.toSolve = a;
        this.stack = new ArrayDeque<>();
    }

    /**
     *This method actually solves our SudokuPuzzle using backtracking. It uses two for loops to go through our entire
     * SudokuPuzzle, checking if we encounter a square with 0 in it. If we do, we create a new move, and then depending
     * on if this move is null or not, we either backtrack or simply add it to our board. If it is null then we
     * continuously pop items out of our stack, set their square on the board to 0, and attempt a new move. Otherwise,
     * we simply add the move to our board and our stack. The inline comments help explain the logic.
     */
    public void solve() {
        //these loops go through our board
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                SudokuMove move;
                //if we find an empty cell
                if (toSolve.getBoardVal(x,y) == 0) {
                        move = nextMove(x, y, 0);//create a new move and if it's null backtrack.
                        if(move == null){
                            while(move == null && !stack.isEmpty()) {
                                int notAllowed = stack.peek().getNum();//now we have an integer that isn't allowed
                                int xPrev = stack.peek().getX();
                                int yPrev = stack.peek().getY();
                                toSolve.setBoard(xPrev,yPrev, 0);
                                stack.pop();
                                //sets move to a new SudokuMove that is being made for the cell we backtracked to
                                move = nextMove(xPrev, yPrev, notAllowed);
                            }
                            //once we find a different move that works in a previous cell:
                            stack.push(move);
                            toSolve.setBoard(move.getX(), move.getY(), move.getNum());
                            //ensure we go to the spot right after the cell we just backtracked to
                            x = move.getX();
                            y = move.getY();
                        }
                        else {//if move isn't null, then yay we found a good move right away!
                            stack.push(move);
                            toSolve.setBoard(move.getX(), move.getY(), move.getNum());
                        }
                }
            }
        }
    }

    /**
     *This is a helper method for our solve method. nextMove takes the location of a potential SudokuMove, and
     * notAllowed which, depending on if we are backtracking or not, prevents us from making a move that we have
     * deemed incorrect. It simply counts from 1 to 10 and uses isValid from SudokuPuzzle to determine if there
     * are any possible moves to make, if there is, we return this move. If no moves are possible, it returns null.
     * @param x location of the square.
     * @param y location of the square
     * @param notAllowed the integer which is not allowed to go in the square that we are trying to make a move for,
     *                   will be passed 0 if we are not backtracking.
     * @return SudokuMove move if there is a possible move, and null if there are none possible.
     */
    public SudokuMove nextMove(int x, int y, int notAllowed) {
        for (int i = notAllowed + 1; i <= 9; i++) { //start past the notAllowed int to avoid it
            SudokuMove move = new SudokuMove(i, x, y);
            if (toSolve.isValid(move)) {
                return move;
            }
        }
        return null;
    }
}
