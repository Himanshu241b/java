import java.util.Set;
import java.util.HashSet;

class CustomClassInSet{
    public static void main(String[] args){
        CustomClass obj1 = new CustomClass("ab", 1);
        CustomClass obj2 = new CustomClass(obj1);
        Set<CustomClass> set = new HashSet<CustomClass>();
        set.add(obj1);
        System.out.println(set.add(obj2));
        System.out.println(obj1.equals(obj2));

    }
}

class CustomClass {
    String name;
    int id;

    CustomClass(String name, int id){
        this.name = name;
        this.id = id;
    }

    CustomClass(CustomClass obj){
        this.name = obj.name;
        this.id = obj.id;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        CustomClass other = (CustomClass) obj;
        return id == other.id && name.equals(other.name);
    }
    @Override
    public int hashCode(){
        int result = name.hashCode();
        result = 31 * result + id; //The multiplication by 31 is a common practice in Java hash code calculations because it helps in spreading out the bits of the hash code more evenly.
        return result;
    }

}