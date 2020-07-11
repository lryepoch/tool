package before.fatherANDson;

import before.fatherANDson.Animal;
import before.fatherANDson.Cat;

public class testClass {

	public static void main(String[] args) {
		Animal animal=new Animal();
		//animal.getHead();
		//animal.getEyes();
		Cat cat_1=(Cat)animal;
		
		//cat_1.getHead();
		cat_1.getEyes();
		
	}

}
