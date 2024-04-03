package WeeklyAssgs.OnlineVotingSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static WeeklyAssgs.OnlineVotingSystem.Employee.employeeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Administrator admin = new Administrator("A1", "Donald Trump", "12-12-1956");

        try(BufferedReader idReader = new BufferedReader(new FileReader("C:\\Users\\chand\\OneDrive\\Desktop\\aviSoft\\src\\WeeklyAssgs\\OnlineVotingSystem\\employeesDB.csv"))){
            String currentline;

            while((currentline = idReader.readLine())!=null){
                String[] userData = currentline.split(",");
                String empID = userData[0];
                String empName = userData[2];
                String dateOfBirth = userData[1];

                Employee employee = new Employee(empID, dateOfBirth, empName);
                employeeMap.put(empID, employee);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

            int choice = 0;
            while(choice != 3){
                System.out.println();
                System.out.println("----ONLINE VOTING SYSTEM----");
                System.out.println("1. Login as Admin");
                System.out.println("2. Login as Employee");
                System.out.println("3. EXIT");
                choice = sc.nextInt();

                switch (choice){
                    case 1:
                        System.out.println("Enter your admin ID: ");
                        String adminID = sc.next();
                        if(adminID.equals(admin.getAdminID())){
                            int remainingChances2 = 3;
                            do{
                                System.out.println("Enter your password: ");
                                String adminPassword = sc.next();
                                if (adminPassword.equals(admin.getAdminPassword())) {
                                    System.out.println("LOGGED IN AS ADMINISTRATOR");
                                    System.out.println();
                                    int choice2=0;
                                    while(choice2!=11){
                                        System.out.println("----ONLINE VOTING SYSTEM----");
                                        System.out.println("1. Add a Candidate");
                                        System.out.println("2. Remove a Candidate");
                                        System.out.println("3. Edit a Candidate");
                                        System.out.println("4. View all Candidates");
                                        System.out.println("5. View all Employees");
                                        System.out.println("6. Remove voter");
                                        System.out.println("7. Remove employee");
                                        System.out.println("8. View all eligible Voters");
                                        System.out.println("9. View all eligible Non-Voters");
                                        System.out.println("10. View Result");
                                        System.out.println("11. Log Out");
                                        choice2 = sc.nextInt();
                                        sc.nextLine();

                                        switch (choice2){
                                            case 1:
                                                System.out.print("Enter the new candidate's name: ");
                                                String candidateName = sc.nextLine();
                                                admin.addCandidate(candidateName);
                                                break;

                                            case 2:
                                                System.out.print("Enter the name of the candidate to be removed: ");
                                                String candidateRemoveName = sc.nextLine();
                                                admin.removeCandidate(candidateRemoveName);
                                                break;

                                            case 3:
                                                System.out.print("Enter the name of the candidate: ");
                                                String oldCandidateName = sc.nextLine();
                                                admin.editCandidate(oldCandidateName);
                                                break;

                                            case 4:
                                                admin.viewCandidates();
                                                break;

                                            case 5:
                                                admin.viewEmployees();
                                                break;

                                            case 6:
                                                System.out.print("Enter the voterID of the voter to be removed: ");
                                                String voterIDtoRemove = sc.nextLine();
                                                admin.removeVoter(voterIDtoRemove);
                                                break;

                                            case 7:
                                                System.out.print("Enter the employeeID of the employee to be removed: ");
                                                String empIDtoRemove = sc.nextLine();
                                                admin.removeEmployee(empIDtoRemove);
                                                break;

                                            case 8:
                                                admin.viewEligibleVoters();
                                                break;

                                            case 9:
                                                admin.viewEligibleNonVoters();
                                                break;

                                            case 10:
                                                admin.viewResult();
                                                break;

                                            case 11:
                                                System.out.println("LOGGED OUT");
                                                break;
                                        }
                                    }
                                    break;
                                }
                                else{
                                    System.out.println("Wrong password");
                                    remainingChances2--;
                                }                            }
                            while (remainingChances2>0);
                            if(remainingChances2==0){
                                System.out.println("You entered the password wrong 3 times, try again after sometime.");
                            }

                        }
                        else{
                            System.out.println("You need to be the admin to login");
                        }
                        break;

                    case 2:
                        System.out.println("Enter your Employee ID: ");
                        String empID = sc.next();
                        if(employeeMap.containsKey(empID)){
                            int remainingChances = 3;
                            do{
                                System.out.println("Enter your password: ");
                                String empPassword = sc.next();
                                if(empPassword.equals(employeeMap.get(empID).getDoB())){
                                    System.out.println("LOGGED IN AS EMPLOYEE");
                                    System.out.println();
                                    int choice1=0;
                                    while(choice1!=5){
                                        System.out.println();
                                        System.out.println("----ONLINE VOTING SYSTEM----");
                                        System.out.println("Enter your choice: ");
                                        System.out.println("1. Register for voting");
                                        System.out.println("2. Cast your vote");
                                        System.out.println("3. Update employee name");
                                        System.out.println("4. Update employee DoB");
                                        System.out.println("5. Log Out");
                                        choice1 = sc.nextInt();
                                        sc.nextLine();

                                        switch (choice1){
                                            case 1:
                                                int remainingChances1 = 3;
                                                if(employeeMap.containsKey(empID)){
                                                    do{
                                                        System.out.print("Enter your password: ");
                                                        String empPassword1 = sc.next();
                                                        if(empPassword1.equals(employeeMap.get(empID).getDoB())){
                                                            employeeMap.get(empID).getRegistered(employeeMap.get(empID));
                                                            break;
                                                        }
                                                        else{
                                                            System.out.println("Wrong password");
                                                            remainingChances1--;
                                                        }
                                                    }
                                                    while (remainingChances1>0);
                                                    if(remainingChances1==0){
                                                        System.out.println("You entered the password wrong 3 times, try again after sometime.");
                                                    }
                                                }
                                                else{
                                                    System.out.print("Sorry, you need to be an employee to vote.");
                                                }
                                                break;

                                            case 2:
                                                Voter.castVote(empID);
                                                break;

                                            case 3:
                                                System.out.print("Enter the updated name: ");
                                                String newName = sc.nextLine();
                                                Employee.updateName(empID,newName);
                                                break;

                                            case 4:
                                                System.out.println("Enter the updated DoB(dd-MM-yyyy): ");
                                                String newDoB = sc.next();
                                                Employee.updateDoB(empID, newDoB);
                                                break;

                                            case 5:
                                                System.out.println("LOGGED OUT");
                                        }
                                    }
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
                            System.out.println();
                            System.out.println("You need to be an employee to login");
                        }
                        break;

                    case 3:
                        System.out.println("Thanks for using the system, EXITING.....");
                }
            }

    }
}
