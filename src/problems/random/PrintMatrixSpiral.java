package problems.random;

public class PrintMatrixSpiral {
	
	    // Function print matrix in spiral form
	    static void spiralPrint(int row, int column, int a[][])
	    {
	        int i, k = 0, l = 0;
	        /*  k - starting row index
	        row - ending row index
	        l - starting column index
	        column - ending column index
	        i - iterator
	        */
	         
	        while (k < row && l < column)
	        {
	            // Print the first row from the remaining rows
	            for (i = l; i < column; ++i)
	            {
	                System.out.print(a[k][i]+" ");
	            }
	            k++;
	 
	            // Print the last column from the remaining columns 
	            for (i = k; i < row; ++i)
	            {
	                System.out.print(a[i][column-1]+" ");
	            }
	            column--;
	 
	            // Print the last row from the remaining rows */
	            if ( k < row)
	            {
	                for (i = column-1; i >= l; --i)
	                {
	                    System.out.print(a[row-1][i]+" ");
	                }
	                row--;
	            }
	 
	            // Print the first column from the remaining columns */
	            if (l < column)
	            {
	                for (i = row-1; i >= k; --i)
	                {
	                    System.out.print(a[i][l]+" ");
	                }
	                l++;    
	            }        
	        }
	    }
	    
	    // driver program
		public static void main (String[] args) 
		{
		    int R = 4;
		    int C = 6;
			int a[][] = { {1,  2,  3,  4,  5,  6},
	                      {7,  8,  9,  10, 11, 12},
	                      {13, 14, 15, 16, 17, 18},
	                      {13, 14, 15, 16, 17, 18}
	                    };
	        spiralPrint(R,C,a);
		}
	}