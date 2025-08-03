import java.lang.reflect.Array;
import java.util.Arrays;

public class FractionalKnapsack {

    public static float fractionalKnapsack(int[] weight, int[] value, int capacity){
        float[][] ratios = new float[weight.length][2];

        for (int i = 0; i < ratios.length; i++) {
            ratios[i][0] = i;
            ratios[i][1] = (float) value[i] / weight[i];
        }

        Arrays.sort(ratios, (a, b) -> Float.compare(b[1], a[1]));  //DESC
        float maxValue = 0;

        for (float[] fs : ratios) {
            int i = (int) fs[0];
            if (weight[i] <= capacity) {
                maxValue += value[i];
                capacity -= weight[i];
            }
            else{
                maxValue += fs[1] * capacity;
                capacity = 0;  //optional
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int w = 50;

        System.out.println(fractionalKnapsack(weight, value, w));
    }
}
