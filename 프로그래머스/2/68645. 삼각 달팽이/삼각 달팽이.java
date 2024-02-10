/*
    1. 단순 구현문제이다.
        - 내려가고 옆으로 가는 것은 어렵지 않다
        - 다만 위로 올라갈 때 인덱스-1 하는 걸 주의하자
    2. 입력은 삼각형의 높이 정수 N
    3. 숫자 반시계 달팽이 삼각형 return
*/
import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[][] ans = new int[n][];
        int cnt = 1;
        int hor = 0;
        int ver = -1;
        for(int i=0; i<n; i++){
            ans[i] = new int[i+1];
        }
        while(n > 0){
            // 아래 이동
            for(int i=0; i<n; i++){
                ans[++ver][hor] = cnt++;
                if(n-1 == i){ // 마지막 번호만 건너뛰기
                    continue;
                }
            }
            n--;
            // 수평 이동
            for(int i=0; i<n; i++){
                ans[ver][++hor] = cnt++;
            }
            n--;
            // 좌 상향 이동
            for(int i=0; i<n; i++){
                --ver;
                --hor;
                ans[ver][hor] = cnt++;
            }
            n--;
        }
        // 출력용 배열
        int[] answer = new int[cnt-1];
        cnt = 0;
        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[i].length; j++){
                answer[cnt++] = ans[i][j];
            }
        }
        return answer;
    }
}