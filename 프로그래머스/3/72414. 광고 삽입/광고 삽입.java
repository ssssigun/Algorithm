/*
    1. 구현 문제인듯 하다.
        - 시간 복잡도 36만 + 36만으로 가능할 것 같다
        - 먼저 시작 순서대로 정렬
        - 초 단위로 변경 후 배열 생성
        - logs배열을 순회하면서 시간들을 우선 순위 큐에 넣음
            - 시작 시간은 +1
            - 종료 시간은 -1
        - 나오는 시간 순서대로 배열에 값넣기
        - 그 다음 0 ~ adb_time 범위 만큼의 값을 더하기
        - 한칸씩 이동하면서 가장 큰 값을 구하고, 시작점 저장
*/
import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->{return o1[0] - o2[0];});
        int N = strToInt(play_time);
        int[] arr = new int[N+2]; // 시간 배열
        // 시간을 우선 순위 큐에 담기
        for(int i=0; i<logs.length; i++){ 
            String[] time = logs[i].split("-");
            pq.offer(new int[]{strToInt(time[0]), 1});
            pq.offer(new int[]{strToInt(time[1]), -1});
        }
        // 시간 가중치 구하기
        int start = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            int[] t = pq.poll();
            for(int i=start; i<t[0]; i++){
                arr[i] = cnt;
            }
            start = t[0];
            cnt += t[1];
        }
        // 가장 큰 시간 구하기
        start = 0; // 시작
        int end = strToInt(adv_time); // 종료
        long sum = 0; // 총합
        long max = 0; // 가장 큰 값
        int idx = 0; // 가장 큰 값의 시작 시간
        for(int i=0; i<end; i++){ // 합 저장
            sum += arr[i];
        }
        // 슬라이딩 윈도우
        while(end <= N){
            if(max < sum){ // 만약 총 합이 크다면 저장
                max = sum;
                idx = start;
            }
            sum -= arr[start++]; // 한칸 이동 (앞의 값 빼기)
            sum += arr[end++]; // 한칸 이동 (뒤에 값 넣기)
        }
        return intToStr(idx);
    }
    public int strToInt(String s){ // 시간을 초로 변환
        String[] str = s.split(":");
        int m = (Integer.parseInt(str[0]) * 60) + Integer.parseInt(str[1]);
        int sec = (m*60) + Integer.parseInt(str[2]);
        return sec;
    }
    public String intToStr(int n){ // 초를 시간으로 변환
        int m = n / 60;
        int s = n % 60;
        int h = m / 60;
        m = m % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}