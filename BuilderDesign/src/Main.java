//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder()
                .age(20)
                .build();
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getAddress());
        System.out.println(person.getPhoneNumber());
    }
}