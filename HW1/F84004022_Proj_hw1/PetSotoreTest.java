/* Unit Test File
 * ����覡: �b eclipse���A�N�Ҧ��ɮץ[�J�b�@��project����ARun �o�ӵ{���N�i�H�F 
 * */
package homework1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PetSotoreTest {
	private Pet pet;
	private Pet pet2;
	private Pet pet3;
	
	@Before
	public void setUp(){
		pet = new Dog();
		pet2 = new Cat();
		pet3 = new Bird();
	}
	
	@After
	public void tearDown(){
		pet = null;
		pet2 = null;
		pet3 = null;
	}
	
	@Test
	public void test() {
		String expected = "Dog";
		String result = pet.getSpecies();
		assertEquals(expected, result);
		
		String expected2 = "Cat";
		String result2 = pet2.getSpecies();
		assertEquals(expected2, result2);
		
		String expected3 = "Bird";
		String result3 = pet3.getSpecies();
		assertEquals(expected3, result3);
	}

}
