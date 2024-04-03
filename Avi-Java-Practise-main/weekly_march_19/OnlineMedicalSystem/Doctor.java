package OnlineMedicalSystem;


public class Doctor extends User {

    String password;

    String type;

    public Doctor(){
    }

    public Doctor(String email, String name, String password,String type) {
        super(email, name);
        this.password = password;
        this.type=type;
    }

    public String getPassword() {
        return password;
    }

    public  Doctor(String email,String name){
        super(email,name);
    }

    public String getType() {
        return type;
    }
}