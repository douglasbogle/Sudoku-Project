/**Doug Bogle, 627045
 * This class represents a SudokuMove. It has attributes containing the move's x, y, and board value. It contains
 * the appropriate getters to access these values.
 */
public class SudokuMove {
    /**
     * i and x are used interchangeably, i represents the move's x value.
     */
    private int i;
    /**
     * j and y are used interchangeably, j represents the move's y value.
     */
    private int j;
    /**
     * integer representing the board value of our SudokuMove
     */
    private int num;

    public SudokuMove(int num, int x, int y) {
        this.i = x;
        this.j = y;
        this.num = num;
    }

    /**
     * getter that retrieves this SudokuMove's board value.
     *
     * @return integer board value.
     */
    public int getNum() {
        return num;
    }

    /**
     * getter that retrieves this SudokuMove's x value.
     *
     * @return integer x value.
     */
    public int getX() {
        return i;
    }

    /**
     * getter that retrieves this SudokuMove's y value.
     *
     * @return integer y value.
     */
    public int getY() {
        return j;
    }
}
