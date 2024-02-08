import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.lang.Override;

// Library Management class with main method 
public class LibraryManagement {
    static Scanner sc = new Scanner(System.in); // initialize scanner for input

    public static void main(String[] args) {

        Library library = new Library(); // Make library object to add items
       
        while (true) {
            //choices for user
            System.out.println("\nLibrary Management System");
            System.out.println("0. Add a book");
            System.out.println("1. Add a magazine");
            System.out.println("2. Register a member");
            System.out.println("3. Display item details");
            System.out.println("4. Check out item");
            System.out.println("5. Return item");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            char choice = sc.next().charAt(0);
            
            //control  for the choices
            switch (choice) {
                case '0':
                    System.out.println("Enter book id:");
                    String bookId = sc.next();
                    System.out.println("Enter book title:");
                    String bookTitle = sc.next();
                    System.out.println("Enter book author:");
                    String bookAuthor = sc.next();
                    System.out.println("Enter book isbn:");
                    String bookIsbn = sc.next();
                    System.out.println("Enter number of books available:");
                    int booksAvailable = sc.nextInt();
                    library.addItem(new Book(bookId, bookTitle, bookAuthor, bookIsbn, booksAvailable));
                    System.out.println("Book added successfully.");
                    break;
                case 1:
                    System.out.println("Enter Magazine id:");
                    String magazineId = sc.next();
                    System.out.println("Enter magazine title:");
                    String magazineTitle = sc.next();
                    System.out.println("Enter magazine author:");
                    String magazineAuthor = sc.next();
                    System.out.println("Enter magazine Issue number:");
                    int magazineIssueNumber = sc.nextInt();
                    System.out.println("Enter number of magazines available:");
                    int magazineAvailable = sc.nextInt();
                    library.addItem(new Magazine(magazineId, magazineTitle, magazineAuthor, magazineIssueNumber, magazineAvailable));
                    System.out.println("Magazine added successfully.");
                    break;   
                case '2':
                    System.out.println("Enter the new member id");
                    String newMemberId = sc.next();
                    System.out.println("Enter the new member name");
                    String newMemberName = sc.next();
                    library.registerMember(new LibraryMember(newMemberId, newMemberName));
                    break;
                case '3':
                    System.out.print("Enter item ID: ");
                    String itemId = sc.next();
                    library.displayItemDetails(itemId);
                    break;
                case '4':
                    System.out.print("Enter item ID to check out: ");
                    String checkoutItemId = sc.next();
                    System.out.println("Enter the member id");
                    String memberCheckoutId = sc.next();
                    LibraryMember memberForItemCheckout = library.getMember(memberCheckoutId);
                    library.checkOutItem(checkoutItemId, memberForItemCheckout);
                    break;
                case '5':
                    System.out.print("Enter item ID to return: ");
                    String returnItemId = sc.next();
                    System.out.println("Enter the member id");
                    String memberReturnId = sc.next();
                    LibraryMember memberForItemReturn = library.getMember(memberReturnId);
                    library.returnItem(returnItemId, memberForItemReturn);
                    break;
                case '6':
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// abstract item class representing an item in the library
abstract class Item { 
    private String id;
    private String title;
    private String author;
    public int quantityAvailable;

    //Item class constructor to initialize an item
    public Item(String id, String title, String author, int quantityAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantityAvailable = quantityAvailable;
    }
    // method to get id of item
    public String getId() {
        return id;
    }
    // method to get title of item
    public String getTitle() {
        return title;
    }
    // method to get author of item
    public String getAuthor() {
        return author;
    }
    //method to get available quantity of item(Book or magazine)
    public int getQuantity() {
        return quantityAvailable;
    }
    // abstract method to display item details
    public abstract void displayDetails();
}

// class representing a book, subclass of Item
class Book extends Item {
    private String isbn;

    //Book class constructor to initialize a book
    public Book(String id, String title, String author, String isbn, int quantityAvailable) {
        super(id, title, author, quantityAvailable);  // call constructor of its parent class to assign common properties to parent class 
        this.isbn = isbn;
    }
    // method to get Isbn number of book
    public String getIsbn() {
        return isbn;
    }

    @Override // override from item class to display the book peoperties 
    public void displayDetails() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + isbn);
        System.out.println("Available books :"+ getQuantity());
    }
}

// class representing a magazine, subclass of Item
class Magazine extends Item {
    private int issueNumber;

    // Magazine class constructor to initialize a magazine
    public Magazine(String id, String title, String author, int issueNumber, int quantityAvailable) {
        super(id, title, author, quantityAvailable); // calling parent constructor to initialize common peoperties to parent class
        this.issueNumber = issueNumber;
    }

    // method to get issue number of magazine
    public int getIssueNumber() {
        return issueNumber;
    }

    @Override // override parent item class method to display magazine details
    public void displayDetails() {
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Available Magazines: " +getQuantity());
    }
}

// Class representing a library member
class LibraryMember {
    private String memberId;
    private String name;
    //constructor to initialize a library member
    public LibraryMember(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
    // method to get member id
    public String getMemberId() {
        return memberId;
    }
    // method to get name of member
    public String getName() {
        return name;
    }

    public void checkOut(Item item) {
        System.out.println(name + " checks out " + item.getTitle());
    }

    public void returnItem(Item item) {
        System.out.println(name + " returns " + item.getTitle());
    }
}

// Class representing the library
class Library {
    private Map<String, Item> inventory; // stores id of item against the item  <Id, item>
    private List<LibraryMember> members; // stores the objects of library members class
    
    //constructor to initialize the library
    public Library() {
        inventory = new HashMap<>();
        members = new ArrayList<>();
    }
    // method to add an item in library
    public void addItem(Item item) {
        inventory.put(item.getId(), item);
    }
    // method to add a member to members list or registration of a member
    public void registerMember(LibraryMember member) {
        members.add(member);
    }

    // mehtod to decrease book count
    public void decrementQuantity(String itemId) {
        inventory.get(itemId).quantityAvailable -=1;
    }

    //method to increment book count
    public void incrementQuantity(String itemId){
        inventory.get(itemId).quantityAvailable += 1;
    }

    // method to display details of an item by extracting the item from the inventory map
    public void displayItemDetails(String itemId) {
        if (inventory.containsKey(itemId)) {
            inventory.get(itemId).displayDetails();
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    // method to checkout an item (it calls checkout method in LibraryMember class to checkout)
    public void checkOutItem(String itemId, LibraryMember member) {
        if (inventory.containsKey(itemId) && inventory.get(itemId).getQuantity() > 0) {
            decrementQuantity(itemId);
            member.checkOut(inventory.get(itemId));
        } else {
            System.out.println("Item with ID " + itemId + " not found or is out of stock.");
        }
    }
    // method to return item  by calling returnItem method of LibraryMember class
    public void returnItem(String itemId, LibraryMember member) {
        if (inventory.containsKey(itemId)) {
            incrementQuantity(itemId);
            member.returnItem(inventory.get(itemId));
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }
    // method to get member from members list called in main method for checkout and return of item
    public LibraryMember getMember(String memberId){
        for(LibraryMember member : members){
            if(member.getMemberId().equals(memberId))
                return member;
        }
        System.out.println("Member not found: " + memberId);
        return null;
    }
}

