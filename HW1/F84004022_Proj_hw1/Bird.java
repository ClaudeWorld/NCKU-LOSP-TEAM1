/*	Bird.java
 * 	implements of Pet interface
 * */
package homework1;

public class Bird implements Pet{
	
	@Override
	public void sayHello(){
		System.out.print("Tweet...\n");
	}

	@Override
	public String getSpecies() {
		return "Bird";
	}
}
