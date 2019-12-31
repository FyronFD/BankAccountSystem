import java.util.UUID;

public class Main {

    public static void main(String[] args) throws AccountNotFoundException, NullPointerException{
        Bank bank1 = new Bank("American Bank");
        Bank bank2 = new Bank("Canadian Bank");
        Bank bank3 = new Bank("Mexican Bank");

        //Uncomment the code in the try block for AccountNotFoundException
        try{
            String owner = "Dude Person";
            UUID accountID1 = bank1.createNewAccount(owner);
//            owner = "lmao get hecked";
            bank1.retrieveAccount(owner).depositAmount(1000000);
            double balanceAccount1 = bank1.retrieveAccount(owner).getBalance();
            System.out.printf("Balance: $%12.2f\n", balanceAccount1);

            bank1.retrieveAccount(accountID1).withdrawAmount(500);
//            UUID notCorrect = UUID.randomUUID();
//            balanceAccount1 = bank1.retrieveAccount(notCorrect).getBalance();
            balanceAccount1 = bank1.retrieveAccount(accountID1).getBalance();
            System.out.printf("Balance: $%12.2f\n", balanceAccount1);

//            System.out.println("\nAccount as string: \n" + bank1.retrieveAccount(accountID1).toString());
        }catch (NullPointerException e){
            System.out.println("The account could not be successfully retrieved, Terminating program.");
        }

    }
}
