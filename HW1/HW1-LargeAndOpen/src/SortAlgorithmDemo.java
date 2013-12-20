
/**
 * The <code>SortAlgorithmDemo</code> class is demo the merge sort 
 * and insert sort.	
 * @author PoAn Yang
 * @since JDK7.0
 */

public class SortAlgorithmDemo
{	
	public static void main(String[] args)
	{
		int oriMerge[] = {5,4,3,2,1};
		int oriInsert[] = {5,4,3,2,1};		
		int finMerge[] = new int[oriMerge.length];
		int finInsert[] = new int[oriInsert.length];
		
		MergeSort mergeSorting = SortFactory.getMerge(oriMerge);
		mergeSorting.setMerge(oriMerge);
		finMerge = mergeSorting.getResult();
		
		InsertionSort insertSorting = SortFactory.getInsetSort(oriInsert);
		insertSorting.setInsert(oriInsert);
		finInsert = insertSorting.getInsert();
		
		for(int i= 0; i < oriMerge.length; i++)
		{
			System.out.printf("%d ",finMerge[i]);
		}
		
		System.out.println("");		
				
		for(int i=0; i < finInsert.length; i++)
		{
			System.out.printf("%d ",finInsert[i]);
		}
	}

}
