/*
    1. k 칸 이동하면 건전지량 k 소모 (점프)
    2. *2이동은 소모량 없음 (순간이동)
    3. 건전지 사용량을 최소로 해서 이동
        - 점프량 최소
    4. 주어진 n을 2로 나누고 나머지가 있으면 +1해주기
*/
import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n>0){
            if(n%2==0){
                n/=2;
            }else{
                ans++;
                n--;
            }
        }
        return ans;
    }
}