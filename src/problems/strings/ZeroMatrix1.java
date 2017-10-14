package problems.strings;

public class ZeroMatrix1 {
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}		
	}

	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}		
	}			
	
	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];	
		boolean[] column = new boolean[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = true; 
					column[j] = true;
		 		}
			}
		}
		
		// Nullify rows
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(matrix, i);
			}
		}
		
		// Nullify columns
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(matrix, j);
			}
		}
	}	
	
	public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			return false;
		}
		
		for (int k = 0; k < m1.length; k++) {
			for (int j = 0; j < m1[0].length; j++) {
				if (m1[k][j] != m2[k][j]) {
					return false;
				}
			}
		}	
		return true;
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix = randomMatrix(nrows, ncols, -10, 10);		

		printMatrix(matrix);
		
		setZeros(matrix);
		
		System.out.println();
		
		printMatrix(matrix);
	}
	
	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
					System.out.print(" ");
				}
				if (matrix[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
}