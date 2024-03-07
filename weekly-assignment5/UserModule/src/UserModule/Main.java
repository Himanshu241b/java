package UserModule;
//imports
import java.util.Scanner;
import AdminModule.Admin;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        User user = null;
        Admin admin = null;
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

                        char userChoice = scanner.next().charAt(0);

                        switch (userChoice) {
                            case '1':  //Register a user
                                String employeeId = scanner.next();
                                System.out.println("Enter your password:");
                                String password = scanner.next();
                                if (validator.validateUser(employeeId, password)) {
                                    System.out.println("Employee with id" + employeeId + " exists");
                                    System.out.println("*********usermodule.User registration********");
                                    System.out.println("Enter your name:");
                                    String name = scanner.next();
                                    System.out.println("Enter your date of birth (DD/MM/YYYY):");
                                    String dateOfBirth = scanner.next();
                                    user = UserRegisterer.registerUser(name, dateOfBirth, employeeId);
                                } else
                                    System.out.println("Your employee id or password is incorrect");
                                break;
                            case '2':  // login a user
                                if (user != null)
                                    System.out.println("You are already logged in...");
                                else {
                                    System.out.println("Enter your employee id:");
                                    employeeId = scanner.next();
                                    System.out.println("Enter your employee password");
                                    password = scanner.next();
                                    user = UserLogin.loginUser(employeeId, password);
                                    if (user != null)
                                        System.out.println("You are logged in successfully...");
                                    else
                                        System.out.println("No user found for above credentials");
                                }
                                break;
                            case '3': // change password of a user
                                if (user != null) {
                                    PasswordChanger.changePassword(user.getUserId());
                                } else
                                    System.out.println("Login first ...");
                                break;
                            case '4':  //display data of user
                                if (user != null) {
                                    user.displayUser();
                                } else
                                    System.out.println("Login first ...");
                                break;
                            case '5':  // logout a user
                                if(user != null) {
                                    user = null;
                                    System.out.println("Logged out successfully...");
                                }
                                else
                                    System.out.println("You have to login first.");
                                break;
                            default:
                                System.out.println("Enter valid choice");
                }
                        }while (user != null) ;
                break;
                case '2':
                    do{
                        System.out.println("Press 1: To login...");
                        char adminChoice = scanner.next().charAt(0);
                        switch (adminChoice){
                            case '1':

                                break;
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
}