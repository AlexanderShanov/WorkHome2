import java.io.Closeable;
import java.util.Random;

public class FileStreamMy implements Closeable  {
    private String nameFile;
    public FileStreamMy(String nameFile) {
        this.nameFile = nameFile;
        System.out.println("Open file");
    }
    public String read(){

        Random random = new Random();

        if(random.nextBoolean()){
            System.out.println("Read file");
        }
        else{
            throw new RuntimeException();
        }


        return "read 123";
    }
    public void write(String text) throws RuntimeException {

        Random random = new Random();

        if(random.nextBoolean()) {
            System.out.println("Write file "  + text);
        }
        else{
            throw new RuntimeException();
        }

    }

    @Override
    public void close() {
        System.out.println("Closed file auto");
    }
}
