class Solution {
    public long solution(int n) {
        long[] temp = new long[n+2];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        for(int i=3; i<=n;i++){
            temp[i] = (temp[i-1] + temp[i-2]) % 1234567;
        }
        return temp[n-1];
    }
}