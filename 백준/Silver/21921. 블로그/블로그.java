import java.io.*;
import java.util.StringTokenizer;

/*
    1. 누적합 문제 연습
        - 배열 크기대로 진행해도 시간 초과를 하지 않을 것 같고, 최댓값도 21억을 넘지 않으므로 int형이 가능하다
        - 배열 입력 저장
        - X 크기만큼 더하고 이동할 때 이전 값을 뺴고 다음 값을 더한다.
        - 큰 수와 큰 수의 갯수를 저장
    2. 첫째 줄에 N과 X가 주어진다
        - 둘째 줄엔 방문자 수
    3. X일 동안 들어온 방문자의 최대값과 같은 기간 갯수를 return
        - 단 최대 방문자가 0이면 SAD return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0; // 최대 방문자 변수
        int cnt = 1; // 일수 변수
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 돌면서 최대값 구하기
        int temp = 0;
        int first = 1;
        int last = K + 1;
        for(int i=1; i<=K; i++){ // 초기값
            temp += arr[i];
        }
        max = temp;
        for(int i=0; i<N-K; i++){ // N - K번 반복
            temp = temp - arr[first] + arr[last];
            if(max < temp){ // 최대값이면 값 변경, 개수 변경
                max = temp;
                cnt = 1;
            }else if(max == temp){ // 같으면 갯수만 카운팅
                cnt++;
            }
            first++;
            last++;
        }
        // 출력
        if(max == 0){ // 최대값이 0이면 SAD
            bw.write("SAD");
        }else{
            bw.write(max+"\n");
            bw.write(cnt+"");
        }
        bw.flush();
    }
}