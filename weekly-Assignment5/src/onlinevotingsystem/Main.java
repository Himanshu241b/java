package onlinevotingsystem;
//imports
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

class Main{
    private static boolean isCooldown = false;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final String avisoftEmployeesCsvPath = "/home/himanshu/Desktop/Avisoft/java/weekly-Assignment5/src/database/avisoftEmployees.csv";
        final String adminCsvPath = "/home/himanshu/Desktop/Avisoft/java/weekly-Assignment5/src/database/admin.csv";
        final String candidatesCsvPath = "/home/himanshu/Desktop/Avisoft/java/weekly-Assignment5/src/database/candidates.csv";
        User voter = null;
        User admin = null;
        boolean isvotingEnabled = false;
        System.out.println("********Welcome to online voting system*********");
        do {
            System.out.println("Press 1: To continue as a voter");
            System.out.println("Press 2: To continue as admin");
            System.out.println("Press 0: To exit...");

            char choice = scanner.next().charAt(0);

                switch (choice) {
                    case '1':
                        do {
                        System.out.println("Press 1: To register...");
                        System.out.println("Press 2: To login...");
                        System.out.println("Press 3: To change your password");
                        System.out.println("Press 4: To view your profile");
                        System.out.println("Press 5: To vote");
                        System.out.println("Press 6: To see current status of votes");
                        System.out.println("Press 0: To logout...");
                        char userChoice = scanner.next().charAt(0);

                        switch (userChoice) {
                            case '1':  //Register a voter
                                if(!isCooldown){
                                int attempts = 3;
                                while(attempts-- > 0 && voter == null) {
                                    System.out.println(attempts + 1 + " attempts left");
                                    System.out.println("Enter your employee id:");
                                    String employeeId = scanner.next();
                                    System.out.println("Enter your password:");
                                    String password = scanner.next();
                                    if (Login.loginUser(employeeId, password, avisoftEmployeesCsvPath) == null) {
                                        System.out.println("Your employee id or password is incorrect");
                                        if (attempts == 0) {
                                            System.out.println("You must wait for 5 minutes before trying again..");
                                            setCooldown();
                                        }
                                        continue;
                                    } else {

                                        System.out.println("Employee with id " + employeeId + " exists");
                                        System.out.println("*********User Registration********");
                                        String name = null;
                                        while (true) {
                                            System.out.println("Enter your name:");
                                            name = scanner.next();
                                            if (!isValidName(name))
                                                System.out.println("Name cant have spaces, numbers and special characters");
                                            else
                                                break;
                                        }
                                        while (true) {
                                            System.out.println("Enter your date of birth (DD/MM/YYYY):");
                                            String dateOfBirth = scanner.next();
                                            if (!isValidDate(dateOfBirth))
                                                System.out.println("Enter a valid date in correct format");
                                            else {
                                                voter = UserRegisterer.registerUser(name, dateOfBirth, employeeId);
                                                break;
                                            }

                                        }
                                        break;
                                    }
                                }
                                }
                                else
                                    System.out.println("Please wait for the cooldown to finish.");
                                break;
                            case '2':  // login a voter
                                if(!isCooldown) {
                                    if (voter != null)
                                        System.out.println("You are already logged in...");
                                    else {
                                        int attempts = 3;
                                        while(attempts-- > 0 && voter == null) {
                                            System.out.println(attempts + 1 + " attempts left");
                                            System.out.println("Enter your employee id:");
                                            String loginEmployeeId = scanner.next();
                                            System.out.println("Enter your employee password");
                                            String loginPassword = scanner.next();
                                            voter = Login.loginUser(loginEmployeeId, loginPassword, avisoftEmployeesCsvPath);
                                            if (voter == null) {
                                                if(attempts == 0){
                                                    System.out.println("You must wait for 5 minutes before trying again..");
                                                    setCooldown();
                                                }
                                                 continue;
                                            }
                                            if (voter != null)
                                                System.out.println("You are logged in successfully...");
                                            else
                                                System.out.println("No voter found for above credentials");
                                        }
                                    }
                                }
                                    else
                                        System.out.println("Please wait for the cooldown to finish.");
                                break;
                            case '3': // change password of a voter
                                if (voter != null) {
                                    PasswordChanger.changePassword(voter.getUserId(), avisoftEmployeesCsvPath);
                                } else
                                    System.out.println("Login first ...");
                                break;
                            case '4':  //display data of voter
                                if (voter != null) {
                                    voter.displayUser();
                                } else
                                    System.out.println("Login first ...");
                                break;
                            case '5': // vote for a candidate
                                if (voter != null && !voter.getName().equals("null") && !voter.getDateOfBirth().equals("null")) {
                                    if (voter.getIsVoted()) {
                                        System.out.println("You have already voted");
                                    } else {
                                        if (isvotingEnabled) {
                                            VotingBooth.castVote(voter.getUserId(), candidatesCsvPath, avisoftEmployeesCsvPath);
                                            voter.setIsVoted();
                                        } else {
                                            System.out.println("Voting not enabled by admin.");
                                        }
                                    }
                                } else {
                                    System.out.println("Register and Login first...");
                                }

                                break;
                            case '6': // display the current status of votes
                                if(voter != null)
                                    ResultRevealer.showStatus(candidatesCsvPath);
                                else
                                    System.out.println("Login first");
                                break;
                            case '0':  // logout a voter
                                if(voter != null) {
                                    voter = null;
                                    System.out.println("Logged out successfully...");
                                }
                                else
                                    System.out.println("You have to login first.");
                                break;
                            default:
                                System.out.println("Enter valid choice");
                }
                        }while (voter != null) ;
                break;
                case '2':
                    do{
                        System.out.println("Press 1: To login.");
                        System.out.println("Press 2: To change your password.");
                        System.out.println("Press 3: To display your profile.");
                        System.out.println("Press 4: To add a new candidate.");
                        System.out.println("Press 5: To edit a candidate.");
                        System.out.println("Press 6: To delete a candidate.");
                        System.out.println("Press 7: To enable voting.");
                        System.out.println("Press 8: To disable voting.");
                        System.out.println("Press 9: To see current stutus of votes.");
                        System.out.println("Press 0: To logout");
                        char adminChoice = scanner.next().charAt(0);
                        switch (adminChoice){
                            case '1': // login the admin
                                if(!isCooldown) {
                                    int attempts = 3;
                                    while (attempts-- > 0) {
                                        System.out.println(attempts + 1 + " attempts available");
                                        System.out.println("Enter your admin id:");
                                        String adminId = scanner.next();
                                        System.out.println("Enter your password:");
                                        String password = scanner.next();
                                        admin = Login.loginUser(adminId, password, adminCsvPath);
                                        if (admin == null) {
                                            if(attempts == 0){
                                                System.out.println("Please retry after 5 minutes.");
                                                setCooldown();
                                            }
                                            continue;
                                        }
                                        break;
                                    }
                                }
                                else{
                                    System.out.println("Please retry after 5 minutes.");
                                }
                                break;
                            case '2': //   change admin password
                                if(admin != null){
                                    PasswordChanger.changePassword(admin.getUserId(), adminCsvPath);
                                }
                                else
                                    System.out.println("Login first...");
                                break;
                                case '3': // display profile of admin
                                    if(admin != null)
                                        admin.displayUser();
                                    else
                                        System.out.println("Login first...");
                                    break;
                                case '4': // add a candidate
                                    if(admin != null)
                                        CandidateManager.addCandidate(candidatesCsvPath);
                                    else
                                        System.out.println("Login first...");
                                    break;
                                case '5':  // edit a candidate
                                    if(admin != null)
                                        CandidateManager.editCandidate(candidatesCsvPath);
                                    else
                                        System.out.println("Login first...");
                                    break;
                                case '6': // delete a candidate
                                    if(admin != null)
                                        CandidateManager.deleteCandidate(candidatesCsvPath);
                                    else
                                        System.out.println("Login first...");
                                    break;
                                case '7': // enable voting
                                    if(admin != null) {
                                        isvotingEnabled = true;
                                        System.out.println("Voting is now enabled");
                                    }
                                    else
                                        System.out.println("login first...");
                                    break;
                                case '8': // disable voting
                                    if(admin != null) {
                                        isvotingEnabled = false;
                                        System.out.println("Voting is now disabled");
                                    }
                                    else
                                        System.out.println("login first...");
                                    break;
                                case '9': // display current status of votes
                                    if(admin != null)
                                        ResultRevealer.showStatus(candidatesCsvPath);
                                    else
                                        System.out.println("Login first.1" +
                                                "");
                                    break;

                                case '0': // logout
                                    if(admin != null){
                                        admin = null;
                                        System.out.println("Logged out successfully");
                                    }
                                    else
                                        System.out.println("You must login first");
                            default:
                                System.out.println("Enter valid choice");
                        }

                    }while(admin != null);
                    break;
                case '0':
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice");
            }
        }while(true);
    }

    public static void setCooldown(){
        isCooldown = true;

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(() -> {
            isCooldown = false;
            scheduledExecutorService.shutdown();
        }, 5, TimeUnit.SECONDS);
    }


        public static boolean isValidName(String name) {
            // Regular expression pattern for a name
            // Allows alphabets, spaces, hyphens, and apostrophes
            String regex = "^[a-zA-Z]+$";

            // Compile the regular expression pattern
            Pattern pattern = Pattern.compile(regex);

            // Match the name against the pattern
            return pattern.matcher(name).matches();
        }


    public static boolean isValidDate(String date) {
        // Regular expression pattern for a date in dd/mm/yyyy format
        // Ensures valid days, months, and years
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the date against the pattern
        return pattern.matcher(date).matches();
    }
}