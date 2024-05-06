import java.io.*;
import java.util.StringTokenizer;

/*
    1. 최악의 경우의 수가 500 * 500 * 256으로 1억이 넘지 않으므로 완전 탐색 가능
        - 최솟값과 최대값을 구해서 범위 지정
        - 최솟값 ~ 최댓값을 돌면서 시간을 구한 후 최소 시간 찾기
    2. 첫째 줄에 세로 N, 가로 M, 인벤토리 블럭 수 B
        - 둘째 줄부터 땅의 높이가 주어짐
    3. 땅을 고르는데 걸리는 시간과 땅의 높이 return
        - 단 답이 여러개이면 가장 높은 수 return
        - 높이는 256보다 낮아야함
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sec = Integer.MAX_VALUE;
        int height = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] field = new int[N][M]; // 땅 배열
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, field[i][j]); // 최솟값 저장
                max = Math.max(max, field[i][j]); // 최댓값 저장
            }
        }
        // 높이 구하기
        for(int i=min; i<=max; i++){
            int t = 0;
            int bt = 0;
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(i < field[j][k]){ // 목표 높이보다 높으면 빼기
                        t += (field[j][k] - i) * 2;
                        bt += (field[j][k] - i);
                    }else{ // 목표 높이보다 낮으면 더하기
                        t += i - field[j][k];
                        bt -= i - field[j][k];
                    }
                }
            }
            if(B+bt>=0 && t<=sec){
                sec = t;
                height = i;
            }
        }
        // 출력
        bw.write(sec + " " + height);
        bw.flush();
    }
}