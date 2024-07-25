/*
    1. 우선 순위 큐를 활용하여 풀기
        - 시간 복잡도 n만큼이므로 가능
        - N == 0이 될 때까지 하나씩 빼서 1씩 줄이기
    2. 남은 시간 N, 작업량 works 배열
    3. 야근 피로도의 최솟값을 return
*/
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
             pq.offer(works[i]);
        }
        while(n > 0){
            int i = pq.poll();
            if(i == 0){
                return ans;
            }
            pq.offer(i-1);
            n--;
        }
        while(!pq.isEmpty()){
            int i = pq.poll();
            ans += Math.pow(i,2);
        }
        return ans;
    }
}
