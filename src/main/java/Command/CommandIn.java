package Command;

public interface CommandIn {

    public void execute();
    public void undo();
    public void redo();
}
