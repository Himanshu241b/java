public class fahrenheit {
    public static void main(String[] args){
        int sFahrenheit = 76;
        int eFahrenheit = 707;
        int gap = 40;
        System.out.println("Fahrenheit '\t\t' degre Celsius");
        for(int i = sFahrenheit; i <= eFahrenheit; i += gap){
            System.out.println(i+"F" +"\t\t"+ (i-32)*5/9+"C");
        }
    }
}
