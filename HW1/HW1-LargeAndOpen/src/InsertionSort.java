
/**
 * The <code>InsertionSort</code> class is implement the insertion sort.
 * Here are some more examples of how InsertionSort can be used:
 * <p><blockquote><pre>
 *     InsertionSort insertSorting = SortFactory.getInsertSort(oriMerge, end);
 *     InsertionSort insert = new InsertionSort();
 * </pre></blockquote>
 * <p>
 * @author PoAn Yang
 * @since JDK7.0
 */

public class InsertionSort
{
	/** The value is used for sort result storage. */
	private int[] finalSort;
	
	/**
     * Initializes a newly created {@code InsertionSort} object so that it represents
     * an integer array without sort.  Note that use of this constructor is
     * unnecessary since MergeSort are immutable.
     */
	public void setInsert(int[] data)
	{
		int end = data.length - 1;
		
		finalSort = new int[end + 1];		
		
		for(int i=0; i < end + 1; i++)
		{
			finalSort[i] = data[i];
		}			
		
		insertionSort(finalSort,end);			
	}
	
	/* Common private utility method used to insert a smaller number before a large number
     * and requested data values used by the InsertionSort(data[],..)
     * constructors.
     */	
	private void insertionSort(int[] data,int end)
	{
		for(int i=1; i < end + 1; i++)
		{
			int key = data[i];		
			int beforeIndex = i - 1;
			while(beforeIndex >= 0 && data[beforeIndex] > key)
			{
				data[beforeIndex + 1] = data[beforeIndex];
				beforeIndex--;
			}
			data[beforeIndex + 1] = key;			
		}				
	}
		
	/**
     * Returns a integer array which is sorted.
     * @return  a integer array which is sorted.
     */
	public int[] getInsert()
	{
		return finalSort;
	}
}
