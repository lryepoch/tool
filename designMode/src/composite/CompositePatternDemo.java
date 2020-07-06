package composite;

import java.util.Iterator;

public class CompositePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee ceo=new Employee("John", "CEO", 30000);
		Employee headSales=new Employee("Robert", "Head Sales", 20000);
		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);
		
		Employee clerk1 = new Employee("Laura", "Marketing", 20000);
		Employee clerk2 = new Employee("Bob","Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
	    Employee salesExecutive2 = new Employee("Rob","Sales", 10000);
	      
	    ceo.add(headSales);
	    ceo.add(headMarketing);
	    
	    headMarketing.add(salesExecutive1);
	    headMarketing.add(salesExecutive2);
	    
	    headSales.add(clerk1);
	    headSales.add(clerk2);
	    
	    System.out.println(ceo);
	    
	    for (Employee headEmployee : ceo.getSubordinates()) {
			System.out.println(headEmployee);
			for(Employee employee :headEmployee.getSubordinates()){
				System.out.println(employee);
			}
		}
	    
	}

}
