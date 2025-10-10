package javaBasics.handson;
import java.util.*;
public class EmployeeManagement {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("enter emp id ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Enter emp Name: ");
            String name = input.nextLine();
            System.out.print("Enter emp department: ");
            String dept = input.nextLine();


            System.out.print("enter base salary: ");
            double basic = input.nextDouble();

            double HRA = 0.2 * basic;
            double DA = 0.1 * basic;

            double grossSalary = basic + HRA + DA;

            // Tax
            double tax;
            if (grossSalary >= 50000) {
                tax = 0.15 * grossSalary;
            } else if (grossSalary >= 30000) {
                tax = 0.1 * grossSalary;
            } else {
                tax = 0.05 * grossSalary;
            }

            double netSalary = grossSalary - tax;

            // Print salary slip
            System.out.println("Your Salary");
            System.out.println("Employee: " + name + " (ID: " + id + ")");
            System.out.println("Basic Salary: " + basic);
            System.out.println("HRA: " + HRA);
            System.out.println("DA: " + DA);
            System.out.printf("Gross Salary: %.2f \n" , grossSalary);
            System.out.println("Tax: " + tax);
            System.out.println("Net Salary: " + netSalary);

            input.close();
        }
    }


