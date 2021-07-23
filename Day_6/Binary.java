public class Binary {
    public int binarySearch(int arr[], int low, int high, int key) {
        int mid = (low + high) / 2;
        if (key == arr[mid]) {
            return mid;
        } else if (key < arr[mid]) {
            int l = low;
            int h = mid - 1;
            return binarySearch(arr, l, h, key);

        } else if (key > arr[mid]) {
            int l = mid + 1;
            int h = high;
            return binarySearch(arr, l, h, key);
        } else {
            System.out.println("key not found");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Given array elements are:");
        int arr[] = { 15, 42, 82, 96, 101, 102, 503, 10000 };
        int searchKey = 100000;
        int ans = 0;
        Binary b1 = new Binary();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == searchKey) {
                ans = 1;
            }
        }
        if (ans == 1) {

            int finalResult = b1.binarySearch(arr, 0, arr.length - 1, searchKey);
            System.out.println("Given element is at " + finalResult + " position");
        } else {

            System.out.println("given element is not present in list");
        }
    }
}
