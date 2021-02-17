package Day1;

import java.util.Arrays;

public class RadixSortAlgorithm {
	
	static int getMax(int [] arr,int n)
	{
		int mx=arr[0];
		for(int i=1;i<n;i++)
		{
			if(arr[i]>mx)
				mx=arr[i];
		}
		return mx;
	}
	
	static void radixSort(int []arr,int n)
	{
		int m=getMax(arr,n);
		
		for(int exp=1;m/exp>0;exp*=10)
			countSort(arr,n,exp);
	}

    static void countSort(int[] arr, int n, int exp) {
		int output[]=new int[n];
		int  count[]=new int[10];
		Arrays.fill(count,0);
		
		for(int i=0;i<n;i++)
			count[(arr[i]/exp)%10]++;
		
		for(int i=1;i<n;i++)
			count[i]+=count[i-1];
		
		for(int i=n-1;i>=0;i--)
		{
			output[count[(arr[i]/exp)%10]-1]=arr[i];
			count[(arr[i]/exp)%10]--;
		}
		
		for(int i=0;i<n;i++)
			arr[i]=output[i];
		
		
	}

	public static void main(String[] args) {
		int []arr=new int[] {21,322,44,53,1,03,24,424,2244};
		System.out.println("Before Sorting ");
		printArray(arr);
		System.out.println("After Sorting ");
		int n=arr.length;
		radixSort(arr,n);
		printArray(arr);
		

	}
	
	static void printArray(int []arr)
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
			System.out.print(" "+arr[i]);
		
		System.out.println();
	}

}
