package Feb_08;


import java.util.*;

//interface for checkoutable
interface CheckOutAble{
    void checkOutItem();
    void returnItem();
}

//abstract class for item
abstract class Item{
    private int id;
    private String title;
    private String author;

    public Item(int id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId(){
        return this.id;
    }
    public String getTitle()
    {
        return this.title;
    }
    public String getAuthor()
    {
        return this.author;
    }

    public abstract void displayDetails();
}

//book class extending item and also implementing checkoutable to use its abstract funcs
class Book extends Item implements CheckOutAble{
    private String isbn;
    private boolean checkOutStatus;

    public Book(int id, String title, String author, String isbn)
    {
        super(id, title, author);
        this.isbn = isbn;
    }

    public String getIsbn()
    {
        return this.isbn;
    }

    //checkout if checkout status is false, otherwise true
    @Override
    public void checkOutItem()
    {
        if(!checkOutStatus){
            checkOutStatus = true;
            System.out.println("Book checked out successfully");
        }
        else System.out.println("Sorry! the Book is already checked out.");
    }

    //return the book only if its checkout -> checkoutstatus is true:
    @Override
    public void returnItem()
    {
        if(checkOutStatus)
        {
            checkOutStatus = false;
            System.out.println("The book is successfully returned");
        }
        else System.out.println("You cannot return the book which is not checked out");
    }

    public void displayDetails(){
        System.out.println("Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nISBN: "+ getIsbn());
    }
}

//Magazine class extending item and also implementing checkoutable to use its abstract funcs
class Magazine extends Item implements CheckOutAble{
    private int issueNumber;
    private boolean checkOutStatus;

    public Magazine(int id, String title, String author, int issueNumber)
    {
        super(id, title, author);
        this.issueNumber = issueNumber;
    }
    public int getIssueNumber()
    {
        return this.issueNumber;
    }

    public void displayDetails()
    {
        System.out.println("Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nIssue Number: "+ getIssueNumber());
    }

    //checkout if checkout status is false, otherwise true
    @Override
    public void checkOutItem()
    {
        if(!checkOutStatus){
            checkOutStatus = true;
            System.out.println("Magazine checked out successfully");
        }
        else System.out.println("Sorry! the magazine is already checked out.");
    }

    //return the book only if its checkout -> checkoutstatus is true:
    @Override
    public void returnItem()
    {
        if(checkOutStatus)
        {
            checkOutStatus = false;
            System.out.println("The Magazine is successfully returned");
        }
        else System.out.println("You cannot return the Magazine which is not checked out");
    }
}



//libraryMember class
class LibraryMember{
    private int memberID;
    private String name;
    private Map<Integer, Item> checkedOutItem;


    public LibraryMember(int memberID, String name)
    {
        this.memberID = memberID;
        this.name = name;
        this.checkedOutItem = new HashMap<>();
    }
    public int getMemberID()
    {
        return this.memberID;
    }
    public String getName()
    {
        return this.name;
    }

    public void checkOut(CheckOutAble item)
    {
        item.checkOutItem();
        checkedOutItem.put(((Item) item).getId(), (Item) item);
        System.out.println(name + " checked out " + ((Item) item).getTitle());
    }

    public void returnItem(CheckOutAble item)
    {
        if(checkedOutItem.containsKey(((Item) item).getId())){
            item.returnItem();
            checkedOutItem.remove(((Item) item).getId());
            System.out.println(name + " returned " + ((Item) item).getTitle());
        }
        else {
            System.out.println("You need to checkout before returning the item.");
        }
    }


}

//library class in which inventory list and registered members list are handled
class Library {
    private List<Item> inventory;
    private List<LibraryMember> members;

    public Library()
    {
        this.inventory = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addItem(Item item)
    {
        inventory.add(item);
        System.out.println(item.getTitle() + " Added Successfully");
    }
    public void addMember(LibraryMember member)
    {
        members.add(member);
        System.out.println(member.getName() + " Added as a member successfully");
    }

    public void displayInventory()
    {
        System.out.println("Inventory:");
        for(Item i: inventory) i.displayDetails();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book(1, "The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0");
        Magazine magazine = new Magazine(2, "National Geographic", "Various", 123);

        // Create an instance of the library
        Library library = new Library();

        // Add items to the inventory
        library.addItem(book);
        library.addItem(magazine);

        // Display details of all items in the inventory
        library.displayInventory();

        // Create an instance of a library member
        LibraryMember member = new LibraryMember(101, "Alice");

        // Register the library member
        library.addMember(member);

        // Simulate checking out and returning items
        member.checkOut(book);
        member.returnItem(book);

        member.checkOut(magazine);
        member.returnItem(magazine);
    }
}
