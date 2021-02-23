//Implementing insertion sort

class Sorting{

	void InsertionSort(int arr[])
	{
		int n=arr.length;

		for(int i=1;i<n;i++)
		{
			int key=arr[i];
			int j=i-1;

			//Move elements that are greater than the key element to make space for key
			while(j>=0 && arr[j]>key)
			{
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1]=key;
			System.out.print("\nStep "+i+" : ");
			printArray(arr);
		}
	}

	void SelectionSort(int arr[])
	{
		int n=arr.length;
		int min_index,temp;;

		for(int i=0;i<n-1;i++)
		{
			min_index = i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<arr[min_index])
				{
					min_index = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;

			System.out.print("\nStep "+i+" : ");
			printArray(arr);
		}
	}

	void printArray(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i] + "  ");
		}

		System.out.println();
	}

	public static void main(String args[])
	{

		int arr1[] = {2,7,9,5,3,8,4,1,6,0};
		int arr2[] = {9,3,7,5,0,1,4,2,8,6};

		Sorting obj = new Sorting();

		System.out.println("-------------USING SELECTION SORT--------------");
		System.out.print("\nInitial Array: ");
		obj.printArray(arr1);
		obj.SelectionSort(arr1);
		System.out.print("\nFinal Array: ");
		obj.printArray(arr1);

		System.out.println("\n-------------USING INSERTION SORT--------------");
		System.out.print("\nInitial Array: ");
		obj.printArray(arr2);
		obj.InsertionSort(arr2);
		System.out.print("\nFinal Array: ");
		obj.printArray(arr2);
	}
}

