package test;

import Main.Numbers;
import Main.Rubles;

public class NumbersTest {

    public void Test1(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("один рубль", number.getNumberWordSring("1"));
    }

    public void Test2(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("минус один рубль", number.getNumberWordSring("-1"));
    }

    public void Test3(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("двенадцать рублей", number.getNumberWordSring("12"));
    }

    public void Test4(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("сто двадцать три рубля", number.getNumberWordSring("123"));
    }

    public void Test5(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("одна тысяча двести тридцать четыре рубля", number.getNumberWordSring("1234"));
    }

    public void Test6(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("двенадцать тысячь триста сорок пять рублей", number.getNumberWordSring("12345"));
    }

    public void Test7(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("нуль рублей", number.getNumberWordSring("0"));
    }

    public void Test8(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("одна тысяча рублей", number.getNumberWordSring("1000"));
    }
    public void Test9(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("одиннадцать септиллионов сто одиннадцать секстиллионов сто одиннадцать квинтиллионов сто одиннадцать квадриллионов сто одиннадцать триллионов сто одиннадцать миллиардов сто одиннадцать миллионов сто одиннадцать тысячь сто одиннадцать рублей", number.getNumberWordSring("11111111111111111111111111"));
    }
    public void Test10(){
        Numbers number = new Numbers(new Rubles());
        test.Assertions.assertEquals("минус сто рублей", number.getNumberWordSring("-100"));
    }
}
