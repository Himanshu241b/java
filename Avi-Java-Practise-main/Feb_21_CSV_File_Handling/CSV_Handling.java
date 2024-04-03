package Feb_21_CSV_File_Handling;
import java.util.*;
import java.io.*;
class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
public class CSV_Handling {
    
    static String inputFile = "employeeData.csv";
    static String outputFile = "employee_above_average.csv";
    static int thresholdPercentage = 10;

    public static void main(String[] args) {

        try{
            List<Employee> employees = new ArrayList<>();
            if(employees.isEmpty())
            {
                System.out.println("No data found in the list.");
                return;
            }
            double avgSalary = calcAvgSalary(employees);
            double threshold = avgSalary * (1 + thresholdPercentage / 100);

            List<Employee> aboveAverageEmployees = filterEmployeesAboveAverage(employees, threshold);

            writeEmployeesToFile(aboveAverageEmployees, outputFile);

            System.out.println("Names and salaries of employees above the average have been written to the output file.");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    private static List<Employee> readEmployeeData(String filename) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    double salary = Double.parseDouble(parts[1].trim());
                    employees.add(new Employee(name, salary));
                }
            }
        }
        return employees;
    }


    static double calcAvgSalary(List<Employee> emps)
    {
        double totalSal = 0;
        for(Employee i: emps)
        {
            totalSal += i.getSalary();
        }
        return totalSal;
    }

    private static List<Employee> filterEmployeesAboveAverage(List<Employee> employees, double threshold) {
        List<Employee> aboveAverageEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getSalary() > threshold) {
                aboveAverageEmployees.add(emp);
            }
        }
        return aboveAverageEmployees;
    }

    private static void writeEmployeesToFile(List<Employee> employees, String filename) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Employee emp : employees) {
                bw.write(emp.getName() + "," + emp.getSalary());
                bw.newLine();
            }
        }
    }
}
