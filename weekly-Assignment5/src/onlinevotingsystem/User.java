package onlinevotingsystem;

public abstract class User {
    String userId;
    String name;
    String dateOfBirth;


    User(){}
    User(String userId, String name, String dateOfBirth){
        this.userId = userId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public abstract void displayUser();
    public boolean getIsVoted(){
        return false;
    }
    public void setIsVoted(){
    }
}
