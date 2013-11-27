
/**
 * The <code>SortFactory</code> class is a factory to get the merge sort & insertion sort.
 * Here are some more examples of how SortFactory can be used:
 * <p><blockquote><pre>
 *     MergeSort mergeSorting = SortFactory.getMerge(oriMerge, start, end);
 *     InsertionSort insertSorting = SortFactory.getInsertSort(oriMerge, end);
 * </pre></blockquote>
 * <p>
 * @author PoAn Yang
 * @since JDK7.0
 */
public class SortFactory
{
	/**
     * Returns a MergeSort object which is sort.
     * @return  a MergeSort object.
     */
	public static MergeSort getMerge(int[] data)
	{
		MergeSort merge = new MergeSort();
		merge.setMerge(data);
		return merge;
	}
	
	/**
     * Returns a InsertionSort object which is sort.
     * @return  a InsertionSort object.
     */
	public static InsertionSort getInsetSort(int[] data)
	{
		InsertionSort insert = new InsertionSort();
		insert.setInsert(data);
		return insert;
	}
}