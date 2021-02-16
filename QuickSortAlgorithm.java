package Day1;

public class QuickSortAlgorithm {

	public static void main(String[] args) {
		int []arr=new int[] {2,2,1,2,3,4,5,1,2,1,1,1,6};
		System.out.println("Before Sorting ");
		printArray(arr);
		System.out.println("After sorting ");
		quicksort(arr,0,arr.length-1);
		printArray(arr);

	}
	
	static void printArray(int []arr)
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
			System.out.print(" "+arr[i]);
		System.out.println();
	}
	
	static int partition(int []arr,int low,int high)
	{
		int pivot=arr[high];
		int i=low-1;
		
		for(int j=low;j<high;j++)
		{
			if(arr[j]<pivot)
			{
				i++;
				
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		
		return i+1;
	}
	
	static void quicksort(int []arr,int low,int high)
	{
		if(low<high)
		{
			int pi=partition(arr,low,high);
			
			quicksort(arr,low,pi-1);
			quicksort(arr,pi+1,high);
		}
	}

}
