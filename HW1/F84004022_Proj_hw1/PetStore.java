/* Large and Open Source Projects
 * Project HW1
 * 組別: Team 1
 * 學號/姓名: F84004022 / 黃啟軒
 * description:  Use "Factory Design Pattern" to
 *   write a pet store program.
 *   
 * */

package homework1;


//Main class store -> factory design pattern 
public class PetStore {
	
	// Let user to call this method to provide a pet 
	public static Pet ProvidePets(String species){	
		
		//pet variable is a interface for Dog Cat Bird to implements
		Pet pet;
		
		if(species == "Dog"){ 
			pet = new Dog();  	// get a Dog
			return pet;
		}
		else if(species == "Cat"){
			pet = new Cat(); 	// get a Cat
			return pet;
		}
		else if(species == "Bird"){
			pet = new Bird();	// get a Bird
			return pet;
		}
		else{ 
			return null;		// if error
		}
	}

	public static void main(String[] args) {
		

		System.out.printf("Welcomet to PetStore\n");
		
		System.out.printf("Jack buy a Bird.\n");
		
		//only one line, user can get object they want
		Pet pet = PetStore.ProvidePets("Bird");
		
		// after buy
		System.out.printf("%s:", pet.getSpecies() );    // print what is bought
		pet.sayHello();
		
		System.out.printf("James buy a Dog.\n");
		
		//only one line, user can get object they want
		Pet pet2 = PetStore.ProvidePets("Dog");
		
		// after buy
		System.out.printf("%s:", pet2.getSpecies() );  // print what is bought
		pet2.sayHello();

		System.out.printf("Mike buy a Cat.\n");
		
		//only one line, user can get object they want
		Pet pet3 = PetStore.ProvidePets("Cat");
		
		// after buy
		System.out.printf("%s:", pet3.getSpecies() );  // print what is bought
		pet3.sayHello();
	}

}
