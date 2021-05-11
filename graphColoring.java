import java.util.Scanner;

public class graphColoring{
	
	int[][] graph;
	int[] color;
	int m,numOfVertices;
	boolean sol;

	void inputAndInitialize()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter number of vertices:  ");
		numOfVertices = sc.nextInt();

		graph = new int[numOfVertices][numOfVertices];
		color = new int[numOfVertices];
		//IMPORTANT FOR CORRECT FUNCTIONING
		//Initializing all colors to 0
		for(int i=0;i<numOfVertices;i++)
			{color[i]=0;}

		System.out.print("\nEnter number of colors:  ");
		m = sc.nextInt();

		System.out.println("\nEnter 1 if edge exists and 0 if it doesn't.\n");
		for(int i=0;i<numOfVertices;i++)
		{
			for(int j=0;j<numOfVertices;j++)
			{
				System.out.printf("Edge between vertex %d and vertex %d : ",i+1,j+1);
				graph[i][j] = sc.nextInt();
			}
			System.out.println();
		}

		//Initializing with 0th vertex
		sol = colorGraph(0);

	}

	boolean colorGraph(int vertex)
	{
		//Case: All vertices have been assigned a color
		if(vertex==numOfVertices)
		{
			return true;
		}

		for(int c=1;c<=m;c++)
		{
			if(isSafe(vertex,c)==true)
			{
				color[vertex] = c;

				if(colorGraph(vertex + 1) == true)
				{
					return true;
				}
				else
				{
					color[vertex]=0;
					return false;
				}
			}
		}
		return false;
	}

	boolean isSafe(int vertex,int clr)
	{
		for(int i=0 ; i<numOfVertices ; i++)
		{
			//NOTE THE IF CONDITION. MIGHT MESS UP HERE
			//If an edge exists between current vertex and ith vertex
			//AND if color of ith vertex=color of current vertex
			if(graph[vertex][i] == 1 && color[i]==clr)
			{
				return false;
			}
		}
		return true;
	}

	void displayOutput()
	{
		if(sol==true)
		{
			System.out.println("SOLUTION EXISTS AND IS AS FOLLOWS: ");
			for(int i=0;i<numOfVertices;i++)
			{
				System.out.printf("\nVertex %d : Color %d",i+1,color[i]);
			}
		}
		else
		{
			System.out.println("SOLUTION DOES NOT EXIST.");	
		}
	}

	public static void main(String args[])
	{
		graphColoring g1 = new graphColoring();

		g1.inputAndInitialize();
		g1.displayOutput();
	}
}