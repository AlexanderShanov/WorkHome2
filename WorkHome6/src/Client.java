import java.util.Objects;

public class Client {
    private String name;
    private int dateOfBirth;

    public Client(String name, int dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Client(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int getDateOfBirth(){
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Client client = (Client)o;

        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString(){
        return name;
    }

}
