/*
    1. 그리디 문제이다.
        - 일의 자리에서 5이하이면 값 추가
        - 6이상이면 10 - num 추가
        - /10 해주기
        - 단 5일 때 고민을 해야한다.
            - 앞자리가 5이상이면 올리기
            - 4이하이면 내리기
*/
class Solution {
    public int solution(int storey) {
        int ans = 0;
        while(storey > 0){
            int num = storey % 10;
            storey /= 10;
            if(num < 5){
                ans += num;
            }else if(num == 5){
                if(storey % 10 >= 5){
                    ans += 10 - num;
                    storey++;
                }else{
                    ans += num;
                }
            }else{
                ans += 10 - num;
                storey++;
            }
        }
        return ans;
    }
}