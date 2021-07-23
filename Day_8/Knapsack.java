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
        float profitArr[] = { 10, 5, 15, 7, 6, 18, 3 };
        k1.printProfitArray(profitArr);
        System.out.println();
        // for print the weight array elements
        System.out.println("Weights are: ");
        float weightArr[] = { 2, 3, 5, 7, 1, 4, 1 };
        k1.printWeightArray(weightArr);
        // for find the p/w value
        System.out.println();
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
        for (int i = 0; i < newArr.length; i++) {
            columnSum += newArr[i][1];
            if (columnSum <= 16) {
                totalProfit += (newArr[i][1] * newArr[i][2]);
            }
        }

        System.out.println();
        System.out.println("Total profit is: " + totalProfit);
    }
}