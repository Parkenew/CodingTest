import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int len = convert(video_len);
        int cur = convert(pos);
        int openingStart = convert(op_start);
        int openingEnd = convert(op_end);

        
        for (String command : commands) {
            if (cur >= openingStart && cur <= openingEnd) {
                cur = openingEnd;
            }
            
            if (command.equals("prev")) {
                cur = Math.max(0, cur - 10);
            } else if (command.equals("next")) {
                cur = Math.min(len, cur + 10);
            }
            
            if (cur >= openingStart && cur <= openingEnd) {
                cur = openingEnd;
            }
        }

        
        return secondsToTime(cur);
    }

    
    private int convert(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    
    private String secondsToTime(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
