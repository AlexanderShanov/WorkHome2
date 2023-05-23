package Main;

import java.util.List;

public class Rubles implements UnitOfMeasure{

    @Override
    public String getUnitOfMeasureString(List<Param> thousands, String number) {

        if(thousands.size() != 0)
        {
            Param param = thousands.get(0);
            if(param.getNumber10() == 1){
                return "рублей";
            }
            else{
                if(param.getNumber1() == 1) return "рубль";
                else if (param.getNumber1() == 2 || param.getNumber1() == 3 || param.getNumber1() == 4) return "рубля";
                else return "рублей";
            }

        }

        return null;
    }
}
