import java.util.Arrays;
import java.util.Comparator;

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
        Knapsack k1 = new Knapsack();

        // for print the Profits array elements
        System.out.println("Profits are: ");
        float profitArr[] = { 40, 30, 20 };
        k1.printProfitArray(profitArr);
        System.out.println();
        // for print the weight array elements
        System.out.println("Weights are: ");
        float weightArr[] = { 20, 10, 5 };
        k1.printWeightArray(weightArr);
        // for find the p/w value
        System.out.println();
        float newArr[][] = { { 40, 20, 0 }, { 30, 10, 0 }, { 20, 5, 0 } };
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
            if (columnSum <= 20) {
                columnSum += newArr[i][1];
                if (columnSum <= 20) {
                    totalProfit += (newArr[i][0]);
                }
            } else {
                float newColumnSum = columnSum - newArr[i - 1][1];
                float newColumnSum1 = 20 - newColumnSum;
                totalProfit += ((newColumnSum1 / newArr[i][1]) * newArr[i][0]);
                j = 0;
            }
        }
        if (j == newArr.length) {
            if (columnSum <= 20) {
                columnSum += newArr[j - 1][1];
                if (columnSum <= 20) {
                    totalProfit += (newArr[j - 1][0]);
                }
            } else {
                float newColumnSum = columnSum - newArr[(j - 1)][1];
                float newColumnSum1 = 20 - newColumnSum;
                totalProfit += ((newColumnSum1 / newArr[j - 1][1]) * newArr[j - 1][0]);
            }
        }
        System.out.println();
        System.out.println("Total profit is: " + totalProfit);
    }
}
