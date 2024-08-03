/*
    1. 구현 (문자열)문제인 줄 알았으나 투 포인터 문제인 것 같다.
        - 문자열로 일일히 다 뒤집으면 시간이 오래 걸림 (시간 초과)
        - 배열 순회
        - 짝수일 때 홀수일 때 둘 다 확인해야함
        - 기준을 기점으로 양 옆이 같은지 확인 (투포인터)
        - 만약 같다면 +2해주고 start는 다운, end 업
            - 최댓값이면 갱신
        - 다르다면 나가기
*/
import java.util.*;
class Solution{
    public int solution(String s){
        int ans = 1;
        for(int i=1; i<s.length(); i++){ // 기준점 순회
            // 짝수일 때 확인
            int start = i-1;
            int end = i;
            int sum = 0;
            while(start>=0 && end<s.length()){ // 범위 안에 있을 때까지 확인
                if(s.charAt(start) == s.charAt(end)){ // 같다면 +2, 최댓값 갱신
                    sum += 2;
                    ans = Math.max(ans, sum);
                    start--;
                    end++;
                }else{ // 다르다면 나가기
                    break;
                }
            }
            // 홀수일 때 확인
            start = i-1;
            end = i+1;
            sum = 1;
            while(start>=0 && end<s.length()){ // 범위 안에 있을 때까지 확인
                if(s.charAt(start) == s.charAt(end)){ // 같다면 +2, 최댓값 갱신
                    sum += 2;
                    ans = Math.max(ans, sum);
                    start--;
                    end++;
                }else{ // 다르다면 나가기
                    break;
                }
            }
        }

        return ans;
    }
}