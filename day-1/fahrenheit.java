public class fahrenheit {
    public static void main(String[] args){
        int sFahrenheit = 30;
        int eFahrenheit = 70;
        int gap = 5;
        System.out.println("Fahrenheit '\t\t' degre Celsius");
        for(int i = sFahrenheit; i <= eFahrenheit; i += gap){
            System.out.println(i+"F" +"\t\t"+ (i-32)*5/9+"C");
        }
    }
}
