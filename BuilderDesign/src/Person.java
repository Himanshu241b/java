/**
 * The Builder pattern is a creational design pattern used to construct complex objects step by step.
 * useful when dealing with objects that have a large number of parameters, some of which may be optional or have default values.
 */



public class Person {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;

    //private constructor to force use of builder
    private Person(Builder Builder){
        this.name = Builder.name;
        this.age = Builder.age;
        this.address = Builder.address;
        this.phoneNumber = Builder.phoneNumber;
    }

    public static class Builder{
        //name property with default value
        private String name = "Himanshu";
        private int age;
        private String address;
        private String phoneNumber;

        //Default constructor
        public Builder(){}

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    // Getters for person class

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
