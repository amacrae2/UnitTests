// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int top = 0;
		int bottom = 0;
		int left = 0;
		int right = 0;
		boolean noMatchingChar = true;
		for (int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == ch) {
					if (noMatchingChar) {
						top = row;
						bottom = row;
						left = col;
						right = col;
						noMatchingChar = false;
					}
					else {
						if (row > bottom) {
							bottom = row;
						}
						if (col > right) {
							right = col;
						}
						else if (col < left) {
							left = col;
						}
					}
				}
			}
		}
		// checks if there were any instances of the desired char. If not returns area of 0.
		if (noMatchingChar) {
			return 0;
		}
		int charArea = calculateCharArea(top,bottom,left,right);
		return charArea;
	}

	/**
	 * Finds the area of the smallest rectangle that has the following params.
	 * @param top the top y coord of the box.
	 * @param bottom the bottom y coord of the box.
	 * @param left the left most x coord of the box.
	 * @param right the right most x coord of the box.
	 * @return the area of the smallest box that fits the coords.
	 */
	private int calculateCharArea(int top, int bottom, int left, int right) {
		int width = right - left + 1;
		int height = bottom - top + 1;
		int area = width*height;
		return area;
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int plusCount = 0;
		for (int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				char ch = grid[row][col];
				if (determineIfPlus(row,col,ch,1)) {
					plusCount++;
				}
			}
		}
		return plusCount;
	}

	private boolean determineIfPlus(int row, int col, char ch, int step) {
		boolean left = (col-step!=-1 && grid[row][col-step]==ch);
		boolean right = (col+step!=grid[0].length && grid[row][col+step]==ch);
		boolean up = (row-step!=-1 && grid[row-step][col]==ch);
		boolean down = (row+step!=grid.length && grid[row+step][col]==ch);
		if (!left && !right && !up && !down && step!=1) {
			return true;
		}
		else if (left && right && up && down) {
			if (determineIfPlus(row, col, ch, step+1)) {
				return true;
			}
		}
		return false;
	}
	
}
