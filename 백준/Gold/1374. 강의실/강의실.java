import java.io.*;
import java.util.*;

/*
    1. 일반 구현으로 진행하니 시간초과가 나옴
        - 우선순위 큐를 활용하는 문제
        - 강의 시작 시간을 오름차순으로 정렬
        - 이후 끝나는 시간을 우선순위 큐에 담으면서 다음 수업 시작 시간과 비교
        - 만약 수업 시작 시간이 끝나는 시간보다 크면 큐를 하나 빼고
        - 그게 아니라 수업 시작 시간이 끝나는 시간보다 작으면 큐를 추가한다.
    2. 첫째 줄 입력은 강의의 갯수 N
        - 둘째 줄부터 강의 번호, 강의 시작 시간, 강의 종료 시간이 차례대로 N개 주어짐
    3. 필요한 최소 강의실의 갯수 return
* */
class Main {
    public static void main(String[] arg) throws IOException{
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Lecture> list = new ArrayList<>(); // 강의실 리스트
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Lecture(st.nextToken(), st.nextToken(), st.nextToken()));
        }
        // 정렬하기
        Collections.sort(list);
        int max = 1;
        // 강의실 배정하기
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            while(!que.isEmpty() && que.peek() <= list.get(i).start){ // 강의를 이어서 진행 가능하면 빼주고 추가
                que.poll();
            }
            que.offer(list.get(i).end); // 아니면 그대로 추가하기
            max = Math.max(max, que.size());
        }
        // 출력
        bw.write(max+"");
        bw.flush();
    }
}
// 강의 클래스
class Lecture implements Comparable<Lecture>{
    int num; // 강의 번호
    int start; // 강의 시작 시간
    int end; // 강의 종료 시간
    @Override
    public int compareTo(Lecture l){ // 비교 연산 재정의
        if(this.start == l.start){
            return this.end - l.end;
        }
        return this.start - l.start;
    }
    public Lecture(String num, String start, String end){ // 생성자
        this.num = Integer.parseInt(num);
        this.start = Integer.parseInt(start);
        this.end = Integer.parseInt(end);
    }
}