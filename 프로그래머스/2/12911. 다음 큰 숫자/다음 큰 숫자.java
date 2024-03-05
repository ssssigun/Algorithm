/*
    1. n+1부터 시작
    2. 2진 변환하면 1의 갯수가 같음
    3. 발견한 처음 숫자 리턴
*/
class Solution {
    public static int cNum(int num){
        int ansNum =0;
        String ans = Integer.toString(num, 2);
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='1'){
                ansNum++;
            }
        }
        return ansNum;
    }
    
    public int solution(int n) {
        int answer = 0;
        int ansNum =cNum(n);
        
        int cnt = n+1;
        while(true){
            if(cNum(cnt)==ansNum){
                break;
            };
            cnt++;
        }
        return cnt;
    }

}