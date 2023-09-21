/*
    1. 트럭 목록을 다리queue에 담고 초를 측정하기
    2. 조건에 주의하자 (무게와 갯수)
    3. 다리 길이를 신경써야한다
        - 다리 길이가 100이면 한개가 지나가더라도 101초가 걸림
    4. 초를 return
*/
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 다리 큐
        Queue<Integer> que = new LinkedList();
        // 지나가기 (대기 트럭 입장)
        for(int truck : truck_weights){
            while(true){
                // 다리가 빈 경우
                if(que.isEmpty()){
                    que.offer(truck);
                    weight -= truck;
                    answer++;
                    break;
                // 다리 끝에 도착한 경우
                }else if(bridge_length == que.size()){
                    weight += que.poll();
                }else{
                // 다리 무게 미만인 경우
                    if(weight - truck >= 0){
                        que.offer(truck);
                        weight -= truck;
                        answer++;
                        break;
                // 다리 무게가 초과된 경우
                    }else{
                        que.offer(0);
                        answer++;
                    }
                }
            }
        }
        // 반복문이 마지막 트럭에서 끝나므로 다리 길이만큼 더해준다
        return answer + bridge_length;
    }
}