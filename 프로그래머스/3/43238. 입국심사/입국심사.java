/*
    1. 이분 탐색 문제인 것 같다.
        - log 1e18 ? -> 가능할 것 같은데 확인해보기
        - 시간을 기준으로 진행 (처음에 초기값을 잘못 세움)
            - low = 1
            - high = 1e18
        - n명이 되는 최솟값 구하기
*/
class Solution {
    public long solution(int n, int[] times) {
        long low = 1;
        long high = (long)1e18;
        while(low < high){
            long mid = (low + high) / 2;
            long cnt = 0;
            for(int i=0; i<times.length; i++){ // 심사 인원 구하기
                cnt += mid / times[i];
            }
            if(cnt < n){ // 심사 인원이 적으면 시간 증가
                low = mid + 1;
            }else{ // 심사 인원이 많으면 시간 감소
                high = mid;
            }
        }
        return low;
    }
}