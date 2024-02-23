/*
    정보처리기사 준비로 옛날 문제 복습하기
*/
import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] temp = {"R", "T", "C", "F", "J", "M", "A", "N"};
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<temp.length; i++){
            map.put(temp[i],0);;
        }
        for(int i=0; i<survey.length; i++){
            if(choices[i]>4){
                String tempS = survey[i].charAt(1)+"";
               map.put(tempS, map.get(tempS) +  choices[i]-4);
            }else if(choices[i]<4){
                String tempS = survey[i].charAt(0)+"";
               map.put(tempS, map.get(tempS) +  4-choices[i]);
            }
        }
        for(int i=0; i<temp.length; i+=2){
            if(map.get(temp[i])>map.get(temp[i+1])){
                sb.append(temp[i]);
            }else if(map.get(temp[i]) == map.get(temp[i+1])){
                if(temp[i].charAt(0) > temp[i+1].charAt(0)){
                    sb.append(temp[i+1]);
                }else{
                    sb.append(temp[i]);
                }
            }
            else{
                sb.append(temp[i+1]);
            }
        }
        return sb.toString();
    }
}