/*
    1. 이분 탐색 문제인 것 같다.
        - 20만 * log2억의 시간 복잡도 (가능)
        - stones의 값을 기준으로 이분 탐색
        - (stone - 중간 값) <= 0의 최대 갯수를 찾는다.
        - k보다 작으면 사람들이 더 지나가도 됨
        - k보다 크면 많은 사람들이 지나가서 줄어야함
*/
class Solution {
    public int solution(int[] stones, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        // 최댓값 최솟값 찾기
        for(int i=0; i<stones.length; i++){
            low = Math.min(low, stones[i]);
            high = Math.max(high, stones[i]);
        }
        // 이분 탐색 시작
        while(low < high){
            int mid = (low + high) / 2;
            int cnt = 0; 
            int max = 0; // 최댓값
            for(int i=0; i<stones.length; i++){
                if(stones[i] - mid <= 0){ // 0이하의 값이라면 카운트
                    cnt++;
                    max = Math.max(max, cnt); // 최댓값 갱신
                }else{ // 연속으로 나오지 않는다면 초기화
                    cnt = 0;
                }
            }
            if(max < k){ // K보다 작다는 것은 더 많이 지나가도 된다 (증가);
                low = mid + 1;
            }else{ // k보다 크다는 것은 너무 많은 사람들이 지나가서 줄여야함 (감소);
                high = mid;
            }
        }
        return low;
    }
}