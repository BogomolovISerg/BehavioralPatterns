package Command;

public class TurnOff implements CommandIn{

    protected Bulb bulb;

    public TurnOff(Bulb bulb){
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        new TurnOff(this.bulb);
    }

    @Override
    public void undo() {
        new TurnOn(this.bulb);
    }

    @Override
    public void redo() {
        execute();
    }
}
