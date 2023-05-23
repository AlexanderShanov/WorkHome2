package Main;

public class Param {
    private String Mantissa;
    private String Exponent;

    private String NumberStr;
    private int Number1 = 0;
    private int Number10 = 0;
    private int Number100 = 0;

    public String getMantissa() {
        return Mantissa;
    }

    public void setMantissa(String mantissa) {
        Mantissa = mantissa;
    }

    public String getExponent() {
        return Exponent;
    }

    public void setExponent(String exponent) {
        Exponent = exponent;
    }

    public String getNumberStr() {
        return NumberStr;
    }

    public void setNumberStr(String numberStr) {
        NumberStr = numberStr;
    }

    public int getNumber1() {
        return Number1;
    }

    public void setNumber1(int number1) {
        Number1 = number1;
    }

    public int getNumber10() {
        return Number10;
    }

    public void setNumber10(int number10) {
        Number10 = number10;
    }

    public int getNumber100() {
        return Number100;
    }

    public void setNumber100(int number100) {
        Number100 = number100;
    }
    @Override
    public String toString() {
        if(Number100 != 0 || Number10 != 0 || Number1 != 0)
            return " " +Mantissa +(Exponent != "0" ? (" " + Exponent) : "" )  ;
        else
            return "";
    }
}
