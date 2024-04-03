package WeeklyAssgs.OnlineVotingSystem;

import java.util.*;

import static WeeklyAssgs.OnlineVotingSystem.Employee.employeeMap;
import static WeeklyAssgs.OnlineVotingSystem.Voter.hasVoted;
import static WeeklyAssgs.OnlineVotingSystem.Voter.voterMap;

public class Administrator {
    private final String adminID;
    private final String adminName;
    private final String adminPassword;

    static HashMap<String, Integer> candidates = new HashMap<>();

    public Administrator(String adminID, String adminName, String adminPassword) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void addCandidate(String candidateName){
        if(!candidates.containsKey(candidateName)){
            candidates.put(candidateName, 0);
            System.out.println("Candidate has been added successfully!!!");
        }
        else{
            System.out.println("Candidate already registered");
        }
        System.out.println();
    }
    public void removeCandidate(String candidateName){
        if(candidates.containsKey(candidateName)){
            candidates.remove(candidateName);
            System.out.println("Candidate removed successfully!!!");
        }
        else{
            System.out.println("No such candidate is registered");
        }
        System.out.println();
    }

    public void editCandidate(String oldCandidateName){
        Scanner sc = new Scanner(System.in);
        if(candidates.containsKey(oldCandidateName)){
            System.out.println("Enter the updated name: ");
            String newCandidateName = sc.nextLine();
            candidates.put(newCandidateName, candidates.get(oldCandidateName));
            candidates.remove(oldCandidateName);
            System.out.println("Candidate updated successfully!!!");
        }
        else{
            System.out.println("No such candidate exists");
        }
        System.out.println();
    }

    public void viewCandidates(){
        System.out.println("----LIST OF CANDIDATES----");
        if(candidates.size()!=0){
            int index = 1;
            for(String candidate:candidates.keySet()){
                System.out.println(index+". "+candidate);
                index++;
            }
        }
        else{
            System.out.println("No registered candidates yet.");
        }
        System.out.println();
    }

    public void viewEmployees(){
        System.out.println("----LIST OF EMPLOYEES----");
        if(employeeMap.size()!=0){
            for(String empID:employeeMap.keySet()){
                System.out.println(employeeMap.get(empID));
            }
        }
        else{
            System.out.println("No employees yet.");
        }
        System.out.println();
    }

    public void viewEligibleVoters(){
        System.out.println("----LIST OF ELIGIBLE VOTERS----");
        if(voterMap.size()!=0){
            for(String voterID:voterMap.keySet()){
                System.out.println(voterMap.get(voterID));
            }
        }
        else{
            System.out.println("No registered voters yet.");
        }
        System.out.println();
    }

    public void viewEligibleNonVoters(){
        System.out.println("----LIST OF ELIGIBLE NON-VOTERS----");
        for(String voterID:voterMap.keySet()){
            if(!hasVoted.get(voterID)){
                System.out.println(voterMap.get(voterID));
            }
        }
        System.out.println();
    }

    public HashMap<String, Integer> calculateResult(HashMap<String, Integer> candidatesMap){
        List<Map.Entry<String, Integer>> list = new LinkedList<>(candidatesMap.entrySet());

        Collections.sort(list, (o1, o2) -> {
            return o2.getValue().compareTo(o1.getValue());
        });

        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public void viewResult(){
        HashMap<String, Integer> resultMap = calculateResult(candidates);
        int max=Integer.MIN_VALUE;

        for(String candidate:candidates.keySet()) {
            if (candidates.get(candidate) > max) {
                max = candidates.get(candidate);
            }
        }

            if(max>0){
                System.out.print("!!!! The winner is: ");
                for(String winner:candidates.keySet()){
                    if(candidates.get(winner)==max){
                        System.out.println(winner+" !!!!");
                    }
                }
            }
            else{
                System.out.println("No winners yet!!!");
            }

        for(String candidate1:resultMap.keySet()){
            System.out.println(candidate1+": "+resultMap.get(candidate1));
            }
        System.out.println();
    }

    public void removeVoter(String voterIDtoRemove) {
        if(voterMap.containsKey(voterIDtoRemove)){
            voterMap.remove(voterIDtoRemove);
            System.out.println("Successfully removed voter");
            System.out.println();
        }
        else{
            System.out.println("No such voter exists.");
            System.out.println();
        }
    }

    public void removeEmployee(String employeeIDtoRemove){
        if(employeeMap.containsKey(employeeIDtoRemove) && voterMap.containsKey(employeeIDtoRemove)){
            employeeMap.remove(employeeIDtoRemove);
            voterMap.remove(employeeIDtoRemove);
            System.out.println("Successfully removed employee");
            System.out.println();
        }
        else if(employeeMap.containsKey(employeeIDtoRemove)){
            employeeMap.remove(employeeIDtoRemove);
            System.out.println("Successfully removed employee");
            System.out.println();
        }
        else{
            System.out.println("No such employee exists");
            System.out.println();
        }
    }
}
