package Strategy;

public class Sorter {

    protected SortStrategy sorter;

    public Sorter(SortStrategy sorter){
        this.sorter = sorter;
    }

    public int[] sort(int[] dataset){
        return this.sorter.sort(dataset);
    }
}
