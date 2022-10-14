package State;

public class TextEditor {
    protected WritingState state;

    public TextEditor(WritingState state){
        this.state = state;
    }

    public void setState(WritingState state){
        this.state = state;
    }

    public void type(String words){
        this.state.write(words);
    }
}
