import java.util.UUID;

public class Account{
    private final UUID accountNumber;
    private String owner;
    private double balance;

    public Account(String owner, double balance){
        this.owner = owner;
        this.balance = balance;
        accountNumber = UUID.randomUUID();
    }

    //Provides account info
    @Override
    public String toString() {
        return String.format("\tOwner: %16s\n\tBalance: $ %12.2f\n\tID: %s", owner, balance, accountNumber.toString());
    }

    public boolean equals(UUID accountNumber){
        return this.accountNumber == accountNumber;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof Account){
//            UUID otherAccountNumber = ((Account) obj).accountNumber;
//            return accountNumber == otherAccountNumber;
//        }
//        return false;
//    }

    public void withdrawAmount(double amount) throws IllegalArgumentException {
        try{
            if(amount > 0){
                setBalance(balance - amount);
            }else{
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("You must provide a positive balance to have withdrawn. ");
        }
    }

    public void depositAmount(double amount) throws IllegalArgumentException {
        try{
            if(amount > 0){
                setBalance(balance + amount);
            }else{
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("You must provide a positive balance to have deposited. ");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }
}
