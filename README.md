# Sudoku Solver Project

## Overview

This Java project solves any given Sudoku puzzle using a backtracking algorithm. The project includes three main classes:
1. **SudokuSolver**: Solves the puzzle using an ArrayDeque to backtrack.
2. **SudokuPuzzle**: Represents the Sudoku board.
3. **SudokuMove**: Represents a move in the Sudoku puzzle.

The **SudokuSolver** class uses brute-force to solve the puzzle, storing every move in a stack to backtrack and correct mistakes.

## Key Classes and Methods

### SudokuSolver

The `SudokuSolver` class is responsible for solving the Sudoku puzzle. It uses backtracking to fill the puzzle and correct mistakes.

- **SudokuSolver(SudokuPuzzle a)**: Constructor that initializes the puzzle to be solved and the stack for backtracking.
- **void solve()**: Solves the Sudoku puzzle using backtracking.
- **SudokuMove nextMove(int x, int y, int notAllowed)**: Finds the next valid move for a given cell.

### SudokuPuzzle

The `SudokuPuzzle` class represents the Sudoku board. It reads the puzzle from a file and provides methods to manipulate and validate the board.

- **SudokuPuzzle(String puzzleFile)**: Constructor that reads a Sudoku puzzle from a file.
- **void setBoard(int x, int y, int newVal)**: Sets the value of a cell on the board.
- **int getBoardVal(int x, int y)**: Gets the value of a cell on the board.
- **boolean isValid(SudokuMove a)**: Checks if a move is valid.
- **boolean equals(Object obj)**: Checks if two Sudoku puzzles are equal.
- **String toString()**: Returns a string representation of the Sudoku board.

### SudokuMove

The `SudokuMove` class represents a move in the Sudoku puzzle, including the row, column, and value to be placed.

- **SudokuMove(int num, int x, int y)**: Constructor that initializes a move.
- **int getNum()**: Gets the value of the move.
- **int getX()**: Gets the row of the move.
- **int getY()**: Gets the column of the move.

### SudokuTest

- Lets you test the Sudoku Solver, can use included files such as s1.txt or s2.txt to test here
