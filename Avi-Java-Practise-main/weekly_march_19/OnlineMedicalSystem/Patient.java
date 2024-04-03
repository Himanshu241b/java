package OnlineMedicalSystem;

public class Patient extends User{

    String password;

    public Patient() {
    }

    public Patient(String email, String name) {
        super(email, name);
    }
}
