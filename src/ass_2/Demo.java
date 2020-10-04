package ass_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the name of the file:");
		String name = kb.next();
		Stream<String> info;
		kb.close();
		try(BufferedReader br = new BufferedReader(new FileReader(name))){
			info = br.lines().collect(Collectors.toList()).stream();
			System.out.println("This file contains: ");
			
			List<Employee> employeesObj = new ArrayList<Employee>();
			info.forEach((n) -> employeesObj.add((Employee)Employee.parse(n)));
			
			
			
//			(Jana) change it to lambda expression 
			Comparator<Employee> sortId = ( e1,  e2) ->
			{
					if(e1.getId() < e2.getId())
						return -1;
					if(e1.getId() > e2.getId())
						return 1;
					return 0;	
			};
			Collections.sort(employeesObj, sortId);
			
			System.out.println("\n\nOrder to id:");
			
			// used method reference here
			employeesObj.forEach(System.out::println);
			
				
			
			
//			sorted to first name
//			(Jana) change it to lambda expression 
			Comparator<Employee> sortFirst = ( e1,  e2) -> {return e1.getFirstName().compareTo(e2.getFirstName());};
			Collections.sort(employeesObj, sortFirst);
			System.out.println("\n\nOrder to First name:");
			employeesObj.forEach(x -> System.out.println(x));
			
			
			
//			sorted to last name
//			(Jana) change it to lambda expression 
			Comparator<Employee> sortLast = ( e1,  e2) -> {return e1.getLastName().compareTo(e2.getLastName());};
			Collections.sort(employeesObj, sortLast);
			System.out.println("\n\nOrder to Last name:");
			employeesObj.forEach(x -> System.out.println(x));
			
			
			
			System.out.println("\n\n");
			
//			grouping by the salary range and finding the number of the group 
			Map<BigDecimal, Long> bySalary = employeesObj.stream().collect(Collectors.groupingBy(e -> {
				BigDecimal salary = ((Employee)e).getSalary();
				BigDecimal small = new BigDecimal(25000.00);
				BigDecimal medium = new BigDecimal(40000.00);
				BigDecimal big = new BigDecimal(70000.00);
				BigDecimal bigger = new BigDecimal(80000.00);
//				finding in which range the salary is in 
				if(salary.compareTo(small) == -1) {
					return small;
				}
				if(salary.compareTo(medium) == -1 && salary.compareTo(small) == 1) {
					return medium;
				}
				if(salary.compareTo(big) == -1 && salary.compareTo(medium) == 1) {
					return big;
				}
				return bigger;
				} 
			, Collectors.counting()));
			
			
//			displaying the number of the groups with all the info
			bySalary.forEach((k,v) -> {
				if(k.compareTo(new BigDecimal(25000.00)) == 0) {
					System.out.println(v + " employees have a salary range of < 25000.00");
				}if(k.compareTo(new BigDecimal(40000.00)) == 0) {
					System.out.println(v + " employees have a salary range of 25,000.00 - 40,000.00");
				}if(k.compareTo(new BigDecimal(70000.00)) == 0) {
					System.out.println(v + " employees have a salary range of 40,000.00 - 70,000.00");
				}if(k.compareTo(new BigDecimal(80000.00)) == 0) {
					System.out.println(v + " employees have a salary range of 70,000.00 >");
				}
			});
			
			System.out.println("\n\n");
			
//			grouping by the salary and finding the average of the group 
			Map<BigDecimal, Double> bySalary2 = employeesObj.stream().collect(Collectors.groupingBy(e -> {
				BigDecimal salary = ((Employee)e).getSalary();
				BigDecimal small = new BigDecimal(25000.00);
				BigDecimal medium = new BigDecimal(40000.00);
				BigDecimal big = new BigDecimal(70000.00);
				BigDecimal bigger = new BigDecimal(80000.00);
//				finding in which range the salary is in 
				if(salary.compareTo(small) == -1) {
					return small;
				}
				if(salary.compareTo(medium) == -1 && salary.compareTo(small) == 1) {
					return medium;
				}
				if(salary.compareTo(big) == -1 && salary.compareTo(medium) == 1) {
					return big;
				}
				return bigger;
				} 
			, Collectors.averagingDouble(e -> {
				BigDecimal salary = ((Employee)e).getSalary();
				String s = salary +"";
				return Double.parseDouble(s);
				})));
			
//			displaying the average of the salary with all the info
			bySalary2.forEach((k,v) -> {
				if(k.compareTo(new BigDecimal(25000.00)) == 0) {
					System.out.println(v + "  is the average salary of the employees that have a salary range of < 25000.00");
				}if(k.compareTo(new BigDecimal(40000.00)) == 0) {
					System.out.println(v + "  is the average salary of the employees that have a salary range of 25,000.00 - 40,000.00");
				}if(k.compareTo(new BigDecimal(70000.00)) == 0) {
					System.out.println(v + "  is the average salary of the employees that have a salary range of 40,000.00 - 70,000.00");
				}if(k.compareTo(new BigDecimal(80000.00)) == 0) {
					System.out.println(v + "  is the average salary of the employees that have a salary range of 70,000.00 >");
				}
			});
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("The file is not found try again later");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
