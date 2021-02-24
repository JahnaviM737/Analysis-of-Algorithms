
class quickSort{

	void sort(int arr[],int low, int high){
		if(low<high)
		{
			//The pivot element(last elem of array) needs to be placed correctly,
			//The partition function returns the correct position/index if the pivot, thus allowing
			//us to perform sorting on left and right subarrays.
			int pi = partition(arr,low,high);

			//pivot is now correctly placed at arr[pi]
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
	}

	int partition(int arr[], int low, int high){
		int i=low-1; //initialize i: this is going to decide where the pivot will be placed
		int pivot = arr[high],temp;

		for(int j=low;j<high;j++) //or j<=high-1
		{
			if(arr[j]<pivot)
			{
				i++; // so that elements smaller than pivot are placed before pi, starting from low
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//Correct placement of pivot i.e. after the elems smaller than pivot
		temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		System.out.print("Pivot: "+ pivot+ "  Array after pivot placement: ");
		printArray(arr);
		return (i+1); //i.e. index of the pivot
	}

	static void printArray(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i] + "  ");
		}

		System.out.println();
	}

	public static void main(String args[]){

		quickSort obj = new quickSort();

		int arr[] = {10,80,30,90,40,50,70,20,60};

		System.out.print("Unsorted array:  ");
		printArray(arr);
		System.out.println("\n");

		int n = arr.length;
		//low=0,high=n-1
		obj.sort(arr,0,n-1);

		System.out.print("\n\nSorted array:  ");
		printArray(arr);
	}
}