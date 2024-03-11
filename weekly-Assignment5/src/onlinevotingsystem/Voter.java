package onlinevotingsystem;

public class Voter extends User{
    private boolean isVoted;
    Voter(String voterId, String name, String dateOfBirth, boolean isVoted){
        super(voterId, name, dateOfBirth);
        this.isVoted = isVoted;
    }
    //getters and setters
    public String getVoterId(){
        return super.getUserId();
    }
    public String getName(){
        return super.getName();
    }
    public String getDateOfBirth(){
        return super.getDateOfBirth();
    }
    @Override
    public boolean getIsVoted(){
        return isVoted;
    }
    public void setIsVoted(){
        isVoted = true;
    }

    /**
     *method to display the details of a voter
     */
    @Override
    public void displayUser(){
        System.out.println("*********Voter details************");
        System.out.println("Voter employee id:"+ this.getVoterId());
        System.out.println("Voter name : " + this.getName());
        System.out.println("Voter dateOfBirth : " + this.getDateOfBirth());
        if(this.isVoted)
            System.out.println("You Have voted");
        else
            System.out.println("You Have not voted");
    }



}