package WeeklyAssgs.OnlineVotingSystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import static WeeklyAssgs.OnlineVotingSystem.Voter.hasVoted;
import static WeeklyAssgs.OnlineVotingSystem.Voter.voterMap;

public class Employee {
    String employeeID;
    String DoB;
    String name;
    static HashMap<String, Employee> employeeMap = new HashMap<>();



    public Employee(String employeeID, String doB, String name) {
        this.employeeID = employeeID;
        this.DoB = doB;
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", DoB='" + DoB + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public String getDoB() {
        return DoB;
    }

    public void getRegistered(Employee employee){
        LocalDate currDate = LocalDate.now();
        String date = employee.getDoB();
        date = date.substring(date.length()-4);
        int empDoY = Integer.parseInt(date);

        if(currDate.getYear()-empDoY>18){
            if(!voterMap.containsKey(employee.getEmployeeID())){
                voterMap.put(employee.getEmployeeID(), new Voter(employee));
                hasVoted.put(employee.getEmployeeID(), false);
                System.out.println("Congrats, you are now registered for voting.");
            }
            else{
                System.out.println("You are already registered.");
            }
        }
        else{
            System.out.println("Sorry, you are not eligible to vote at this age.");
        }
    }

    public static void updateName(String employeeID, String newName){
        Scanner sc = new Scanner(System.in);

        if(voterMap.containsKey(employeeID)){
            int remainingChances = 3;
            do{
                System.out.print("Enter your password: ");
                String empPassword = sc.next();
                if(empPassword.equals(employeeMap.get(employeeID).getDoB())){
                    voterMap.put(employeeID, new Voter(employeeID, voterMap.get(employeeID).getDoB(), newName));
                    employeeMap.put(employeeID, new Employee(employeeID, employeeMap.get(employeeID).getDoB(), newName));
                    System.out.println("Name changed successfully");
                    break;
                }
                else{
                    System.out.println("Wrong password");
                    remainingChances--;
                }
            }
            while (remainingChances>0);
            if(remainingChances==0){
                System.out.println("You entered the password wrong 3 times, try again after sometime.");
            }
        }

        else if(employeeMap.containsKey(employeeID)){
            int remainingChances = 3;
            do{
                System.out.print("Enter your password: ");
                String empPassword = sc.next();
                if(empPassword.equals(employeeMap.get(employeeID).getDoB())){
                    employeeMap.put(employeeID, new Employee(employeeID, employeeMap.get(employeeID).getDoB(), newName));
                    System.out.println("Name changed successfully");
                    break;
                }
                else{
                    System.out.println("Wrong password");
                    remainingChances--;
                }
            }
            while (remainingChances>0);
            if(remainingChances==0){
                System.out.println("You entered the password wrong 3 times, try again after sometime.");
            }
        }

        else{
            System.out.println("You need to be an employee to update your name.");
        }
    }

    public static void updateDoB(String employeeID, String newDoB){
        Scanner sc = new Scanner(System.in);
        if(voterMap.containsKey(employeeID)){
            int remainingChances = 3;
            do{
                System.out.print("Enter your password: ");
                String empPassword = sc.next();
                if(empPassword.equals(employeeMap.get(employeeID).getDoB())){
                    voterMap.put(employeeID, new Voter(employeeID, newDoB, voterMap.get(employeeID).getName()));
                    employeeMap.put(employeeID, new Employee(employeeID, newDoB, employeeMap.get(employeeID).getName()));
                    System.out.println("Date Of Birth changed successfully");
                    break;
                }
                else{
                    System.out.println("Wrong password");
                    remainingChances--;
                }
            }
            while (remainingChances>0);
            if(remainingChances==0){
                System.out.println("You entered the password wrong 3 times, try again after sometime.");
            }
        }

        else if(employeeMap.containsKey(employeeID)){
            int remainingChances = 3;
            do{
                System.out.print("Enter your password: ");
                String empPassword = sc.next();
                if(empPassword.equals(employeeMap.get(employeeID).getDoB())){
                    employeeMap.put(employeeID, new Employee(employeeID, newDoB, employeeMap.get(employeeID).getName()));
                    System.out.println("Name changed successfully");
                    break;
                }
                else{
                    System.out.println("Wrong password");
                    remainingChances--;
                }
            }
            while (remainingChances>0);
            if(remainingChances==0){
                System.out.println("You entered the password wrong 3 times, try again after sometime.");
            }
        }
        else{
            System.out.println("You need to be an employee to update your date of birth.");
        }
    }
}
