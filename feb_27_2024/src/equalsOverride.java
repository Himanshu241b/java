

class equalsOverride{

    public static void main(String[] args){
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        int comparison = myClass1.equals(myClass2);
        System.out.println(comparison);
    }
}

class MyClass{

    public enum PropertyPriority{
        a(1),
        b(2),
        c(3);
        private int value;
        private PropertyPriority(int value){
            this.value = value;
        }

    }
    int a;
    double b;
    String c;


    public int equals(MyClass obj){
        if(this.a == obj.a && this.b == obj.b && this.c.equals(obj.c))
            return 0;
        else if(this.a >= obj.a && this.b >= obj.b && !this.c.equals(obj.c))
            return 1;
        else
            return -1;

    }
}