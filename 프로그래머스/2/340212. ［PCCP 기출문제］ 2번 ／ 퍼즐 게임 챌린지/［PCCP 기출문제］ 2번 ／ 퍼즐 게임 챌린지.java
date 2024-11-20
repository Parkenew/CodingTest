class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int max = Integer.MIN_VALUE;
        for (int diff : diffs) {
            max = Math.max(max, diff);
        }

        
        int start = 1;
        int end = max;
        int answer = max; 

        while (start <= end) {
            int mid = (start + end) / 2;

            
            long totalTime = play(mid, diffs, times);

            if (totalTime <= limit) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

    private long play(int level, int[] diffs, int[] times) {
        long totalTime = 0; 
        int len = diffs.length;

        for (int i = 0; i < len; i++) {
            if (diffs[i] > level) {
                int mistakes = diffs[i] - level; 
                int timePrev = i > 0 ? times[i - 1] : 0;
                totalTime += mistakes * (times[i] + timePrev);
            }

        
            totalTime += times[i];
        }

        return totalTime;
    }
}
