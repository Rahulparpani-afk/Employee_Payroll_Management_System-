import java.util.*;

// Main class for employee payroll management system
public class Employee_payroll_MGS {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        
        // Initialize the ArrayList to store all employees
        ArrayList<employee> employeeList = new ArrayList<>();
        
        while(true){
            System.out.println("\n--- Welcome to Employee Payroll Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = ip.nextInt();
                
            if(choice == 1){
                System.out.print("Enter Employee Type (1 for Full-Time, 2 for Part-Time): ");
                int empType = ip.nextInt();
                ip.nextLine(); 
                        
                if(empType == 1){
                    System.out.print("Enter Name: ");
                    String name = ip.nextLine();
                    System.out.print("Enter ID: ");
                    int id = ip.nextInt();
                    System.out.print("Enter Base Salary: ");
                    int baseSalary = ip.nextInt();
                    System.out.print("Enter Bonus: ");
                    int bonus = ip.nextInt();
                    System.out.print("Enter Allowance: ");
                    int allowance = ip.nextInt();
                    
                    employee emp = new FullTimeEmployee(name, id, baseSalary, bonus, allowance);
                    
                    //Storing emp in the list
                    employeeList.add(emp);
                    System.out.println(">>> Full-Time Employee added successfully!");
                    
                } else if(empType == 2){
                    System.out.print("Enter Name: ");
                    String name = ip.nextLine();
                    System.out.print("Enter ID: ");
                    int id = ip.nextInt();
                    System.out.print("Enter Base Salary: ");
                    int baseSalary = ip.nextInt();
                    System.out.print("Enter Hours Worked: ");
                    int hoursWorked = ip.nextInt();
                    System.out.print("Enter Hourly Paid: ");
                    int hourlyPaid = ip.nextInt();
                    
                    employee emp = new PartTimeEmployee(name, id, baseSalary, hoursWorked, hourlyPaid);
                    
                    //Storing emp in the list
                    employeeList.add(emp);
                    System.out.println(">>> Part-Time Employee added successfully!");
                } else {
                    System.out.println("Invalid Employee Type.");
                }
                
            } else if(choice == 2){
                // 3. Display employee details from the list
                if (employeeList.isEmpty()) {
                    System.out.println("No employees in the system yet. Please add one first.");
                } else {
                    System.out.println("\n--- Employee Payroll Details ---");
                    for (employee emp : employeeList) {
                        System.out.println("Employee Name: " + emp.name + ", Employee ID: " + emp.id);
                        
                        // Polymorphism dynamically calculates the correct salary
                        emp.calculateSalary(); 
                        System.out.println("--------------------------------");
                    }
                }
                
            } else if(choice == 3){
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        ip.close(); //closing the scanner.........
    }
}

// Base class for all employees
class employee {
    String name;
    int id;
    int BaseSalary;
    
    employee(String name , int id, int BaseSalary) {
        this.name = name;
        this.id = id;
        this.BaseSalary = BaseSalary;
    }
    
    // Default implementation to calculate salary
    void calculateSalary() {
        System.out.println("Base Salary: " + BaseSalary);
    }
}

// Full-time employee with bonus and allowance
class FullTimeEmployee extends employee {
    int bonus, allowance;
    
    FullTimeEmployee(String name , int id, int BaseSalary, int bonus, int allowance) {
        super(name, id, BaseSalary);
        this.bonus = bonus;
        this.allowance = allowance;
    }
    
    // Override to calculate total salary including bonus and allowance
    @Override
    void calculateSalary() {
        int totalSalary = BaseSalary + bonus + allowance;
        System.out.println("Total Salary: " + totalSalary);
    }
}

// Part-time employee paid by hours worked
class PartTimeEmployee extends employee {
    int hoursWorked, hourlyPaid;
    
    PartTimeEmployee(String name , int id, int BaseSalary, int hoursWorked, int hourlyPaid) {
        super(name, id, BaseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyPaid = hourlyPaid;
    }
    
    // Override to calculate salary based on hours worked
    @Override
    void calculateSalary() {
        int totalSalary = hoursWorked * hourlyPaid;
        System.out.println("Total Salary: " + totalSalary);
    }
}