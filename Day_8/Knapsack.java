import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Knapsack {
    float max = 0;

    public void ratio(float profitArr[], float weightArr[], float newArr[][]) {
        // float acendingRatio[] = {};
        float ratioArray[] = new float[profitArr.length];
        for (int i = 0; i < profitArr.length; i++) {
            ratioArray[i] = profitArr[i] / weightArr[i];
            System.out.print(ratioArray[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < ratioArray.length; i++) {
            newArr[i][2] = ratioArray[i];
        }
        System.out.println();

        for (int i = 0; i < ratioArray.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void printProfitArray(float profitArr[]) {
        int n = profitArr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(profitArr[i] + " ");
        }

    }

    public void printWeightArray(float weightArr[]) {
        int n = weightArr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(weightArr[i] + " ");
        }

    }

    public void sorting(float newArr[][], int columnNumber) {
        Arrays.sort(newArr, new Comparator<float[]>() {

            @Override
            public int compare(float[] o1, float[] o2) {
                if (o1[columnNumber - 1] < o2[columnNumber - 1]) {
                    return 2;
                } else {
                    return -1;
                }
                // return 0;
            }

        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Knapsack k1 = new Knapsack();

        // for print the Profits array elements
        System.out.println("Profits are: ");
        float profitArr[] = { 10, 5, 15, 7, 6, 18, 3 };
        k1.printProfitArray(profitArr);
        System.out.println();
        // for print the weight array elements
        System.out.println("Weights are: ");
        float weightArr[] = { 2, 3, 5, 7, 1, 4, 1 };
        k1.printWeightArray(weightArr);
        // for find the p/w value
        System.out.println();
        System.out.println("enter capacity of knapsack: ");
        float capacity = sc.nextFloat();

        float newArr[][] = { { 10, 2, 0 }, { 5, 3, 0 }, { 15, 5, 0 }, { 7, 7, 0 }, { 6, 1, 0 }, { 18, 4, 0 },
                { 3, 1, 0 } };
        System.out.println("Ratio are");
        k1.ratio(profitArr, weightArr, newArr);
        int col = 3;
        k1.sorting(newArr, col);
        System.out.println();

        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
        float columnSum = 0;
        float totalProfit = 0;
        int j = 0;
        for (int i = 0; i < newArr.length; i++) {
            j++;
            if (columnSum <= capacity) {
                columnSum += newArr[i][1];
                if (columnSum <= capacity) {
                    totalProfit += (newArr[i][0]);
                }
            } else {
                float newColumnSum = columnSum - newArr[i - 1][1];
                float newColumnSum1 = capacity - newColumnSum;
                totalProfit += ((newColumnSum1 / newArr[i][1]) * newArr[i][0]);
                j = 0;
            }
        }
        if (j == newArr.length) {
            if (columnSum <= capacity) {
                columnSum += newArr[j - 1][1];
                if (columnSum <= capacity) {
                    totalProfit += (newArr[j - 1][0]);
                }
            } else {
                float newColumnSum = columnSum - newArr[(j - 1)][1];
                float newColumnSum1 = capacity - newColumnSum;
                totalProfit += ((newColumnSum1 / newArr[j - 1][1]) * newArr[j - 1][0]);
            }
        }
        System.out.println();
        System.out.println("Total profit is: " + totalProfit);
    }
}
// test case1 :
// profit : 40,30,20
// weight : 20,10,5
// capacity : 20
// ans : 60

// test case2:
// profit : 10,5,15,7,6,18,3
// weight : 2,3,5,7,1,4,1
// capacity : 15
// ans : 54

// test case3 :
// profit : 60,100,120
// weight : 10,20,30
// capacity : 50
// ans : 240

// test case4 :
// profit : 60,50,20
// weight : 20,25,5
// capacity : 40
// ans : 110
