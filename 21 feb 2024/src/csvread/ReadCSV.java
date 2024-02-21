package csvread;

// imports 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;

/**
 * ReadCSV class that reads the csv file
 */
public class ReadCSV {
    double averageSalary;
    List<String[]> lines;

    /**
     * Constructor to initialize averagesalary and salaries list
     */
    ReadCSV(){
        this.averageSalary = 0.0;
        this.lines = new ArrayList<String[]>();
    }
    
    /**
     * mehod to read the path 
     * it also calculates the average salary alongside
     * @param filePath
     */
    public double getAverageSalary(String filePath){
        double salarySum = 0;
        int employeeCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                lines.add(fields);
                // The salary is in the 8th column (index 7) in the CSV
                String salaryStr = fields[7].trim(); // Trim to remove leading/trailing whitespaces
                if(salaryStr == null || !salaryStr.matches("^\\d+$"))
                    throw new InvalidSalaryException("Salary string is not a number value or is null");

                // Convert the salary string to an integer and add it to salarySum
                int salary = Integer.parseInt(salaryStr);
                salarySum += salary;
                
                // Increment the count of employees
                employeeCount++;
            }
            reader.close();
        } catch (IOException | InvalidSalaryException e) {
            e.printStackTrace();
        }

        // Calculate the average salary
        averageSalary = salarySum / employeeCount;

        System.out.println("Total sum of salaries: " + salarySum);
        System.out.println("Total number of employees: " + employeeCount);
        System.out.println("Average salary: " + averageSalary);

        return averageSalary;
    }
    
    /**
     * Filter employees with salaries above average thresholds and write to file
     * @param filePath path to output file
     * @param threshold threshold percentage
     */
    public void writeCSVFilteredBySalary(String filePath, int threshold){
        
        // Calculate the threshold salary 
        double thresholdSalary = averageSalary * (1 + threshold / 100);
        
        // Open file writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("Name,Salary\n");

            // Write data that meets the condition
            for (String[] line : lines) {
                double salary = Double.parseDouble(line[7].trim());
                if (salary > thresholdSalary) {
                    writer.write(line[1] + " " + line[2] + "," + line[7] + "\n");
                }
            }
            writer.close();

            System.out.println("CSV file created successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
