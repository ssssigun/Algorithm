/*
    1. 이분 탐색 문제 (값을 도출하기가 어려웠음)
        - 시간을 기준으로 이분 탐색 0 ~ (10^9 * 2 * 10^5 *2)
        - 숫자가 크므로 long타입 활용
        - 3가지 기준을 확인
            - 전체 광물을 옮길 수 있는가 (a+b)
            - 금의 이동을 우선으로 했을 때 옮길 수 있는가 (a)
            - 은의 이동을 우선으로 했을 때 옮길 수 있는가 (b)
    2. 옮겨야하는 광물, 금 a, 은, b
        - i 마을에 있는 광물, 금 g[], 은 s[]
        - 한번에 옮길 수 있는 무게 w[]
        - 걸리는 시간 t[]
    3. 광물 a, b를 전달 할 수 있는 가장 빠른 시간을 return
*/
class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        // 이분 탐색 범위 잡기
        long low = 0L;
        long high = (long)(1e9 * 2 *1e5 * 2);
        
        while(low < high){ // 탐색 시작
            long mid = (low + high) / 2;
            if(possible(a, b, g, s, w, t, mid)){ // 옮길 수 있으면 최소 시간을 위해 범위 줄이기
                high = mid;
            }else{ // 불가능하면 범위 올리기
                low = mid + 1;
            }
        }
        return low;
    }
    
    public static boolean possible(int a, int b, int[] g, int[] s, int[] w, int[] t, long mid){
        long n = g.length;
        long totalMax = 0L;
        long gMax = 0L;
        long sMax = 0L;
        
        for(int i=0; i<n; i++){ // 옮길 수 있는 광물의 무게 계산
            long num = (mid/(2L*t[i])); // 시간 안에 운반 가능한 횟수
            if((mid%(2L*t[i])) >= t[i]){
                num++;
            }
            long temp = w[i] * num;
            totalMax += Math.min(g[i] + s[i], temp); // 운반이 가능한 최대량
            gMax += Math.min(g[i], temp); // 금 운반의 최대량 
            sMax += Math.min(s[i], temp); // 은 운반의 최대량
        }
        if(a<=gMax && b<=sMax && (a+b)<=totalMax){
            return true;
        }
        
        return false;
    }
}








