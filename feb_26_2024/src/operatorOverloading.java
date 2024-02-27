class OperatorOverloading{
    public static void main(String[] args) {
        String1 obj1 = new String1("hello");
        String1 obj2 = new String1(" world!");

        String concat = obj1+obj2.toString();
        System.out.println(concat);

    }
}

class String1{
    String str1;

     String1(String str1){
        this.str1 = str1;
    }

    @Override
    public String toString(){
         return str1;
    }
}



