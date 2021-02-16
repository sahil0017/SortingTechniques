package Day1;

public class SelectionSortAlgorithm {         //Best case O(n2)

	public static void main(String[] args) {
		int arr[]= {21,3,4,54,23,87,99,1,5};
		sort(arr);
		System.out.println("After sorting ");
		printArray(arr);
	}
	
	static void sort(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n-1;i++)
		{
			int min_index=i;
			boolean flag=false;
			for(int j=i+1;j<n;j++)
			{
				if(arr[min_index]>arr[j])
					min_index=j;
				flag=true;
			}
			int temp=arr[min_index];
			arr[min_index]=arr[i];
			arr[i]=temp;
			if(flag==false)
				break;
		}
	}
	
	static void printArray(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
			System.out.print(" "+arr[i]);
		System.out.println();
	}

}
