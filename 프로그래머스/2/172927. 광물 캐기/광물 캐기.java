/*
    1. 단순 구현 문제인듯 하다
        - 수가 작아서 시간 초과 X
        - 단순 5개씩 그리디 계산인 줄 알았으나 피로도에 따라 사용하는 곡괭이의 종류를 다르게 해줘야함
        - 따라서 5개씩 광물을 묶고 각각 곡괭이 종류 별로 피로도 계산
        - 돌 곡괭이 기준으로 내림차순 정렬
        - 피로도 높은 그룹 먼저 높은 곡괭이로 캐기
        - 단, 곡괭이가 부족하여 끝까지 못 갈때는 도달하지 못하는 마지막 부분 제외
    2. 곡괭이의 종류와 갯수 picks, 들어있는 광물의 종류 minerals
    3. 최소한의 피로도 return
*/
import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int ans = 0;
        int g = picks[0] + picks[1] + picks[2];
        int leng = Math.min(minerals.length/5+1, g);
        int[][] sum = new int[leng][3]; 
        
        // 광물마다 피로도 계산
        for(int i=0; i<minerals.length; i++){
            String m = minerals[i];
            if(g*5 == i){ // 광물을 다 못캘 경우 탈출
                break;
            }
            if("diamond".equals(m)){ // 광물이 다이아
                    sum[i/5][0] += 1;    
                    sum[i/5][1] += 5;    
                    sum[i/5][2] += 25;    
            }else if("iron".equals(m)){ // 광물이 철
                    sum[i/5][0] += 1;    
                    sum[i/5][1] += 1;    
                    sum[i/5][2] += 5;    
            }else if("stone".equals(m)){ // 광물이 돌
                    sum[i/5][0] += 1;    
                    sum[i/5][1] += 1;    
                    sum[i/5][2] += 1;    
            }
        }
        // 돌 곡괭이 기준으로 정렬 (내림차순)
        Arrays.sort(sum, (o1,o2) ->{return o2[2] - o1[2];});
        // 곡괭이로 피로도 높은 광물부터 캐기
        for(int i=0; i<sum.length; i++){
            if(picks[0] >= 1){ // 다이아 곡괭이
                ans += sum[i][0];
                picks[0]--;
                System.out.println("D");
            }else if(picks[1] >= 1){ // 철 곡괭이
                ans += sum[i][1];
                picks[1]--;
                System.out.println("I");
            }else if(picks[2] >= 1){ // 돌 곡괭이
                ans += sum[i][2];
                picks[2]--;
                System.out.println("S");
            }
        }
        return ans;
    }
}