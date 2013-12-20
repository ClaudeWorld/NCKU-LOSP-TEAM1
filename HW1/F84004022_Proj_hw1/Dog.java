/*	Dog.java 
 *  implements of Pet interface
*/

package homework1;

public class Dog implements Pet{
	
	@Override
	public void sayHello(){
		System.out.print("Wow!\n");	
	}
	@Override
	public String getSpecies() {
		return "Dog";
	}
}
