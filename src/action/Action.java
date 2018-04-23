package action;
//https://docs.oracle.com/javase/8/docs/technotes/guides/language/generics.html
public abstract class Action {

    private String text;

    public Action(){

    }

    public Action(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void execute();
}
