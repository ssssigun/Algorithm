import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
        정보처리기사 시험으로 쉬운 문제 복기하기
    1. 소수를 찾는 에라토스테네스의 체 구현하기
    2. 찻째 줄에 N, K
        - N은 숫자 범위, K번쨰 지우는 수
    3. K번째 지워진 수를 return;
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=N; i++){ // 수 추가
            list.add(i);
        }
        // 에라토스테네스의 체 진행
        while(!list.isEmpty()){
            int P = list.get(0);
            int s = P; // 제곱 연산용
            while(P <= N){
                if(list.contains(P)){ // 배수가 존재하면 삭제
                    list.remove(list.indexOf(P));
                    cnt++;
                }
                if(cnt == K){ // K번째 수 출력
                    bw.write(P+"");
                    break;
                }
                P += s; // 배수 연산
            }
        }
        // 출력
        bw.flush();
    }
}