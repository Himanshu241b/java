class DeepComparison{
    public static void main(String[] args){
        String str1= "hello";
        String str2= new String("world");
        System.out.println(str1.equals(str2));
    }
}
class MyString{
    private String str;

    public MyString(String str){
        this.str = str;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        else if(this.equals(obj))
            return true;
        else
            return false;
    }
}
