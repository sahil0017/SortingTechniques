package Day1;

public class optimisedBubbleSort {      // BEST CASE O(n)

	public static void main(String[] args) {
		int arr[] = {
			21,3,4,78,32,90,45
		};
		
		buubleSort(arr);
		System.out.println("After sorting ");
		printArray(arr);

	}
	
	static void buubleSort(int arr[])
	{
		int n=arr.length;
		boolean flag;
		for(int i=0;i<n-1;i++)
		{
			flag=false;
			for(int j=0;j<n-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
					flag=true;
				}
				
			}
			
			if(flag==false)
				break;
		}
	}
	static void printArray(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}

}
