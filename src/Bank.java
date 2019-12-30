import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    private ArrayList<Account> accounts;
    public String bankName;

    public Bank(String bankName){
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }

    public UUID createNewAccount(String owner, double initialBalance){
        Account account = new Account(owner, initialBalance);
        accounts.add(account);
        return account.getAccountNumber();
    }

    public UUID createNewAccount(String owner){
        Account account = new Account(owner, 0);
        accounts.add(account);
        return account.getAccountNumber();
    }

    public Account retrieveAccount(UUID accountNumber) throws IndexOutOfBoundsException, AccountNotFoundException{
        Account desiredAccount = null;
        try{
            if(accounts.size() > 0){
                for(Account account : accounts){
                    if(account.getAccountNumber().equals(accountNumber)){
                        desiredAccount = account;
                    }
                }
                if(desiredAccount == null){
                    throw new AccountNotFoundException();
                }
            }else{
                throw new IndexOutOfBoundsException();
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("There are no accounts registered at this bank.");
        }catch (AccountNotFoundException e){
            System.out.println("An account with that ID could not be found.");
        }
        return desiredAccount;
    }

    public Account retrieveAccount(String owner) throws IndexOutOfBoundsException, AccountNotFoundException{
        Account desiredAccount = null;
        try{
            if(accounts.size() > 0){
                for(Account account : accounts){
                    if(account.getOwner().equals(owner)){
                        desiredAccount = account;
                    }
                }
                if(desiredAccount == null){
                    throw new AccountNotFoundException();
                }
            }else{
                throw new IndexOutOfBoundsException();
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("There are no accounts registered at this bank.");
        }catch (AccountNotFoundException e){
            System.out.println("An account with that owner's name could not be found.");
        }
        return desiredAccount;
    }

    public void removeAccount(UUID accountNumber) throws IndexOutOfBoundsException, AccountNotFoundException{
        boolean accountFound = false;
        int index = 0;
        try{
            if(accounts.size() > 0){
                for(Account account : accounts){
                    if(account.getAccountNumber().equals(accountNumber)){
                        accountFound = true;
                        break;
                    }
                    index++;
                }
                if(accountFound){
                    accounts.remove(index);
                }else{
                    throw new AccountNotFoundException();
                }
            }else{
                throw new IndexOutOfBoundsException();
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("There are no accounts registered at this bank.");
        }catch (AccountNotFoundException e){
            System.out.println("An account with that ID could not be found.");
        }
    }

    public void removeAccount(String owner) throws IndexOutOfBoundsException, AccountNotFoundException{
        boolean accountFound = false;
        int index = 0;
        try{
            if(accounts.size() > 0){
                for(Account account : accounts){
                    if(account.getOwner().equals(owner)){
                        accountFound = true;
                        break;
                    }
                    index++;
                }
                if(accountFound){
                    accounts.remove(index);
                }else{
                    throw new AccountNotFoundException();
                }
            }else{
                throw new IndexOutOfBoundsException();
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("There are no accounts registered at this bank.");
        }catch (AccountNotFoundException e){
            System.out.println("An account with that owner's name could not be found.");
        }
    }
}
