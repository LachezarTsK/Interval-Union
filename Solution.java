
import java.util.Arrays;

public class Solution {

    /*
    By the problem design on binarysearch.com, we have to work
    around the given method 'public int solve(int[] intervals)'.
    Even though the name 'solve' does not make a lot of sense, 
    it is left as it is, so that the code can be run directly 
    on the website, without any modifications.
     */
    public int[][] solve(int[][] intervals) {
        return findUnionIntevals(intervals);
    }

    /*
    The methods finds all intervals that have intersection between them,
    merges these intervals, and returns the all thus formed intervals
    an a sorted array.
     */
    public int[][] findUnionIntevals(int[][] intervals) {

        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        /*
        In order to have O(1) space comlexity, we will utilize the existing 
        array 'intervals' and start filling it with the results from the start, 
        in the indexes of the already checked intervals. Thus, integer 'indexResults'
        is implemented.
         */
        int indexResults = 0;

        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];
            i++;

            /* 
            Keep merging the intervals until there is no intersection between
            the current and the next interval, or there are no more intervals.
             */
            while (i < intervals.length && intervals[i][0] <= end) {
                if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
                i++;
            }

            i--;
            intervals[indexResults++] = new int[]{start, end};
        }
        return Arrays.copyOfRange(intervals, 0, indexResults);
    }
}
