/*
    1. 구현? 구간합? 문제인 것 같다.
        - stations의 개수만큼 반복
        - 구해야하는 구간 / (2*w +1)
        - 나머지가 있다면 + 1
    2. 아파트의 개수 N
        - 현재 기지국의 설치된 아파트 배열 stations
        - 전파 도달 거리 W
    3. 기지국을 증설할 갯수 return
*/
class Solution {
    public int solution(int n, int[] stations, int w) {
        int ans = 0;
        int prev = 1;
        int section = (2*w) + 1;
        for(int i=0; i<stations.length; i++){
            if(prev >= stations[i]-w){ // 이전 구간이 겹치면 넘어감
                prev = stations[i]+w+1;
                continue;
            }
            int patition = (stations[i]-w) - prev; // 구간 계산
            ans += patition / section; // 송전탑 설치 확인
            if(patition % section != 0){ // 구간이 조금이라도 남으면 송전탑 추가
                ans++;
            }
            prev = stations[i]+w+1;
        }
        if(stations[stations.length-1]+w < n){ // 마지막 구간 확인하기
            int patition = n+1 -prev;
            ans += patition / section;
            if(patition % section != 0){
                ans++;
            }
        }
        return ans;
    }
}