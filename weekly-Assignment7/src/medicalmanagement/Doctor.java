package medicalmanagement;

public class Doctor extends User{

    String speciality;
    String contact;

    Doctor(String email, String name, String speciality, String contact){
        super(email, name);
        this.speciality = speciality;
        this.contact = contact;
    }

    @Override
    public String getName() {
        return super.getName();
    }


    @Override
    public String getEmail() {
        return super.getEmail();
    }



    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void displayDoctor(){
        System.out.println("Doctor name: " + super.getName());
        System.out.println("Doctor email: " + super.getEmail());
        System.out.println("Doctor speciality: " + speciality);
        System.out.println("Doctor contact: " + contact);
    }
}
