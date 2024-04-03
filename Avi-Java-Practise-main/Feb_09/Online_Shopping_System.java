package Feb_09;


//Design and implement a Java application for an Online Shopping System that encapsulates the
// core Object-Oriented Programming (OOP) principles: encapsulation, inheritance, polymorphism, and abstraction.
// The system should manage products, orders, and users, providing functionality to add products, place orders,
// and manage user accounts.Scenario:
//You are responsible for creating a software system for an online retailer. This system must manage a catalog
// of products, process customer orders, and handle user account creation and management.
// The goal is to design a system that is flexible enough to accommodate future expansion,
// such as adding new types of products or different user roles.Requirements:
//
//Encapsulation: Use private fields to protect the data within your classes and provide public methods to access
// and modify this data.
//Inheritance: Design a base class named Product with common attributes such as productId, productName, and price.
// Then, create specific product classes (e.g., Electronics, Clothing) that inherit from Product and add unique
// attributes or behaviors.
//Polymorphism: Implement polymorphic behavior for handling discounts. Each product type can have its own
// method to calculate the final price after applying any discounts specific to that product category.
//Abstraction: Define an interface or an abstract class for user actions such as browsing products,
// adding products to the cart, and checking out. Ensure different user types
// (e.g., Guest, RegisteredUser) implement these actions in ways appropriate to their roles.

//Detailed Description:
//Class Design:
//Product: An abstract class with attributes like productId, productName, and price. Include a method to
// display product details.

//Electronics, Clothing: Classes that inherit from Product and implement additional properties or methods,
// such as warranty period for electronics or size and color for clothing.

//User: An abstract class or interface with methods for user actions. This could include browsing products,
// adding items to a shopping cart, and placing orders.

//Guest, RegisteredUser: Classes that implement the User interface, with RegisteredUser having additional
// features like order history.

//Order: A class to represent customer orders, containing order details such as the list of products, order date,
// and total amount.

//Functionality:
//Product management: Adding new products to the system, updating product details.
//User account management: Creating new user accounts, updating user information.
//Shopping process: Browsing products, adding products to the cart, and placing orders.
//Task:
//Implement the system as described, focusing on the use of OOP concepts to structure your solution.
//Your application should include a main class that demonstrates creating products, registering users,
// and processing orders.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//PRODUCT abstract class
abstract class Product{
    private static int productID = 0;
    private String productName;
    private double price;

    public Product( String productName, double price)
    {
        Product.productID += 1;
        this.productName = productName;
        this.price = price;
    }

    //getters for id, name , price
    public int getProductID()
    {
        return this.productID;
    }
    public String getProductName()
    {
        return this.productName;
    }
    public int getPrice()
    {
        return this.price;
    }

    abstract void productDetails();

}

//ELECTRONINCS class inheriting product
class Electronic extends Product{
    private int warrantyPeriod;

    public Electronic( String productName, double price, int warrantyPeriod)
    {
        super( productName, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    //getter for warrantyperiod
    public int getWarrantyPeriod()
    {
        return this.warrantyPeriod;
    }

    @Override
    public void productDetails()
    {
        System.out.println("Product Description: \n\n" + "Product Name -> " + this.getProductID() + "\nPrice -> " + this.getPrice() + "Warranty Period -> " + this.getWarrantyPeriod() + "\n");
    }
}

//CLOTHING class inheriting product as well
class Clothing extends Product{
    private String size;
    private String color;
    public Clothing( String productName, double price, String size, String color)
    {
        super( productName, price);
        this.size = size;
        this.color = color;
    }
    //getter for size and color
    public String getSize()
    {
        return this.size;
    }
    public String getColor()
    {
        return this.color;
    }

    @Override
    public void productDetails()
    {
        System.out.println("Product Description: \n\n" + "Product Name -> " + this.getProductID() + "\nPrice -> " + this.getPrice() + "\nSize -> " + this.getSize() + "\nColor -> " + this.getColor() + "\n");
    }
}

//manage products
class ManageProduct{
    private Map<Integer, Product> productList = new HashMap<>();

    public void addProduct(Product product)
    {
        productList.put(product.getProductID(), product);
    }
    public Product getProductById(int productId)
    {
        return productList.get(productId);
    }
}

interface User{
    void browseProducts(ManageProduct manageProduct, int productId);
    void addToCart(Product product);
    void placeOrder();
}
//guest class for new user
class Guest implements User{

    private List<Product> cart = new ArrayList<>();

    @Override
    public void browseProducts() {
        System.out.println("Browsing products as a guest.");
    }

    @Override
    public void addToCart(Product product) {
        cart.add(product);
        System.out.println(product.getProductName() + " successfully added to cart.");
    }

    @Override
    public void placeOrder() {
        System.out.println("Cannot place order! Please register to proceed further");
    }
}

//Registered user class implementing User
class RegisteredUser implements User{
    private List<Product> cart = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();
    private boolean isRegistered = false;
    private String userName;

    public RegisteredUser(String userName)
    {
        this.userName = userName;
    }
    @Override
    public void browseProducts(ManageProduct manageProduct, int productId) {
        Product product = manageProduct.getProductById(productId);
        if(product != null)
        {
            product.productDetails();
        }
        else System.out.println("Sorry!, Product not found.");
    }

    @Override
    public void addToCart(Product product) {
        cart.add(product);
        System.out.println(product.getProductName() + " successfully added to cart.");
    }

    @Override
    public void placeOrder() {
        if(isRegistered)
        {
            if(  !cart.isEmpty())
            {
                Order order = new Order(cart, new Date());
                orderHistory.add(order);
                System.out.println("Your order is placed successfully");
            }
            else System.out.println("Cart is empty.");
        }
        else System.out.println("Please register yourself to proceed further");
    }

    //method to register user
    public void register()
    {
        isRegistered = true;
        System.out.println("User registered successfully");
    }

    public void viewOrderHistory(){
        System.out.println("\nOrder History:");
        for(Order order: orderHistory) order.orderDetails();
    }
}

//Order class
class Order{
    private static int orderID = 0;
    private List<Product> products;
    private Date orderDate;

    public Order(List<Product> products, Date orderDate)
    {
        Order.orderID += 1;
        this.products = products;
        this.orderDate = orderDate;
    }

    //getter for order id
    public int getOrderID()
    {
        return Order.orderID;
    }

    //to display the order products list
    public void orderDetails()
    {
        System.out.println("Order ID: " + orderID + ", Order Date: " + orderDate);
        System.out.println("Products in the order");
        for(Product product: products)
        {
            product.productDetails();
        }
        System.out.println("Total Price = Rs. " + calculateTotalPrice() + "/-");
    }

    private double calculateTotalPrice()
    {
        double totalPrice = 0;
        for(Product product: products)
        {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

}

public class Online_Shopping_System {
    static final Scanner sc = new Scanner(System.in);
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
// Create a product catalog
        ManageProduct productManager = new ManageProduct();

        // Add electronic products
        Electronic laptop = new Electronic("Laptop", 50000, 2);
        Electronic smartphone = new Electronic("Smartphone", 20000, 1);
        productManager.addProduct(laptop);
        productManager.addProduct(smartphone);

        // Add clothing products
        Clothing tShirt = new Clothing("T-Shirt", 1000, "M", "Blue");
        Clothing jeans = new Clothing("Jeans", 2000, "32", "Black");
        productManager.addProduct(tShirt);
        productManager.addProduct(jeans);

        // User interactions
        Guest guest = new Guest();
        guest.browseProducts(productManager, laptop.getProductID());
        guest.addToCart(laptop);

        // Register a user
        RegisteredUser user = new RegisteredUser("John");
        user.register();

        // Registered user interactions
        user.browseProducts(productManager, tShirt.getProductID());
        user.addToCart(tShirt);
        user.placeOrder();

        // View order history for registered user
        user.viewOrderHistory();

    }

}
