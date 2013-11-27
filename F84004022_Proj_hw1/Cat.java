/* 	Cat.java
 *  implements of Pet interface
 * */
package homework1;

public class Cat implements Pet{
	
	@Override
	public void sayHello(){
		System.out.print("Meow~\n");
	}

	@Override
	public String getSpecies() {	
		return "Cat";
	}
}
