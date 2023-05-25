import java.io.File;

public class Main {
    public static void main(String[] args) {

        int successfulResult = 0;
        for(int i = 0; i < 4; i++){
            String info;

            try{
                info = read();
                write(info);
                successfulResult++;
            }
            catch( Exception o){
                System.out.println(o);
            }
        }
        System.out.println( "Успешных записей: " + successfulResult);

        System.out.println("Hello world!");
    }

    public static String read(){

        try(FileStreamMy streamMyOut = new FileStreamMy("fileOut.txt")){
            return streamMyOut.read();
        }
        catch (Exception o){
            throw new RuntimeException("not read " + o);
        }
    }

    public static void write(String info){

        try(FileStreamMy streamMyIn = new FileStreamMy("fileIn.txt")){
            streamMyIn.write(info);
        }
        catch (Exception o){
            throw new RuntimeException("not wride " + o);
        }
    }
}