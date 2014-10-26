package algorithm.sort;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestResult;
import junit.framework.TestSuite;

import org.junit.Before;
import  org.junit.Test;
import org.junit.Assert;


public class SortClassTest {
	List<Integer> unsorted;
	List<Integer> sorted;
	@Before
	public void loadList(){
		Integer uns[] = {8,3,5,6,4,1,2,7,9};
		Integer s[] ={1,2,3,4,5,6,7,8,9};
		unsorted = Arrays.asList(uns);
		sorted = Arrays.asList(s);
		System.out.println("success**********");
	}
	@Test
	public void testSort(){
		List<Integer> op =SortArray.mergeSort(unsorted);
		Assert.assertTrue(op.equals(sorted));
	}
}


