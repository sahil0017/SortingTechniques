package Day1;

public class mergeSortAlgorithm {
	
	static void mergeSort(int []arr,int low,int high)
	
	{
		
		if(low<high)
		{
			int mid=low+(high-low)/2;
			
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			
			mergeSortAlgo(arr,low,mid,high);
		}
	}
	
	static void mergeSortAlgo(int []arr,int low,int mid,int high)
	
	{
		
		int n1=mid-low+1;
		int n2=high-mid;
		
		int left[]=new int[n1];
		int right[]=new int[n2];
		
		for(int i=0;i<n1;i++)
			left[i]=arr[low+i];
		
		for(int j=0;j<n2;j++)
			right[j]=arr[mid+1+j];
		
		int i=0;
		int j=0;
		
		int k=low;
		
		while(i<n1&&j<n2)
			
		{
			
			if(left[i]<=right[j])
			{
				
				arr[k]=left[i];
				i++;
				
			}
			else
				
			{
				
				arr[k]=right[j];
				j++;
				
			}
			k++;
			
		}
		
		while(i<n1)
			
		{
			
			arr[k]=left[i];
			i++;
			k++;
			
		}
		
		while(j<n2)
			
		{
			
			arr[k]=right[j];
			j++;
			k++;
			
		}
		
	}
	
	static void printArray(int []arr)
	
	{
		
		int n=arr.length;
		for(int i=0;i<n;i++)
			System.out.print(" "+arr[i]+" ");
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		int arr[]=new int[] {21,32,45,1,4,7,87,23,53};
		System.out.println("Before Sorting ");
		printArray(arr);
		mergeSort(arr,0,arr.length-1);
		System.out.println("After Sorting ");
		printArray(arr);

	}

}
