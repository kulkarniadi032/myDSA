
import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

    public void sorting(int arr[][], int columnNumber) {
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[columnNumber - 1] < o2[columnNumber - 1]) {
                    return 2;
                } else {
                    return -1;
                }
                // return 0;
            }

        });
    }

    int totalCost = 0;

    public void totalCost(int arr[][], int slots) {
        int count = slots;

        int newArr[] = new int[slots];
        for (int i = 0; i < arr.length; i++) {
            // System.out.println(i);
            if (arr[i][1] <= slots && count > 0) {
                for (int j = arr[i][1] - 1; j >= 0; j--) {
                    if (newArr[j] == 0) {
                        newArr[j] = arr[i][0];
                        // System.out.println(newArr[j]);
                        // System.out.println(j);
                        count--;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            totalCost += newArr[i];
        }
        System.out.println("Total cost is:  " + totalCost);
    }

    public static void main(String[] args) {
        int arr[][] = { { 25, 4 }, { 35, 7 }, { 40, 4 }, { 30, 7 }, { 18, 1 }, { 25, 4 }, { 33, 6 }, { 43, 5 },
                { 19, 3 }, { 25, 6 } };
        int col = 1;
        JobSequencing j1 = new JobSequencing();
        j1.sorting(arr, col);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        j1.totalCost(arr, 7);
    }
}

// test case1 :
// profit : 35,30,20,12,5,15,25
// slots:3,4,2,1,2,3,4
// ans : 110

// test case2 :
// profit : 100,19,27,25,15
// slots:2,1,2,1,3
// ans : 142

// test case3 :
// profit : 15,20,30,18,18,10,23,16,25
// slots:7,2,5,3,4,5,2,7,3
// ans : 147

// test case4 :
// profit : 25,35,40,30,18,25,33,43,19,25
// slots:4,7,4,7,1,4,6,5,3,6
// ans : 231
