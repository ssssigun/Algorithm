import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
    1. 문제 이해가 너무 안됬는데 점수가 아니라 등수였고, 또 상대 평가이므로 비교값이 갱신되어야한다
        - 그리디, 정렬을 사용하는 문제
        - 2등부터 시작
    2. 첫째 줄엔 테스트 케이스의 갯수 T
        - 이후에 신입 사원의 수
        - 그 다음엔 서류 전형, 면접 전형 등수
    3. 선발할 수 있는 신입 사원의 최대 인원수 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int cnt = 1;
            int[][] arr = new int[N][2];
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, new Comparator<int[]>() { // 오름차순 정렬
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
                }
            });
            // 신입사원 찾기
            int top = arr[0][1]; // 1등의 면접 점수
            for(int j=1; j<N; j++){ // 2등부터 시작
                if(top > arr[j][1]){
                    cnt++;
                    top = arr[j][1];
                }
            }
            bw.write(cnt+"\n");
        }
        // 출력
        bw.flush();
    }
}