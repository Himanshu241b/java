package medicalmanagement;

public class Patient extends User{

    String disease;
    String contact;

    Patient(String email, String name, String disease, String contact){
        super(email,name);
        this.disease = disease;
        this.contact = contact;
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }



    @Override
    public String getName() {
        return super.getName();
    }


    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void displayPatient(){
        System.out.println("Patient name: " + super.getName());
        System.out.println("Patient email: " + super.getEmail());
        System.out.println("Patient disease: " + disease);
        System.out.println("Patient contact: " + contact);
    }

}
