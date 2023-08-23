/*
    1. list에서 전체 더해주고 구하기
    2. 
*/
import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList();
        int cnt =0;
        int temp=0;
        boolean run = true;
        while(run){
            if(cnt >= progresses.length){
                run =false;
                break;
            }
            //작업 속도 더하기
            for(int i=cnt; i<progresses.length; i++){
                progresses[i]+=speeds[i];
            }
            //작업 끝났는지 확인
            for(int i=cnt; i<progresses.length; i++){
                if(progresses[i]>=100){
                    temp++;
                }else{
                    break;
                }
            }
            // 작업이 완료됬다면 순서대로 배포
            if(temp>0){
                answer.add(temp);
                cnt+=temp;
                temp=0; 
            }
        }
        return answer;
    }
}