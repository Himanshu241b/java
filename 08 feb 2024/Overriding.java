import java.util.*;
class Overriding {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        s1 obj = new s1();
        System.out.println(obj.setSalary(300));
        System.out.println("Enter the value 1");
        String n = scanner.nextLine();
        System.out.println("Enter the value 2");
        String n1 = scanner.next(); // will not consume the enter so will n2 will get the newline character
        System.out.println("Enter the value 3");
        String n2 = scanner.nextLine();// it consumes the newline character of previous enter pressed by user
        

    }
}
class s2 {
    int salary = 1000;
    public int setSalary(int value) {
        return salary += value;
    }
}
class s1 extends s2{
    int salary = 12000;
    public int setSalary(int value) {
        return salary -= value;
    }
}

