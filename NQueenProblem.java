import java.util.Scanner;

public class NQueenProblem{
	
	int[][] board;
	int n,sol=0;

	void inpAndInitialize()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of queens to be placed on the board:  ");
		n = sc.nextInt();

		board = new int[n][n];

		//Initialize all with 0
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j]=0;
			}
		}
	}

	boolean startNQueen(int currentCol)
	{
		int row;
		//If all queens are placed, we have a solution
		if(currentCol >=n)
		{
			sol = 1;
			return true;
		}
			//In this present col, we check for each row if it gives a solution
			for(row = 0 ; row < n ; row++)
			{
				if(isSafe(row,currentCol)==true)
					//THE STATEMENTS IN THIS BLOCK SHOULD BE IN PROPER ORDER!!
					//DO NOT PLACE THE FOLLOWING IF STMT OUTSIDE THE UPPER IF BLOCK
					{
						board[row][currentCol] = 1;

						//If we placed a queen and at this state, 
						//and if other queens can be placed too, then we have a solution
						if( startNQueen(currentCol+1) == true)
						{
							return true;
						}
						//If not, we cant place the queen in this row,col and set it back to 0(Backtrack)
						else
						{
							board[row][currentCol] = 0;
						}
					}
			}
			return false;
	}

	//We check only to the left of the column in consideration
	boolean isSafe(int row, int col)
	{
		int r,c;
		//Check for a queen in the entire row to the left
		for(c=0;c<col;c++)
		{
			if(board[row][c]==1)
				return false;
		}

		//Check for a queen in the left upper diagonal
		for(r=row,c=col ; r>=0 && c>=0 ; r--,c--)
		{
			if(board[r][c]==1)
				return false;
		}

		//Check for a queen in the left lower diagonal
		for(r=row,c=col ; r<n && c>=0 ; r++,c--)
		{
			if(board[r][c]==1)
				return false;
		}

		return true;
	}

	void displayOutput()
	{
		if(sol==1)
		{
			System.out.printf("\nSOLUTION OF THE N_QUEEN PROBLEM WITH %d QUEENS IS: \n",n);
			for(int r=0;r<n;r++)
				{for(int c=0;c<n;c++)
					{System.out.printf("  %d  ",board[r][c]);}
				System.out.println();}
		}
		else
		{
			System.out.println("Solution Does Not Exist.");
		}
	}

	public static void main(String args[])
	{
		NQueenProblem obj = new NQueenProblem();
		obj.inpAndInitialize();
		obj.startNQueen(0);
		obj.displayOutput();
	}
}