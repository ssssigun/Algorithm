/*
    1. 작업량이 가장 적은 순서대로 진행해야함
        - 우선 순위 큐 사용
        - 1~1000초를 반복문으로 진행
        - 작업 대기가 없다면 바로 실행
        - 작업 중이면 작업 대기 (pq)에 넣기
        - 종료 시간 - 요청 시간 을 더하기
        - 작업 수로 나눠주기
*/
import java.util.*;
class Process implements Comparable<Process>{
    int start;
    int amount;
    Process(int start, int amount){
        this.start = start;
        this.amount = amount;
    }
    @Override
    public int compareTo(Process o1){
        return this.amount == o1.amount ? 
            this.start - o1.start : this.amount - o1.amount;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int ans = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (o1,o2) ->{return o1[0] -o2[0];});
        int time = 0;
        int cnt = 0;
        // 작업 시작
        while(true){
            for(int[] i : jobs){ // 작업 목록 확인
                if(i[0] == time){ // 만약 해당 시간에 작업이 있다면 작업 대기에 넣기
                    pq.offer(new Process(i[0], i[1]));
                    cnt++;
                }
            }
            if(pq.isEmpty()){ // 작업 대기가 없으면 지나감
                time++;
            }else{ // 작업 대기가 있으면 진행
                Process p = pq.poll();
                for(int[] i : jobs){ // 해당 작업 동안의 작업들을 대기열에 넣기
                    if(time < i[0] && i[0] < time + p.amount){
                        pq.offer(new Process(i[0], i[1]));
                        cnt++;
                    }
                }
                time += p.amount; // 시간 지남
                ans += time - p.start; // 요청부터 종료까지의 시간 구하기
            }
            if(cnt == jobs.length && pq.isEmpty()){
                break;
            }
            // System.out.println(time +" "+ans);
        }
        return ans/jobs.length;
    }
}