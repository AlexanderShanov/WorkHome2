import java.util.Objects;
public class Account {
    private int id;
    private Client client;
    private int balance;
    public Account(int id, Client client, int balance){
        this.id = id;
        this.client = client;
        this.balance = balance;
    }
    public Account(int id){
        this.id = id;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;

        return Objects.equals(id, account.id);

    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Акаунт id " + id + " Клиет " + client.toString() + " Баланс " + balance;
    }
}
