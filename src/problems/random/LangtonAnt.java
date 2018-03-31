package problems.random;

/* Implement langton ant problem */

import java.util.HashSet;

class Ant {
	public Position position = new Position(0, 0);
	public Orientation orientation = Orientation.right;

	public void turn(boolean clockwise) {
		orientation = orientation.getTurn(clockwise);
	}

	public void move() {
		if (orientation == Orientation.left) {
			position.column--;
		} else if (orientation == Orientation.right) {
			position.column++;
		} else if (orientation == Orientation.up) {
			position.row--;
		} else if (orientation == Orientation.down) {
			position.row++;
		}
	}

	public void adjustPosition(int shiftRow, int shiftColumn) {
		position.row += shiftRow;
		position.column += shiftColumn;
	}
}

class Board {
	private HashSet<Position> whites = new HashSet<Position>();
	private Ant ant = new Ant();
	private Position topLeftCorner = new Position(0, 0);
	private Position bottomRightCorner = new Position(0, 0);

	public Board() {
	}

	/* Move ant. */
	public void move() {
		ant.turn(isWhite(ant.position)); // Turn
		flip(ant.position); // flip
		ant.move(); // move
		ensureFit(ant.position);
	}

	/* Flip color of cells. */
	private void flip(Position position) {
		if (whites.contains(position)) {
			whites.remove(position);
		} else {
			whites.add(position.clone());
		}
	}

	/*
	 * "Grow" the grid by tracking the most top-left and bottom-right position
	 * that we've seen.
	 */
	private void ensureFit(Position position) {
		int row = position.row;
		int column = position.column;

		topLeftCorner.row = Math.min(topLeftCorner.row, row);
		topLeftCorner.column = Math.min(topLeftCorner.column, column);

		bottomRightCorner.row = Math.max(bottomRightCorner.row, row);
		bottomRightCorner.column = Math.max(bottomRightCorner.column, column);
	}

	/* Check if cell is white. */
	public boolean isWhite(Position p) {
		return whites.contains(p);
	}

	/* Check if cell is white. */
	public boolean isWhite(int row, int column) {
		return whites.contains(new Position(row, column));
	}

	/* Print board. */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int rowMin = topLeftCorner.row;
		int rowMax = bottomRightCorner.row;
		int colMin = topLeftCorner.column;
		int colMax = bottomRightCorner.column;
		for (int r = rowMin; r <= rowMax; r++) {
			for (int c = colMin; c <= colMax; c++) {
				if (r == ant.position.row && c == ant.position.column) {
					sb.append(ant.orientation);
				} else if (isWhite(r, c)) {
					sb.append("X");
				} else {
					sb.append("_");
				}
			}
			sb.append("\n");
		}
		sb.append("Ant: " + ant.orientation + ". \n");
		return sb.toString();
	}
}

class Grid {
	private boolean[][] grid;
	private Ant ant = new Ant();

	public Grid() {
		grid = new boolean[1][1];
	}

	/*
	 * Copy old values into new array, with an offset/shift applied to the row
	 * and columns.
	 */
	private void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftColumn) {
		for (int r = 0; r < oldGrid.length; r++) {
			for (int c = 0; c < oldGrid[0].length; c++) {
				newGrid[r + shiftRow][c + shiftColumn] = oldGrid[r][c];
			}
		}
	}

	/*
	 * Ensure that the given position will fit on the array. If necessary,
	 * double the size of the matrix, copy the old values over, and adjust the
	 * ant's position so that it's in a positive ranges.
	 */
	private void ensureFit(Position position) {
		int shiftRow = 0;
		int shiftColumn = 0;

		/* Calculate new number of rows. */
		int numRows = grid.length;
		if (position.row < 0) {
			shiftRow = numRows;
			numRows *= 2;
		} else if (position.row >= numRows) {
			numRows *= 2;
		}

		/* Calculate new number of columns. */
		int numColumns = grid[0].length;
		if (position.column < 0) {
			shiftColumn = numColumns;
			numColumns *= 2;
		} else if (position.column >= numColumns) {
			numColumns *= 2;
		}

		/* Grow array, if necessary. Shift ant's position too. */
		if (numRows != grid.length || numColumns != grid[0].length) {
			boolean[][] newGrid = new boolean[numRows][numColumns];
			copyWithShift(grid, newGrid, shiftRow, shiftColumn);
			ant.adjustPosition(shiftRow, shiftColumn);
			grid = newGrid;
		}
	}

	/* Flip color of cells. */
	private void flip(Position position) {
		int row = position.row;
		int column = position.column;
		grid[row][column] = grid[row][column] ? false : true;
	}

	/* Move ant. */
	public void move() {
		ant.turn(grid[ant.position.row][ant.position.column]); // Turn
		flip(ant.position); // flip
		ant.move(); // move
		ensureFit(ant.position); // grow
	}

	/* Print board. */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (r == ant.position.row && c == ant.position.column) {
					sb.append(ant.orientation);
				} else if (grid[r][c]) {
					sb.append("X");
				} else {
					sb.append("_");
				}
			}
			sb.append("\n");
		}
		sb.append("Ant: " + ant.orientation + ". \n");
		return sb.toString();
	}
}

class Position {
	public int row;
	public int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Position) {
			Position p = (Position) o;
			return p.row == row && p.column == column;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (row * 31) ^ column;
	}

	public Position clone() {
		return new Position(row, column);
	}
}

enum Orientation {
	left, up, right, down;

	public Orientation getTurn(boolean clockwise) {
		if (this == left) {
			return clockwise ? up : down;
		} else if (this == up) {
			return clockwise ? right : left;
		} else if (this == right) {
			return clockwise ? down : up;
		} else { // down
			return clockwise ? left : right;
		}
	}

	@Override
	public String toString() {
		if (this == left) {
			return "\u2190";
		} else if (this == up) {
			return "\u2191";
		} else if (this == right) {
			return "\u2192";
		} else { // down
			return "\u2193";
		}
	}
}

public class LangtonAnt {

	public static void main(String[] args) {
		Board board = new Board();
		Grid grid = new Grid();
		System.out.println(board.toString());
		for (int i = 0; i < 100; i++) {
			System.out.println("\n\n---- MOVE " + i + " ----");
			board.move();
			String bs = board.toString();
			System.out.println(bs);

			grid.move();
			String gs = grid.toString();
			System.out.println(gs);

			if (!bs.equals(gs)) {
				System.out.println("ERROR");
				break;
			}

		}
	}

}