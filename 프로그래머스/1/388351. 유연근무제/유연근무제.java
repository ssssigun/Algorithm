/*
 1. 단순 구현 문제
 2. n^2해도 시간 안넘을듯
 3. 출근 유효시간 계산시 조심, 단순 +10이 아닌 60이 넘어가면 백의자리를 올려줘야함
 4. 요일 계산 필요 (토,일 제외)
*/
import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // 토,일 위치 계산
        int h1 = 6-startday<0 ? 6 : 6-startday;
        int h2 = 7-startday;
        List<Integer> list = new ArrayList<>();
        
        // 출근 유효 시간계산
        for(int i=0; i<schedules.length; i++){
            int min = schedules[i];
            int max = 0;
            int hour = min/100;
            int minutes = min%100;
            if (minutes>=50){
                max = (hour *100) + 100 + ((minutes+10)%60);
            }else{
                max = min+10;
            }
            list.add(max);
        }
        
        // 직원 순회하면서 체크
        for(int j=0; j<timelogs.length; j++){
            boolean ch = false;
            for(int k=0; k<timelogs[j].length; k++){
                // 토,일이면 스킵
                if(k == h1 || k == h2){
                 continue;
                }
                // 희망 출근 시간에 포함되는지 확인
                if(timelogs[j][k] <= list.get(j)){
                    ch = true;
                }else{
                    ch = false;
                    break;
                }
            }
            // 전부 통과했으면 카운트
            if(ch){
                answer++;
            }
        }
        
        return answer;
    }
}