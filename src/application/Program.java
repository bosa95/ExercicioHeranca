package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsorcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();

		List<Employee> employeesList = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			System.out.printf("Employee #%d data: \n", i);
			System.out.print("Outsorced (y/n)? ");
			char yn = sc.next().toLowerCase().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String employeeName = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			if (yn == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();

				employeesList.add(new OutsorcedEmployee(employeeName, hours, valuePerHour, additionalCharge));

			} else {

				employeesList.add(new Employee(employeeName, hours, valuePerHour));

			}
		}

		System.out.println();
		System.out.println("PAYMENTS: ");
		for (Employee e : employeesList) {
			System.out.println(e.getName() + " - $ " + e.payment());
		}

		sc.close();

	}

}
