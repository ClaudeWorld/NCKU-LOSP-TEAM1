
/**
 * The <code>MergeSort</code> class is implement the merge sort.
 * Here are some more examples of how MergeSort can be used:
 * <p><blockquote><pre>
 *     MergeSort mergeSorting = SortFactory.getMerge(oriMerge, start, end);
 *     MergeSort merge = new MergeSort();
 * </pre></blockquote>
 * <p>
 * @author PoAn Yang
 * @since JDK7.0
 */

public class MergeSort
{		
	/** The value is used for sort result storage. */
	private int[] finalSort;
	
	
	/**
     * Initializes a newly created {@code MergeSort} object so that it represents
     * an integer array without sort.  Note that use of this constructor is
     * unnecessary since MergeSort are immutable.
     */
	public void setMerge(int[] data)
	{
		int start = 0;
		int end = data.length - 1;
		
		finalSort = new int[end - start + 1];
		
		for(int i=0; i < end + 1; i++)
		{
			finalSort[i] = data[i];
		}
		mergeSort(finalSort,start,end);
	}
	
	
	/* Common private utility method used to separate an array into two array
     * and requested data values used by the MergeSort(data[],..)
     * constructors.
     */
	private void mergeSort(int[] data, int start, int end)
	{
		int floorMid;
		
		if(start < end)
		{
			floorMid = (start + end)/2;
			mergeSort(data,start,floorMid);
			mergeSort(data,floorMid+1,end);
			merge(data,start,floorMid,end);
		}
		else
		{
			return;		
		}
	}
	
	/* Common private utility method used to sort array
     * and requested data values used by the MergeSort(data[],..)
     * constructors.
     */	
	private void merge(int[] data, int start , int floorMid, int end)
	{
		int totalOne = floorMid - start + 1;
		int totalTwo = end - floorMid;
		int leftIndex = 0;
		int rightIndex = 0; 
		int leftArray[] = new int[totalOne];
		int rightArray[] = new int[totalTwo];
		
		for(int i=0; i < totalOne; i++)
		{
			leftArray[i] = data[start + i];						
		}
		
		for(int i=0; i < totalTwo; i++)
		{
			rightArray[i] = data[floorMid + i + 1];
		}
		
		for(int i = start; i < end + 1; i++)
		{
			if(leftIndex == totalOne)
			{
				data[i] = rightArray[rightIndex];
				rightIndex++;
			}
			else if(rightIndex == totalTwo)
			{
				data[i] = leftArray[leftIndex];
				leftIndex++;
			}
			else if(leftArray[leftIndex] <= rightArray[rightIndex])
			{
				data[i] = leftArray[leftIndex];
				leftIndex++;
			}
			else
			{
				data[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}
	
	
	/**
     * Returns a integer array which is sorted.
     * @return  a integer array which is sorted.
     */
	public int[] getResult()
	{
		return finalSort;
	}
}
