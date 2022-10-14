package Command;

public class TurnOn implements CommandIn{

    protected Bulb bulb;

    public TurnOn(Bulb bulb){
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        new TurnOn(this.bulb);
    }

    @Override
    public void undo() {
        new TurnOff(this.bulb);
    }

    @Override
    public void redo() {
        execute();
    }
}
