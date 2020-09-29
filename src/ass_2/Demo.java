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

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the name of the file:");
		String name = kb.next();
		Stream<String> info;
		
		try(BufferedReader br = new BufferedReader(new FileReader(name))){
			info = br.lines().collect(Collectors.toList()).stream();
			System.out.println("This file contains: ");
			
			List<Employee> objects = new ArrayList<Employee>();
			info.forEach((n) -> objects.add((Employee)Employee.parse(n)));
			
			for(int i = 0; i< objects.size(); i++) {
				System.out.println(objects.get(i));
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
			Collections.sort(objects, sortId);
			System.out.println("\n\nOrder to id:");
			System.out.println(objects.toString());
			
//			sorted to first name
			Comparator<Employee> sortFirst = new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.getFirstName().compareTo(e2.getFirstName());
				}
			};
			Collections.sort(objects, sortFirst);
			System.out.println("\n\nOrder to First name:");
			System.out.println(objects.toString());
			
			
			
			
//			sorted to last name
			Comparator<Employee> sortLast = new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.getLastName().compareTo(e2.getLastName());
				}
			};
			Collections.sort(objects, sortLast);
			System.out.println("\n\nOrder to Last name:");
			System.out.println(objects.toString());
			
			
//			sorted to salary
			Comparator<Employee> sortSalary = new Comparator<Employee>() {
				@Override
				public int compare(Employee e1, Employee e2) {
					return e1.getSalary().compareTo(e2.getSalary());
				}
			};
			Collections.sort(objects, sortSalary);
			System.out.println("\n\nOrder to salary:");
			for(int i = 0; i< objects.size(); i++) {
				System.out.println(objects.get(i));
			}
			
			
//			 Use at least one method-reference in your code. ********************
		}
		
//		I dont know why it not working ***********************
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
