import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class JUnitTest {
	
	
	
	@Before
	public void setUp(){
		
	}
	@After
	public void tearDown(){
		
	}
	@Test
	public void test() throws IOException {
		int expected = 1;
		int result = 1;
		assertEquals(expected, result);
	}

}
