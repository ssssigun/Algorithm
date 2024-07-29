/*
    1. 구현 문제이다.
        - key에 데이터의 원소 정보를 저장
        - data를 돌면서 val_ext가 낮은 것을은 0으로 채우기, cnt++
        - sort_by 기준으로 정렬
        - cnt번째부터 데이터 추출
*/
import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<String> key = new ArrayList<>(List.of("code", "date", "maximum", "remain"));
        int fNum = key.indexOf(ext);
        int sNum = key.indexOf(sort_by);
        int cnt = 0;
        for(int i=0; i<data.length; i++){ // 데이터 분류
            if(data[i][fNum] >= val_ext){
                Arrays.fill(data[i], 0);
                cnt++;
            }
        }
        // 정렬
        Arrays.sort(data, (o1, o2) ->{return o1[sNum] - o2[sNum];}); 
        // 배열 자르기
        int[][] ans = new int[data.length -cnt][4];       
        for(int i=0; i<ans.length; i++){
            ans[i][0] = data[cnt+i][0];
            ans[i][1] = data[cnt+i][1];
            ans[i][2] = data[cnt+i][2];
            ans[i][3] = data[cnt+i][3];
        }
        return ans;
    }
}