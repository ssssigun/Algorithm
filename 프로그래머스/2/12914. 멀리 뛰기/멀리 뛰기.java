/*
    1. 멀리 뛰기 방법 수는 피보나치 수열로 늘어난다. 
    2. 따라서 피보나치 수열 구현하기
*/
class Solution {
    public long solution(int n) {
        long[] idx= new long[n+2];
        idx[0] =0;
        idx[1] =1;
        idx[2] =2;
        for(int i=3;i<=n;i++){
            idx[i] = (idx[i-1] + idx[i-2])%1234567;
        }
        return idx[n];
    }
}