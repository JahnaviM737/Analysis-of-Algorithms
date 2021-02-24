
class mergeSort{

	void merge(int arr[], int low, int mid, int high){

		//We have got an array; Now we need to obtain two subarrays- left and right
		//in order to be able to iterate separately and store result in final sorted array

		int n1 = mid - low + 1;
		int n2 = high - (mid +1) +1;

		int left[] = new int[n1];
		int right[] = new int[n2];

		//Copying elements into respective subarrays
		for(int i=0;i<n1;i++)
		{
			left[i] = arr[low+i];
		}
		for(int j=0;j<n2;j++)
		{
			right[j] = arr[mid+1+j];
		}

		System.out.print("\nLeft: ");
		printArray(left);
		System.out.print("\tRight: ");
		printArray(right);

		//Merging the two subarrays
		int i=0, j=0, k=low; //do not put k=0 or k=1!!!!!!

		while(i<n1 && j<n2)
		{
			if(left[i]<=right[j])
			{
				arr[k] = left[i];
				i++;
				k++;
			}
			else
			{
				arr[k] = right[j];
				j++;
				k++;
			}
		}

		/* Copy remaining elements of left[] if any */
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of right[] if any */
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
	}

	void sort(int arr[], int low, int high){

		if(low<high)
		{
			int mid = (low + high)/2;

			//Dividing problem into subparts and calling sort on these sub parts
			sort(arr,low,mid);
			sort(arr,mid+1,high);

			//Combining the solutions of subparts
			merge(arr,low,mid,high);
			System.out.print("\nMerge step: ");
			printArray(arr);
		}
	}

	static void printArray(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i] + "  ");
		}

		//System.out.println();
	}

	public static void main(String args[]){

		mergeSort obj = new mergeSort();

		int arr[] = {5,7,2,3,9,8,1,4,0,6};

		System.out.print("Unsorted array:  ");
		printArray(arr);
		System.out.println();

		int n = arr.length;
		//low=0,high=n-1
		obj.sort(arr,0,n-1);

		System.out.print("\n\nSorted array:  ");
		printArray(arr);

	}
}