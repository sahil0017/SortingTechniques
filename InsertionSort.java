package Day1;

public class InsertionSort {          //    O(n2)

	public static void main(String[] args) {
		int arr[]=new int[] {0,1,2,1,0,2,1,1,1};
		insertionSort(arr);
		System.out.println("Sorted Array ");
		printArray(arr);

	}
	
	static void insertionSort(int []arr)
	{
		int n=arr.length;
		for(int i=1;i<n;i++)
		{
			int key=arr[i];
			int j=i-1;
			
			while(j>=0&&arr[j]>key)
			{
				arr[j+1]=arr[j];
				j--;
			}
			
			arr[j+1]=key;
		}
	}
	
	static void printArray(int []arr)
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
			System.out.print(" "+arr[i]);
		System.out.println();
	}

}
