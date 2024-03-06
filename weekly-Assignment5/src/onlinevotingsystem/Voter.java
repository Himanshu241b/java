package onlinevotingsystem;

class User{
    private String userId;
    private String name;
    private String dateOfBirth;
    User(String userId, String name, String dateOfBirth){
        this.userId = userId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //getters and setters
    public String getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }

    public String getdateOfBirth(){
        return dateOfBirth;
    }

    public void displayUser(){
        System.out.println("usermodule.User employee id:"+ this.userId);
        System.out.println("usermodule.User name : " + this.name);
        System.out.println("usermodule.User dateOfBirth : " + this.dateOfBirth);
    }

}