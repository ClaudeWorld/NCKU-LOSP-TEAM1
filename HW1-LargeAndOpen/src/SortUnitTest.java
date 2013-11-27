import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This test file test MergeSort & InsertionSort & SortFactory class.
 * You can use test1_1 & test1_2 test MergeSort class.
 * Change original integer array oriMerge[]
 * and give answer in ansMerge[]. Then you can test MergeSort class.
 * You also can use test2_1 & 2_2 test InsertionSort class.
 * Change original integer array oriInsert[]
 * and give answer in ansMerge[]. Then you can test InsertionSort class.
 * @author YangPoAn
 * @since JDK7.0
 */

public class SortUnitTest
{
	@Test
	public void test1_1()
	{
		int oriMerge[] = {5,4,3,2,1};
		int finMerge[] = new int[oriMerge.length];
		int ansMerge[] = {1,2,3,4,5};

		MergeSort mergeSorting = SortFactory.getMerge(oriMerge);
		mergeSorting.setMerge(oriMerge);
		finMerge = mergeSorting.getResult();
		
		assertArrayEquals(ansMerge,finMerge);
	}
	
	@Test
	public void test1_2()
	{
		int oriMerge[] = {2,2,1,1};
		int finMerge[] = new int[oriMerge.length];
		int ansMerge[] = {1,1,2,2};

		MergeSort mergeSorting = SortFactory.getMerge(oriMerge);
		mergeSorting.setMerge(oriMerge);
		finMerge = mergeSorting.getResult();
		
		assertArrayEquals(ansMerge,finMerge);
	}
	
	@Test
	public void test2_1()
	{
		int oriInsert[] = {5,4,3,2,1};
		int finInsert[] = new int[oriInsert.length];
		int ansInsert[] = {1,2,3,4,5};
		
		InsertionSort insertSorting = SortFactory.getInsetSort(oriInsert);
		insertSorting.setInsert(oriInsert);
		finInsert = insertSorting.getInsert();
		
		assertArrayEquals(ansInsert,finInsert);
	}

	@Test
	public void test2_2()
	{
		int oriInsert[] = {2,2,1,1};
		int finInsert[] = new int[oriInsert.length];
		int ansInsert[] = {1,1,2,2};
		
		InsertionSort insertSorting = SortFactory.getInsetSort(oriInsert);
		insertSorting.setInsert(oriInsert);
		finInsert = insertSorting.getInsert();
		
		assertArrayEquals(ansInsert,finInsert);
	}
}
