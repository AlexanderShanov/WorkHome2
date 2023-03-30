import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.TestDataInBank();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id счета ");

        if(scanner.hasNextInt()){
            Account account = new Account(scanner.nextInt());
            Client client = bank.findClient(account);
            System.out.println("Счет принадлежит: " + client);

            List<Account> accountList = bank.getAcounts(client);
            System.out.println("У клиента " + client + " есть счета: " + accountList);
        }


        System.out.println("Hello world!");
    }
}