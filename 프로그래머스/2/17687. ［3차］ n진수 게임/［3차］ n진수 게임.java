/*
    1. 구현 문제인 것 같다.
        - t * m 개의 크기만큼 문자열 생성
        - StringBuilder에 저장
        - (p-1) + (m * t)번째 글자를 뽑아서 저장
    2. 진수 n, 구할 개수 t, 참여 인원 m, 튜브의 순서
    3. 튜브가 말해야하는 문자열 return
*/
import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder ans = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for(int i=0; i<100000; i++){ // 문자 생성
            if(t*m <= i){ // 구할 수보다 커지면 탈출
                break;
            }
            str.append(Integer.toString(i, n));
        }
        for(int i=0; i<t; i++){ // 본인 차례 문자 구하기
            ans.append(str.charAt((p-1) + (m*i)));
        }
        return ans.toString().toUpperCase();
    }
}