import java.util.Arrays;
import java.util.Comparator;

public class TwoDArraySorting {

    public void sorting(int arr[][], int columnNumber) {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[columnNumber - 1] > o2[columnNumber - 1]) {
                    return 2;
                } else {
                    return -1;
                }
                // return 0;
            }

        });
    }

    public static void main(String[] args) {
        int arr[][] = { { 35, 3 }, { 30, 4 }, { 20, 2 }, { 12, 1 }, { 5, 2 }, { 15, 3 }, { 25, 4 } };
        int col = 1;
        TwoDArraySorting t1 = new TwoDArraySorting();
        t1.sorting(arr, col);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
