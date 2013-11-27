/*    File Name : StringTestFunction.java  
 * Project Name : Unit Test
 * 	Environment : Eclipse
 * Unit Testing : JUnit
 *       Author : ´¿«a³Õ  (brandboat) 
 *   Student ID : F74002141
 *  Description : This is a test file for StringTestFunction.java .
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class test {
	StringTest s1, s2;
	String s = "";
	
	// test if FUNCTION size() return the right length of a string
	@Test
	public void testSize() {
		s = " 123 ";
		s1 = new StringTest(s);
		assertEquals("s1 size must be 5", 5, s1.size());
		s = "";
		s1 = new StringTest(s);
		assertEquals("s1 size must be 0", 0, s1.size());
		s = "\0";
		s1 = new StringTest(s);
		assertEquals("s1 size must be 0", 1, s1.size());
	}
	
	// test if FINCTION isEmpty() works correctly 
	@Test
	public void testIsEmpty(){
		s = "123";
		s1 = new StringTest(s);
		assertFalse("s1 isn't empty", s1.isEmpty());
	} 

	// test if FINCTION isAllEng() works correctly
	@Test
	public void testIsAllEng(){
		s = "F74002141";
		s1 = new StringTest(s);
		assertFalse("s1 isn't all in English", s1.isAllEng());
		
		s = "apple";
		s1 = new StringTest(s);
		assertTrue("s1 is all in english.", s1.isAllEng());
	}
	
	// test if FUNCTION getCountOfVowel() works correctly
	@Test
	public void testGetCountOfVowel(){
		s = "apple";
		s1 = new StringTest(s);
		assertEquals("s1 has 2 vowels", 2, s1.getCountOfVowel());
		
		s = "00000";
		s1 = new StringTest(s);
		assertEquals("s1 has 0 vowels", 0, s1.getCountOfVowel());
	}
	
	// test if the FUNCTION reverse() works correctly
	@Test
	public void testReverse(){
		s = "apple";
		s1 = new StringTest(s);
		assertEquals("the reverse of the s1 is elppa", "elppa", s1.reverse());
		
		s = "abba";
		s1 = new StringTest(s);
		assertEquals("the reverse of the s1 is abba", "abba", s1.reverse());
		
		s = "";
		s1 = new StringTest(s);
		assertEquals("the reverse of the s1 is ", "", s1.reverse());
		
		s = "0";
		s1 = new StringTest(s);
		assertEquals("the reverse of the s1 is 0", "0", s1.reverse());
	}
	
	// test if FUNCTION showDistinctElements works correctly
	@Test
	public void testShowDistinctElements(){
		s = "apple";
		s1 = new StringTest(s);
		assertEquals("the distinct elements of the s1 is a p l e", "a p l e ", s1.showDistinctElements());
		
		s = "1111";
		s1 = new StringTest(s);
		assertEquals("the distinct elements of the s1 is 1", "1 ", s1.showDistinctElements());
		
		s = "";
		s1 = new StringTest(s);
		assertEquals("the distinct elements of the s1 is ", "", s1.showDistinctElements());
	}
	
	// test if FUNCTION equals(StringTest s) works correctly
	@Test
	public void testEquals(){
		
		s = "apple";
		s1 = new StringTest(s);
		s = "apple";
		s2 = new StringTest(s);
		assertTrue("s1 and s2 is equal.", s1.equals(s2));
		
		s = "apple";
		s1 = new StringTest(s);
		s = "apll";
		s2 = new StringTest(s);
		assertFalse("s1 and s2 is not equal.", s1.equals(s2));
	}
	
	// test if FUNCTION subset(StringTest s) works correctly
	@Test
	public void testSubset(){
		
		s = "an apple";
		s1 = new StringTest(s);
		s = "app";
		s2 = new StringTest(s);
		assertFalse("s1 is a subset of s2", s1.subSet(s2));
		
		s = "app";
		s1 = new StringTest(s);
		s = "an apple";
		s2 = new StringTest(s);
		assertTrue("s1 is a subset of s2", s1.subSet(s2));
		
	}
}








