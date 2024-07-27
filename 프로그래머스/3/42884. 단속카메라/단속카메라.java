/*
    1. 완전 탐색
        - 시간 복잡도 10000정도 될 것 같다 (가능)
        - 도착지 기준으로 정렬 (처음에 출발지 기준으로 했다가 틀림)
        - 반복문을 돌면서 이전 카메라의 위치와 비교
        - 만약 카메라보다 앞에 있다면 넘어가기
        - 뒤에 있다면 좌표를 저장하고 ans++
    2. 차량 i개의 출입 기록 routes
    3. 단속 카메라의 최소 설치 개수 return
*/
import java.util.*;
class Solution { 
    public int solution(int[][] routes) {
        int ans = 0;
        Arrays.sort(routes, (o1,o2) ->{return o1[1] - o2[1];}); // 도착지 기준으로 정렬
        
        int cam = -300001; // 카메라 위치 저장
        for(int i=0; i<routes.length; i++){
            int s = routes[i][0];
            int e = routes[i][1];
            if(s > cam){ // 이전 카메라가 이전에 있다면 새로 추가
                ans++;
                cam = e;
            }
        }
        return ans;
    }
}
