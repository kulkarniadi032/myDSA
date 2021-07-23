public class Quick {
    public int partition(int arr[], int low, int high) {

        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while (arr[i] <= pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public void quicksorting(int arr[], int l, int h) {
        if (l < h) {
            int j = partition(arr, l, h);
            quicksorting(arr, l, j - 1);
            quicksorting(arr, j + 1, h);

        }
    }

    public void printArray(int arr[]) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 20, 30, 80, 40, 10, 100 };
        System.out.println("Given array elements are:");
        Quick q1 = new Quick();
        q1.printArray(arr);
        q1.quicksorting(arr, 0, arr.length - 1);
        System.out.println("Given array elements are sorted using quicksort:");
        q1.printArray(arr);
    }
}
