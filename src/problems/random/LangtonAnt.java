package problems.random;

/* Implement langton ant problem */

import java.util.HashSet;

class LangtonAnt {

    public static void main(String[] args) {
        LangtonAnt langtonAnt = new LangtonAnt();
        Board board = langtonAnt.new Board();
        Grid grid = langtonAnt.new Grid();
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

    enum Orientation {
        left,
        up,
        right,
        down;

        private Orientation getTurn(boolean clockwise) {
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

    private class Ant {
        private Position position = new Position(0, 0);
        private Orientation orientation = Orientation.right;

        private void turn(boolean clockwise) {
            orientation = orientation.getTurn(clockwise);
        }

        private void move() {
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

        private void adjustPosition(int shiftRow, int shiftColumn) {
            position.row += shiftRow;
            position.column += shiftColumn;
        }
    }

    private class Board {
        private HashSet<Position> whites = new HashSet<Position>();
        private Ant ant = new Ant();
        private Position topLeftCorner = new Position(0, 0);
        private Position bottomRightCorner = new Position(0, 0);

        public Board() {
        }

        private void move() {
            ant.turn(isWhite(ant.position)); // Turn
            flip(ant.position); // flip
            ant.move(); // move
            ensureFit(ant.position);
        }

        private void flip(Position position) {
            if (whites.contains(position)) {
                whites.remove(position);
            } else {
                whites.add(position.clone());
            }
        }

        private void ensureFit(Position position) {
            int row = position.row;
            int column = position.column;

            topLeftCorner.row = Math.min(topLeftCorner.row, row);
            topLeftCorner.column = Math.min(topLeftCorner.column, column);

            bottomRightCorner.row = Math.max(bottomRightCorner.row, row);
            bottomRightCorner.column = Math.max(bottomRightCorner.column, column);
        }

        private boolean isWhite(Position p) {
            return whites.contains(p);
        }

        private boolean isWhite(int row, int column) {
            return whites.contains(new Position(row, column));
        }

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

    private class Grid {
        private boolean[][] grid;
        private Ant ant = new Ant();

        public Grid() {
            grid = new boolean[1][1];
        }

        private void copyWithShift(
            boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftColumn) {
            for (int r = 0; r < oldGrid.length; r++) {
                for (int c = 0; c < oldGrid[0].length; c++) {
                    newGrid[r + shiftRow][c + shiftColumn] = oldGrid[r][c];
                }
            }
        }

        private void ensureFit(Position position) {
            int shiftRow = 0;
            int shiftColumn = 0;

            int numRows = grid.length;
            if (position.row < 0) {
                shiftRow = numRows;
                numRows *= 2;
            } else if (position.row >= numRows) {
                numRows *= 2;
            }

            int numColumns = grid[0].length;
            if (position.column < 0) {
                shiftColumn = numColumns;
                numColumns *= 2;
            } else if (position.column >= numColumns) {
                numColumns *= 2;
            }

            if (numRows != grid.length || numColumns != grid[0].length) {
                boolean[][] newGrid = new boolean[numRows][numColumns];
                copyWithShift(grid, newGrid, shiftRow, shiftColumn);
                ant.adjustPosition(shiftRow, shiftColumn);
                grid = newGrid;
            }
        }

        private void flip(Position position) {
            int row = position.row;
            int column = position.column;
            grid[row][column] = grid[row][column] ? false : true;
        }

        private void move() {
            ant.turn(grid[ant.position.row][ant.position.column]);
            flip(ant.position);
            ant.move();
            ensureFit(ant.position);
        }

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

    private class Position {
        private int row;
        private int column;

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
}
