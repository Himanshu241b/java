package ATMSimulator;


public abstract class Account {

    private String accountNumber;
    private String pin;
    private String name;
    private double balance;
    private String cardNumber;
    private String ifsc;
    
    
    public Account(String accountNumber,String pin,String cardNumber, String name, double balance, String ifsc) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.ifsc = ifsc;
    }

    public abstract void deposit(double amount);


    public String getName(){
        return name;
    }
    public String getaccountNumber(){
        return accountNumber;
    }
    public String getPin(){
        return pin;
    }
    public double getBalance(){
        return balance;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public String getIfsc(){
        return ifsc;
    }
    //abstract method to return bankname
    abstract public String getBankName();
        
}

//HDFC account
class HDFCAccount extends Account {
    final private String bankName = "hdfc";

    public HDFCAccount(String accountNumber,String pin,String cardNumber, String name, double balance, String ifsc) {
        super(accountNumber, pin,cardNumber, name, balance, ifsc);
    }

    @Override
    public void deposit(double amount) {
        // Implement specific deposit logic
    }
    @Override
    public String getBankName(){
        return bankName;
    }

   
}

//SBIAccount 
class SBIAccount extends Account {
    final private String bankName = "sbi";
    public SBIAccount(String accountNumber, String pin, String cardNumber, String name, double balance, String ifsc) {
        super(accountNumber,pin,cardNumber, name, balance,ifsc);
    }

    @Override
    public void deposit(double amount) {
        // Implement specific deposit logic
    }

    @Override
    public String getBankName(){
        return bankName;
    }
   
}

//ICICIAccount
class ICICIAccount extends Account {
    final private String bankName = "icici";
    public ICICIAccount(String accountNumber, String pin,String cardNumber ,String name,double balance, String ifsc) {
        super(accountNumber, pin,cardNumber, name, balance, ifsc);
    }

    @Override
    public void deposit(double amount) {
        // Implement specific deposit logic
    }

    @Override
    public String getBankName(){
        return bankName;
    }

   
}


