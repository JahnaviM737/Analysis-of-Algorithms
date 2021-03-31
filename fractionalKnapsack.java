import java.util.Scanner;

/*
items : 0 name of item
        1 weight
        2 profit
        3 ratio of (profit/weight)
        4 considered for selection? (0=no, 1=yes)

selected : 0 name of item
           1 fraction selected
           2 weight added to totalWeight        
*/

class fractionalKnapsack{
	
	int numOfItems, capacity;
	Object[][] items;
	int totalWeight;
	float totalProfit;
	Object[][] selected;
	int k; //for selected array

	void inputItems()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of items: ");
		numOfItems = sc.nextInt();

		items = new Object[5][numOfItems];
		selected = new Object[3][numOfItems];

		for(int i=0;i<numOfItems;i++)
		{
			System.out.print("Name of Item " + (i+1) + " : ");
			items[0][i] = sc.next();
			System.out.print("Weight of Item " + (i+1) + " : ");
			items[1][i] = sc.nextInt();
			System.out.print("Profit associated with Item " + (i+1) + " : ");
			items[2][i] = sc.nextInt();
			System.out.println();
			//Calculating ratio of profit to weight
			items[3][i] = (float)((Integer)items[2][i])/(Integer)items[1][i];
			//Setting initial state of selection to 0
			items[4][i] = 0;
			//Setting initial selected fraction to 0
			selected[1][i] = 0;
			selected[2][i] = 0;
		}

		System.out.print("Enter maximum capacity of the knapsack: ");
		capacity = sc.nextInt();
	}

	void selectItems()
	{
		int selectedIndex=0;
		float maxRatio=0;
		totalWeight = 0;
		totalProfit = 0;
		k=0; //for selected array

		while(totalWeight != capacity)
		{
			//To find item with maxRatio
			maxRatio=0; //IMPPPPP
			for(int i=0;i<numOfItems;i++)
			{
				if((Integer)items[4][i] == 1)
				{
					continue;
				}
				else
				{
					if((Float)items[3][i]>maxRatio)
					{
						maxRatio = (Float)items[3][i];
						selectedIndex = i;
					}
				}
			}
			//Set status of selected item to 1
			items[4][selectedIndex] = 1;
			//check if weight of selected item is less than (capacity-totalweight)
			if((Integer)items[1][selectedIndex] <= (capacity-totalWeight))
			{
				totalWeight = totalWeight + (Integer)items[1][selectedIndex];
				totalProfit = totalProfit + (Integer)items[2][selectedIndex];
				selected[0][k] = (String)items[0][selectedIndex];
				selected[1][k] = 1;
				selected[2][k] = (Integer)items[1][selectedIndex];
				k++;
				//System.out.println((String)items[0][selectedIndex]+" "+totalWeight+" "+totalProfit);
			} 
			else
			{
				int available = capacity - totalWeight;
				float fraction = (float)available/(Integer)items[1][selectedIndex];
				selected[0][k] = (String)items[0][selectedIndex];
				selected[1][k] = fraction;
				selected[2][k] = available;
				k++;
				totalWeight = totalWeight + available;
				totalProfit = totalProfit + (Integer)items[2][selectedIndex]*fraction;
				//System.out.println((Integer)items[2][selectedIndex]*fraction);
			}
		}

	}

	void displayOutput()
	{
		System.out.println("Selected Items: ");
		for(int i=0;i<k;i++)
		{
			System.out.println("("+selected[1][i]+")" + " " + selected[0][i]);
		}
		System.out.println();
		System.out.println("Total Profit: " + totalProfit);
		System.out.println("Total Weight: " + totalWeight);
	}

	public static void main(String atrgs[])
	{
		fractionalKnapsack obj = new fractionalKnapsack();
		obj.inputItems();
		obj.selectItems();
		obj.displayOutput();
	}
}

