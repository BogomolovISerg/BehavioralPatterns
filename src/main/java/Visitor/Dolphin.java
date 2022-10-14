package Visitor;

public class Dolphin implements Animal{
    @Override
    public void accept(AnimalOperation operation) {
        operation.visitDolphin(this);
    }

    public void speak(){
        System.out.println("Tuut tuttu tuutt!");
    }
}
