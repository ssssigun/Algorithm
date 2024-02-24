/*
    1. 2인 제한 ,무게는 limit
        - 내림차순으로 sort해서 limit으로 하기
    2. 입력은 사람들의 무게를 담은 people, 보트의 무게 제한 limit
    3. 구출하기 위해 필요한 보트의 최솟값 return
*/

import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int temp =0;
        int cnt =0;
        Integer[] peo= new Integer[people.length];
        for(int i=0; i<people.length; i++){
            peo[i] = people[i];
        }
        Arrays.sort(peo, Collections.reverseOrder());
        int len = peo.length;
        int lastidx = 0;
        
        for(int i=0; i<len - lastidx; i++){
            if(temp + peo[i] <= limit && cnt <2){
                temp += peo[i];
                cnt++;
                if( temp + peo[len - lastidx-1] <= limit && cnt <2){
                    temp += peo[len - lastidx-1];
                    cnt++;
                    lastidx++;
                }
            }else{
                answer++;
                temp=0;
                cnt=1;
                temp+=peo[i];
                if( temp + peo[len - lastidx-1] <= limit && cnt <2){
                    temp += peo[len - lastidx-1];
                    cnt++;
                    lastidx++;
                }
            }
        }
        answer++;
        return answer;
    }
}