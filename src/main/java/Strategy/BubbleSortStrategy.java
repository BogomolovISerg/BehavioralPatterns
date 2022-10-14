package Strategy;

public class BubbleSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] dataset) {
        System.out.println("Sorting using bubble sort");

        for (int out = dataset.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(dataset[in] > dataset[in + 1]) {
                    int dummy = dataset[in];
                    dataset[in] = dataset[in+1];
                    dataset[in+1] = dummy;
                }
            }
        }
        return dataset;
    }

}
