class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        Input: collection of different start and end intervals 
        Output: collection of only non overlapping intervals by combining intervals from input
        guranteed input to have one interval
        intervals are overlapping if they share at least one common point

        -check if the start value of an interval is less than the end value of the last interval
        [1, 3], [1, 5], [6, 7], [1, 5]
        -sort intervals array by the starting interval
        -to merge compare both intervals end values and create a new interval with the start and max end value
        -create a result collection of intervals -> List[int[]]
        */
        // [1, 2], [3, 5]

        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0]));
        List<int[]> resIntervals = new ArrayList<>();
        int lastEnd = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start <= lastEnd) {
                int[] previous = resIntervals.get(resIntervals.size() - 1);
                previous[1] = Math.max(end, lastEnd);
                continue;
            }
            resIntervals.add(new int[] {start, end});
            lastEnd = end;
        }
        return resIntervals.toArray(new int[resIntervals.size()][2]);
    }
}
