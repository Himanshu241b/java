package OnlineMedicalSystem;

class User {
    private String email;
    private String name;

    //Constructors
    User(){}
    User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    // getters and setters
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }




}