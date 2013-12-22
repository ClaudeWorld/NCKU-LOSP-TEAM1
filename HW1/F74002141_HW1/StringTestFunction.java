/*
 *       File Name : StringTestFunction.java  
 *    Project Name : Unit Test
 * 	   Environment : Eclipse
 *    Unit Testing : JUnit
 *          Author : ´¿«a³Õ  (brandboat) 
 *      Student ID : F74002141
 *     Description : This is a program used to do some test on a single string or compare the differences between two strings.
 *	       		     To compare the two strings you need to pass 2 arguments (in Eclipse you need to go to Run -> Run Configurations -> 
 *				     arguments) before running the programming.
 * Design Patterns : Singleton Pattern
 *        FUNCTION :
 *                   public int size() --- return the length of the string.
 *                   public boolean isEmpty() --- test if the string is empty.
 *                   public boolean isAllEng() --- test if the string is all in English.
 *                   public int getCountOfVowel() -- get the number of vowels in one string.
 *                   public String reverse() --- return a string reversed
 *                   public String showDistinctElements() --- return a string includes the characters that are not repeated arise in a string.
 *                   public boolean equals(StringTest) --- test if two string are equal.
 *                   public boolean subSet(StringTest) --- test if one string is a subset if the other string.
 */

class StringTest
{
	public char[] elements;
	
	/*constructors for inputing nothing*/
	public StringTest()
	{
		elements = new char[0];
	}
	/* using the following code ---< elements = null >--- to initialize elements, then there will be an error : 
	 * Exception in thread "main" java.lang.NullPointerException */
	
	/*constructors for inputing something*/
	public StringTest(String input)
	{
		elements = new char[input.length()];
		for(int i = 0; i < input.length(); i++)
		{
			elements[i] = input.charAt(i);
		}
	}
	
	public int size()
	{
		return elements.length;
	}
	
	public boolean isEmpty()
	{
		if(elements.length == 0)
			return true;
		else 
			return false;
	}
	
	public boolean isAllEng()
	{
		String str = String.valueOf(elements);
		if(str.matches("[a-zA-Z]+")) //regular expression
		   return true;
		else
		   return false;
	}
	
	public int getCountOfVowel()
	{
		int numOfVowel = 0;
		String str;
		for(int i = 0; i < elements.length; i++)
		{
			str = String.valueOf(elements[i]);
			if(str.matches("[aeiouAEIOU]"))
			{
				numOfVowel++;
			}
		}
		return numOfVowel;
	}
	
	public String reverse()
	{
		String reverse = String.valueOf(elements);
		
		char[] tmpReverse = new char[elements.length];
		for(int i = 0; i < elements.length; i++)
		{
			tmpReverse[elements.length - 1 - i] = elements[i];
		}
		reverse = String.valueOf(tmpReverse);
		
		return reverse;
	}
	
	public String showDistinctElements()
	{
		int differ = 0;
		String s = "";
		for(int i = 0; i < elements.length; i++)
		{
			for(int j = i + 1; j < elements.length; j++)
			{
				if(elements[i] != elements[j])
					differ++;
			}
			if((differ + i + 1) == elements.length)
			{
				s += elements[i];
				s += ' ';
			}
			differ = 0;
			
		}
		return s;
	}

	public boolean equals(StringTest s)
	{
		int correspond = 0;
		
		if(elements.length == s.elements.length)
		{
			for(int i = 0; i < elements.length; i++)
			{
				if(elements[i] == s.elements[i])
					correspond++;
			}
		}
		else
			return false;
		
		if(correspond == elements.length)
			return true;
		else 
			return false;
	}
	
	public boolean subSet(StringTest s)
	{
		int correspond = 0;
		if(elements.length <= s.elements.length)
		{
			for(int i = 0; i < s.elements.length; i++)
			{
				if(elements[0] == s.elements[i])
				{
					for(int j = 0; j < elements.length; j++)
					{
						if((i + j) >= s.elements.length)
							break;
						if(elements[j] == s.elements[i + j])
							correspond++;
						else
						{
							correspond = 0;
							break;
						}
					}
				}
			}
			if(correspond == elements.length)
				return true;
			else
				return false;
		}
		else 
			return false;
	}

}

public class StringTestFunction
{
	public static void main(String[] args)
	{
		StringTest obj1, obj2;
		String s1 = "", s2 = "";
		
		//dealing with the situation that the args is null
		if(args != null)
		{	
			for(int i = 0; i < args.length;)
			{
				s1 = args[i];
				if(args.length > 1)	
					s2 = args[i + 1];
				break;
			}
		}
		
		obj1 = new StringTest(s1);
		obj2 = new StringTest(s2);
		
		System.out.println("the first input's length : " + obj1.size());
		System.out.println("the second input's length : " + obj2.size() + "\n");
		
		System.out.println("the first input is empty : " + obj1.isEmpty());
		System.out.println("the second input is empty : " + obj2.isEmpty() + "\n");
		
		System.out.println("the first input is all in english : " + obj1.isAllEng());
		System.out.println("the second input is all in english : " + obj2.isAllEng() + "\n");
		
		System.out.println("the first input's number of vowel : " + obj1.getCountOfVowel());
		System.out.println("the second input's number of vowel : " + obj2.getCountOfVowel() + "\n");
		
		System.out.println("the first input's reverse: " + obj1.reverse());
		System.out.println("the second input's reverse : " + obj2.reverse() + "\n");
		
		System.out.println("the first input's distinct elements are : " + obj1.showDistinctElements());
		System.out.println("the second input's distinct elements are : " + obj2.showDistinctElements() + "\n");
		
		System.out.println("two inputs are the same: " + obj1.equals(obj2) + "\n");
		
		System.out.println("the first input is a subset of the second input : " + obj1.subSet(obj2) + "\n");
	
	}
}





