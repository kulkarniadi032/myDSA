class MergeSort {
    public void merging(int arr[], int mid, int low, int high) {
        int arrLength1 = mid - low + 1;
        int arrLength2 = high - mid;

        int leftArr[] = new int[arrLength1];
        int rightArr[] = new int[arrLength2];

        for (int i = 0; i < arrLength1; i++) {
            leftArr[i] = arr[low + i];
        }
        for (int j = 0; j < arrLength2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;

        while (i < arrLength1 && j < arrLength2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;

            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < arrLength1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < arrLength2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    public void sorting(int arr[], int l, int h) {

        if (l < h) {
            int mid = (l + h) / 2;
            sorting(arr, l, mid);
            sorting(arr, mid + 1, h);

            merging(arr, mid, l, h);

        }

    }

    public void printMyArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 35, 6, 1, 9, 75, 100, 4 };
        System.out.println("Elements which we have to sort");
        MergeSort m1 = new MergeSort();
        m1.printMyArray(arr);
        m1.sorting(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("Now sorted elements in array after merge sort:");
        m1.printMyArray(arr);

    }
}