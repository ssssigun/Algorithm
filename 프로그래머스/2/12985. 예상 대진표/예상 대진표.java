/*
    1. 이거 저기서 스킬체크에서 풀었음
    2. a b둘다 2로 나누기
    3. 홀수면 +1 해주고 무한 반복
    4. 같을때 리턴 
*/
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(true){
            if(a%2==0){
                a /=2;
            }else{
                a = (a/2) +1;
            }
            if(b%2==0){
                b /= 2;
            }else{
                b  = (b/2) +1;
            }
            answer++;
            if(a == b){
                return answer;
            }
        }
    }
}