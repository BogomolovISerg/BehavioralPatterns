package Strategy;

public class QuickSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] dataset) {
        System.out.println("Sorting using quick sort");

        if (dataset.length == 0)
            return dataset;

        int low = 0;
        int high = dataset.length-1;

        int middle = low + (high - low) / 2;
        int opora = dataset[middle];

        int i = low, j = high;
        while (i <= j) {
            while (dataset[i] < opora) {
                i++;
            }

            while (dataset[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = dataset[i];
                dataset[i] = dataset[j];
                dataset[j] = temp;
                i++;
                j--;
            }
        }
        return dataset;
    }
}
