import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private Map<Client, List<Account>> accounts;
    private Map<Account, Client> clients;

    public Bank(){
        accounts = new HashMap();
        clients = new HashMap();
    }

    public void AddClient(String name, int dateOfBirth){

        Client clientNew = new Client(name, dateOfBirth);
        accounts.put(clientNew, new ArrayList<>());
        System.out.println("Добавлен клиет " + name);
    }
    public void AddAcount(int accountId, String clientName, int balance){
        Client client = null;
        for(Client clientCurrent: accounts.keySet()){
            if(clientCurrent.getName() == clientName) {
                client = clientCurrent;
                break;
            }
        }
        if(client != null){
            Account account = new Account(accountId, client, balance);
            if(clients.containsKey(account)){
                System.out.println("счет с таким id уже существует");
            }
            else{
                accounts.get(client).add(account);
                clients.put(account, client);
                System.out.println("Добавлен счет с id " + accountId + " c балансом " + balance);
            }

        }
        else{
            System.out.println("Такой клиент не сущемт");
        }


    }

    public List<Account> getAcounts(Client client){

        return accounts.get(client);
    }
    public Client findClient(Account account){

        return clients.get(account);
    }


    public static Bank TestDataInBank(){
        Bank bank = new Bank();
        bank.AddClient("Alex", 1991);
        bank.AddAcount(1, "Alex", 100);
        bank.AddAcount(2, "Alex", 200);
        bank.AddClient("Dima", 1978);
        bank.AddAcount(3, "Dima", 100);
        bank.AddAcount(4, "Dima", 300);
        bank.AddAcount(5, "Dima", 400);
        bank.AddClient("Gleb", 1978);
        bank.AddAcount(6, "Gleb", 400);

        return bank;

    }

}
