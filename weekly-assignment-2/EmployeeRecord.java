import java.util.*;

//EmployeeRecord main class
public class EmployeeRecord {
    private static Map<String, Employee> employees;

    public EmployeeRecord() {
        employees = new HashMap<>();
    }

    // Method to add a new employee
    public static void addEmployee(Employee employee) {
        if (!employees.containsKey(employee.getEmployeeID())) {
            employees.put(employee.getEmployeeID(), employee);
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee ID already exists. Failed to add employee.");
        }
    }

    // Method to remove an employee based on their Employee ID
    public static void removeEmployee(String employeeID) {
        if (employees.containsKey(employeeID)) {
            employees.remove(employeeID);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee ID not found. Failed to remove employee.");
        }
    }

    // Method to display information of a specific employee based on their Employee ID
    public static void displayEmployeeInformation(String employeeID) {
        if (employees.containsKey(employeeID)) {
            Employee employee = employees.get(employeeID);
            System.out.println("Employee ID: " + employee.getEmployeeID());
            System.out.println("Name: " + employee.getName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Salary: " + employee.getSalary());
        } else {
            System.out.println("Employee ID not found.");
        }
    }

    // Method to display information of all employees
    public static void displayAllEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println("Employee ID: " + employee.getEmployeeID());
            System.out.println("Name: " + employee.getName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println();
        }
    }

    // Method to calculate and display the total salary of all employees
    public static void calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees.values()) {
            totalSalary += employee.getSalary();
        }
        System.out.println("Total Salary of all employees: " + totalSalary);
    }

    // Method to sort employees by salary in descending order
    public static void sortEmployeesBySalary() {
        List<Employee> sortedEmployees = new ArrayList<>(employees.values());
        sortedEmployees.sort(Comparator.comparingDouble(Employee::getSalary));
        for (Employee employee : sortedEmployees) {
            System.out.println("Employee ID: " + employee.getEmployeeID() + ", Salary: " + employee.getSalary());
        }
    }
    // Method to search on basis of name
    public static void searchByName(String name){
        for(Employee employee : employees.values()){
            if(employee.getName().equals(name))
                displayEmployeeInformation(employee.getEmployeeID());   
        }
    }
    //Method to search on basis of POSITION
    public static void searchByPosition(String position){
        for(Employee employee : employees.values())
            if(employee.getPosition().equals(position))
                displayEmployeeInformation(employee.getEmployeeID()); 
    }

    //Method to search on basis of salary name
    public static void searchBySalaryRange(Double salaryRange){
        for(Employee employee : employees.values())
            if(employee.getSalary() <= salaryRange)
                displayEmployeeInformation(employee.getEmployeeID()); 
    }

    //Method to update employee record
    public static void updateRecord(String employeeId){
        Scanner scanner = new Scanner(System.in);
        for(Employee employee : employees.values()){
            if(employee.getEmployeeID().equals(employeeId)){
                System.out.println("Enter the employee id: of  employee");
                String id = scanner.next();
                System.out.println("Enter the employee name of employee");
                String name = scanner.next();
                System.out.println("Enter the employee position of employee");
                String position = scanner.next();
                System.out.println("Enter the  salary of employee");
                Double salary = scanner.nextDouble();
                System.out.println("Enter the months worked by employee");
                int timeWorked = scanner.nextInt();
                double totalSalary = salary * timeWorked;
                String removedId = employee.getEmployeeID();
                removeEmployee(removedId);
                FullTimeEmployee updatedEmployee = new FullTimeEmployee(removedId, name, position, salary, timeWorked, totalSalary);
            }
        }
    }
    public static boolean check(String name) {
        // Regular expression to match only letters (uppercase and lowercase)
        String regex = "^[a-zA-Z]+$";
    
        // Check if the name matches the regular expression
        return name.matches(regex);
    }  


    // main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeRecord ems = new EmployeeRecord();
        System.out.println("Enter total number of employees");
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++) { // take input for each employee
            boolean validInput = false;
            do {
                try {
                    System.out.println("Enter the employee id of employee " + (i + 1) + ":");
                    String id = scanner.next();
                    System.out.println("Enter the employee name of employee " + (i + 1) + ":");
                    String name = scanner.next();
                    if(!check(name)){
                        throw new IllegalArgumentException("Please enter valid name without special characters or numbers");
                    }
                    System.out.println("Enter the employee position of employee " + (i + 1) + ":");
                    String position = scanner.next();
                    System.out.println("Enter the employee salary of employee " + (i + 1) + ":");
                    double salary = scanner.nextDouble();
                    if (salary <= 0) {
                        throw new IllegalArgumentException("Salary must be a positive number.");
                    }
                    System.out.println("Enter the months worked by employee " + (i + 1) + ":");
                    int timeWorked = scanner.nextInt();
                    if (timeWorked <= 0) {
                        throw new IllegalArgumentException("Months worked must be a positive integer.");
                    }
                    double totalSalary = salary * timeWorked;
                    // create object of class
                    FullTimeEmployee employee = new FullTimeEmployee(id, name, position, salary, timeWorked, totalSalary);
                    addEmployee(employee); // add object to map containing all employees data
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input format. Please enter valid input.");
                    scanner.nextLine(); // consume invalid input
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!validInput);
        }
        char choice='0';
        do {
            System.out.println("To see employee information of a perticular employee: press 1\nTo see employee information of all employees: press 2\nTo see total salary of all employees: press 3\nTo see employees sorted by salary: press 4\nTo search for employee based on name: press 5\n:To search for employee based on position: press 6\nTo search for employee based on salary:press 7\nTo Update an employee: press 8\nTo remove an employee: press 9\nTo terminate the program: press 0");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '0':
                    System.out.println("Terminated");
                    return; // exit the program
                case '1':
                    System.out.println("Enter the id of employee to display its data");
                    String id = scanner.next();
                    displayEmployeeInformation(id);
                    System.out.println("---------------------------------------------------------");

                    break;
                case '2':
                    displayAllEmployees();
                    System.out.println("---------------------------------------------------------");
                    break;
                case '3':
                    System.out.println("Total Salary of all employees: " );
                    calculateTotalSalary();
                    System.out.println("---------------------------------------------------------");

                    break;
                case '4':
                    sortEmployeesBySalary();
                    System.out.println("---------------------------------------------------------");
                    break;
                case '5':
                    System.out.println("Enter the name to search");
                    String name = scanner.next();
                    searchByName(name);
                    System.out.println("---------------------------------------------------------");
                    break;
                case '6':
                    System.out.println("Enter the position to search");
                    String position = scanner.next();
                    searchByPosition(position);
                break;
                case '7':
                    System.out.println("Enter the Salary range to search");
                    Double salaryRange= scanner.nextDouble();
                    searchBySalaryRange(salaryRange);
                    break;
                case '8':
                    System.out.println("Enter id of employee you want to update:");
                    String employeeId= scanner.next();
                    updateRecord(employeeId);
                    break;
                case '9':
                    System.out.println("Enter employee id you want to remove:");
                    String removeId = scanner.next();
                    removeEmployee(removeId);
                default:
                    System.out.println("Enter a valid choice");
                    System.out.println("****************************************");
            }
        } while (true);
    }
}


// Employee interface
interface Employee {
    String getEmployeeID();
    String getName();
    String getPosition();
    double getSalary();
    double getTimeWorked();
    double getTotalSalary();
}

// FullTimeEmployee class implementing Employee interface
class FullTimeEmployee implements Employee {
    private String employeeID;
    private String name;
    private String position;
    private double salary;
    private int timeWorked;
    private double totalSalary;

    public FullTimeEmployee(String employeeID, String name, String position, double salary, int timeWorked, double totalSalary) {
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.timeWorked = timeWorked;
        this.totalSalary = totalSalary;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public double getTimeWorked(){
        return timeWorked / 12 ;
    }
    @Override
    public double getTotalSalary(){
        return totalSalary;
    }
}

