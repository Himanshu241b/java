package onlinevotingsystem;
public class Admin extends User{


    private String roles;
    Admin(String adminId, String name, String dateOfBirth, String roles){
        super(adminId, name, dateOfBirth);
        this.roles = roles;
    }

    @Override
    public void displayUser(){
        System.out.println("**********Admin details*********");
        System.out.println("Admin id:"+ this.getUserId());
        System.out.println("Admin name : " + this.getName());
        System.out.println("Admin dateOfBirth : " + this.getDateOfBirth());
        System.out.println("Admin roles : " + this.roles);
    }

}