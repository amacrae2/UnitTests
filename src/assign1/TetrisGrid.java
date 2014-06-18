//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

import java.util.Stack;

public class TetrisGrid {
	private boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		//first checks for empty array.
		if (grid.length < 1) {
			return;
		}
		// non-empty array
		Stack<Integer> rowsToClear = new Stack<Integer>();
		for (int row = 0; row < grid[0].length; row++) {
			for (int col = 0; col < grid.length; col++) {
				if (!grid[col][row]) {
					break;
				}	
				else if (col == grid.length-1) {
					rowsToClear.push(row);
				}
			}
		}
		shiftClearedRows(rowsToClear);
	}

	/**
	 * clears the rows that contain all true booleans,
	 * and shifts rows down accordingly.
	 * @param rowsToClear the rows that contain all true booleans
	 */
	private void shiftClearedRows(Stack<Integer> rowsToClear) {
		while (!rowsToClear.empty()) {
			int startRow = rowsToClear.pop();
			for (int row = startRow; row < grid[0].length; row++) {
				for (int col = 0; col < grid.length; col++) {
					if (row+1 == grid[0].length) {
						grid[col][row] = false;
					}
					else {
						grid[col][row] = grid[col][row+1];
					}
				}
			}
		}
	}


	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
