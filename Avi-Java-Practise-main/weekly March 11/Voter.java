package WeeklyAssgs.OnlineVotingSystem;

import java.util.HashMap;
import java.util.Scanner;

import static WeeklyAssgs.OnlineVotingSystem.Administrator.candidates;

public class Voter extends Employee{
    static HashMap<String, Voter> voterMap = new HashMap<>();
    static HashMap<String, Boolean> hasVoted = new HashMap<>();
    String password;
    public Voter(String employeeID, String doB, String name) {
        super(employeeID, doB, name);
        this.password = doB;
    }

    public Voter(Employee employee){
        super(employee.employeeID, employee.getDoB(), employee.getName());
    }

    public String getPassword() {
        return password;
    }

    public static void castVote(String voterID){
        Scanner sc = new Scanner(System.in);
        int remainingChances = 3;
        if(voterMap.containsKey(voterID)){
//            do{
                System.out.print("Enter your password: ");
                String empPassword = sc.nextLine();
                do{
                if(empPassword.equals(voterMap.get(voterID).getDoB())){
                    if(!hasVoted.get(voterID)){
                        String chosenCandidate;
                        do{
                        int index=1;
                        System.out.println("Choose your candidate to vote: ");
                        for(String candidate: candidates.keySet()){
                            System.out.println(index+". "+candidate);
                            index++;
                        }
                        chosenCandidate = sc.nextLine();
//                        do{
                            if(candidates.containsKey(chosenCandidate)) {
                                System.out.println("checked the if condition");
                                candidates.put(chosenCandidate, candidates.get(chosenCandidate) + 1);
                                hasVoted.put(voterID, true);
                                System.out.println("You have successfully casted your vote to "+chosenCandidate);
                                break;
                            }
                            else{
                                System.out.println("Please choose a valid candidate");
                            }
                        }
                        while(!candidates.containsKey(chosenCandidate));
                    }
                    else{
                        System.out.println("YOU HAVE ALREADY VOTED!!!");
                        break;
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
            System.out.println("You need to be a registered voter to vote.");
        }
    }
}
