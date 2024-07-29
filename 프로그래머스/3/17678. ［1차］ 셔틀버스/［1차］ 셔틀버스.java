/*
    1. 단순 구현문제이다.
        - 시간 충분
        - 우선 timetable 정렬
        - 큐에 timetable값 넣기 (대기열)
        - 버스 시간대로 진행 n번 t간격으로 반복
        
*/
import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<timetable.length; i++){
            String[] s = timetable[i].split(":");
            int time = (Integer.parseInt(s[0])*60) + Integer.parseInt(s[1]);
            que.offer(time);
        }
        int bus = 9*60; // 9시
        int cnt = 0;
        int crew = 0;
        // 셔틀 운행 시작
        while(cnt < n){
            while(!que.isEmpty()){
                int cur = que.peek();
                if(cur <= bus){ // 버스 시간 이전에 왔으면 탑승
                    crew++;
                    que.poll();
                }else{ // 아니면 출발
                    break;
                }
                if(cnt == n-1 && crew == m){ // 마지막이면서 정원이 다 찼을 때 
                    return conv(cur-1);
                }
                if(crew == m){ // 정원이 다 찼으면 출발
                    crew = 0;
                    break;
                }
            }
            if(cnt == n-1){ // 버스가 마지막일 때
                return conv(bus);
            }
            bus += t;
            cnt++;
            crew = 0;
        }
        return answer;
    }
    public static String conv(int i){ // 시간 변환 함수
        String h = (i / 60)+"";
        String m = (i % 60)+"";
        h = h.length() == 1 ? "0"+h : h;
        m = m.length() == 1 ? "0"+m : m;
        return  h+":"+m;
    }
}