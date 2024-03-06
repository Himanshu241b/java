package adminmodule;

public class Admin{
    private String adminId;
    private String name;
    private String dateOfBirth;

    Admin(String adminId, String name, String dateOfBirth){
        this.adminId = adminId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //getters and setters
    public String getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

}