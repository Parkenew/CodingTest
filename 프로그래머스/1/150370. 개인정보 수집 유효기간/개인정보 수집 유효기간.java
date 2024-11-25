import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer={};
        
        String[] div=today.split("\\.");
        int now_year=Integer.parseInt(div[0]);
        int now_month=Integer.parseInt(div[1]);
        int now_day=Integer.parseInt(div[2]);
        int now=convertSum(now_year,now_month,now_day);
        
        Map<String,Integer> policies= new HashMap<>();
        for(String term: terms){
            div=term.split(" ");
            policies.put(div[0],Integer.parseInt(div[1])*28-1);
        }
        int len=privacies.length;
        for(int i=0;i<len;i++){
            div=privacies[i].split(" ");
            String date=div[0];
            String p_type=div[1];
            div=date.split("\\.");
            int year=Integer.parseInt(div[0]);
            int month=Integer.parseInt(div[1]);
            int day=Integer.parseInt(div[2]);
            int privacy=convertSum(year,month,day)+policies.get(p_type);
            if(privacy<now){
                answer=Arrays.copyOf(answer,answer.length+1);
                answer[answer.length-1]=i+1;
            }
        }
        
        
        
        return answer;
    }
    
    private int convertSum(int year,int month, int day){
        int sum=0;
        sum+=year*12*28+month*28+day;
        return sum;
    }
    
}