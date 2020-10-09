package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		List<Employee> list = new ArrayList<>();
		// PART 1 - READING DATA
		
		System.out.println("How many employees be registered ?");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			
			System.out.println();
			System.out.println("Employee #" + i +":");
		
			System.out.print("Employee Id :");
			int id = sc.nextInt();
			while(hasId (list, id)) {
				System.out.println("Id alredy taken. Try again");
				id = sc.nextInt();
			}
	
			
			
			System.out.println("Employee Name :");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Employee salary :");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name,salary));
		}
		
		// PART 2 - UPDATING SALARY OF GIVEN ENPLOYEE
		
		System.out.println();
		System.out.println("Enter the Employee id that will have salary increase:");
		int id = sc.nextInt();
		Employee emp =  list.stream().filter(x -> x.getId()== id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist !");
		}
		else {
				System.out.print("Enter the percentage");
				double percentage = sc.nextDouble();
				emp.increaseSalary(percentage);
		}
		
		// PART 3 - LISTING EMPLOYEES :
		
		System.out.println();
		System.out.println("List of employees  :");
		for(Employee obj : list) {
			System.out.println(obj);
		}
		sc.close();
	}
		
				public static boolean hasId(List<Employee> list, int id) {
					Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
					return emp != null;
				}
			
	}


