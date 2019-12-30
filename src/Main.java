import java.util.UUID;

public class Main {

    public static void main(String[] args) throws AccountNotFoundException, NullPointerException{
        Bank bank1 = new Bank("American Bank");
        Bank bank2 = new Bank("Canadian Bank");
        Bank bank3 = new Bank("Mexican Bank");

        try{
            String owner = "Dude Person";
            UUID accountID1 = bank1.createNewAccount(owner, 1000000);
//            owner = "lmao get hecked";
            double balanceAccount1 = bank1.retrieveAccount(owner).getBalance();
            System.out.println("Balance: " + balanceAccount1);

            bank1.retrieveAccount(accountID1).withdrawAmount(500);
//            UUID notCorrect = UUID.randomUUID();
//            balanceAccount1 = bank1.retrieveAccount(notCorrect).getBalance();
            balanceAccount1 = bank1.retrieveAccount(accountID1).getBalance();
            System.out.println("Balance: " + balanceAccount1);

            System.out.println("Account as string: " + bank1.retrieveAccount(accountID1).toString());
        }catch (NullPointerException e){
            System.out.println("The account could not be successfully retrieved, Terminating program.");
        }

    }
}
