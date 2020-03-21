// Lab15avst.java
// 02-28-15 by Leon Schram
// The "Odd Magic Square" Program
// This is the student, starting version of the Lab15 assignment.


import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab15avst
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

      System.out.print("Enter the odd# size of the Magic Square -->  ");
      int size = input.nextInt();
      MagicSquare magic = new MagicSquare(size);

      magic.computeMagicSquare();
      magic.displayMagicSquare();
   //	magic.checkRows();          // for 100 & 110 Point Version Only
   //	magic.checkColumns();		 // for 100 & 110 Point Version Only
   //	magic.checkDiagonals();	 	 // for 100 & 110 Point Version Only
	}
}


public class MagicSquare {

    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        if (n % 2 == 0) throw new RuntimeException("n must be odd");

        int[][] magic = new int[n][n];

        int row = n-1;
        int col = n/2;
        magic[row][col] = 1;

        for (int i = 2; i <= n*n; i++) {
            if (magic[(row + 1) % n][(col + 1) % n] == 0) {
                row = (row + 1) % n;
                col = (col + 1) % n;
            }
            else {
                row = (row - 1 + n) % n;
                // don't change col
            }
            magic[row][col] = i;
        }

        // print results
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (magic[i][j] < 10)  System.out.print(" ");  // for alignment
                if (magic[i][j] < 100) System.out.print(" ");  // for alignment
                System.out.print(magic[i][j] + " ");
            }
            System.out.println();
        }

    }
}

   
}

