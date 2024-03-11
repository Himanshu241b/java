package onlinevotingsystem;

/**
 * User class that represents a user of voting system
 */
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

    //getters and setters
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
