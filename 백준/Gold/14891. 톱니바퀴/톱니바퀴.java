import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
    1. 톱니 바퀴의 회전 구현 (재귀 느낌도 약간 난다.)
        - 반시계, 시계 회전 (톱니바퀴는 LinkedList로 구현)
        - 맞닿은 곳이 같은 극인지 확인
        - 마지막에 점수 환산
    2. 첫째 줄부터 4번째 줄까지 톱니 바퀴에 정보 (12시부터 시계 방향으로 주어짐)
        - N 0, S 1
        - 다섯째 줄엔 회전 횟수 K
        - 다음 K줄부터 회전시킨 방법 (톱니바퀴 번호, 방향 {1 시계, -1 반시계} )
    3. 회전 시킨 후 점수의 합 return
        - 1번 톱니바퀴의 12시 방향 N 0, S 1
        - 2번 톱니바퀴의 12시 방향 N 0, S 2
        - 3번 톱니바퀴의 12시 방향 N 0, S 4
        - 4번 톱니바퀴의 12시 방향 N 0, S 8
* */
class Main {
    static LinkedList<Integer>[] w = new LinkedList[4];
    static boolean[] visited; // 방문처리 배열
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i=0; i<4; i++){
            w[i] = new LinkedList<Integer>();
        }
        // 입력 받기
        for(int i=0; i<4; i++){
            String temp = br.readLine();
            for(int j=0; j<8; j++){
                w[i].add((temp.charAt(j) -'0'));
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            visited = new boolean[4];
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotate(num - 1, dir);
        }
        // 출력
        bw.write(w[0].get(0) + (2*w[1].get(0)) + (4*w[2].get(0)) + (8*w[3].get(0)) + "");
        bw.flush();
    }
    // 회전 함수
    static void rotate(int num, int dir){
        if(num<0 || num>=4 || visited[num]){ // 톱니바퀴 범위 안이면서 방문한 적이 없어야한다.
            return;
        }
        visited[num] = true; // 방문 처리
        int left = w[num].get(6);
        int right =w[num].get(2);
        if(dir == 1){ // 시계 방향이면 처음에 마지막 요소를 추가
            w[num].addFirst(w[num].pollLast());
        }else{ // 반시계 방향이면 마지막에 처음 요소를 추가
            w[num].addLast(w[num].pollFirst());
        }
        if( num != 3 && right != w[num+1].get(6) ){ // 오른쪽 확인
            rotate(num+1, -dir);
        }
        if( num != 0 && left != w[num-1].get(2) ){ // 왼쪽 확인
            rotate(num-1, -dir);
        }
    }
}