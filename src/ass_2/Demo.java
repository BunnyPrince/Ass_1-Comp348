package ass_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
	
	public enum Range{
		SMALL (25000.00),
	    MEDIUM   (40000.00),
	    BIG   (70000.00);

	    private final double number;
	    Range(double d) {
	        this.number = d;
	    }
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the name of the file:");
		// (noah) !!!NOTE!!! Add try catch for file not found error????
		// !NOTE! Uncomment the following line to allow input (currently commented out for test)
//		String name = kb.next();
		String name = "EmployesInformation.txt"; // TO DELETE
		Stream<String> info;
		
		try(BufferedReader br = new BufferedReader(new FileReader(name))){
			info = br.lines().collect(Collectors.toList()).stream();
			System.out.println("This file contains: ");
			
			List<Employee> employeesObj = new ArrayList<Employee>();
			info.forEach((n) -> employeesObj.add((Employee)Employee.parse(n)));
			
			for(int i = 0; i< employeesObj.size(); i++) {
				System.out.println(employeesObj.get(i));
			}
			
			
//			sorted to id
			Comparator<Employee> sortId = new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					if(e1.getId() < e2.getId())
						return -1;
					if(e1.getId() > e2.getId())
						return 1;
					return 0;
				}
			};
			Collections.sort(employeesObj, sortId);
			System.out.println("\n\nOrder to id:");
			// (noah) modifications on sort by id: vertical display instead of horizontal list
			// System.out.println(objects.toString());
			
			
			
			// used method reference here
			employeesObj.forEach(System.out::println);
			
				
			
			
//			sorted to first name
			Comparator<Employee> sortFirst = new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.getFirstName().compareTo(e2.getFirstName());
				}
			};
			Collections.sort(employeesObj, sortFirst);
			System.out.println("\n\nOrder to First name:");
			// (noah) idem to sort by id modification
			// System.out.println(employeesObj.toString());
			employeesObj.forEach(x -> System.out.println(x));
			
			
			// (noah) i tried something here but i dont know how the Array.sort work...
			// ALSO i think we can use comparator (just not comparable) since it's a functional interface
			// Arrays.sort(employeesObj, Comparator.comparing(Employee::getId));
			
			
			
			
//			sorted to last name
			Comparator<Employee> sortLast = new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.getLastName().compareTo(e2.getLastName());
				}
			};
			Collections.sort(employeesObj, sortLast);
			System.out.println("\n\nOrder to Last name:");
			// (noah) idem modication
			// System.out.println(employeesObj.toString());
			employeesObj.forEach(x -> System.out.println(x));
			
			
//			sorted to salary
			Comparator<Employee> sortSalary = new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.getSalary().compareTo(e2.getSalary());
				}
			};
			Collections.sort(employeesObj, sortSalary);
			System.out.println("\n\nOrder to salary:");
			employeesObj.forEach(x -> System.out.println(x));
			
			// (noah)!!!! TO DELETE : Following for-loop since not allowed per asm instruction
//			for(int i = 0; i< employeesObj.size(); i++) {
//				System.out.println(employeesObj.get(i));
//			}
			
			
//			 Use at least one method-reference in your code. (noah) Done, see when sorted by id
		}
		
//		I dont know why it not working ***********************
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
