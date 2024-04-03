package Feb_13;

abstract public class Person {
    private static int id = 0;
    private String name;
    private int age;

    Person(String name, int age)
    {
        Person.id += 1;
        this.name = name;
        this.age = age;

    }

    //getters
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return this.name;
    }
    public int getAge()
    {
        return age;
    }

    abstract public void getDetails();
}

