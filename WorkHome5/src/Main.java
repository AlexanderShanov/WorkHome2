import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> collection1 = new ArrayList<Integer>();
        List<Integer> collection2 = new ArrayList<Integer>();

        Random random = new Random();

        for(int i = 0; i < 1000; i++){
            int number = random.nextInt();
            collection1.add(number);
            collection2.add(number);
        }

        System.out.println("Колекции до сортировки");
        for(int i = 0; i< collection2.size(); i++){
            System.out.print(collection2.get(i) + " ");
            if((i+1)%10 == 0 ) System.out.println();
        }
        System.out.println();

        long time1 = System.currentTimeMillis();
        Collections.sort(collection1);
        long time2 = System.currentTimeMillis();

        System.out.println("Колекции после сртирвки Collections.sort");
        for(int i = 0; i< collection1.size(); i++){
            System.out.print(collection1.get(i) + " ");
            if((i+1)%10 == 0 ) System.out.println();
        }
        System.out.println();

        long time3 = System.currentTimeMillis();
        for(int i = 0; i<collection2.size(); i++){
            for(int j = 0; j < collection2.size() - 1; j++){
                if(collection2.get(j) > collection2.get(j + 1)){
                    int temp = collection2.get(j);
                    collection2.set(j, collection2.get(j + 1));
                    collection2.set(j + 1, temp);
                }
            }
        }
        long time4 = System.currentTimeMillis();

        System.out.println("Колекции после моей сортировки ");
        for(int i = 0; i< collection2.size(); i++){
            System.out.print(collection2.get(i) + " ");
            if((i+1)%10 == 0 ) System.out.println();
        }
        System.out.println();

        System.out.println("Время работы сортировки Collections.sort:" + (time2 - time1));
        System.out.println("Время работы моей сортировки поплавком" + (time4 - time3));

        System.out.println("Hello world!");
    }
}