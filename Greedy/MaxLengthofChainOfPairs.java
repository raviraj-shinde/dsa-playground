import java.util.Arrays;

public class MaxLengthofChainOfPairs {

    public static int maxLengthOfChainOfPair(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int lastEnd = pairs[0][1];
        int count = 1;

        for (int i = 1; i < pairs.length; i++) {
            if(lastEnd < pairs[i][0]){
                count++;
                lastEnd = pairs[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = {
                { 5, 24 },
                { 39, 60 },
                { 5, 28 },
                { 27, 40 },
                { 50, 90 }
        };

        System.out.println(maxLengthOfChainOfPair(pairs));
    }
}