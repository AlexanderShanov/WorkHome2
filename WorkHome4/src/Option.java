public class Option {
    private boolean Correct;
    private String Text;
    public Option(boolean correct, String text){
        Correct = correct;
        Text = text;
    }

    public boolean getCorrect(){
        return Correct;
    }
    public String getText(){
        return Text;
    }
}
