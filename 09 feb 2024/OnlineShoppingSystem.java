import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// online shopping system class containing main method
public class OnlineShoppingSystem {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Electronics("E001", "Laptop", 60000, 12);
        Product shirt = new Clothing("C001", "Shirt", 200, "M", "Blue");

        // adding products to stock or store
        Stock stock = new Stock();
        stock.addProduct(laptop);
        stock.addProduct(shirt);
        
        // updating a product
        stock.updateProduct("E001", "Washing Machine", 10000);
        // Display product details
        laptop.displayProductDetails();
        System.out.println("Final Price: ₹" + laptop.calculateFinalPrice());

        shirt.displayProductDetails();
        System.out.println("Final Price: ₹" + shirt.calculateFinalPrice());

        // Guest user actions
        User guestUser = new Guest();
        guestUser.addToCart(laptop);
        guestUser.addToCart(shirt);
        guestUser.placeOrder();

        //register a new user with username and password
        RegisteredUser newUser = RegisteredUser.registerNewUser();
        System.out.println("New user registered with username: " + newUser.getUsername());

        // Registered user actions
        newUser.addToCart(laptop);
        newUser.addToCart(shirt);
        newUser.browseProducts();
        newUser.placeOrder();
        
        // order history of registered user
        System.out.println("Order History:");
        newUser.viewOrderHistory();

        // update user
        newUser.updateUsername();
        newUser.updatePassword();
    }
}

//stock class to store all products in a list
class Stock {
    static List<Product> products = new ArrayList<Product>();

    // method to add product to list
    public void addProduct(Product product) {
        products.add(product);
    }

    // method to update product details by productId
    public void updateProduct(String productId, String newProductName, double newPrice) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setProductName(newProductName);
                product.setPrice(newPrice);
                System.out.println("Product details updated successfully!");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found!");
    }
}

// Product class - base class for all products
abstract class Product {
    private String productId;
    private String productName;
    private double price;

    // constructor to create a new Product
    public Product(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    // returns product id
    public String getProductId() {
        return productId;
    }

    // returns product name
    public String getProductName() {
        return productName;
    }

    // sets product name
    public void setProductName(String newName) {
        this.productName = newName;
    }

    // returns price of the product
    public double getPrice() {
        return price;
    }

    // sets price of the product
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public abstract String getCategory(); // abstract method to get the category of the product

    public abstract double calculateFinalPrice(); // abstract method to calculate final price of Electronics or Clothing

    public void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }
}

// Electronics class - extends Product
class Electronics extends Product {
    private int warrantyPeriod;
    private String category = "electronics";

    //Electronics product constructor
    public Electronics(String productId, String productName, double price, int warrantyPeriod) {
        super(productId, productName, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    // return warranty period
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    //returns category
    public String getCategory() {
        return category;
    }

    //calculates final price of product after discount
    @Override // overrides the abstract method of product class 
    public double calculateFinalPrice() {
        double finalPrice = getPrice() - (getPrice() * 0.05);  //Final Price = Original Price - (Original Price * 0.05) -> 5% discount
        return finalPrice;
    }
}

// Clothing class - extends Product
class Clothing extends Product {
    private String size;
    private String color;
    private String category = "clothing";

    // constructor for creating a new clothing product
    public Clothing(String productId, String productName, double price, String size, String color) {
        super(productId, productName, price);
        this.size = size;
        this.color = color;
    }

    //return size of the product
    public String getSize() {
        return size;
    }

    // return color of the product
    public String getColor() {
        return color;
    }

    //retuns category
    public String getCategory() {
        return category;
    }

    @Override // overrides abstract method of product class
    public double calculateFinalPrice() {
        double finalPrice = getPrice() - (getPrice() * 0.1);//Final Price = Original Price - (Original Price * 0.1) -> 10% discount
        return finalPrice;
    }
}

// User interface
interface User {
    void browseProducts();
    void addToCart(Product product);
    void placeOrder();
}

// Guest class that implements User interface
class Guest extends Stock implements User {
    private List<Product> cart;
    Scanner scanner = new Scanner(System.in);
    public Guest() { // guest constructor initializes the cart
        cart = new ArrayList<>();
    }

    @Override // override abstract method of interface
    public void browseProducts() {
        System.out.println("What category you want to browse?");
        System.out.println("Press 1. for electronics category");
        System.out.println("Press 2. for clothing category");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consumes nextline character
        switch (choice) {
            case 1: 
                listElectronics();
                break;
            case 2:
                listClothing();
                break;
            default: 
                System.out.println("Enter a valid choice");
        }
    }

    @Override   // override abstract method of interface and adds a product to cart
    public void addToCart(Product product) {
        cart.add(product);
    }

    @Override // override abstract method of interface 
    public void placeOrder() {
        System.out.println("Register first...");
    }

    //method to show electronics products
    public void listElectronics(){
        for(Product product : products){
            if(product.getCategory().equals("electronics")){
                product.displayProductDetails();
                System.out.println("*******************************");
            }
        }
    }

    //method to show clothing products
    public void listClothing(){
        for(Product product : products){
            if(product.getCategory().equals("clothing")){
                product.displayProductDetails();
                System.out.println("*******************************");
            }
        }
    }
}

// RegisteredUser class that implements the User interface
class RegisteredUser extends Stock implements User {
    Scanner scanner = new Scanner(System.in);
    private List<Product> cart; // List of products
    private List<Order> orderHistory; // List to store the order history
    private String username; // New field to hold the username
    private String password; // New field to hold the password

    public RegisteredUser(String username, String password) {
        this.username = username;
        this.password = password;
        cart = new ArrayList<>();
        orderHistory = new ArrayList<>();
    }

    // Method to register a new user account
    public static RegisteredUser registerNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        return new RegisteredUser(username, password);
    }

    // constructor that initializes the registered user
    public RegisteredUser() {
        cart = new ArrayList<>();
        orderHistory = new ArrayList<>();
    }


    // Method to update username
    public void updateUsername() {
        System.out.println("Enter new username: ");
        String newUsername = scanner.next();
        setUsername(newUsername);
        System.out.println("Username updated successfully!");
    }

    // Method to update password
    public void updatePassword() {
        System.out.println("Enter new password: ");
        String newPassword = scanner.next();
        setPassword(newPassword);
        System.out.println("Password updated successfully!");
    }

    //method to setUsername(Update it)
    public void setUsername(String username) {
        this.username = username;
    }

    //method to setPassword(Update it)
    public void setPassword(String password) {
        this.password = password;
    }
    //return username
    public String getUsername() {
        return username;
    }

    @Override // overidden method from User interface
    public void browseProducts() {
        System.out.println("What category you want to browse?");
        System.out.println("Press 1. for electronics category");
        System.out.println("Press 2. for clothing category");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: 
                listElectronics();
                break;
            case 2:
                listClothing();
                break;
            default: 
                System.out.println("Enter a valid choice");
        }
    }

     //method to show electronics products
     public void listElectronics(){
        for(Product product : products){
            if(product.getCategory().equals("electronics")){
                product.displayProductDetails();
                System.out.println("*******************************");
            }
        }
    }

    //method to show clothing products
    public void listClothing(){
        for(Product product : products){
            if(product.getCategory().equals("clothing")){
                product.displayProductDetails();
                System.out.println("*******************************");
            }
        }
    }

    @Override // overidden method from User interface
    public void addToCart(Product product) {
        cart.add(product);
    }

    // method that returns total amount for all products in cart
    public int priceOfCart(List<Product> cart) {
        int total = 0;
        for(Product product : cart)
            total +=product.calculateFinalPrice();
        return total;
    }

    @Override  // overidden method from User interface
    public void placeOrder() {
        orderHistory.add(new Order(cart, new Date(), priceOfCart(cart)));
        System.out.println("Order placed successfully");
        cart.clear();  // clears the cart elements
    }
    // displays the order history of the registered user
    public void viewOrderHistory() {
        for(Order order : orderHistory){
            order.displayOrderDetails();
            System.out.println("****************************************");
        }
    }
}

// Order class
class Order {
    private List<Product> products; // List of products in the order
    private Date orderDate; // Date object to store date of order placement
    private double totalAmount; // total amount of order placed

    // constructor to initialize an order
    public Order(List<Product> products, Date orderDate, double totalAmount) {
        this.products = products;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
    // method to display order details of user
    public void displayOrderDetails() {
        for(Product product : products) 
        System.out.println(product.getProductName());
        System.out.println("Order Date : " + orderDate);
        System.out.println("Total: ₹" + totalAmount );
    }

}


