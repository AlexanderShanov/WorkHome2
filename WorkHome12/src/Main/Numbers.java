package Main;

import java.util.*;

public class Numbers {
    UnitOfMeasure unitOfMeasure;
    Map<Integer, String> numberStringWomen;
    Map<Integer, String> numberStringMan;
    Map<Integer, String> exponentString;
    Map<Integer, String> exponent2String;
    Map<Integer, String> exponent3String;

    List<Param> thousands;


    public Numbers(UnitOfMeasure unitOfMeasure){
        this.unitOfMeasure = unitOfMeasure;
        MapInint();
    }

    


    public String getNumberWordSring(String numberString){
        thousands = new ArrayList<>();
        String str = "";
        try{
            str = NumberWord(numberString) + " " + unitOfMeasure.getUnitOfMeasureString(thousands, numberString);
        }
        catch(Exception e){
            return e.toString();
        }
        return str.trim();
    }

    private String NumberWord(String numberString){


            String str  = SplitOfThousant(numberString, thousands);
            str += GenerateWord(thousands);
            return str;


    }

    private String SplitOfThousant  (String numberString, List<Param> thousands){
        numberString = numberString.trim();

        if(numberString.length() == 0)  throw new RuntimeException("некоректный ввод");
        char[] array = numberString.toCharArray();

        String str = "";
        int minus = 0;
        if(array[0] == '-'){
            minus = 1; //первый символ в последовательности не читать в цыкле while в нем хранится символ "минус"
            str += "минус";
        }

        int iCurrnet = array.length - 1;
        int i = 0;
        Param param = new Param();;
        do{
            int number = 0;

            try{
                number = Integer.valueOf(String.valueOf(array[iCurrnet]) );
            }
            catch(Exception e)
            {
                 throw new RuntimeException("некоректный ввод");
            }


            if(i == 0){
                param = new Param();
                param.setNumber1(number);

            }

            if(i == 1){
                param.setNumber10(number);
            }

            if(i == 2){
                param.setNumber100(number);
            }

            if(i == 2 || iCurrnet == minus){
                thousands.add(param);
            }

            iCurrnet--;
            i++;
            if(i > 2) i = 0;
        }
        while(iCurrnet >= minus);

        return str;
    }

    private String GenerateWord(List<Param> thousands){

        for (int i = 0; i< thousands.size(); i++) {

            Param param = thousands.get(i);
            String maltissa ="";

            if(param.getNumber100() != 0){
                maltissa +=  numberStringMan.get(param.getNumber100() * 100);
            }
            if(param.getNumber10() != 0){
                if(param.getNumber10() == 1) {
                    maltissa += (param.getNumber100() == 0 ? "" : " ") +  numberStringMan.get(param.getNumber10() * 10 + param.getNumber1());//от 10 до 19
                }
                else{
                    maltissa +=(param.getNumber100() == 0 ? "" : " ") +    numberStringMan.get(param.getNumber10() * 10);
                }

            }

            if(param.getNumber1() != 0 && param.getNumber10() != 1){
                maltissa += (param.getNumber100() == 0 && param.getNumber10() == 0 ? "" : " ");
                if(i == 1 && (param.getNumber1() == 1 || param.getNumber1() == 2))                {
                    maltissa +=  numberStringWomen.get(param.getNumber1() );
                }
                else{
                    maltissa +=  numberStringMan.get(param.getNumber1() );
                }

            }

            param.setMantissa(maltissa);
            if (i > 0){

                if(param.getNumber10() == 1) {
                    param.setExponent(exponent3String.get(i * 3));
                }
                else{
                    if(param.getNumber1() == 1){
                        param.setExponent(exponentString.get(i * 3));
                    }
                    else if(param.getNumber1() > 1 && param.getNumber1() < 5){
                        param.setExponent(exponent2String.get(i * 3));
                    }
                    else{
                        param.setExponent(exponent3String.get(i * 3));
                    }
                }
            }
            else
                param.setExponent("0");
        }

        String str = "";
        if(thousands.size()<=41)
        {
            for (int i = thousands.size() - 1; i >= 0; i--){
                str += thousands.get(i).toString();
            }

        }
        else{
            throw new RuntimeException("слишком большое число");
        }

        if( str.length() == 0) str = numberStringMan.get(0) ;


        return str;
    }

    private void MapInint(){

        numberStringWomen = new HashMap<>();
        numberStringWomen.put(1, "одна");
        numberStringWomen.put(2, "две");

        numberStringMan = new HashMap<>();
        numberStringMan.put(0, "нуль");
        numberStringMan.put(1, "один");
        numberStringMan.put(2, "два");
        numberStringMan.put(3, "три");
        numberStringMan.put(4, "четыре");
        numberStringMan.put(5, "пять");
        numberStringMan.put(6, "шесть");
        numberStringMan.put(7, "семь");
        numberStringMan.put(8, "восемь");
        numberStringMan.put(9, "девять");
        numberStringMan.put(10, "десять");

        numberStringMan.put(11, "одиннадцать");
        numberStringMan.put(12, "двенадцать");
        numberStringMan.put(13, "тринадцать");
        numberStringMan.put(14, "четырнадцать");
        numberStringMan.put(15, "пятнадцать");
        numberStringMan.put(16, "шестнадцать");
        numberStringMan.put(17, "семнадцать");
        numberStringMan.put(18, "восемнадцать");
        numberStringMan.put(19, "девятнадцать");
        numberStringMan.put(20, "двадцать");

        numberStringMan.put(30, "тридцать");
        numberStringMan.put(40, "сорок");
        numberStringMan.put(50, "пятьдесят");
        numberStringMan.put(60, "шестьдесят");
        numberStringMan.put(70, "семьдесят");
        numberStringMan.put(80, "восемьдесят");
        numberStringMan.put(90, "девяносто");

        numberStringMan.put(100, "сто");
        numberStringMan.put(200, "двести");
        numberStringMan.put(300, "триста");
        numberStringMan.put(400, "четыреста");
        numberStringMan.put(500, "пятьсот");
        numberStringMan.put(600, "шестьсот");
        numberStringMan.put(700, "семьсот");
        numberStringMan.put(800, "восемьсот");
        numberStringMan.put(900, "девятьсот");


        exponentString = new HashMap<>();
        exponentString.put(3, "тысяча");
        exponentString.put(6, "миллион");
        exponentString.put(9, "миллиард");
        exponentString.put(12, "триллион");
        exponentString.put(15, "квадриллион");
        exponentString.put(18, "квинтиллион");
        exponentString.put(21, "секстиллион");
        exponentString.put(24, "септиллион");
        exponentString.put(27, "октиллион");
        exponentString.put(30, "нониллион");
        exponentString.put(33, "дециллион");
        exponentString.put(36, "ундециллион");
        exponentString.put(39, "дуодециллион");
        exponentString.put(42, "тредециллион");
        exponentString.put(45, "кваттуордециллион");
        exponentString.put(48, "квиндециллион");
        exponentString.put(51, "сексдециллион");
        exponentString.put(54, "септдециллион");
        exponentString.put(57, "октодециллион");
        exponentString.put(60, "новемдециллион");
        exponentString.put(63, "вигинтиллион");
        exponentString.put(66, "унвигинтиллион");
        exponentString.put(69, "дуовигинтиллион");
        exponentString.put(72, "тревигинтиллион");
        exponentString.put(75, "кваттуорвигинтиллион");
        exponentString.put(78, "квинвигинтиллион");
        exponentString.put(81, "сексвигинтиллион");
        exponentString.put(84, "септенвигинтиллион");
        exponentString.put(87, "октовигинтиллион");
        exponentString.put(90, "новемвигинтиллион");
        exponentString.put(93, "тригинтиллион");
        exponentString.put(96, "унтригинтиллион");
        exponentString.put(99, "дуотригинтиллион");
        exponentString.put(102, "третригинтиллион");
        exponentString.put(105, "кваттуортригинтиллион");
        exponentString.put(108, "квинтригинтиллион");
        exponentString.put(111, "секстригинтиллион");
        exponentString.put(114, "септентригинтиллион");
        exponentString.put(117, "октотригинтиллион");
        exponentString.put(120, "новемтригинтиллион");
        exponentString.put(123, "квадрагинтиллион");

        exponent2String = new HashMap<>();
        exponent2String.put(3, "тысячи");
        exponent2String.put(6, "миллиона");
        exponent2String.put(9, "миллиарда");
        exponent2String.put(12, "триллиона");
        exponent2String.put(15, "квадриллиона");
        exponent2String.put(18, "квинтиллиона");
        exponent2String.put(21, "секстиллиона");
        exponent2String.put(24, "септиллиона");
        exponent2String.put(27, "октиллиона");
        exponent2String.put(30, "нониллиона");
        exponent2String.put(33, "дециллиона");
        exponent2String.put(36, "ундециллиона");
        exponent2String.put(39, "дуодециллиона");
        exponent2String.put(42, "тредециллиона");
        exponent2String.put(45, "кваттуордециллиона");
        exponent2String.put(48, "квиндециллиона");
        exponent2String.put(51, "сексдециллиона");
        exponent2String.put(54, "септдециллиона");
        exponent2String.put(57, "октодециллиона");
        exponent2String.put(60, "новемдециллиона");
        exponent2String.put(63, "вигинтиллиона");
        exponent2String.put(66, "унвигинтиллиона");
        exponent2String.put(69, "дуовигинтиллиона");
        exponent2String.put(72, "тревигинтиллиона");
        exponent2String.put(75, "кваттуорвигинтиллиона");
        exponent2String.put(78, "квинвигинтиллиона");
        exponent2String.put(81, "сексвигинтиллиона");
        exponent2String.put(84, "септенвигинтиллиона");
        exponent2String.put(87, "октовигинтиллиона");
        exponent2String.put(90, "новемвигинтиллиона");
        exponent2String.put(93, "тригинтиллиона");
        exponent2String.put(96, "унтригинтиллиона");
        exponent2String.put(99, "дуотригинтиллиона");
        exponent2String.put(102, "третригинтиллиона");
        exponent2String.put(105, "кваттуортригинтиллиона");
        exponent2String.put(108, "квинтригинтиллиона");
        exponent2String.put(111, "секстригинтиллиона");
        exponent2String.put(114, "септентригинтиллиона");
        exponent2String.put(117, "октотригинтиллиона");
        exponent2String.put(120, "новемтригинтиллиона");
        exponent2String.put(123, "квадрагинтиллиона");

        exponent3String = new HashMap<>();
        exponent3String.put(3, "тысячь");
        exponent3String.put(6, "миллионов");
        exponent3String.put(9, "миллиардов");
        exponent3String.put(12, "триллионов");
        exponent3String.put(15, "квадриллионов");
        exponent3String.put(18, "квинтиллионов");
        exponent3String.put(21, "секстиллионов");
        exponent3String.put(24, "септиллионов");
        exponent3String.put(27, "октиллионов");
        exponent3String.put(30, "нониллионов");
        exponent3String.put(33, "дециллионов");
        exponent3String.put(36, "ундециллионов");
        exponent3String.put(39, "дуодециллионов");
        exponent3String.put(42, "тредециллионов");
        exponent3String.put(45, "кваттуордециллионов");
        exponent3String.put(48, "квиндециллионов");
        exponent3String.put(51, "сексдециллионов");
        exponent3String.put(54, "септдециллионов");
        exponent3String.put(57, "октодециллионов");
        exponent3String.put(60, "новемдециллионов");
        exponent3String.put(63, "вигинтиллионов");
        exponent3String.put(66, "унвигинтиллионов");
        exponent3String.put(69, "дуовигинтиллионов");
        exponent3String.put(72, "тревигинтиллионов");
        exponent3String.put(75, "кваттуорвигинтиллионов");
        exponent3String.put(78, "квинвигинтиллионов");
        exponent3String.put(81, "сексвигинтиллионов");
        exponent3String.put(84, "септенвигинтиллионов");
        exponent3String.put(87, "октовигинтиллионов");
        exponent3String.put(90, "новемвигинтиллионов");
        exponent3String.put(93, "тригинтиллионов");
        exponent3String.put(96, "унтригинтиллионов");
        exponent3String.put(99, "дуотригинтиллионов");
        exponent3String.put(102, "третригинтиллионов");
        exponent3String.put(105, "кваттуортригинтиллионов");
        exponent3String.put(108, "квинтригинтиллионов");
        exponent3String.put(111, "секстригинтиллионов");
        exponent3String.put(114, "септентригинтиллионов");
        exponent3String.put(117, "октотригинтиллионов");
        exponent3String.put(120, "новемтригинтиллионов");
        exponent3String.put(123, "квадрагинтиллионов");

    }

}
